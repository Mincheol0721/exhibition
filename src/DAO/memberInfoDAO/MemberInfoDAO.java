package DAO.memberInfoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.apache.regexp.recompile;

import VO.CMemberVO.CMemberVO;
import VO.IMemberVO.IMemberVO;
import VO.appFormVO.AppFormVO;
import VO.consVO.ConsVO;
import VO.iJobExpVO.IjobExpVO;
import VO.iapplicationVO.AllAppFormVO;
import VO.iapplicationVO.CareerExpVO;
import VO.iapplicationVO.LicenseVO;
import VO.iapplicationVO.TrainingVO;

public class MemberInfoDAO {
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
			public MemberInfoDAO() {
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
			

			
			//회원 수정화면에서 조회해올 메소드
			public IMemberVO searchMyInfo(String id) {
				IMemberVO vo = null;
				try {
					//DB연결
					con = dataSource.getConnection();
					//sql문 작성
					String sql = "select * from iMember where id = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, id);
					rs = pstmt.executeQuery();
					
					while (rs.next()) {
						String password = rs.getString("password");//비밀번호
						String ssn = rs.getString("ssn");
						String name = rs.getString("name"); // 이름
						String itel = rs.getString("itel"); //전화번호
						String email = rs.getString("email"); //이메일
						String addr1 = rs.getString("addr1"); // 주소
						String addr2 = rs.getString("addr2"); // 주소
						String addr3 = rs.getString("addr3"); // 주소
						String addr4 = rs.getString("addr4"); // 주소
						String fileRealName = rs.getString("fileRealName"); //파일의 실제 이름
						
						vo = new IMemberVO(id, password, ssn, name, addr1, addr2, addr3, addr4, itel, email,fileRealName);
						
					}
					
				} catch (Exception e) {
					System.out.println("MemberInfoDAO클래스의 searchMyInfo메소드의 sql문 오류" + e);
				}finally {
					freeResource();
				}
				return vo;
			}
			//회원 수정 기능을 수행할 메소드
			public int modifyMyInfo(IMemberVO vo, String id) {
					int check = -1;
				try {
					//DB연결
					con = dataSource.getConnection();
					//sql문 작성
					String sql = "update imember SET password = ?, name = ?, "
							+ " addr1 = ?, addr2 = ?, addr3 = ?, addr4 = ?, itel = ?, email = ? WHERE id = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, vo.getPassword());
					pstmt.setString(2, vo.getName());
					pstmt.setString(3, vo.getAddr1());
					pstmt.setString(4, vo.getAddr2());
					pstmt.setString(5, vo.getAddr3());
					pstmt.setString(6, vo.getAddr4());
					pstmt.setString(7, vo.getItel());
					pstmt.setString(8, vo.getEmail());
					pstmt.setString(9, id);
					
					check = pstmt.executeUpdate();
					
				} catch (Exception e) {
					
				}finally {
					freeResource();
				}
				return check;
			}
			//기업회원 테이블에서 조회해올 메소드
			public CMemberVO searchCInfo(String cno) {
				CMemberVO vo = null;
				String sql = null;
				try {
					//DB연결
					con = dataSource.getConnection();
					//sql문 작성
					sql = "select * from cMember where cno = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, cno);
					rs = pstmt.executeQuery();
					
					while (rs.next()) {
						String password = rs.getString("password");//비밀번호
						String name = rs.getString("name"); // 이름
						String ctel = rs.getString("ctel"); //전화번호
						String cname = rs.getString("cname");
						String divcomp = rs.getString("divcomp");
						String jobtype = rs.getString("jobtype");
						String addr1 = rs.getString("addr1"); // 주소
						String addr2 = rs.getString("addr2"); // 주소
						String addr3 = rs.getString("addr3"); // 주소
						String addr4 = rs.getString("addr4"); // 주소
						
						vo = new CMemberVO(ctel, name, cname, divcomp, jobtype, password, addr1, addr2, addr3, addr4);
						
					}
					
				} catch (Exception e) {
					System.out.println("MemberDAO클래스의 searchCInfo메소드의 sql문 오류"+e);
				}finally {
					freeResource();
				}
				return vo;
			}

			public int modifyCInfo(CMemberVO vo, String cno) {
				int check = -1;
				try {
					//DB연결
					con = dataSource.getConnection();
					//sql문 작성
					String sql = "update cmember SET cname = ?, name = ?, "
							+ " addr1 = ?, addr2 = ?, addr3 = ?, addr4 = ?, ctel = ?, jobtype = ?, divcomp = ? WHERE cno = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, vo.getCname());
					pstmt.setString(2, vo.getName());
					pstmt.setString(3, vo.getAddr1());
					pstmt.setString(4, vo.getAddr2());
					pstmt.setString(5, vo.getAddr3());
					pstmt.setString(6, vo.getAddr4());
					pstmt.setString(7, vo.getCtel());
					pstmt.setString(8, vo.getJobtype());
					pstmt.setString(9, vo.getDivcomp());
					pstmt.setString(10, cno);
					
					check = pstmt.executeUpdate();
					
					
				} catch (Exception e) {
					System.out.println("MemberInfoDAO클래스의 modifyCInfo메소드의 sql문 오류"+e);
				}finally {
					freeResource();
				}
				return check;
			}

			

			public AppFormVO searchMyapp(IMemberVO vo) {
				AppFormVO appvo = null;
				String sql = null;
				try {
					//DB연결
					con = dataSource.getConnection();
					//Sql문 작성
					sql = "select * from appForm where ssn = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, vo.getSsn());
					rs = pstmt.executeQuery();
					
					while (rs.next()) {
						String name = rs.getString("name");
						String ssn = rs.getString("ssn");
						String cname = rs.getString("cname");
						String addr = rs.getString("addr");
						String tel = rs.getString("tel");
						String milServ = rs.getString("milServ");
						String edu = rs.getString("edu");
						String eduStat = rs.getString("eduStat");
						
						appvo = new AppFormVO(cname, ssn, addr, tel, milServ, edu, eduStat);
					}
					
				} catch (Exception e) {
					System.out.println("MemberInfoDAO클래스의 searchMyapp메소드의 sql문 오류" + e);
				}finally {
					freeResource();
				}
				return appvo;
			}

			public void updateImember(IMemberVO vo,String id) {
				String sql =null;
				try {
					//DB연결
					con = dataSource.getConnection();
					//sql문 작성
					if (vo.getFileName() == null) {
						sql = "update Imember set itel = ?, addr1 = ?, addr2 = ?, addr3 = ?, addr4 = ? "
								+ " where id = ?";
						
						pstmt = con.prepareStatement(sql);
						
						pstmt.setString(1, vo.getItel());
						pstmt.setString(2, vo.getAddr1());
						pstmt.setString(3, vo.getAddr2());
						pstmt.setString(4, vo.getAddr3());
						pstmt.setString(5, vo.getAddr4());
						pstmt.setString(6, id);
					}else {
						sql = "update Imember set itel = ?, addr1 = ?, addr2 = ?, addr3 = ?, addr4 = ?, "
								+ " fileName = ?, fileRealName = ? where id = ?";
						
						pstmt = con.prepareStatement(sql);
						
						pstmt.setString(1, vo.getItel());
						pstmt.setString(2, vo.getAddr1());
						pstmt.setString(3, vo.getAddr2());
						pstmt.setString(4, vo.getAddr3());
						pstmt.setString(5, vo.getAddr4());
						pstmt.setString(6, vo.getFileName());
						pstmt.setString(7, vo.getFileRealName());
						pstmt.setString(8, id);
					}
					
					pstmt.executeUpdate();
					
				} catch (Exception e) {
					System.out.println("MemberInfoDAO클래스의 updateImember메소드의 sql문 오류" + e);
				}finally {
					freeResource();
				}
				
			}

			
			public void addcareerExp(CareerExpVO carVO) {
				
					String sql = null;
				try {
					//DB연결
					con = dataSource.getConnection();
					//sql문 작성
					if (!carVO.getCareerName1().isEmpty() && 
							!carVO.getCareerStartDate1().isEmpty() && 
							!carVO.getCareerCname1().isEmpty() && 
							!carVO.getCareerEndDate1().isEmpty() && 
							!carVO.getDamdang1().isEmpty()) {
						sql = "MERGE INTO careerexp \r\n" + 
								"            USING dual \r\n" + 
								"            ON (name = ? and no = ?) \r\n" + 
								" \r\n" + 
								"    WHEN MATCHED THEN \r\n" + 
								"        UPDATE SET cname = ? ,\r\n" + 
								"        startDate = ? ,\r\n" + 
								"        endDate = ? ,\r\n" + 
								"        damdang = ? \r\n" + 
								"    WHEN NOT MATCHED THEN \r\n" + 
								"        INSERT(\r\n" + 
								"         no, \r\n" + 
								"          name,\r\n" + 
								"         cname,\r\n" + 
								"         startDate,\r\n" + 
								"         endDate,\r\n" + 
								"         damdang\r\n" + 
								"        )\r\n" + 
								"        VALUES(\r\n" + 
								"         careerExp_no.nextval,\r\n" + 
								"         ?,\r\n" + 
								"         ?,\r\n" + 
								"         ?,\r\n" + 
								"         ?,\r\n" + 
								"         ?\r\n" + 
								"        )";
						
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, carVO.getCareerName1());
						pstmt.setString(2, carVO.getNo1());
						pstmt.setString(3, carVO.getCareerCname1());
						pstmt.setString(4, carVO.getCareerStartDate1());
						pstmt.setString(5, carVO.getCareerEndDate1());
						pstmt.setString(6, carVO.getDamdang1());
						pstmt.setString(7, carVO.getCareerName1());
						pstmt.setString(8, carVO.getCareerCname1());
						pstmt.setString(9, carVO.getCareerStartDate1());
						pstmt.setString(10, carVO.getCareerEndDate1());
						pstmt.setString(11, carVO.getDamdang1());
						pstmt.executeQuery();
					}
					if (!carVO.getCareerName2().isEmpty() && 
							!carVO.getCareerStartDate2().isEmpty() && 
							!carVO.getCareerCname2().isEmpty() && 
							!carVO.getCareerEndDate2().isEmpty() && 
							!carVO.getDamdang2().isEmpty()) {
						sql = "MERGE INTO careerexp \r\n" + 
								"            USING dual \r\n" + 
								"            ON (name = ? and no = ?) \r\n" + 
								" \r\n" + 
								"    WHEN MATCHED THEN \r\n" + 
								"        UPDATE SET cname = ? ,\r\n" + 
								"        startDate = ? ,\r\n" + 
								"        endDate = ? ,\r\n" + 
								"        damdang = ? \r\n" + 
								"    WHEN NOT MATCHED THEN \r\n" + 
								"        INSERT(\r\n" + 
								"         no, \r\n" + 
								"          name,\r\n" + 
								"         cname,\r\n" + 
								"         startDate,\r\n" + 
								"         endDate,\r\n" + 
								"         damdang\r\n" + 
								"        )\r\n" + 
								"        VALUES(\r\n" + 
								"         careerExp_no.nextval,\r\n" + 
								"         ?,\r\n" + 
								"         ?,\r\n" + 
								"         ?,\r\n" + 
								"         ?,\r\n" + 
								"         ?\r\n" + 
								"        )";
						
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, carVO.getCareerName2());
						pstmt.setString(2, carVO.getNo2());
						pstmt.setString(3, carVO.getCareerCname2());
						pstmt.setString(4, carVO.getCareerStartDate2());
						pstmt.setString(5, carVO.getCareerEndDate2());
						pstmt.setString(6, carVO.getDamdang2());
						pstmt.setString(7, carVO.getCareerName2());
						pstmt.setString(8, carVO.getCareerCname2());
						pstmt.setString(9, carVO.getCareerStartDate2());
						pstmt.setString(10, carVO.getCareerEndDate2());
						pstmt.setString(11, carVO.getDamdang2());
						pstmt.executeQuery();
					}
					if (carVO.getCareerName3() !=null && 
							!carVO.getCareerName3().isEmpty() &&
							!carVO.getCareerStartDate2().isEmpty() && 
							!carVO.getCareerCname3().isEmpty() && 
							!carVO.getCareerEndDate3().isEmpty() &&
							!carVO.getDamdang3().isEmpty()) {
						sql = "MERGE INTO careerexp \r\n" + 
								"            USING dual \r\n" + 
								"            ON (name = ? and no = ?) \r\n" + 
								" \r\n" + 
								"    WHEN MATCHED THEN \r\n" + 
								"        UPDATE SET cname = ? ,\r\n" + 
								"        startDate = ? ,\r\n" + 
								"        endDate = ? ,\r\n" + 
								"        damdang = ? \r\n" + 
								"    WHEN NOT MATCHED THEN \r\n" + 
								"        INSERT(\r\n" + 
								"         no, \r\n" + 
								"          name,\r\n" + 
								"         cname,\r\n" + 
								"         startDate,\r\n" + 
								"         endDate,\r\n" + 
								"         damdang\r\n" + 
								"        )\r\n" + 
								"        VALUES(\r\n" + 
								"         careerExp_no.nextval,\r\n" + 
								"         ?,\r\n" + 
								"         ?,\r\n" + 
								"         ?,\r\n" + 
								"         ?,\r\n" + 
								"         ?\r\n" + 
								"        )";
						
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, carVO.getCareerName3());
						pstmt.setString(2, carVO.getNo3());
						pstmt.setString(3, carVO.getCareerCname3());
						pstmt.setString(4, carVO.getCareerStartDate3());
						pstmt.setString(5, carVO.getCareerEndDate3());
						pstmt.setString(6, carVO.getDamdang3());
						pstmt.setString(7, carVO.getCareerName3());
						pstmt.setString(8, carVO.getCareerCname3());
						pstmt.setString(9, carVO.getCareerStartDate3());
						pstmt.setString(10, carVO.getCareerEndDate3());
						pstmt.setString(11, carVO.getDamdang3());
						pstmt.executeQuery();
						
					}
					
					
					
					
				} catch (Exception e) {
					System.out.println("MemberInfoDAO클래스의 addcareerExp메소드의 sql문 오류" + e);
				}finally {
					freeResource();
				}
				
			}

			public void addLicense(LicenseVO livo) {
				String sql = null;
				try {
					//DB연결
					con = dataSource.getConnection();
					//sql문 작성
					if (!livo.getLicenseName1().isEmpty() && 
							!livo.getLname1().isEmpty() && 
							!livo.getLnum1().isEmpty() && 
							!livo.getGetDate1().isEmpty() && 
							!livo.getPub1().isEmpty()) {
						sql = "MERGE INTO license\r\n" + 
								"            USING dual\r\n" + 
								"            ON (name = ? and lnum = ?)\r\n" + 
								"\r\n" + 
								"            WHEN MATCHED THEN\r\n" + 
								"                UPDATE SET lname = ?,\r\n" + 
								"                            getDate = ?,\r\n" + 
								"                            pub = ?\r\n" + 
								"\r\n" + 
								"            WHEN NOT MATCHED THEN\r\n" + 
								"                INSERT(\r\n" + 
								"                         name,\r\n" + 
								"                         lnum,\r\n" + 
								"                         lname,\r\n" + 
								"                         getDate,\r\n" + 
								"                         pub\r\n" + 
								"                )\r\n" + 
								"                VALUES(\r\n" + 
								"                         ?,\r\n" + 
								"                         ?,\r\n" + 
								"                         ?,\r\n" + 
								"                         ?,\r\n" + 
								"                         ?\r\n" + 
								"                )";
						
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, livo.getLicenseName1());
						pstmt.setString(2, livo.getLnum1());
						pstmt.setString(3, livo.getLname1());
						pstmt.setString(4, livo.getGetDate1());
						pstmt.setString(5, livo.getPub1());
						pstmt.setString(6, livo.getLicenseName1());
						pstmt.setString(7, livo.getLnum1());
						pstmt.setString(8, livo.getLname1());
						pstmt.setString(9, livo.getGetDate1());
						pstmt.setString(10, livo.getPub1());
						
						pstmt.executeQuery();
					}
					if (!livo.getLicenseName2().isEmpty() && 
							!livo.getLname2().isEmpty() && 
							!livo.getLnum2().isEmpty() && 
							!livo.getGetDate2().isEmpty() && 
							!livo.getPub2().isEmpty()) {
						sql = "MERGE INTO license\r\n" + 
								"            USING dual\r\n" + 
								"            ON (name = ? and lnum = ?)\r\n" + 
								"\r\n" + 
								"            WHEN MATCHED THEN\r\n" + 
								"                UPDATE SET lname = ?,\r\n" + 
								"                            getDate = ?,\r\n" + 
								"                            pub = ?\r\n" + 
								"\r\n" + 
								"            WHEN NOT MATCHED THEN\r\n" + 
								"                INSERT(\r\n" + 
								"                         name,\r\n" + 
								"                         lnum,\r\n" + 
								"                         lname,\r\n" + 
								"                         getDate,\r\n" + 
								"                         pub\r\n" + 
								"                )\r\n" + 
								"                VALUES(\r\n" + 
								"                         ?,\r\n" + 
								"                         ?,\r\n" + 
								"                         ?,\r\n" + 
								"                         ?,\r\n" + 
								"                         ?\r\n" + 
								"                )";
						
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, livo.getLicenseName2());
						pstmt.setString(2, livo.getLnum2());
						pstmt.setString(3, livo.getLname2());
						pstmt.setString(4, livo.getGetDate2());
						pstmt.setString(5, livo.getPub2());
						pstmt.setString(6, livo.getLicenseName2());
						pstmt.setString(7, livo.getLnum2());
						pstmt.setString(8, livo.getLname2());
						pstmt.setString(9, livo.getGetDate2());
						pstmt.setString(10, livo.getPub2());
						
						pstmt.executeQuery();
					}
					if (	livo.getLicenseName3() !=null &&
							!livo.getLicenseName3().isEmpty() && 
							!livo.getLname3().isEmpty() && 
							!livo.getLnum3().isEmpty() && 
							!livo.getGetDate3().isEmpty() && 
							!livo.getPub3().isEmpty()) {
						sql = "MERGE INTO license\r\n" + 
								"            USING dual\r\n" + 
								"            ON (name = ? and lnum = ?)\r\n" + 
								"\r\n" + 
								"            WHEN MATCHED THEN\r\n" + 
								"                UPDATE SET lname = ?,\r\n" + 
								"                            getDate = ?,\r\n" + 
								"                            pub = ?\r\n" + 
								"\r\n" + 
								"            WHEN NOT MATCHED THEN\r\n" + 
								"                INSERT(\r\n" + 
								"                         name,\r\n" + 
								"                         lnum,\r\n" + 
								"                         lname,\r\n" + 
								"                         getDate,\r\n" + 
								"                         pub\r\n" + 
								"                )\r\n" + 
								"                VALUES(\r\n" + 
								"                         ?,\r\n" + 
								"                         ?,\r\n" + 
								"                         ?,\r\n" + 
								"                         ?,\r\n" + 
								"                         ?\r\n" + 
								"                )";
						
						pstmt = con.prepareStatement(sql);
						pstmt.setString(1, livo.getLicenseName3());
						pstmt.setString(2, livo.getLnum3());
						pstmt.setString(3, livo.getLname3());
						pstmt.setString(4, livo.getGetDate3());
						pstmt.setString(5, livo.getPub3());
						pstmt.setString(6, livo.getLicenseName3());
						pstmt.setString(7, livo.getLnum3());
						pstmt.setString(8, livo.getLname3());
						pstmt.setString(9, livo.getGetDate3());
						pstmt.setString(10, livo.getPub3());
						
						pstmt.executeQuery();
					}
				} catch (Exception e) {
					System.out.println("MemberInfoDAO클래스의 addLicense메소드의 sql문 오류" + e);
				}finally {
					freeResource();
				}
				
			}

			public void addTraining(TrainingVO trainingVO) {
				String sql = null;
				
				try {
					//DB연결
					con = dataSource.getConnection();
					//sql문 작성
					if ( 	!trainingVO.getTname1().isEmpty() &&
							!trainingVO.getEduName1().isEmpty() && 
							!trainingVO.gettStartDate1().isEmpty() && 
							!trainingVO.gettEndDate1().isEmpty() &&
							!trainingVO.getContent1().isEmpty()) {
					sql = "MERGE INTO training\n" + 
							"            USING dual\n" + 
							"            ON (name = ? AND tno = ?)\n" + 
							"\n" + 
							"    WHEN MATCHED THEN\n" + 
							"        UPDATE SET eduname = ?,\n" + 
							"        startDate = ?,\n" + 
							"        endDate = ?,\n" + 
							"        content = ?\n" + 
							"\n" + 
							"    WHEN NOT MATCHED THEN\n" + 
							"        INSERT (\n" + 
							"         tno,\n" + 
							"          name,\n" + 
							"         eduname,\n" + 
							"         startDate,\n" + 
							"         endDate,\n" + 
							"         content\n" + 
							"        )\n" + 
							"        VALUES (\n" + 
							"         careerExp_no.nextval,\n" + 
							"         ?,\n" + 
							"         ?,\n" + 
							"         ?,\n" + 
							"         ?,\n" + 
							"         ?\n" + 
							"        )";
						
						pstmt = con.prepareStatement(sql);
						
						pstmt.setString(1, trainingVO.getTname1());
						pstmt.setString(2, trainingVO.getTno1());
						pstmt.setString(3, trainingVO.getEduName1());
						pstmt.setString(4, trainingVO.gettStartDate1());
						pstmt.setString(5, trainingVO.gettEndDate1());
						pstmt.setString(6, trainingVO.getContent1());
						pstmt.setString(7, trainingVO.getTname1());
						pstmt.setString(8, trainingVO.getEduName1());
						pstmt.setString(9, trainingVO.gettStartDate1());
						pstmt.setString(10, trainingVO.gettEndDate1());
						pstmt.setString(11, trainingVO.getContent1());
						pstmt.executeQuery();
					}
					//DB연결
					con = dataSource.getConnection();
					//sql문 작성
					if ( 	!trainingVO.getTname2().isEmpty() &&
							!trainingVO.getEduName2().isEmpty() && 
							!trainingVO.gettStartDate2().isEmpty() && 
							!trainingVO.gettEndDate2().isEmpty() &&
							!trainingVO.getContent2().isEmpty()) {
						sql = "MERGE INTO training \r\n" + 
								"            USING dual \r\n" + 
								"            ON (name = ? and tno = ?) \r\n" + 
								" \r\n" + 
								"    WHEN MATCHED THEN \r\n" + 
								"        UPDATE SET eduname = ? ,\r\n" + 
								"        startDate = ? ,\r\n" + 
								"        endDate = ? ,\r\n" + 
								"        content = ? \r\n" + 
								"    WHEN NOT MATCHED THEN \r\n" + 
								"        INSERT(\r\n" + 
								"         tno, \r\n" + 
								"          name,\r\n" + 
								"         eduname,\r\n" + 
								"         startDate,\r\n" + 
								"         endDate,\r\n" + 
								"         content\r\n" + 
								"        )\r\n" + 
								"        VALUES(\r\n" + 
								"         careerExp_no.nextval,\r\n" + 
								"         ?,\r\n" + 
								"         ?,\r\n" + 
								"         ?,\r\n" + 
								"         ?,\r\n" + 
								"         ?\r\n" + 
								"        )";
							
							pstmt = con.prepareStatement(sql);
							
							pstmt.setString(1, trainingVO.getTname2());
							pstmt.setString(2, trainingVO.getTno2());
							pstmt.setString(3, trainingVO.getEduName2());
							pstmt.setString(4, trainingVO.gettStartDate2());
							pstmt.setString(5, trainingVO.gettEndDate2());
							pstmt.setString(6, trainingVO.getContent2());
							pstmt.setString(7, trainingVO.getTname2());
							pstmt.setString(8, trainingVO.getEduName2());
							pstmt.setString(9, trainingVO.gettStartDate2());
							pstmt.setString(10, trainingVO.gettEndDate2());
							pstmt.setString(11, trainingVO.getContent2());
							pstmt.executeQuery();
					}
					if (trainingVO.getTname3() !=null && 
							!trainingVO.getTname3().isEmpty() &&
							!trainingVO.getEduName3().isEmpty() && 
							!trainingVO.gettStartDate3().isEmpty() && 
							!trainingVO.gettEndDate3().isEmpty() &&
							!trainingVO.getContent3().isEmpty()) {
						sql = "MERGE INTO training \r\n" + 
								"            USING dual \r\n" + 
								"            ON (name = ? and tno = ?) \r\n" + 
								" \r\n" + 
								"    WHEN MATCHED THEN \r\n" + 
								"        UPDATE SET eduname = ? ,\r\n" + 
								"        startDate = ? ,\r\n" + 
								"        endDate = ? ,\r\n" + 
								"        content = ? \r\n" + 
								"    WHEN NOT MATCHED THEN \r\n" + 
								"        INSERT(\r\n" + 
								"         tno, \r\n" + 
								"          name,\r\n" + 
								"         eduname,\r\n" + 
								"         startDate,\r\n" + 
								"         endDate,\r\n" + 
								"         content\r\n" + 
								"        )\r\n" + 
								"        VALUES(\r\n" + 
								"         careerExp_no.nextval,\r\n" + 
								"         ?,\r\n" + 
								"         ?,\r\n" + 
								"         ?,\r\n" + 
								"         ?,\r\n" + 
								"         ?\r\n" + 
								"        )";
							
							pstmt = con.prepareStatement(sql);
							pstmt.setString(1, trainingVO.getTname3());
							pstmt.setString(2, trainingVO.getTno3());
							pstmt.setString(3, trainingVO.getEduName3());
							pstmt.setString(4, trainingVO.gettStartDate3());
							pstmt.setString(5, trainingVO.gettEndDate3());
							pstmt.setString(6, trainingVO.getContent3());
							pstmt.setString(7, trainingVO.getTname3());
							pstmt.setString(8, trainingVO.getEduName3());
							pstmt.setString(9, trainingVO.gettStartDate3());
							pstmt.setString(10, trainingVO.gettEndDate3());
							pstmt.setString(11, trainingVO.getContent3());
							pstmt.executeQuery();
					}
					
				} catch (Exception e) {
					System.out.println("MemberInfoDAO클래스의 addTraining메소드의 sql문 오류" + e);
				}finally {
					freeResource();
				}
				
			}

			public void addAppForm(AppFormVO appVO) {
				
				String sql =null;
				try {
					//DB연결
					con = dataSource.getConnection();
					//sql문 작성
					sql = "MERGE INTO appForm\r\n" + 
							"            USING dual\r\n" + 
							"            ON (name = ? and ssn = ?)\r\n" + 
							"\r\n" + 
							"            WHEN MATCHED THEN\r\n" + 
							"                UPDATE SET Addr = ?,\r\n" + 
							"                            tel = ?,\r\n" + 
							"                            milserv = ?,\r\n" + 
							"                            edu = ?,\r\n" + 
							"                            eduStat = ? " + 
							"\r\n" + 
							"            WHEN NOT MATCHED THEN\r\n" + 
							"                INSERT(\r\n" + 
							"                         name,\r\n" + 
							"                         ssn,\r\n" + 
							"                         Addr,\r\n" + 
							"                         tel,\r\n" + 
							"                         milserv,\r\n" + 
							"                         edu,\r\n" + 
							"                         eduStat " + 
							"                )\r\n" + 
							"                VALUES(\r\n" + 
							"                         ?,\r\n" + 
							"                         ?,\r\n" + 
							"                         ?,\r\n" + 
							"                         ?,\r\n" + 
							"                         ?,\r\n" + 
							"                         ?,\r\n" + 
							"                         ?\r\n" + 
							"                )\r\n" + 
							"";
							
						
						pstmt = con.prepareStatement(sql);
						
						pstmt.setString(1, appVO.getName());
						pstmt.setString(2, appVO.getSsn());
						pstmt.setString(3, appVO.getAddr());
						pstmt.setString(4, appVO.getTel());
						pstmt.setString(5, appVO.getMilServ());
						pstmt.setString(6, appVO.getEdu());
						pstmt.setString(7, appVO.getEduStat());
						pstmt.setString(8, appVO.getName());
						pstmt.setString(9, appVO.getSsn());
						pstmt.setString(10, appVO.getAddr());
						pstmt.setString(11, appVO.getTel());
						pstmt.setString(12, appVO.getMilServ());
						pstmt.setString(13, appVO.getEdu());
						pstmt.setString(14, appVO.getEduStat());
						pstmt.executeUpdate();
					
				} catch (Exception e) {
					System.out.println("MemberInfoDAO클래스의 addAppForm메소드의 sql문 오류" + e);
				}finally {
					freeResource();
				}
			}

			public AllAppFormVO searchMyInfo2(String id) {
				AllAppFormVO vo = null;
				try {
					//DB연결
					con = dataSource.getConnection();
					//sql문 작성
					String sql = "select * from iMember where id = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, id);
					rs = pstmt.executeQuery();
					
					while (rs.next()) {
						String password = rs.getString("password");//비밀번호
						String ssn = rs.getString("ssn");
						String name = rs.getString("name"); // 이름
						String itel = rs.getString("itel"); //전화번호
						String email = rs.getString("email"); //이메일
						String addr1 = rs.getString("addr1"); // 주소
						String addr2 = rs.getString("addr2"); // 주소
						String addr3 = rs.getString("addr3"); // 주소
						String addr4 = rs.getString("addr4"); // 주소
						String fileRealName = rs.getString("fileRealName"); //파일의 실제 이름
						
						vo = new AllAppFormVO(id, password, ssn, name, addr1, addr2, addr3, addr4, itel, email, fileRealName);
						
					}
					
				} catch (Exception e) {
					System.out.println("MemberInfoDAO클래스의 searchMyInfo메소드의 sql문 오류" + e);
				}finally {
					freeResource();
				}
				return vo;

			}

			public List<AllAppFormVO> searchCareerInfo(AllAppFormVO vo) {
				List<AllAppFormVO> list = new ArrayList<AllAppFormVO>();
				
				try {
					//DB연결
					con = dataSource.getConnection();
					//sql문 작성
					String sql = "select * from Careerexp where name = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, vo.getName());
					rs = pstmt.executeQuery();
					for (int i =0;rs.next();i++) {
						vo = new AllAppFormVO();
						vo.setNo(rs.getInt("no"));
						vo.setCarName(rs.getString("name"));
						vo.setCarcName(rs.getString("cname"));
						vo.setStartDate(rs.getTimestamp("startdate"));
						vo.setEndDate(rs.getTimestamp("endDate"));
						vo.setDamdang(rs.getString("damdang"));
						
						list.add(i, vo);
					}
					
						
				} catch (Exception e) {
					System.out.println("MemberInfo클래스의 searchCareerInfo메소드의 sql문 오류" + e);
				}finally {
					freeResource();
				}
				return list;
			}

			public List<AllAppFormVO> searchLicenseInfo(AllAppFormVO vo) {
				
				List<AllAppFormVO> list = new ArrayList<AllAppFormVO>();
				
				try {
					//DB연결
					con = dataSource.getConnection();
					//sql문 작성
					String sql = "select * from license where name = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, vo.getName());
					rs = pstmt.executeQuery();
					for (int i =0;rs.next();i++) {
						vo = new AllAppFormVO();
						vo.setLiname(rs.getString("name"));
						vo.setLname(rs.getString("lname"));
						vo.setLnum(rs.getString("lnum"));
						vo.setGetDate(rs.getTimestamp("getDate"));
						vo.setPub(rs.getString("pub"));
						
						list.add(i, vo);
					}
					
						
				} catch (Exception e) {
					System.out.println("MemberInfo클래스의 searchCareerInfo메소드의 sql문 오류" + e);
				}finally {
					freeResource();
				}
				return list;
			}
			
			public List<AllAppFormVO> searchTrainingInfo(AllAppFormVO vo) {
				
				List<AllAppFormVO> list = new ArrayList<AllAppFormVO>();
				
				try {
					//DB연결
					con = dataSource.getConnection();
					//sql문 작성
					String sql = "select * from training where name = ? ";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, vo.getName());
					rs = pstmt.executeQuery();
					for (int i =0;rs.next();i++) {
						vo = new AllAppFormVO();
						vo.setTno(rs.getInt("tno"));
						vo.setTrname(rs.getString("name"));
						vo.setEduName(rs.getString("eduName"));
						vo.setTrstartDate(rs.getTimestamp("startDate"));
						vo.setTrendDate(rs.getTimestamp("endDate"));
						vo.setContent(rs.getString("content"));
						
						list.add(i, vo);
					}
					
						
				} catch (Exception e) {
					System.out.println("MemberInfo클래스의 searchTraningInfo메소드의 sql문 오류" + e);
				}finally {
					freeResource();
				}
				return list;
			}

			public List<AllAppFormVO> searchAppFormInfo(AllAppFormVO vo) {
				List<AllAppFormVO> list = new ArrayList<AllAppFormVO>();
				try {
					//DB연결
					con = dataSource.getConnection();
					//sql문 작성
					String sql = "select * from appForm where name = ? ";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, vo.getName());
					rs = pstmt.executeQuery();
					
					while (rs.next()) {
						String name = rs.getString("name"); // 이름
						String ssn = rs.getString("ssn"); // 주민번호
						String cname = rs.getString("cname"); // 지원한 기업명
						String addr = rs.getString("addr"); // 주소
						String tel = rs.getString("tel"); // 연락처
						String milServ = rs.getString("milServ"); // 병역사항
						String edu = rs.getString("edu"); // 최종학력
						String eduStat = rs.getString("eduStat"); // 현재 재학상태(무학,재학,졸업,휴학,중퇴)
						vo = new AllAppFormVO(name, ssn, cname, addr, tel, milServ, edu, eduStat);
						list.add(vo);
					}
					
				} catch (Exception e) {
					System.out.println("MemberInfoDAO클래스의 searchMyInfo메소드의 sql문 오류" + e);
				}finally {
					freeResource();
				}
				return list;

			}

			public List<IjobExpVO> listMembers(IMemberVO vo) {
				List<IjobExpVO> list = new ArrayList<IjobExpVO>();
				try {
					//DB연결
					con = dataSource.getConnection();
					//Sql문 작성
					String sql = "select * from ijobExp where name = ?";
					pstmt = con.prepareStatement(sql);
					
					pstmt.setString(1, vo.getName());
					
					rs = pstmt.executeQuery();
					
					while (rs.next()) {
						 int no = rs.getInt("no");
						 String tel = rs.getString("tel");
						 String name = rs.getString("name");
						 String jobexpname = rs.getString("jobexpname");
						 Timestamp regDate = rs.getTimestamp("regDate");
						
						IjobExpVO ivo = new IjobExpVO(no, tel, name, jobexpname, regDate);
						
						list.add(ivo);
					}
				} catch (Exception e) {
					System.out.println("MemberInfoDAO클래스의 listMembers메소드의 sql문 오류" + e);
				}finally {
					freeResource();
				}
				return list;
			}
			
			public void delMember(String no) {
				
				try {
					//1.커넥션풀(DataSouce)객체 내부에 있는 Connection객체 얻기(DB연결)
					con = dataSource.getConnection();
					//2.매개변수로 전달 받은 삭제할 회원 아이디를 이용해 DELETE SQL문장 만들기
					String sql = "delete from ijobExp where no=?";
					//3. delete문장 전체를 미리 로드한 OraclcePreparedStatementWrapper실행 객체 얻기
					pstmt = con.prepareStatement(sql);
					//3.1 ? 설정
					pstmt.setString(1, no);
					//4. 완성된 delete전체 문장을  DB에 전송해서 실행!
					pstmt.executeUpdate(); //삭제에 성공하면 1을 반환 , 삭제에 실패하면 0을 반환 
					
				} catch (Exception e) {
					System.out.println("MemberDAO의 delMember메소드 내부에서 SQL문 실행 오류 : " + e);
				} finally {
					//자원해제 
					freeResource();
				}
			}

			public void delAppForm(String name) {
				try {
					//1.커넥션풀(DataSouce)객체 내부에 있는 Connection객체 얻기(DB연결)
					con = dataSource.getConnection();
					//2.매개변수로 전달 받은 삭제할 회원 아이디를 이용해 DELETE SQL문장 만들기
					String sql = "delete from AppForm where name=?";
					//3. delete문장 전체를 미리 로드한 OraclcePreparedStatementWrapper실행 객체 얻기
					pstmt = con.prepareStatement(sql);
					//3.1 ? 설정
					pstmt.setString(1, name);
					//4. 완성된 delete전체 문장을  DB에 전송해서 실행!
					pstmt.executeUpdate(); //삭제에 성공하면 1을 반환 , 삭제에 실패하면 0을 반환 
					
				} catch (Exception e) {
					System.out.println("MemberDAO의 delMember메소드 내부에서 SQL문 실행 오류 : " + e);
				} finally {
					//자원해제 
					freeResource();
				}
			}
				public void delcareerExp(String name) {
					try {
						//1.커넥션풀(DataSouce)객체 내부에 있는 Connection객체 얻기(DB연결)
						con = dataSource.getConnection();
						//2.매개변수로 전달 받은 삭제할 회원 아이디를 이용해 DELETE SQL문장 만들기
						String sql = "delete from careerExp where name=?";
						//3. delete문장 전체를 미리 로드한 OraclcePreparedStatementWrapper실행 객체 얻기
						pstmt = con.prepareStatement(sql);
						//3.1 ? 설정
						pstmt.setString(1, name);
						//4. 완성된 delete전체 문장을  DB에 전송해서 실행!
						pstmt.executeUpdate(); //삭제에 성공하면 1을 반환 , 삭제에 실패하면 0을 반환 
						
					} catch (Exception e) {
						System.out.println("MemberDAO의 delMember메소드 내부에서 SQL문 실행 오류 : " + e);
					} finally {
						//자원해제 
						freeResource();
					}
				}
					public void delLicense(String name) {
						try {
							//1.커넥션풀(DataSouce)객체 내부에 있는 Connection객체 얻기(DB연결)
							con = dataSource.getConnection();
							//2.매개변수로 전달 받은 삭제할 회원 아이디를 이용해 DELETE SQL문장 만들기
							String sql = "delete from license where name=?";
							//3. delete문장 전체를 미리 로드한 OraclcePreparedStatementWrapper실행 객체 얻기
							pstmt = con.prepareStatement(sql);
							//3.1 ? 설정
							pstmt.setString(1, name);
							//4. 완성된 delete전체 문장을  DB에 전송해서 실행!
							pstmt.executeUpdate(); //삭제에 성공하면 1을 반환 , 삭제에 실패하면 0을 반환 
							
						} catch (Exception e) {
							System.out.println("MemberDAO의 delMember메소드 내부에서 SQL문 실행 오류 : " + e);
						} finally {
							//자원해제 
							freeResource();
						}
					}
						public void delTraining(String name) {
							try {
								//1.커넥션풀(DataSouce)객체 내부에 있는 Connection객체 얻기(DB연결)
								con = dataSource.getConnection();
								//2.매개변수로 전달 받은 삭제할 회원 아이디를 이용해 DELETE SQL문장 만들기
								String sql = "delete from Training where name=?";
								//3. delete문장 전체를 미리 로드한 OraclcePreparedStatementWrapper실행 객체 얻기
								pstmt = con.prepareStatement(sql);
								//3.1 ? 설정
								pstmt.setString(1, name);
								//4. 완성된 delete전체 문장을  DB에 전송해서 실행!
								pstmt.executeUpdate(); //삭제에 성공하면 1을 반환 , 삭제에 실패하면 0을 반환 
								
							} catch (Exception e) {
								System.out.println("MemberDAO의 delMember메소드 내부에서 SQL문 실행 오류 : " + e);
							} finally {
								//자원해제 
								freeResource();
							}
							
							
			}

						public List<ConsVO> conslist(IMemberVO vo) {
							List<ConsVO> list = new ArrayList<ConsVO>();
							try {
								//DB연결
								con = dataSource.getConnection();
								//Sql문 작성
								String sql = "select * from cons where name = ?";
								pstmt = con.prepareStatement(sql);
								
								pstmt.setString(1, vo.getName());
								
								rs = pstmt.executeQuery();
								
								while (rs.next()) {
									 int no = rs.getInt("no");
									
									 String name = rs.getString("name");
									 String title = rs.getString("title");
									 String startTime = rs.getString("startTime");
									 String endTime = rs.getString("endTime");
									 String locate = rs.getString("locate");
									 String ampm = rs.getString("ampm");
									 String consType = rs.getString("consType");
									
									ConsVO consvo = new ConsVO(no, name, title, ampm, startTime, endTime, locate, consType);
									
									list.add(consvo);
								}
							} catch (Exception e) {
								System.out.println("MemberInfoDAO클래스의 conslist메소드의 sql문 오류" + e);
							}finally {
								freeResource();
							}
							return list;
						}

						public void delCons(String name, String no, String consType) {
							try {
								//DB연결
								con = dataSource.getConnection();
								//sql문작성
								String sql = "delete from Cons where name = ? and no = ? and constype = ? ";
								pstmt = con.prepareStatement(sql);
								pstmt.setString(1, name);
								pstmt.setString(2, no);
								pstmt.setString(3, consType);
								
								pstmt.executeUpdate();
								
							} catch (Exception e) {
								System.out.println("MemberDAO클래스의 delCons메소드의 sql문 오류" + e);
							}finally {
								freeResource();
							}
							
						}
			
}//class의 끝
