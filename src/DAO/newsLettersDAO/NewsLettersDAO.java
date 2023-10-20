package DAO.newsLettersDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
		} finally {
			freeResource();
		}
		
		return count;
		
	}//getBoardCount end
	
	//뉴스레터 게시판 글 목록 조회해오는 메소드
	public List<NewsLettersVO> getBoardList(int startRow, int pageSize){
		
	    query = "SELECT * FROM (SELECT ROWNUM AS rnum, n.* FROM (SELECT * FROM newsLetters ORDER BY re_ref DESC, re_seq ASC) n) WHERE rnum >= ? AND rnum <= ?";
		
		List<NewsLettersVO> list = new ArrayList<NewsLettersVO>();
		
		try {
			
			//DB연결
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, pageSize);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				NewsLettersVO vo = new NewsLettersVO();
				
				vo.setNo(rs.getInt("no"));
				vo.setArticleType(rs.getString("articleType"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));				
				vo.setFileName(rs.getString("fileName"));
				vo.setFileRealName(rs.getString("fileRealName"));
				vo.setRe_lev(rs.getInt("re_lev"));
				vo.setRe_ref(rs.getInt("re_ref"));
				vo.setRe_seq(rs.getInt("re_seq"));
				vo.setWriteDate(rs.getDate("writeDate"));
				vo.setReadCount(rs.getInt("readCount"));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			freeResource();
		}
		
		return list;
		
	}//getBoardList end
	
	public void insertNewsLetters(NewsLettersVO vo) {
		
		query =  "insert into newsLetters INSERT INTO newsLetters (no, articleType, title, content, fileName, fileRealName, re_ref, re_lev, re_seq, writeDate, readCount)"
				   + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
		
		int no = 0; //글번호
		
		try {
			
			//DB연결
			con = ds.getConnection();
			
			pstmt = con.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {				
				no = rs.getInt(1) + 1;	//글이 존재할 경우 최대값 + 1 		
			}else {
				no = 1; //글이 없을 경우 1
			}
			
			pstmt.setInt(1, no);
			pstmt.setString(2, vo.getArticleType());
			pstmt.setString(3, vo.getTitle());
			pstmt.setString(4, vo.getContent());
			pstmt.setString(5, vo.getFileName());
			pstmt.setString(6, vo.getFileRealName());
			pstmt.setInt(7, no); //re_ref 그룹 번호 == no 주글번호 기준
			pstmt.setInt(8, 0); //들여쓰기
			pstmt.setInt(9, 0); //답글순서
			pstmt.setString(10, vo.getArticleType());
			pstmt.setInt(11, 0); //조회수
			
			//insert 실행
			pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			freeResource();
		}
		
		
	}//insertNewsLetters end
	
	//특정 뉴스레터 게시글 클릭 시 뉴스레터 게시글을 조회하는 메소드
	public NewsLettersVO getNewsLettersDetail(int no) {		
			
			System.out.println("getNewsLettersDetail메소드 뉴스레터 번호: " + no);
			query = "select * from newsLetters where no=" + no;
			
			try {
				//DB연결
				con = ds.getConnection();
				
				pstmt = con.prepareStatement(query);
				
				rs = pstmt.executeQuery();
				
				//한 행사의 데이터를 불러옴
				if (rs.next()) {
					
					vo = new NewsLettersVO();
					
					vo.setNo(rs.getInt("no"));
					vo.setArticleType(rs.getString("articleType"));
					vo.setTitle(rs.getString("title"));
					vo.setContent(rs.getString("content"));				
					vo.setFileName(rs.getString("fileName"));
					vo.setFileRealName(rs.getString("fileRealName"));
					vo.setRe_lev(rs.getInt("re_lev"));
					vo.setRe_ref(rs.getInt("re_ref"));
					vo.setRe_seq(rs.getInt("re_seq"));
					vo.setWriteDate(rs.getDate("writeDate"));
					vo.setReadCount(rs.getInt("readCount"));
					
				}	
				
				System.out.println("getNewsLettersDetail메소드 실행 완료");
				
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("getNewsLettersDetail메소드 실행 오류 : " + e);
			} finally {
				freeResource();
			}
					
		return vo;
		
	}//getNewsLettersDetail end
	
}
