package controller.eventInfoController;

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


import VO.eventInfoVO.EventInfoVO;
import service.eventInfoService.EventInfoService;

@WebServlet("/EventInfo/*")
public class EventInfoController extends HttpServlet{

	// 게시판 서비스 객체
	private EventInfoService es;
	
	// 게시글 정보 객체
	private EventInfoVO vo;

	// 서블릿 초기화 메서드, 서블릿 컨테이너에 의해 서블릿 초기화 시 호출됨
	public void init(ServletConfig config) throws ServletException {
		es = new EventInfoService();
		vo = new EventInfoVO();
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
		System.out.println("EventInfoController 2단계 요청주소: " + action);
		// 		/getEventInfoList.do 박람회들 정보 한번에 가져올 때	
		// 		/getEventInfo.do 클릭한 포스터의 no값에 따라 정보를 가져올 때	
		
		try {
			
			 if (action.equals("/getEventInfoList.do")) {	
				 
				List<EventInfoVO> list = es.getEventInfoList();
				request.setAttribute("eventInfoList", list);
				nextPage = "/view/eventInfo.jsp"; 
			 
				// 다음 페이지로 포워드하기 위한 디스패처 객체 생성
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
				dispatch.forward(request, response); // 다음 페이지로 요청과 응답 객체를 포워드
	            
			 }else if (action.equals("/getEventInfo.do")) {
				 
				int no = Integer.parseInt(request.getParameter("no")); 				 
				request.setAttribute("eventInfo", no);
				nextPage = "/view/eventInfo.jsp?no=" + no;
				 
				// 다음 페이지로 포워드하기 위한 디스패처 객체 생성
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
				dispatch.forward(request, response); // 다음 페이지로 요청과 응답 객체를 포워드
			 }
			 
			 } catch (Exception e) {
		         e.printStackTrace(); // 예외 발생 시 콘솔에 스택 트레이스 출력
		}
	    
	
		
	}//doHandle 메소드
	
	
}
