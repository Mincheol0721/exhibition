package DAO.loginDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class LoginDAO {
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
			public LoginDAO() {
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
			public int ilogin(String id, String pwd) {
				int check = -1;
				try {
					//DB연결
					con = dataSource.getConnection();
					//sql문 작성
					String sql = "select id,password,isAdmin from Imember where id = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, id);
					
					rs = pstmt.executeQuery();
					if(rs.next()) {//입력한 아이디로 조회한 행이 있으면? (아이디가 있으면?)
						
						//입력한 비밀번호와 조회된 비밀번호와 비교해서 있으면 ?(비밀번호가 있으면?)
						if(pwd.equals(rs.getString("password"))) {
							check = 1;
						}else {//아이디는 맞고 , 비밀번호 틀림
							check = 0;
						}
					}else {//아이디가 틀림
						check = -1;
					}
					
				} catch (Exception e) {
					System.out.println("LoginDAO클래스의 Ilogin메소드의 sql문 오류 발생" + e);
				}finally {
					freeResource();
				}
				
				
				return check;
			}
			
			public int adminCheck(String id) {
				int check = 0;
				try {
					//DB연결
					con = dataSource.getConnection();
					//sql문 작성
					String sql = "select id,password,isAdmin from Imember where id = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, id);
					rs = pstmt.executeQuery();
					
					if (rs.next()) {
						check = rs.getInt("isAdmin");
					}
					
				} catch (Exception e) {
					System.out.println("LoginDAO클래스의 adminCheck메소드의 sql문 오류 발생" + e);
				}finally {
					freeResource();
				}
				return check;
			}

			public int clogin(String cno,String cPwd) {
				int check = -1;
				try {
					//DB연결
					con = dataSource.getConnection();
					//Sql문 작성
					String sql = "select cno,password from Cmember where cno = ?";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, cno);
					
					rs = pstmt.executeQuery();
					if(rs.next()) {//입력한 아이디로 조회한 행이 있으면? (아이디가 있으면?)
						
						//입력한 비밀번호와 조회된 비밀번호와 비교해서 있으면 ?(비밀번호가 있으면?)
						if(cPwd.equals(rs.getString("password"))) {
							check = 1;
						}else {//아이디는 맞고 , 비밀번호 틀림
							check = 0;
						}
					}else {//아이디가 틀림
						check = -1;
					}
					
				} catch (Exception e) {
					System.out.println("LoginDAO클래스의 clogin메소드의 sql문 오류 발생" + e);
				}finally {
					freeResource();
				}
				
				
				return check;
			}
}//class의 끝
