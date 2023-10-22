package DAO.newsLettersDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import VO.newsLettersVO.NewsLettersVO;

public class NewsLettersDAO {

	private Connection con;		
	private PreparedStatement pstmt;		
	private ResultSet rs;		
	private DataSource ds;
	private NewsLettersVO vo;
	//쿼리문을 저장할 변수
	private String query;
		
	//NewsLettersDAO클래스의 기본생성자
	//역할 : new NewsLettersDAO(); 객체 생성시 호출되는 생성자로 !!
	//     생성자 내부에서 커넥션풀 역할을 하는 DataSouce객체를 얻는 작업을 하게 됩니다.
	public NewsLettersDAO() {
	
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
			
			//System.out.println("DataSource 커넥션풀 객체 얻기 성공!");
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
	
	//뉴스레터 전체 글 개수 반환하는 메소드
	public int getBoardCount() {
		
		query = "select count(*) from newsLetters";
		
		int count = 0;
		
		try {
			
			//DB연결
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				count = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getBoardCount메소드 실행 오류 : " + e);

		} finally {
			freeResource();
		}
		
		return count;
		
	}//getBoardCount end
	
	public List<NewsLettersVO> getBoardList(int startRow, int pageSize) {
		
	    List<NewsLettersVO> list = new ArrayList<NewsLettersVO>();
	    
	    query = "SELECT * FROM (SELECT ROWNUM AS rnum, n.* FROM (SELECT * FROM newsLetters ORDER BY no DESC) n) WHERE rnum >= ? AND rnum <= ?";

	    try {
	        // DB 연결
	        con = ds.getConnection();
	        pstmt = con.prepareStatement(query);
	        pstmt.setInt(1, startRow + 1);
	        pstmt.setInt(2, startRow + pageSize);

	        rs = pstmt.executeQuery();

	        while (rs.next()) {
	            NewsLettersVO vo = new NewsLettersVO();

	            vo.setNo(rs.getInt("no"));
	            vo.setTitle(rs.getString("title"));
	            vo.setContent(rs.getString("content"));
	            vo.setFileName(rs.getString("fileName"));
	            vo.setFileRealName(rs.getString("fileRealName"));
	            vo.setWriteDate(rs.getDate("writeDate"));
	            vo.setReadCount(rs.getInt("readCount"));

	            list.add(vo);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
			System.out.println("getBoardList메소드 실행 오류 : " + e);

	    } finally {
	        freeResource();
	    }

	    return list;
	    
	}//getBoardList end


	 // 뉴스레터 글 등록
    public void insertNewsLetters(String title, String content, String fileName, String fileRealName) {

        String query = "INSERT INTO newsLetters (no, title, content, fileName, fileRealName, writeDate, readCount) " +
                	   "VALUES (newsLetters_no.NEXTVAL, ?, ?, ?, ?, SYSDATE, 0)";
        try {
        	
            con = ds.getConnection();
            
            pstmt = con.prepareStatement(query);
            
            pstmt.setString(1, title);
            pstmt.setString(2, content);
            pstmt.setString(3, fileName);
            pstmt.setString(4, fileRealName);

            pstmt.executeUpdate();
            
        } catch (Exception e) {
			e.printStackTrace();
			System.out.println("insertNewsLetters메소드 실행 오류 : " + e);
		} finally {
			freeResource();
		}
        
    }//insertNewsLetters end
	
	//특정 뉴스레터 게시글 클릭 시 뉴스레터 게시글을 조회하는 메소드
	public NewsLettersVO getNewsLettersDetail(int no) {		
			
		System.out.println("getNewsLettersDetail메소드 뉴스레터 번호: " + no);
		query = "select * from newsLetters where no=" + no;
		
		try {
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			//한 행사의 데이터를 불러옴
			if (rs.next()) {
				
				vo = new NewsLettersVO();
				
				vo.setNo(rs.getInt("no"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));				
				vo.setFileName(rs.getString("fileName"));
				vo.setFileRealName(rs.getString("fileRealName"));
				vo.setWriteDate(rs.getDate("writeDate"));
				vo.setReadCount(rs.getInt("readCount"));
				
			}	
						
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("getNewsLettersDetail메소드 실행 오류 : " + e);
		} finally {
			freeResource();
		}
				
		return vo;
		
	}//getNewsLettersDetail end
	
	//수정하기 위해 no값에 따라 불러오는 메소드
	public NewsLettersVO getNewsLetterByNo(int no) {

	    query = "SELECT * FROM newsLetters WHERE no = ?";

	    try {
	    	
	        con = ds.getConnection();
	        
	        pstmt = con.prepareStatement(query);
	        pstmt.setInt(1, no);
	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	        	
	            vo = new NewsLettersVO();
	            
	            vo.setNo(rs.getInt("no"));
	            vo.setTitle(rs.getString("title"));
	            vo.setContent(rs.getString("content"));
	           
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
			System.out.println("getNewsLetterByNo메소드 실행 오류 : " + e);

	    } finally {
	       freeResource();
	    }
	    return vo;
	    
	}//getNewsLetterByNo end
	
	public void updateNewsLetter(int no, String title, String content) {

	    query = "UPDATE newsLetters SET title = ?, content = ? WHERE no = ?";

	    try {
	    	
	        con = ds.getConnection();
	        pstmt = con.prepareStatement(query);
	        
	        pstmt.setString(1, title);
	        pstmt.setString(2, content);
	        pstmt.setInt(3, no);

	        pstmt.executeUpdate();
	      
	    } catch (Exception e) {
	        e.printStackTrace();
			System.out.println("updateNewsLetter메소드 실행 오류 : " + e);

	    } finally {
	        freeResource();
	    }
	    
	}//updateNewsLetter end
	
	//조회수 올리는 메소드
	public void increaseReadCount(int no) {

	    query = "UPDATE newsLetters SET readCount = readCount + 1 WHERE no = ?";

	    try {
	    	
	        con = ds.getConnection();
	        
	        pstmt = con.prepareStatement(query);
	        pstmt.setInt(1, no);
	        
	        pstmt.executeUpdate();
	        
	    } catch (Exception e) {
	        e.printStackTrace();
			System.out.println("increaseReadCount메소드 실행 오류 : " + e);

	    } finally {
	       freeResource();
	    }   
	}//increaseReadCount end
	
	//뉴스레터 게시글 삭제하는 기능의 메소드
	public void delNewsLetters(int no) {
		
		query = "delete from newsLetters where no=?";
		
		try {
			
			con = ds.getConnection();
	
			pstmt = con.prepareStatement(query);			
			pstmt.setInt(1, no);
			
			pstmt.executeUpdate();
						
			//System.out.println("delNewsLetters 구문 실행 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("delNewsLetters메소드 실행 오류 : " + e);
		} finally {
			freeResource();
		}
			
	}//delNewsLetters end

}
