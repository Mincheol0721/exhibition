package controller.pgsController;

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

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import VO.pgsVO.PgsVO;
import service.pgsService.copy.PgsService;

@WebServlet("/pgs/*")
public class PgsController extends HttpServlet {
	  
	// 게시글 정보를 저장하는 리스트
	private List<PgsVO> list;
	
	// 게시판 서비스 객체
	private PgsService ps; 
	
	// 게시글 정보 객체
	private PgsVO vo;

	// 서블릿 초기화 메서드, 서블릿 컨테이너에 의해 서블릿 초기화 시 호출됨
	public void init(ServletConfig config) throws ServletException {
		ps = new PgsService();
		vo = new PgsVO();
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
	    
	    //요청한 값 얻기
	    int pageNum = 1;
	    if(request.getParameter("pageNum") != null) {
	    	pageNum = Integer.parseInt(request.getParameter("pageNum"));
	    }
	    int pageSize = 10;
	    if(request.getParameter("pageSize") != null) {
	    	pageSize = Integer.parseInt(request.getParameter("pageSize"));
	    }
	    
	    int pno = 0;
	    if(request.getParameter("pno") != null) {
			pno = Integer.parseInt(request.getParameter("pno"));
		}
	    
	    String action = request.getPathInfo();
		

		try {
			
			if(action.equals("/admin.do")) {
				
				nextPage = "/view/admin/management.jsp";
				System.out.println("admin.do: " + nextPage);
				
			} else if(action.equals("/getList.do")) {
				
				System.out.println("pageNum: " + pageNum);
				System.out.println("pageSize: " + pageSize);
				
				list = ps.getPgsList(pageNum, pageSize);
				
				request.setAttribute("list", list);
				
				nextPage = "/view/admin/pgsList.jsp?pageNum=" + pageNum;
				
			} else if(action.equals("/getPgs.do")) {
				
				vo = ps.getPgs(pno);
				
				request.setAttribute("vo", vo);
				System.out.println("voTitle: " + vo.getTitle());
				
				nextPage = "/view/admin/viewPg.jsp";
			} else if(action.equals("/pgRegPage.do")) {
				
				nextPage = "/view/admin/pgReg.jsp";
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 다음 페이지로 포워드하기 위한 디스패처 객체 생성
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
		dispatch.forward(request, response); // 다음 페이지로 요청과 응답 객체를 포워드
		
	}
	
	
}
