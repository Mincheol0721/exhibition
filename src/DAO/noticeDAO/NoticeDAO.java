package DAO.noticeDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import VO.JobExpVO.CJobExpVO;
import VO.noticeVO.NoticeVO;

public class NoticeDAO {

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	DataSource ds;
	
	//커넥션풀 생성 후 커넥션 객체 얻는 생성자
	public NoticeDAO() {
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
	
			//모든 공지사항조회
			public ArrayList getNoticeList() {
				
				ArrayList list = new ArrayList();
				
				
				NoticeVO noticeVO = new NoticeVO();
				
				try {
					//DB접속 : 커넥션풀에 만들어져 있는 커넥션 얻기
					con = ds.getConnection();
					//DB의 carlist테이블 저장된 모든 차량을 조회하는 SELECT문장을 sql변수에 저장
					String sql = "select * from articles";
					//SELECT문장을 DB의 carlist테이블에 전송해서 조회할 PreparedStatement객체 얻기
					pstmt = con.prepareStatement(sql);
					//SLELCT문장을 실행하여 조회된 데이터들을 ResultSet에 담아 반환 받기
					rs = pstmt.executeQuery();
					//반복문을 활용하여 ResultSet객체에 조회된 한줄 정보씩 얻어와
					//CarListVo객체의 각변수에 저장 후 
					//CarListVo객체를 Vector배열에 추가 하여 담습니다.
					while (rs.next()) {
						
						noticeVO = new NoticeVO(
								rs.getInt("no"), 
								rs.getString("articleType"), 
								rs.getString("title"), 
								rs.getString("content"),  
								rs.getString("fileName"), 
								rs.getString("fileRealName"), 
								rs.getDate("writeDate"), 
								rs.getString("readCount"));
								
						
						list.add(noticeVO);
					}
				}catch (Exception e) {
					System.out.println("getNoticeList메소드에서 SQL오류 : "+ e);
				}finally {
					//자원해제
					closeResource();
				}
				
				return list;
			}
			
			//하나의 공지사항만 조회하는 메소드
			public NoticeVO getOneNotice(int no) {
				
				NoticeVO noticeVO = new NoticeVO();
				
				
				try {
					//DB접속 : 커넥션풀에 만들어져 있는 커넥션 얻기
					con = ds.getConnection();
					//DB의 carlist테이블 저장된 모든 차량을 조회하는 SELECT문장을 sql변수에 저장
					String sql = "select * from articles where no=?";
					
					
					//SELECT문장을 DB의 carlist테이블에 전송해서 조회할 PreparedStatement객체 얻기
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, no );
					//SLELCT문장을 실행하여 조회된 데이터들을 ResultSet에 담아 반환 받기
					rs = pstmt.executeQuery();
					

				
					while (rs.next()) {
						noticeVO = new NoticeVO(
								rs.getInt("no"), 
								rs.getString("articleType"), 
								rs.getString("title"), 
								rs.getString("content"),  
								rs.getString("fileName"), 
								rs.getString("fileRealName"), 
								rs.getDate("writeDate"), 
								rs.getString("readCount"));
					}
								
						
						
					
				}catch (Exception e) {
					System.out.println("getOneNotice메소드에서 SQL오류 : "+ e);
				}finally {
					//자원해제
					closeResource();
				}
				
				return noticeVO;
			}
			
			
			//조회수 증가 메소드
			public void plusReadCount(int no) {
				
				NoticeVO noticeVO = new NoticeVO();
				
				
				try {
					//DB접속 : 커넥션풀에 만들어져 있는 커넥션 얻기
					con = ds.getConnection();
					//DB의 carlist테이블 저장된 모든 차량을 조회하는 SELECT문장을 sql변수에 저장
					String sql = "update articles"
							+ " set readcount = readcount+1"
							+ "where no=?";
					
					
					//SELECT문장을 DB의 carlist테이블에 전송해서 조회할 PreparedStatement객체 얻기
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, no );
					//SLELCT문장을 실행하여 조회된 데이터들을 ResultSet에 담아 반환 받기
					rs = pstmt.executeQuery();
					

					
				}catch (Exception e) {
					System.out.println("plusReadCount메소드에서 SQL오류 : "+ e);
				}finally {
					//자원해제
					closeResource();
				}
				
				
			}
			
}//NoticeDAO

