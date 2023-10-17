package DAO.eventInfoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import VO.eventInfoVO.EventInfoVO;

public class EventInfoDAO {
	
	private Connection con;		
	private PreparedStatement pstmt;		
	private ResultSet rs;		
	private DataSource ds;
	private EventInfoVO vo;
	//쿼리문을 저장할 변수
	private String query;
		
	//EventInfoDAO클래스의 기본생성자
	//역할 : new EventInfoDAO(); 객체 생성시 호출되는 생성자로 !!
	//     생성자 내부에서 커넥션풀 역할을 하는 DataSouce객체를 얻는 작업을 하게 됩니다.
	public EventInfoDAO() {
	
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
		
	//DB연결 후 작업하는 객체들 사용한 뒤에 자원해제 할 때 공통으로 쓰이는 메소드
	public void freeResource() {
		try {
			
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
			if(con != null) con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//자원해제 end
			
	//테이블에 저장된 레코드의 개수를 반환하는 메소드
	public int getEventInfoCount(Map<String, Object> map) {

		int count = 0;		
		
		try {
			con = ds.getConnection();
			
			query = "select count(*) from eventInfo";
			
			pstmt = con.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (Exception e) {
			System.out.println("EventInfoDAO내부의 getEventInfoCount에서 예외 발생: " + e);
		} finally {
			freeResource();
		}
		
		return count;
		
	}//getEventInfoCount
		
	//행사 안내 조회
	public EventInfoVO getEventInfo(int no) {
		
		System.out.println("getEventInfo메소드가 받는 글번호: " + no);
		query = "select * from eventInfo where no=?";
		
		try {
			
			//DB연결
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(query);
			
			//DB에 전달할 ?값 세팅
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			
			//한 행사의 데이터를 불러옴
			if (rs.next()) {
				
				vo.setNo(rs.getInt("no"));
				vo.setName(rs.getString("name"));
				vo.setStartDate(rs.getString("startDate"));
				vo.setEndDate(rs.getString("endDate"));
				vo.setLocate(rs.getString("locate"));
				vo.setiPart(rs.getString("iPart"));
				vo.setcPart(rs.getString("cPart"));				
				vo.setFileName(rs.getString("fileName"));				
				vo.setFileRealName(rs.getString("fileRealName"));				
				
			}	
			
			System.out.println("getEventInfo메소드 실행 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getCourseInfo메소드 실행 오류 : " + e);
		} finally {
			freeResource();
		}
		
		//수정할 과목명에 대한 과목 객체 전달
		return vo;

	}//getEventInfo end

	
}
