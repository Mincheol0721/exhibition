package DAO.joinDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import VO.CMemberVO.CMemberVO;
import VO.IMemberVO.IMemberVO;

public class JoinDAO {
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
		public JoinDAO() {
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
				
		//개인 회원가입 처리하는 메소드
		public void addIMember(IMemberVO vo) {
			try {
				//DB연결
				con = dataSource.getConnection();
				
				//2. IMember테이블에 insert할 값 ! 즉! 우리가 입력한 회원정보들은 IMemberVO객체의 각 인스턴스변수에 저장되어 있으므로
				//   MemberVO객체의 getter메소드들을 호출해서 각 인스턴스 변수에 저장된 입력한 값들을 반환받자.
				String id = vo.getId();
				String password = vo.getPassword();
				String ssn = vo.getSsn();
				String name = vo.getName();
				String itel = vo.getItel();
				String email = vo.getEmail();
				String addr1 = vo.getAddr1();
				String addr2 = vo.getAddr2();
				String addr3 = vo.getAddr3();
				String addr4 = vo.getAddr4();
				String filename = vo.getFileName();
				String fileRealName = vo.getFileRealName();
				//sql문 작성
				String sql = "insert into iMember(id, password, ssn, name, itel, email, addr1, addr2, addr3, addr4,filename,fileRealName) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				
				pstmt= con.prepareStatement(sql);
				
				pstmt.setString(1, id);
				pstmt.setString(2, password);
				pstmt.setString(3, ssn);
				pstmt.setString(4, name);
				pstmt.setString(5, itel);
				pstmt.setString(6, email);
				pstmt.setString(7, addr1);
				pstmt.setString(8, addr2);
				pstmt.setString(9, addr3);
				pstmt.setString(10, addr4);
				pstmt.setString(11, filename);
				pstmt.setString(12, fileRealName);
				pstmt.executeUpdate();
				
			} catch (Exception e) {
				System.out.println("JoinDAO클래스의 addImeber메소드 sql문 오류 발생" + e);
			}finally {
				freeResource();
			}
		}
		
		//기업회원가입 처리할 메소드
		public void addCMember(CMemberVO vo) {
			try {
				//DB연결
				con = dataSource.getConnection();
				
				//2. IMember테이블에 insert할 값 ! 즉! 우리가 입력한 회원정보들은 IMemberVO객체의 각 인스턴스변수에 저장되어 있으므로
				//   MemberVO객체의 getter메소드들을 호출해서 각 인스턴스 변수에 저장된 입력한 값들을 반환받자.
				String cno = vo.getCno(); // 기업회원 사업자등록번호
				String ctel = vo.getCtel();// 기업회원 회사전화번호
				String name = vo.getName(); // 기업회원 대표자명
				String cname = vo.getCname(); // 기업명
				String divcomp = vo.getDivcomp(); //기업 사업체 구분(일반기업, 공공기관, 사회적기업)
				String jobtype = vo.getJobtype(); //모집 직종
				String password = vo.getPassword(); // 비밀번호
				String fileName = vo.getFileName();
				String fileRealName = vo.getFileRealName();
				String addr1 = vo.getAddr1();
				String addr2 = vo.getAddr2();
				String addr3 = vo.getAddr3();
				String addr4 = vo.getAddr4();
				//sql문 작성
				String sql = "insert into CMember "
						+ " (cno, ctel, name, divcomp, jobtype, cname, password,fileName,fileRealName,addr1,addr2,addr3,addr4) "
						+ " values(? ,? ,? ,? ,? ,?, ?, ?, ?, ?, ?, ?, ?)";
				pstmt = con.prepareStatement(sql);
				
					pstmt.setString(1, cno);
					pstmt.setString(2, ctel);
					pstmt.setString(3, name);
					pstmt.setString(4, divcomp);
					pstmt.setString(5, jobtype);
					pstmt.setString(6, cname);
					pstmt.setString(7, password);
					pstmt.setString(8, fileName);
					pstmt.setString(9, fileRealName);
					pstmt.setString(10, addr1);
					pstmt.setString(11, addr2);
					pstmt.setString(12, addr3);
					pstmt.setString(13, addr4);
				pstmt.executeUpdate();
				
				
			} catch (Exception e) {
				System.out.println("JoinDAO클래스의 addCMember메소드 sql문 오류 발생" + e);
			}finally {
				freeResource();
			}
			
		}
		
		//아이디 중복 체크
		public boolean overlappedId(String id) {
			
			boolean result = false;
			
			try {
				
				//DB접속 : 커넥션풀에 만들어져 있는 커넥션 얻기
				con = dataSource.getConnection();
				//오라클의 decode()함수를 이용하여 서블릿에서 전달되는
				//입력한 ID에 해당하는 데이터를 검색하여 true 또는 false를 반환하는데
				//검색한 갯수가 1(검색한 레코드가 존재하면)이면 'true'를 반환,
				//존재하지 않으면 'false'를 문자열로 반환하여 조회합니다.
				String sql = "select decode(count(*), 1, 'true', 'false') as result from imember where id=?";
				//SELECT문장을 DB의 member테이블에 전송해서 조회할 PreparedStatement객체 얻기
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, id);
				//SLELCT문장을 실행하여 조회된 데이터들을 ResultSet에 담아 반환 받기
				rs = pstmt.executeQuery();
				
				rs.next(); //조회된 제목줄에 커서(화살표)가 있다가 조회된 줄로 내려가 위치함
				
				String value = rs.getString("result");
				result = Boolean.parseBoolean(value);
				//true면 중복 , false면 중복아님
				
			} catch (Exception e) {
				System.out.println("overlappedId 메소드 내부에서 오류!");
				e.printStackTrace();
			}finally {
				freeResource();
			}
			
			return result;
		}
		
		public boolean overlappedCno(String cno) {
			
			boolean result = false;
			
			try {
				
				//DB접속 : 커넥션풀에 만들어져 있는 커넥션 얻기
				con = dataSource.getConnection();
				//오라클의 decode()함수를 이용하여 서블릿에서 전달되는
				//입력한 ID에 해당하는 데이터를 검색하여 true 또는 false를 반환하는데
				//검색한 갯수가 1(검색한 레코드가 존재하면)이면 'true'를 반환,
				//존재하지 않으면 'false'를 문자열로 반환하여 조회합니다.
				String sql = "select decode(count(*), 1, 'true', 'false') as result from Cmember where cno=?";
				//SELECT문장을 DB의 member테이블에 전송해서 조회할 PreparedStatement객체 얻기
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, cno);
				//SLELCT문장을 실행하여 조회된 데이터들을 ResultSet에 담아 반환 받기
				rs = pstmt.executeQuery();
				
				rs.next(); //조회된 제목줄에 커서(화살표)가 있다가 조회된 줄로 내려가 위치함
				
				String value = rs.getString("result");
				result = Boolean.parseBoolean(value);
				//true면 중복 , false면 중복아님
				
			} catch (Exception e) {
				System.out.println("overlappedId 메소드 내부에서 오류!");
				e.printStackTrace();
			}finally {
				freeResource();
			}
			
			return result;
		}
		
}//class 끝
