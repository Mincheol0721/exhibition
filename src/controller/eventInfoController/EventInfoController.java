package controller.eventInfoController;

import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import VO.eventInfoVO.EventInfoVO;
import service.eventInfoService.EventInfoService;

@WebServlet("/eventInfo/*")
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
	    
	    int no = Integer.parseInt(request.getParameter("no"));
	    String name = request.getParameter("name");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");
		String locate = request.getParameter("locate");
		String iPart = request.getParameter("iPart");
		String cPart = request.getParameter("cPart");
		String way = request.getParameter("way");
		String content = request.getParameter("content");
		String fileName = request.getParameter("fileName");
		String fileRealName = request.getParameter("fileRealName");
		
		String action = request.getPathInfo();
		System.out.println("EventInfoController 2단계 요청주소: " + action);
		
		try {
			
			if(action == null || action.equals("/getEventInfo.do")) {
				
				vo.setNo(no);
				vo.setName(name);
				vo.setStartDate(startDate);
				vo.setEndDate(endDate);
				vo.setLocate(locate);
				vo.setiPart(iPart);
				vo.setcPart(cPart);
				vo.setWay(way);
				vo.setContent(content);
				vo.setFileName(fileName);
				vo.setFileRealName(fileRealName);	
				
				es.getEventInfo(name);
				
				nextPage = "/view/eventInfo.jsp"; // 다음 페이지 경로 설정
				
			}else if (action.equals("/getEventInfoList.do")) {
				
				vo.setNo(no);
				vo.setName(name);
				vo.setStartDate(startDate);
				vo.setEndDate(endDate);
				vo.setLocate(locate);
				vo.setiPart(iPart);
				vo.setcPart(cPart);
				vo.setWay(way);
				vo.setContent(content);
				vo.setFileName(fileName);
				vo.setFileRealName(fileRealName);	
				
				es.getEventInfo(name);
				
				nextPage = "/view/eventInfo.jsp"; // 다음 페이지 경로 설정
			}
			
		} catch (Exception e) {
			e.printStackTrace(); // 예외 발생 시 콘솔에 스택 트레이스 출력
		}
	    
		// 다음 페이지로 포워드하기 위한 디스패처 객체 생성
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
		dispatch.forward(request, response); // 다음 페이지로 요청과 응답 객체를 포워드
		
	}//doHandle 메소드
	
	
}
