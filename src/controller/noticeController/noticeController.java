package controller.noticeController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.noticeVO.NoticeVO;
import service.noticeService.NoticeService;


@WebServlet("/notice/*")
public class noticeController extends HttpServlet {
	
    
    public noticeController() {
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String action = request.getPathInfo();
		System.out.println("2단계 요청 주소: "+action);
		
		NoticeService noticeService = new NoticeService();
		String nextPage = null;
		
		if(action == null || action.equals("/noticeBoard.do")) {
			ArrayList noticelist = noticeService.getNoticeListSerivce();
			
			
			request.setAttribute("noticelist", noticelist);
			
			nextPage="/view/notice/noticeBoard.jsp";
			
		}else if(action.equals("/viewNotice.do")) {
			
			int no = Integer.parseInt(request.getParameter("no"));
								//하나의행만 조회하는 메소드
			 NoticeVO noticeOne = noticeService.getOneNoticeService(no);
			 					//조회수 +1하는 메소드
			 					 noticeService.plusReadCountService(no);
			 
				request.setAttribute("noticeOne", noticeOne);
			nextPage="/view/notice/viewNotice.jsp";
			
		}
		
		//포워딩 (디스패처 방식)
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
						  dispatch.forward(request, response);
	}//doHandle
	
	
	
}
