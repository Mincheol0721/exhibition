package DAO.applicantDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import VO.IMemberVO.IMemberVO;
import VO.applicantVO.ApplicantVO;

public class ApplicantDAO {
	//위 4가지 접속 설정값을 이용해서 오라클 DB와 접속한 정보를 지니고 있는 Connection객체를 저장할 참조변수 선언
		private Connection con;
		//DB와 연결 후 우리 개발자가 만든 SQL문장을 오라클 DB의 테이블에 전송하여 실행할 역할을 하는 Statement실행객체의 주소를 저장할 참조변수 선언
		//private Statement stmt;
		private PreparedStatement pstmt;
		//SELECT문을 실행한 검색결과를 임시로 저장해 놓은 ResultSet객체의 주소를 저장할 참조변수 선언
		private ResultSet rs;
		//DataSouce커넥션풀 역할을 하는 객체의 주소를 저장할 참조변수
		private DataSource ds;
		//AppFormVO 객체를 저장할 변수
		private ApplicantVO vo;
		//쿼리문을 저장할 변수
		private String query;
		//리스트를 저장할 변수
		List<ApplicantVO> list;
		
		//MemberDAO클래스의 기본생성자
		//역할 : new MemberDAO(); 객체 생성시 호출되는 생성자로 !!
		//     생성자 내부에서 커넥션풀 역할을 하는 DataSouce객체를 얻는 작업을 하게 됩니다.
		public ApplicantDAO() {
		
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
		
		public int getICount() {
			int count = 0;
			
			try {
				con = ds.getConnection();
				query = "SELECT count(*) FROM ijobexp";
				
				pstmt = con.prepareStatement(query);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt(1);
				}
				
			} catch (Exception e) {
				System.out.println("ApplicantDAO내부 getICount에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
			
			return count;
		};
		
		public int getCCount() {
			int count = 0;
			
			try {
				con = ds.getConnection();
				query = "SELECT count(*) FROM cjobexpreg";
				
				pstmt = con.prepareStatement(query);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt(1);
				}
				
			} catch (Exception e) {
				System.out.println("ApplicantDAO내부 getCCount에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
			
			return count;
		};
		
		public int getConsCount(String constype) {
			int count = 0;
			
			try {
				con = ds.getConnection();
				query = "SELECT count(*) FROM cons WHERE constype='" + constype + "'";
				
				pstmt = con.prepareStatement(query);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt(1);
				}
				
			} catch (Exception e) {
				System.out.println("ApplicantDAO내부 getConsCount에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
			
			return count;
		};
		
		public int getJSCount() {
			int count = 0;
			
			try {
				con = ds.getConnection();
				query = "SELECT count(*) FROM imember WHERE isSeek=0";
				
				pstmt = con.prepareStatement(query);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt(1);
				}
				
			} catch (Exception e) {
				System.out.println("ApplicantDAO내부 getJSCount에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
			
			return count;
		};
		
		//신청한 직업체험 리스트들을 전부 조회해오는 메소드
		public List<ApplicantVO> getCList(int pageNum, int pageSize) {
			list = new ArrayList<ApplicantVO>();
			
			try {
				con = ds.getConnection();
				query = "SELECT * FROM ( "
					  + " SELECT ROWNUM AS rn, c.* "
					  + " FROM cjobexpreg c "
					  + " WHERE ROWNUM <= ( " + pageNum + "*" + pageSize + ") "
					  + " ) WHERE rn >= ( ( " + pageNum + " - 1 ) * " + pageSize + ") + 1 "
					  + " ORDER BY startdate ASC";
				
				pstmt = con.prepareStatement(query);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					vo = new ApplicantVO( rs.getString("cname"), 
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
					
					vo.setIsrecog(rs.getInt("isrecog"));
					list.add(vo);
				}
				
			} catch (Exception e) {
				System.out.println("ApplicantDAO내부 getCList에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
			
			return list;
		}

		public List<ApplicantVO> getIList(int pageNum, int pageSize) {
			list = new ArrayList<ApplicantVO>();
			
			try {
				con = ds.getConnection();
				query = "SELECT * FROM ( "
						  + " SELECT ROWNUM AS rn, i.* "
						  + " FROM ijobexp i "
						  + " WHERE ROWNUM <= ( " + pageNum + "*" + pageSize + ") "
						  + " ) WHERE rn >= ( ( " + pageNum + " - 1 ) * " + pageSize + ") + 1 "
						  + " ORDER BY regdate ASC";
				pstmt = con.prepareStatement(query);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					vo = new ApplicantVO( rs.getString("tel"), 
										  rs.getString("name"), 
										  rs.getString("jobexpname") );
					vo.setNo(rs.getInt("no"));
					vo.setRegDate(rs.getString("regDate"));
					
					list.add(vo);
				}
				
			} catch (Exception e) {
				System.out.println("ApplicantDAO내부 getIList에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
			
			return list;
		}
		
		public List<ApplicantVO> getConsList(int pageNum, int pageSize, String constype) {
			list = new ArrayList<ApplicantVO>();
			
			try {
				con = ds.getConnection();
				query = "SELECT * FROM ( "
						  + " SELECT ROWNUM AS rn, c.* "
						  + " FROM cons c "
						  + " WHERE constype='" + constype + "' and "
						  + " ROWNUM <= ( " + pageNum + "*" + pageSize + ") "
						  + " ) WHERE rn >= ( ( " + pageNum + " - 1 ) * " + pageSize + ") + 1 ";
				pstmt = con.prepareStatement(query);
				
				System.out.println("query문: " + query);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					vo = new ApplicantVO();
					vo.setTitle(rs.getString("title")); 
					vo.setContent(rs.getString("content")); 
					vo.setIpart(rs.getString("iPart")); 
					vo.setStartTime(rs.getString("startTime")); 
					vo.setEndTime(rs.getString("endTime")); 
					vo.setLocate(rs.getString("locate")); 
					vo.setFileName(rs.getString("fileName")); 
					vo.setFileRealName(rs.getString("fileRealName")); 
					vo.setUsePeople(rs.getInt("usePeople")); 
					vo.setReservation(rs.getInt("reservation")); 
					vo.setAmpm(rs.getString("ampm")); 
					vo.setHomepage(rs.getString("homepage")); 
					vo.setConstype(rs.getString("consType"));
					vo.setSitel(rs.getString("sitel") );
					vo.setNo(rs.getInt("no"));
					vo.setName(rs.getString("name"));
					vo.setRegDate(rs.getString("regDate"));
					
					list.add(vo);
				}
				
			} catch (Exception e) {
				System.out.println("ApplicantDAO내부 getMeetings에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
			
			return list;
		}
		
		public ApplicantVO getCons(int no) {
			try {
				con = ds.getConnection();
				query = "SELECT * FROM cons WHERE no=" + no;
				pstmt = con.prepareStatement(query);
				rs = pstmt.executeQuery();
				pstmt = con.prepareStatement(query);
				
				System.out.println("query문: " + query);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					vo = new ApplicantVO();
					vo.setTitle(rs.getString("title")); 
					vo.setContent(rs.getString("content")); 
					vo.setIpart(rs.getString("iPart")); 
					vo.setStartTime(rs.getString("startTime")); 
					vo.setEndTime(rs.getString("endTime")); 
					vo.setLocate(rs.getString("locate")); 
					vo.setFileName(rs.getString("fileName")); 
					vo.setFileRealName(rs.getString("fileRealName")); 
					vo.setUsePeople(rs.getInt("usePeople")); 
					vo.setReservation(rs.getInt("reservation")); 
					vo.setAmpm(rs.getString("ampm")); 
					vo.setHomepage(rs.getString("homepage")); 
					vo.setConstype(rs.getString("consType"));
					vo.setSitel(rs.getString("sitel") );
					vo.setNo(rs.getInt("no"));
					vo.setName(rs.getString("name"));
					vo.setRegDate(rs.getString("regDate"));
				}
				
			} catch (Exception e) {
				System.out.println("ApplicantDAO내부 getMeeting(단일)에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
			
			return vo;
		}

		public void delCons(int no) {
			try {
				con = ds.getConnection();
				query = "DELETE FROM cons WHERE no=" + no;
				pstmt = con.prepareStatement(query);
				
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				System.out.println("ApplicantDAO내부 delCons에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
		}

		public void updateCons(ApplicantVO vo, int no) {
			
			try {
				con = ds.getConnection();
				query = "UPDATE cons SET regDate=?, startTime=?, name=?, sitel=? WHERE no=" + no;
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, vo.getRegDate());
				pstmt.setString(2, vo.getStartTime());
				pstmt.setString(3, vo.getName());
				pstmt.setString(4, vo.getSitel());
				
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				System.out.println("ApplicantDAO내부 updateCons에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
		}

		public List<IMemberVO> getImemberList(int pageNum, int pageSize) {
			List<IMemberVO> list = new ArrayList<IMemberVO>();
			System.out.println("pageNum: " + pageNum + ", pageSize: " + pageSize);
			try {
				con = ds.getConnection();
				query = "SELECT * FROM ( "
						  + " SELECT ROWNUM AS rn, i.* "
						  + " FROM imember i "
						  + " WHERE isseek <> -1 and "
						  + " ROWNUM <= ( " + pageNum + "*" + pageSize + ") "
						  + " ORDER BY ID ASC "
						  + " ) WHERE rn >= ( ( " + pageNum + " - 1 ) * " + pageSize + ") + 1 ";
				pstmt = con.prepareStatement(query);
				
				System.out.println("query문: " + query);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					IMemberVO vo = new IMemberVO( rs.getString("id"), 
												  rs.getString("password"), 
												  rs.getString("ssn"), 
												  rs.getString("name"), 
												  rs.getString("addr1"),
												  rs.getString("addr2"),
												  rs.getString("addr3"),
												  rs.getString("addr4"),
												  rs.getString("itel"),
												  rs.getString("email"),
												  rs.getString("fileName"),
												  rs.getString("fileRealName") );
					vo.setRegDate(rs.getDate("regDate").toString());
					vo.setIsSeek(rs.getInt("isseek"));
					
					list.add(vo);
				}
				
			} catch (Exception e) {
				System.out.println("ApplicantDAO내부 getImemberList에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
			
			return list;
		}

		public IMemberVO getJobSeeker(String id) {
			IMemberVO vo = new IMemberVO();
			System.out.println("id: " + id);
			try {
				con = ds.getConnection();
				query = "SELECT * FROM imember WHERE id='" + id + "'";
				pstmt = con.prepareStatement(query);
				
				System.out.println("query문: " + query);
				
				rs = pstmt.executeQuery();
				
				if (rs.next()) {
					vo = new IMemberVO( rs.getString("id"), 
												  rs.getString("password"), 
												  rs.getString("ssn"), 
												  rs.getString("name"), 
												  rs.getString("addr1"),
												  rs.getString("addr2"),
												  rs.getString("addr3"),
												  rs.getString("addr4"),
												  rs.getString("itel"),
												  rs.getString("email"),
												  rs.getString("fileName"),
												  rs.getString("fileRealName") );
					System.out.println(rs.getDate("regDate").toString());
					vo.setRegDate(rs.getDate("regDate").toString());
					vo.setIsSeek(rs.getInt("isseek"));
				}
				
			} catch (Exception e) {
				System.out.println("ApplicantDAO내부 getJobSeeker에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
			
			return vo;
		}

		public void updateJobSeeker(IMemberVO vo, String id) {
			try {
				con = ds.getConnection();
				query = "UPDATE imember SET name=?, itel=?, ssn=?, email=?, addr1=?, addr2=?, addr3=?, addr4=?, regDate=?, isSeek=? WHERE id='" + id + "'";
				pstmt = con.prepareStatement(query);
				pstmt.setString(1, vo.getName());
				pstmt.setString(2, vo.getItel());
				pstmt.setString(3, vo.getSsn());
				pstmt.setString(4, vo.getEmail());
				pstmt.setString(5, vo.getAddr1());
				pstmt.setString(6, vo.getAddr2());
				pstmt.setString(7, vo.getAddr3());
				pstmt.setString(8, vo.getAddr4());
				pstmt.setString(9, vo.getRegDate());
				pstmt.setInt(10, vo.getIsSeek());
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				System.out.println("ApplicantDAO내부 updateJS에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
		}

		public void delJobSeeker(String id) {
			try {
				con = ds.getConnection();
				query = "DELETE FROM imember WHERE id='" + id + "'";
				pstmt = con.prepareStatement(query);
				
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				System.out.println("ApplicantDAO내부 delJobSeeker에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
		}

}
