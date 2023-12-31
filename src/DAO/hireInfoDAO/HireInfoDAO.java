package DAO.hireInfoDAO;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import VO.CMemberVO.CMemberVO;
import VO.IMemberVO.IMemberVO;
import VO.hireInfoVO.HireInfoVO;

public class HireInfoDAO {
	//위 4가지 접속 설정값을 이용해서 오라클 DB와 접속한 정보를 지니고 있는 Connection객체를 저장할 참조변수 선언
	private Connection con;
	//DB와 연결 후 우리 개발자가 만든 SQL문장을 오라클 DB의 테이블에 전송하여 실행할 역할을 하는 Statement실행객체의 주소를 저장할 참조변수 선언
	//private Statement stmt;
	private PreparedStatement pstmt;
	//SELECT문을 실행한 검색결과를 임시로 저장해 놓은 ResultSet객체의 주소를 저장할 참조변수 선언
	private ResultSet rs;
	//DataSouce커넥션풀 역할을 하는 객체의 주소를 저장할 참조변수
	private DataSource ds;
	//HireInfoVO 객체를 저장할 변수
	private HireInfoVO vo;
	//쿼리문을 저장할 변수
	private String query;
	private Calendar today;
	private SimpleDateFormat sdf;
	private String todayStr;
	private Date today1;
	private int expireDate;
	private Date expire;
	
	//MemberDAO클래스의 기본생성자
	//역할 : new MemberDAO(); 객체 생성시 호출되는 생성자로 !!
	//     생성자 내부에서 커넥션풀 역할을 하는 DataSouce객체를 얻는 작업을 하게 됩니다.
	public HireInfoDAO() {
	
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
	public int getHireInfoCount() {
		int count = 0;
		
		try {
			con = ds.getConnection();
			
			query = "select count(*) from hireInfo";
			
			pstmt = con.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (Exception e) {
			System.out.println("HireInfoDAO내부의 getHireInfoCount에서 예외 발생: " + e);
		} finally {
			freeResource();
		}
		
		return count;
	}
	
	//DB에 접속하여 채용정보 테이블 내부의 데이터들을 전부 조회해오는 메소드
	public List<HireInfoVO> getHireInfoList(int pageNum, int pageSize) {
		
		List<HireInfoVO> list = new ArrayList<HireInfoVO>(); 
		
		try {
			con = ds.getConnection();
			System.out.println("pageNum: " + pageNum);
			System.out.println("pageSize: " + pageSize);
			query = "SELECT * " + 
					"FROM ( " + 
					"    SELECT ROWNUM AS rn, h.* " + 
					"    FROM hireinfo h " + 
					"    WHERE ROWNUM <= ( " + pageNum + " * " + pageSize + ") " + 
					" ) " + 
					" WHERE rn >= ((" + pageNum + " - 1) * " + pageSize + ") + 1 " +
					" ORDER BY appexpire DESC";
			
			pstmt = con.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			while(rs.next()) {
				vo = new HireInfoVO( rs.getString("cname"), 
									 rs.getString("htel"), 
									 rs.getString("divComp"), 
									 rs.getString("homepage"), 
									 rs.getString("jobtype"), 
									 rs.getString("workTime"), 
									 rs.getString("legal"),
									 rs.getString("appType"),
									 rs.getString("appstart"),
									 rs.getString("appexpire"));
				vo.setFileName(rs.getString("fileName"));
				vo.setFileRealName(rs.getString("fileRealName"));
				
				//오늘 날짜 얻기
				sdf = new SimpleDateFormat("yyyy-MM-dd");
				today = Calendar.getInstance();
				today.set(Calendar.HOUR_OF_DAY, 0);
				today.set(Calendar.MINUTE, 0);
				today.set(Calendar.SECOND, 0);
				today.set(Calendar.MILLISECOND, 0);
				todayStr = sdf.format(today.getTime());
				today1 = sdf.parse(todayStr);
				
				for(int i=0; i < 1; i++) {
				
				expire = sdf.parse(vo.getAppexpire());
				System.out.println("접수마감일: " + expire);
				
				expireDate = (int) ( (expire.getTime() - today1.getTime()) / (24 * 60 * 60 * 1000) );
				vo.setExpireDate(expireDate);
				}
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			System.out.println("HireInfoDAO내부 getHireInfoList에서 예외 발생: " + e);
		} finally {
			freeResource();
		}
		
		return list;
	}//getHireInfoList

	//DB에 접속하여 로그인 한 기업에 해당하는 채용정보 데이터를 조회해오는 메소드
	public HireInfoVO getHireInfo(String cname) {
		try {
			con = ds.getConnection();
			query = "select * from hireInfo where cname='" + cname + "'";
			
			pstmt = con.prepareStatement(query);
			
			rs = pstmt.executeQuery();

			//오늘 날짜 얻기
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			today = Calendar.getInstance();
			today.set(Calendar.HOUR_OF_DAY, 0);
			today.set(Calendar.MINUTE, 0);
			today.set(Calendar.SECOND, 0);
			today.set(Calendar.MILLISECOND, 0);
			todayStr = sdf.format(today.getTime());
			today1 = sdf.parse(todayStr);
			
			if(rs.next()) {
				vo = new HireInfoVO( rs.getString("cname"), 
									 rs.getString("htel"), 
									 rs.getString("divComp"), 
									 rs.getString("homepage"), 
									 rs.getString("jobtype"), 
									 rs.getString("workTime"), 
									 rs.getString("legal"),
									 rs.getString("appType"),
									 rs.getString("appstart"),
									 rs.getString("appexpire"));
			}
			
			if(vo.getAppexpire() != null) {
				System.out.println("if문 탑승..?");
				expire = sdf.parse(vo.getAppexpire());
				System.out.println("expire: " + expire);
				expireDate = (int) ( (expire.getTime() - today1.getTime()) / (24 * 60 * 60 * 1000) );
				vo.setExpireDate(expireDate);
			}
			
		} catch (Exception e) {
			System.out.println("HireInfoDAO내부 getHireInfo에서 예외 발생: " + e);
		} finally {
			freeResource();
		}
		
		return vo;
	}

	//DB에 접속하여 채용정보를 추가하는 메소드
	public void insertHireInfo(HireInfoVO vo) {
		try {
			con = ds.getConnection();
			query = "INSERT INTO hireInfo (cname, htel, divcomp, homepage, jobtype, workTime, legal, appType, appstart, appexpire)  "
					+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, TO_DATE(?, 'YYYY-MM-DD'), TO_DATE(?, 'YYYY-MM-DD'))";
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, vo.getCname());
			pstmt.setString(2, vo.getHtel());
			pstmt.setString(3, vo.getDivComp());
			pstmt.setString(4, vo.getHomepage());
			pstmt.setString(5, vo.getJobtype());
			pstmt.setString(6, vo.getWorkTime());
			pstmt.setString(7, vo.getLegal());
			pstmt.setString(8, vo.getAppType());
			pstmt.setString(9, vo.getAppstart());
			pstmt.setString(10, vo.getAppexpire());
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("HireInfoDAO내부 insertHireInfo에서 예외 발생: " + e);
		} finally {
			freeResource();
		}
		
	}

	public void updateHireInfo(HireInfoVO vo) {
		try {
			con = ds.getConnection();
			query = "UPDATE hireinfo SET htel=?, divcomp=?, homepage=?, jobtype=?, worktime=?, legal=?, appstart=TO_DATE(?, 'YYYY-MM-DD'), appexpire=TO_DATE(?, 'YYYY-MM-DD') WHERE cname=?";
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, vo.getHtel());
			pstmt.setString(2, vo.getDivComp());
			pstmt.setString(3, vo.getHomepage());
			pstmt.setString(4, vo.getJobtype());
			pstmt.setString(5, vo.getWorkTime());
			pstmt.setString(6, vo.getLegal());
			pstmt.setString(7, vo.getAppstart());
			pstmt.setString(8, vo.getAppexpire());
			pstmt.setString(9, vo.getCname()); 
			
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("HireInfoDAO내부 updateHireInfo에서 예외 발생: " + e);
		} finally {
			freeResource();
		}
	}

	public void delHireInfo(String cname) {
		
		try {
			con = ds.getConnection();
			query = "DELETE FROM hireinfo WHERE cname='" + cname + "'";
			
			pstmt = con.prepareStatement(query);
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("HireInfoDAO내부 delHireInfo에서 예외 발생: " + e);
		} finally {
			freeResource();
		}
	}
	
	//DB에 접속하여 cmember테이블에서 cname이 일치하는 행의 데이터를 가져오는 메소드
	public CMemberVO getCmemberInfo(String cname) {
		CMemberVO cvo = new CMemberVO();
		try {
			con = ds.getConnection();
			query = "SELECT * FROM cMember WHERE cname='" + cname + "'";
			
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cvo.setCno(rs.getString("cno"));
				cvo.setCname(rs.getString("cname"));
				cvo.setCtel(rs.getString("ctel"));
				cvo.setName(rs.getString("name"));
				cvo.setDivcomp(rs.getString("divComp"));
				cvo.setJobtype(rs.getString("jobType"));
				cvo.setFileName(rs.getString("fileName"));
				cvo.setFileRealName(rs.getString("fileRealName"));
				cvo.setAddr1(rs.getString("addr1"));
				cvo.setAddr2(rs.getString("addr2"));
				cvo.setAddr3(rs.getString("addr3"));
				cvo.setAddr4(rs.getString("addr4"));
			}
			
		} catch (Exception e) {
			System.out.println("HireInfoDAO내부 getCmemberINfo에서 예외 발생: " + e);
		} finally {
			freeResource();
		}
		
		return cvo;
	}
	
	public IMemberVO getImember(String id) {
		IMemberVO vo = new IMemberVO();
		try {
			con = ds.getConnection();
			query = "SELECT * FROM iMember WHERE id='" + id + "'";
			
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
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
			}
			
		} catch (Exception e) {
			System.out.println("HireInfoDAO내부 getImember에서 예외 발생: " + e);
		} finally {
			freeResource();
		}
		
		return vo;
	}
	
}
