package DAO.JobExpDAO;

import java.sql.Connection; 

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import VO.JobExpVO.CJobExpVO;
import VO.JobExpVO.IJobExpVO;






public class JobExpDAO {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	//커넥션풀 생성 후 커넥션 객체 얻는 생성자
	public JobExpDAO() {
		try {		
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/oracle");
			
		} catch (Exception e) {
			System.out.println("DB연결 실패! - "+ e);
		}
	}
	
	//자원해제 기능
	private void closeResource() {
		if(con != null)try {con.close();} catch (Exception e) {e.printStackTrace();}
		if(pstmt != null)try {pstmt.close();} catch (Exception e) {e.printStackTrace();}
		if(rs != null)try {rs.close();} catch (Exception e) {e.printStackTrace();}
	}

	//모든 직업체험조회
		public ArrayList getcjobExpList() {
			
			ArrayList list = new ArrayList();
			
			
			CJobExpVO cjobExpVO = null;
			
			try {
				//DB접속 : 커넥션풀에 만들어져 있는 커넥션 얻기
				con = ds.getConnection();
				//DB의 carlist테이블 저장된 모든 차량을 조회하는 SELECT문장을 sql변수에 저장
				String sql = "select * from cjobExpReg";
				//SELECT문장을 DB의 carlist테이블에 전송해서 조회할 PreparedStatement객체 얻기
				pstmt = con.prepareStatement(sql);
				//SLELCT문장을 실행하여 조회된 데이터들을 ResultSet에 담아 반환 받기
				rs = pstmt.executeQuery();
				//반복문을 활용하여 ResultSet객체에 조회된 한줄 정보씩 얻어와
				//CarListVo객체의 각변수에 저장 후 
				//CarListVo객체를 Vector배열에 추가 하여 담습니다.
				while (rs.next()) {
					
					cjobExpVO = new CJobExpVO(rs.getString("cname"), 
							rs.getString("title"), 
							rs.getString("content"), 
							rs.getString("iPart"), 
							rs.getString("teacher"), 
							rs.getString("startTime"), 
							rs.getString("endTime"), 
							rs.getString("locate"), 
							rs.getString("fileName"), 
							rs.getString("fileRealName"),
							rs.getDate("startDate"));
							
					
					list.add(cjobExpVO);
				}
			}catch (Exception e) {
				System.out.println("getcjobExpList메소드에서 SQL오류 : "+ e);
			}finally {
				//자원해제
				closeResource();
			}
			
			return list;
		}

		public int insertIjobExp(IJobExpVO iJobExpVO) {
			int result = 0;
		try {
			//DB접속 : 커넥션풀에 만들어져 있는 커넥션 얻기
			con = ds.getConnection();
			
			String name = iJobExpVO.getName();
			String tel = iJobExpVO.getTel();
			String jobexpname = iJobExpVO.getJobexpname();
			
			String query="insert into ijobExp (no, name, tel, jobexpname) values (ijobExp_no.NEXTVAL, ?, ?, ?) ";
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, name);
			pstmt.setString(2, tel);
			pstmt.setString(3, jobexpname);
			
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("insertIjobExp메소드에서 SQL오류 : "+ e);
		}finally {
			closeResource();
		}		
			
			
		return result;
					
					
		}
		
		public int insertCjobExp(CJobExpVO cJobExpVO) {
			int result = 0;
		try {
			//DB접속 : 커넥션풀에 만들어져 있는 커넥션 얻기
			con = ds.getConnection();
			
			String cname = cJobExpVO.getCname();
			String title = cJobExpVO.getTitle();
			String content = cJobExpVO.getContent();
			String iPart = cJobExpVO.getiPart();
			String teacher = cJobExpVO.getTeacher();
			String startTime = cJobExpVO.getStartTime();
			String endTime = cJobExpVO.getEndTime();
			String locate = cJobExpVO.getLocate();
			String fileName = cJobExpVO.getFileName();
			String fileRealName = cJobExpVO.getFileRealName();
			
			
			
			
			String query="insert into cjobExpReg (cname, title, content,iPart,teacher,startTime,endTime,locate,fileName,fileRealName) "
						+ "values (?, ?, ? ,? ,? ,?, ?, ? ,? ,?)";
			
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, cname);
			pstmt.setString(2, title);
			pstmt.setString(3, content);
			pstmt.setString(4, iPart);
			pstmt.setString(5, teacher);
			pstmt.setString(6, startTime);
			pstmt.setString(7, endTime);
			pstmt.setString(8, locate);
			pstmt.setString(9, fileName);
			pstmt.setString(10, fileRealName);
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			System.out.println("insertCjobExp메소드에서 SQL오류 : "+ e);
		}finally {
			closeResource();
		}		
			
			
		return result;
					
					
		}
}


