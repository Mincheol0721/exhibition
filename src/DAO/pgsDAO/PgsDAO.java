package DAO.pgsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import VO.pgsVO.PgsVO;

public class PgsDAO {
	//위 4가지 접속 설정값을 이용해서 오라클 DB와 접속한 정보를 지니고 있는 Connection객체를 저장할 참조변수 선언
		private Connection con;
		//DB와 연결 후 우리 개발자가 만든 SQL문장을 오라클 DB의 테이블에 전송하여 실행할 역할을 하는 Statement실행객체의 주소를 저장할 참조변수 선언
		//private Statement stmt;
		private PreparedStatement pstmt;
		//SELECT문을 실행한 검색결과를 임시로 저장해 놓은 ResultSet객체의 주소를 저장할 참조변수 선언
		private ResultSet rs;
		//DataSouce커넥션풀 역할을 하는 객체의 주소를 저장할 참조변수
		private DataSource ds;
		//PgsVO 객체를 저장할 변수
		private PgsVO vo;
		//쿼리문을 저장할 변수
		private String query;
		
		//MemberDAO클래스의 기본생성자
		//역할 : new MemberDAO(); 객체 생성시 호출되는 생성자로 !!
		//     생성자 내부에서 커넥션풀 역할을 하는 DataSouce객체를 얻는 작업을 하게 됩니다.
		public PgsDAO() {
		
			try {
				//1.톰캣서버가 실행되면 context.xml파일에 적은 <Resouce>태그의 설정을 읽어와서
				//  톰캣서버의 메모리에 <Context>태그에 대한 Context객체들을 생성하여 저장해 둡니다.
				// 이때 InitialContext객체가 하는 역할은  톰캣서버 실행시 context.xml에 의해서 생성된 
				// Context객체들에 접근하는 역할을 하기때문에 생성합니다.
				Context ctx = new InitialContext();
				
				//2.JNDI기법(key를 이용해 값을 얻는 기법)으로 접근하기 위해 기본경로(java:/comp/env)를 지정합니다.
				// lookup("java:/comp/env"); 는 그중 톰캣서버의 환경설정에 관련된 Context객체들에 접근하기 위한 기본 경로 주소를 설정하는 것입니다
				Context envContext = (Context) ctx.lookup("java:/comp/env");
				
				//3.그런후 다시 톰캣서버는  context.xml에 설정한 <Resouce name="jdbc/oracle"....../>태그의
				// name속성값  "jdbc/oracle"(JNDI기법을 사용하기위한 key)를 이용해 톰캣 서버가 미리연결을 맺은 Connection객체들을 보관하고 있는
				// DataSouce커넥션풀 객체를 찾아서 반환해 줍니다.
				ds = (DataSource) envContext.lookup("jdbc/oracle");
				
				System.out.println("DataSource 커넥션풀 객체 얻기 성공!");
			} catch (Exception e) {
				System.out.println("DataSource커넥션풀 객체 얻기 실패  : " + e);
			}
		
		}
		
		//DB작업관련 객체 메모리들 자원해제 하는 메소드 
		public void freeResource() {	
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(rs != null) {
					rs.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//DB에 접속하여 레코드 총 개수를 반환하는 메소드
		public int getPgsCount() {
			int count = 0;
			
			try {
				con = ds.getConnection();
				
				query = "select count(*) from pgs";
				
				pstmt = con.prepareStatement(query);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt(1);
				}
				
			} catch (Exception e) {
				System.out.println("PgsDAO내부의 getPgsCount에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
			
			return count;
		}
		
		//DB에 접속하여 현재 진행중인 프로그램을 불러오는 메소드
		public List<PgsVO> getPgsList(int pageNum, int pageSize) {
			
			List<PgsVO> list = new ArrayList<PgsVO>(); 
			
			try {
				con = ds.getConnection();
				System.out.println("pageNum: " + pageNum);
				System.out.println("pageSize: " + pageSize);
				query = "SELECT * " + 
						"FROM ( " + 
						"    SELECT ROWNUM AS rn, p.* " + 
						"    FROM ( " +
						"	 	SELECT * FROM pgs ORDER BY pno DESC " + 
						"    ) p " + 
						" 	 WHERE ROWNUM <= ( " + pageNum + " * " + pageSize + ") " + 
						" ) " + 
						" WHERE rn >= ((" + pageNum + " - 1) * " + pageSize + ") + 1";
				
				pstmt = con.prepareStatement(query);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					vo = new PgsVO( rs.getInt("pno"), 
								    rs.getString("pgname"), 
								    rs.getString("pgtype"), 
								    rs.getString("title"), 
								    rs.getString("content"), 
								    rs.getString("ipart"), 
								    rs.getString("teacher"), 
								    rs.getString("startTime"), 
								    rs.getString("endTime"), 
								    rs.getString("locate"), 
								    rs.getString("fileName"), 
								    rs.getString("fileRealName"), 
								    rs.getString("startDate"), 
								    rs.getString("endDate") ); 
					
					list.add(vo);
				}
				
				System.out.println("dao에서 받은 총 list 개수: " + list.size());
				
			} catch (Exception e) {
				System.out.println("PgsDAO내부 getPgsList에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
			
			return list;
		}//getPgsList
		
		//DB에 접속하여 로그인 한 기업에 해당하는 채용정보 데이터를 조회해오는 메소드
		public PgsVO getPgs(int pno) {
			List<PgsVO> list = new ArrayList<PgsVO>();
			try {
				con = ds.getConnection();
				query = "SELECT * FROM pgs WHERE pno=" + pno; 
				
				pstmt = con.prepareStatement(query);
				
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					vo = new PgsVO( rs.getInt("pno"), 
						    rs.getString("pgname"), 
						    rs.getString("pgtype"), 
						    rs.getString("title"), 
						    rs.getString("content"), 
						    rs.getString("ipart"), 
						    rs.getString("teacher"), 
						    rs.getString("startTime"), 
						    rs.getString("endTime"), 
						    rs.getString("locate"), 
						    rs.getString("fileName"), 
						    rs.getString("fileRealName"), 
						    rs.getString("startDate"), 
						    rs.getString("endDate") ); 
				}
			
			} catch (Exception e) {
				System.out.println("PgsDAO내부 getPgs에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
			
			return vo;
		}

		public void regPgs(PgsVO vo) {
			try {
				con = ds.getConnection();
				query = "INSERT INTO pgs(pno, pgname, pgtype, title, content, iPart, teacher, startTime, endTime, locate, fileName, fileRealName, startDate, endDate) " + 
						"VALUES(pgs_pno.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, vo.getPgname());
				pstmt.setString(2, vo.getPgtype());
				pstmt.setString(3, vo.getTitle());
				pstmt.setString(4, vo.getContent());
				pstmt.setString(5, vo.getIpart());
				pstmt.setString(6, vo.getTeacher());
				pstmt.setString(7, vo.getStartTime());
				pstmt.setString(8, vo.getEndTime());
				pstmt.setString(9, vo.getLocate());
				pstmt.setString(10, vo.getFileName());
				pstmt.setString(11, vo.getFileRealName());
				pstmt.setString(12, vo.getStartDate());
				pstmt.setString(13, vo.getEndDate());
				
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				System.out.println("PgsDAO내부 regPgs에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
		}
		
		public void updatePgs(PgsVO vo) {
			try {
				con = ds.getConnection();
				query = "UPDATE pgs SET pgname=?, pgtype=?, title=?, content=?, iPart=?, teacher=?, startTime=?, endTime=?, locate=?, fileName=?, fileRealName=?, startDate=?, endDate=? " +
						" WHERE pno=" + vo.getPno(); 
				
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, vo.getPgname());
				pstmt.setString(2, vo.getPgtype());
				pstmt.setString(3, vo.getTitle());
				pstmt.setString(4, vo.getContent());
				pstmt.setString(5, vo.getIpart());
				pstmt.setString(6, vo.getTeacher());
				pstmt.setString(7, vo.getStartTime());
				pstmt.setString(8, vo.getEndTime());
				pstmt.setString(9, vo.getLocate());
				pstmt.setString(10, vo.getFileName());
				pstmt.setString(11, vo.getFileRealName());
				pstmt.setString(12, vo.getStartDate());
				pstmt.setString(13, vo.getEndDate());
				
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				System.out.println("PgsDAO내부 modPgs에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
		}

		public void delPgs(int pno) {
			try {
				con = ds.getConnection();
				query = "DELETE FROM pgs WHERE pno=" + pno;
				
				pstmt = con.prepareStatement(query);
				
				rs = pstmt.executeQuery();
				
			} catch (Exception e) {
				System.out.println("PgsDAO내부 delPgs에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
		}

		
		
}
