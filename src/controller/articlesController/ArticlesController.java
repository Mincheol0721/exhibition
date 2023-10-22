package controller.articlesController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.newsLettersVO.NewsLettersVO; 
import service.articlesService.ArticlesService;


@WebServlet("/Articles/*")
public class ArticlesController extends HttpServlet{
	
	// 게시판 서비스 객체
	private ArticlesService as;
	
	// 게시글 정보 객체
	private NewsLettersVO vo;
	
	// 서블릿 초기화 메서드, 서블릿 컨테이너에 의해 서블릿 초기화 시 호출됨
	public void init(ServletConfig config) throws ServletException {
		as = new ArticlesService();
		vo = new NewsLettersVO();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nextPage = "";
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
	    PrintWriter out = response.getWriter();
	    
		String action = request.getPathInfo();
		System.out.println("ArticlesController 2단계 요청주소: " + action);
		// 		/NewsLetters.do 뉴스레터 게시판으로 이동
		// 		/NewsLettersWrite.do 뉴스레터 작성 페이지로 이동
		
		try {
			
			if (action.equals("/NewsLetters.do")) {
				
                int pageSize = 10;
                int currentPage = 1;

                String pageNum = request.getParameter("pageNum");
                if (pageNum != null) {
                    currentPage = Integer.parseInt(pageNum);
                }

                int startRow = (currentPage - 1) * pageSize;
                List<NewsLettersVO> list = as.getBoardList(startRow, pageSize);
                request.setAttribute("list", list);

                nextPage = "/view/articles/newsLetters.jsp";
                
                // 다음 페이지로 포워드하기 위한 디스패처 객체 생성
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
				dispatch.forward(request, response); // 다음 페이지로 요청과 응답 객체를 포워드
				
			} else if (action.equals("/NewsLettersWrite.do")) {
				
				nextPage = "/view/articles/newsLettersWrite.jsp"; // 상세 정보를 보여줄 JSP 페이지의 경로
				
				// 다음 페이지로 포워드하기 위한 디스패처 객체 생성
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
				dispatch.forward(request, response); // 다음 페이지로 요청과 응답 객체를 포워드
				
			} else if (action.equals("/NewsLettersDetail.do")) {
			    
			    int no = Integer.parseInt(request.getParameter("no"));
			   
			    NewsLettersVO vo = as.getNewsLettersDetail(no);
			    request.setAttribute("vo", vo);

			    nextPage = "/view/articles/newsLettersDetail.jsp";
			    
			    // 다음 페이지로 포워드하기 위한 디스패처 객체 생성
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
				dispatch.forward(request, response); // 다음 페이지로 요청과 응답 객체를 포워드
				
			}
			
		} catch (Exception e) {
			e.printStackTrace(); // 예외 발생 시 콘솔에 스택 트레이스 출력
		}		
	
	}
}
