package DAO.appFormDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import VO.CMemberVO.CMemberVO;
import VO.appFormVO.AppFormVO;

public class AppFormDAO {
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
		private AppFormVO vo;
		//쿼리문을 저장할 변수
		private String query;
		
		//MemberDAO클래스의 기본생성자
		//역할 : new MemberDAO(); 객체 생성시 호출되는 생성자로 !!
		//     생성자 내부에서 커넥션풀 역할을 하는 DataSouce객체를 얻는 작업을 하게 됩니다.
		public AppFormDAO() {
		
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
		
		public String getCname(String cno) {
			String cname="";
			
			try {
				con = ds.getConnection();
				
				query = "select cname from cmember where cno='" + cno + "'";
				
				pstmt = con.prepareStatement(query);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					cname = rs.getString("cname");
				}
				
			} catch (Exception e) {
				System.out.println("AppFormDAO내부의 getCname에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
			
			return cname;
		}
		
		//DB에 접속하여 레코드 총 개수를 반환하는 메소드
		public int getAppFormCount(String cname) {
			int count = 0;
			
			try {
				con = ds.getConnection();
				
				query = "select count(*) from appform where cname='" + cname + "'";
				
				pstmt = con.prepareStatement(query);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt(1);
				}
				
			} catch (Exception e) {
				System.out.println("AppFormDAO내부의 getAppFormCount에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
			
			return count;
		}
		
		//DB에 접속하여 입사지원서 테이블 중 로그인 한 회사에 지원한 지원서 데이터들만 조회해오는 메소드
		public List<AppFormVO> getAppFormList(int pageNum, int pageSize, String cname) {
			
			List<AppFormVO> list = new ArrayList<AppFormVO>(); 
			
			try {
				con = ds.getConnection();
				System.out.println("pageNum: " + pageNum);
				System.out.println("pageSize: " + pageSize);
				query = "SELECT * " + 
						"FROM ( " + 
						"    SELECT ROWNUM AS rn, a.* " + 
						"    FROM ( " + 
						"	 SELECT " + 
						"        af.name AS name, " + 
						"        af.ssn AS ssn, " + 
						"        af.cname AS acname, " + 
						"        af.addr AS addr, " + 
						"        af.tel AS tel, " + 
						"        af.milServ AS milServ, " + 
						"        af.edu AS edu, " + 
						"        af.eduStat AS eduStat, " + 
						"        MAX(ce.cname) AS cname, " + 
						"        MAX(ce.startDate) AS cstartDate, " + 
						"        MAX(ce.endDate) AS cendDate, " + 
						"        MAX(ce.damdang) AS damdang, " + 
						"        MAX(l.lname) AS lname, " + 
						"        MAX(l.lnum) AS lnum, " + 
						"        MAX(l.getDate) AS getDate, " + 
						"        MAX(l.pub) AS publisher, " + 
						"        MAX(t.eduName) AS eduName, " + 
						"        MAX(t.startDate) AS eduStartDate, " + 
						"        MAX(t.endDate) AS eduEndDate, " + 
						"        MAX(t.content) AS eduContent" + 
						"        FROM appForm af " + 
						"        LEFT JOIN careerExp ce ON af.name = ce.name " + 
						"        LEFT JOIN license l ON af.name = l.name " + 
						"        LEFT JOIN training t ON af.name = t.name " +
						"		 GROUP BY " + 
						"            af.name, " + 
						"            af.ssn, " + 
						"            af.cname, " + 
						"            af.addr, " + 
						"            af.tel, " + 
						"            af.milServ, " + 
						"            af.edu, " + 
						"            af.eduStat" + 
						"    ) a" + 
						"    WHERE a.acname='" + cname + "' and " + 
						" ROWNUM <= ( " + pageNum + " * " + pageSize + ") " + 
						" ) " + 
						" WHERE rn >= ((" + pageNum + " - 1) * " + pageSize + ") + 1";
				
				pstmt = con.prepareStatement(query);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					vo = new AppFormVO(); 
					vo.setName(rs.getString("name"));
					vo.setSsn(rs.getString("ssn"));
					vo.setAddr(rs.getString("addr")); 
					vo.setTel(rs.getString("tel")); 
					vo.setMilServ(rs.getString("milServ")); 
					vo.setEdu(rs.getString("edu")); 
					vo.setEduStat(rs.getString("eduStat"));
					vo.setCname(rs.getString("cname"));
					vo.setCstartDate(rs.getString("cstartDate"));
					vo.setCendDate(rs.getString("cendDate"));
					vo.setDamdang(rs.getString("damdang"));
					vo.setLname(rs.getString("lname"));
					vo.setLnum(rs.getString("lnum"));
					vo.setGetDate(rs.getString("getDate"));
					vo.setPub(rs.getString("publisher"));
					vo.setEduName(rs.getString("eduname"));
					vo.setTstartDate(rs.getString("edustartdate"));
					vo.setTendDate(rs.getString("eduenddate"));
					vo.setContent(rs.getString("educontent"));
					
					list.add(vo);
				}
				
				System.out.println("dao에서 받은 총 list 개수: " + list.size());
				
			} catch (Exception e) {
				System.out.println("AppFormDAO내부 getAppFormList에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
			
			return list;
		}//getAppFormList
		
		//DB에 접속하여 로그인 한 기업에 해당하는 채용정보 데이터를 조회해오는 메소드
		public AppFormVO getAppForm(String ssn) {
			List<AppFormVO> list = new ArrayList<AppFormVO>();
			try {
				con = ds.getConnection();
				query = "SELECT * " + 
						"FROM ( " + 
						"    SELECT ROWNUM AS rn, a.* " + 
						"    FROM ( " + 
						"	 SELECT " + 
						"        af.name AS name, " + 
						"        af.ssn AS ssn, " + 
						"        af.cname AS acname, " + 
						"        af.addr AS addr, " + 
						"        af.tel AS tel, " + 
						"        af.milServ AS milServ, " + 
						"        af.edu AS edu, " + 
						"        af.eduStat AS eduStat, " + 
						"        ce.cname AS cname, " + 
						"        ce.startDate AS cstartDate, " + 
						"        ce.endDate AS cendDate, " + 
						"        ce.damdang AS damdang, " + 
						"        l.lname AS lname, " + 
						"        l.lnum AS lnum, " + 
						"        l.getDate AS getDate, " + 
						"        l.pub AS publisher, " + 
						"        t.eduName AS eduName, " + 
						"        t.startDate AS eduStartDate, " + 
						"        t.endDate AS eduEndDate, " + 
						"        t.content AS eduContent" + 
						"        FROM appForm af " + 
						"        LEFT JOIN careerExp ce ON af.name = ce.name " + 
						"        LEFT JOIN license l ON af.name = l.name " + 
						"        LEFT JOIN training t ON af.name = t.name " +
						"    ) a" + 
						"    WHERE a.ssn='" + ssn + "')"; 
						
				
				pstmt = con.prepareStatement(query);
				
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					vo = new AppFormVO();
					vo.setName(rs.getString("name"));
					vo.setSsn(rs.getString("ssn"));
					vo.setAddr(rs.getString("addr")); 
					vo.setTel(rs.getString("tel")); 
					vo.setMilServ(rs.getString("milServ")); 
					vo.setEdu(rs.getString("edu")); 
					vo.setEduStat(rs.getString("eduStat"));
					vo.setCname(rs.getString("cname"));
					vo.setCstartDate(rs.getString("cstartDate"));
					vo.setCendDate(rs.getString("cendDate"));
					vo.setDamdang(rs.getString("damdang"));
					vo.setLname(rs.getString("lname"));
					vo.setLnum(rs.getString("lnum"));
					vo.setGetDate(rs.getString("getDate"));
					vo.setPub(rs.getString("publisher"));
					vo.setEduName(rs.getString("eduname"));
					vo.setTstartDate(rs.getString("edustartdate"));
					vo.setTendDate(rs.getString("eduenddate"));
					vo.setContent(rs.getString("educontent"));
					
				}
			
			} catch (Exception e) {
				System.out.println("AppFormDAO내부 getAppForm에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
			
			return vo;
		}
		
		//DB에 접속하여 로그인 한 기업에 해당하는 채용정보 데이터를 조회해오는 메소드
		public List<AppFormVO> getCareerExp(String ssn) {
			List<AppFormVO> list = new ArrayList<AppFormVO>();
			try {
				con = ds.getConnection();
				query = "SELECT * " + 
						"FROM ( " + 
						"    SELECT ROWNUM AS rn, a.* " + 
						"    FROM ( " + 
						"	 SELECT " + 
						"        af.name AS name, " + 
						"        af.ssn AS ssn, " + 
						"        af.cname AS acname, " + 
						"        af.addr AS addr, " + 
						"        af.tel AS tel, " + 
						"        af.milServ AS milServ, " + 
						"        af.edu AS edu, " + 
						"        af.eduStat AS eduStat, " + 
						"        ce.cname AS cname, " + 
						"        ce.startDate AS cstartDate, " + 
						"        ce.endDate AS cendDate, " + 
						"        ce.damdang AS damdang, " + 
						"        l.lname AS lname, " + 
						"        l.lnum AS lnum, " + 
						"        l.getDate AS getDate, " + 
						"        l.pub AS publisher, " + 
						"        t.eduName AS eduName, " + 
						"        t.startDate AS eduStartDate, " + 
						"        t.endDate AS eduEndDate, " + 
						"        t.content AS eduContent" + 
						"        FROM appForm af " + 
						"        LEFT JOIN careerExp ce ON af.name = ce.name " + 
						"        LEFT JOIN license l ON af.name = l.name " + 
						"        LEFT JOIN training t ON af.name = t.name " +
						"    ) a" + 
						"    WHERE a.ssn='" + ssn + "')"; 
				
				
				pstmt = con.prepareStatement(query);
				
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					vo = new AppFormVO();
					
					vo.setCname(rs.getString("cname"));
					vo.setCstartDate(rs.getString("cstartDate"));
					vo.setCendDate(rs.getString("cendDate"));
					vo.setDamdang(rs.getString("damdang"));
					
					list.add(vo);
				}
				
			} catch (Exception e) {
				System.out.println("AppFormDAO내부 getCareerExp에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
			
			return list;
		}
		
		//DB에 접속하여 로그인 한 기업에 해당하는 채용정보 데이터를 조회해오는 메소드
		public List<AppFormVO> getLicense(String ssn) {
			List<AppFormVO> list = new ArrayList<AppFormVO>();
			try {
				con = ds.getConnection();
				query = "SELECT * " + 
						"FROM ( " + 
						"    SELECT ROWNUM AS rn, a.* " + 
						"    FROM ( " + 
						"	 SELECT " + 
						"        af.name AS name, " + 
						"        af.ssn AS ssn, " + 
						"        af.cname AS acname, " + 
						"        af.addr AS addr, " + 
						"        af.tel AS tel, " + 
						"        af.milServ AS milServ, " + 
						"        af.edu AS edu, " + 
						"        af.eduStat AS eduStat, " + 
						"        ce.cname AS cname, " + 
						"        ce.startDate AS cstartDate, " + 
						"        ce.endDate AS cendDate, " + 
						"        ce.damdang AS damdang, " + 
						"        l.lname AS lname, " + 
						"        l.lnum AS lnum, " + 
						"        l.getDate AS getDate, " + 
						"        l.pub AS publisher, " + 
						"        t.eduName AS eduName, " + 
						"        t.startDate AS eduStartDate, " + 
						"        t.endDate AS eduEndDate, " + 
						"        t.content AS eduContent" + 
						"        FROM appForm af " + 
						"        LEFT JOIN careerExp ce ON af.name = ce.name " + 
						"        LEFT JOIN license l ON af.name = l.name " + 
						"        LEFT JOIN training t ON af.name = t.name " +
						"    ) a" + 
						"    WHERE a.ssn='" + ssn + "')"; 
						
				
				pstmt = con.prepareStatement(query);
				
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					vo = new AppFormVO();
					vo.setLname(rs.getString("lname"));
					vo.setLnum(rs.getString("lnum"));
					vo.setGetDate(rs.getString("getDate"));
					vo.setPub(rs.getString("publisher"));
					
					list.add(vo);
				}
			
			} catch (Exception e) {
				System.out.println("AppFormDAO내부 getAppForm에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
			
			return list;
		}

		//DB에 접속하여 로그인 한 기업에 해당하는 채용정보 데이터를 조회해오는 메소드
		public List<AppFormVO> getTraining(String ssn) {
			List<AppFormVO> list = new ArrayList<AppFormVO>();
			try {
				con = ds.getConnection();
				query = "SELECT * " + 
						"FROM ( " + 
						"    SELECT ROWNUM AS rn, a.* " + 
						"    FROM ( " + 
						"	 SELECT " + 
						"        af.name AS name, " + 
						"        af.ssn AS ssn, " + 
						"        af.cname AS acname, " + 
						"        af.addr AS addr, " + 
						"        af.tel AS tel, " + 
						"        af.milServ AS milServ, " + 
						"        af.edu AS edu, " + 
						"        af.eduStat AS eduStat, " + 
						"        ce.cname AS cname, " + 
						"        ce.startDate AS cstartDate, " + 
						"        ce.endDate AS cendDate, " + 
						"        ce.damdang AS damdang, " + 
						"        l.lname AS lname, " + 
						"        l.lnum AS lnum, " + 
						"        l.getDate AS getDate, " + 
						"        l.pub AS publisher, " + 
						"        t.eduName AS eduName, " + 
						"        t.startDate AS eduStartDate, " + 
						"        t.endDate AS eduEndDate, " + 
						"        t.content AS eduContent" + 
						"        FROM appForm af " + 
						"        LEFT JOIN careerExp ce ON af.name = ce.name " + 
						"        LEFT JOIN license l ON af.name = l.name " + 
						"        LEFT JOIN training t ON af.name = t.name " +
						"    ) a" + 
						"    WHERE a.ssn='" + ssn + "')"; 
						
				
				pstmt = con.prepareStatement(query);
				
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					vo = new AppFormVO();
					vo.setEduName(rs.getString("eduname"));
					vo.setTstartDate(rs.getString("edustartdate"));
					vo.setTendDate(rs.getString("eduenddate"));
					vo.setContent(rs.getString("educontent"));
					
					list.add(vo);
				}
			
			} catch (Exception e) {
				System.out.println("AppFormDAO내부 getAppForm에서 예외 발생: " + e);
			} finally {
				freeResource();
			}
			
			return list;
		}
		
		
}
