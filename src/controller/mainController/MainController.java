package controller.mainController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import DAO.eventInfoDAO.EventInfoDAO;
import VO.eventInfoVO.EventInfoVO;

 
@WebServlet("/Menu/*")
public class MainController extends HttpServlet {
	EventInfoDAO dao = new EventInfoDAO();
	
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
		System.out.println("MainController 2단계 요청주소: " + action);
		// 		/index.do 메뉴에서 홈화면 눌렀을 때
		//		/searchIndexNo.do 상세보기(또는 해당 사진) 눌렀을 때
		// 		/eventInfo.do 박람회안내-행사안내 눌렀을 때
		// 		/guide.do 박람회안내-이용안내 눌렀을 때
		
		if(action.equals("/index.do")) {
			
			nextPage = "/view/index.jsp";			
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
			dispatch.forward(request, response); 
			
		}else if(action.equals("/searchIndexNo.do")) {
					
			EventInfoVO vo = dao.selectMaxEventInfo();
			request.setAttribute("vo", vo);
			nextPage = "/view/index.jsp";			
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
			dispatch.forward(request, response); 
		
		}else if(action.equals("/eventInfo.do")) {
			
			nextPage = "/view/eventInfo/eventInfo.jsp";			
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
			dispatch.forward(request, response); 
			
		}else if(action.equals("/guide.do")) {
			
			nextPage = "/view/eventInfo/guide.jsp";
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
			dispatch.forward(request, response); 
			
		}
		
		
	}
}
