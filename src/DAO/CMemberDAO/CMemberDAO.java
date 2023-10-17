package DAO.CMemberDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import VO.CMemberVO.CMemberVO;

public class CMemberDAO {
	//위 4가지 접속 설정값을 이용해서 오라클 DB와 접속한 정보를 지니고 있는 Connection객체를 저장할 참조변수 선언
		private Connection con;
		
		//DB와 연결후 우리 개발자가 만든 SQL문장을 오라클 DB의 테이블에 전송하여 실행할 역할을 하는 Statement실행객체의 주소를 저장할 참조변수 선언
		//private Statement stmt;
		private PreparedStatement pstmt;
		
		//SELECT문을 실행한 검색결과를 임시로 저장해 놓은 ResultSet객체의 주소를 저장할 참조변수 선언
		private ResultSet rs;
		
		//DataSouce커넥션풀 역할을 하는 객체의 주소를 저장할 참조 변수
		private DataSource dataSource;
		
		//MemberDAO클래스의 기본생성자
		//역할 : new MemberDAO(); 객체 생성시 호출되는 생성자로 !!
		//		생성자 내부에서 커넥션풀 역할을 하는 DataSource객체를 얻는 작업을 하게 됩니다.
		public CMemberDAO() {
			try {
				//1.톰캣서버가 실행되면 context.xml파일에 적은 <Resource>태그의 설정을 읽어와서
				//	톰캣서버의 메모리에 <context>태그에 대한 Context객체들을 생성하여 저장해 둡니다.
				//	이때 InitialContext객체가 하는 역할은 톰캣서버 실행시 context.xml에 의해서 생성된
				//	Context객체들에 접근하는 역할을 하기 때문에 생성 합니다.
				Context ctx = new InitialContext();
				
				//2.JNDI기법(key를 이용해 값을 얻는 기법)으로 접근하기 위해 기본경로(java:/comp/env)를 지정합니다.
				// lookup("java:/comp/env"); 는 그중 톰캣서버의 환경설정에 관련된 Context객체들에 접근하기 위한 기본 경로 주소를 설정하는 것입니다
				Context envContext = (Context) ctx.lookup("java:/comp/env");
				
				//3.그런후 다시 톰캣서버는  context.xml에 설정한 <Resouce name="jdbc/oracle"....../>태그의
				// name속성값  "jdbc/oracle"(JNDI기법을 사용하기위한 key)를 이용해 톰캣 서버가 미리연결을 맺은 Connection객체들을 보관하고 있는
				// DataSouce커넥션풀 객체를 찾아서 반환해 줍니다.
				dataSource = (DataSource) envContext.lookup("jdbc/oracle");
				
			} catch (Exception e) {
				System.out.println("DataSouce커넥션풀 객체 얻기 실패  : " + e);
			}
		
		}
		
		//DB작업관련 객체 메모리들 자원해제 하는 메소드 
				public void ResourceClose() {	
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
				
	public void addMember(CMemberVO cMemberVO) {
		
		try {
			//db연결
			con = dataSource.getConnection();
			//요청한 값 얻기
			String cno = cMemberVO.getCno(); // 기업회원 사업자등록번호
			String ctel = cMemberVO.getCtel();// 기업회원 회사전화번호
			String name = cMemberVO.getName(); // 기업회원 대표자명
			String cname = cMemberVO.getCname(); // 기업명
			String divcomp = cMemberVO.getDivcomp(); //기업 사업체 구분(일반기업, 공공기관, 사회적기업)
			String jobtype = cMemberVO.getJobtype(); //모집 직종
			String password = cMemberVO.getPassword(); // 비밀번호
			
			//sql문 작성
			String sql = "insert into CMember (cno, ctel, name, divcomp, jobtype, cname,password) values(? ,? ,? ,? ,? ,?, ?)";
			pstmt = con.prepareStatement(sql);
			
				pstmt.setString(1, cno);
				pstmt.setString(2, ctel);
				pstmt.setString(3, name);
				pstmt.setString(4, divcomp);
				pstmt.setString(5, jobtype);
				pstmt.setString(6, cname);
				pstmt.setString(7, password);
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("CMemberDAO클래스에서 addMember메소드의 sql문 오류" + e);
		}finally {
			ResourceClose();
		}
	}			
}
