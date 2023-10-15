package controller.eventController;

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

import VO.eventVO.EventVO;
import service.eventService.EventService;

@WebServlet("/event/*")
public class EventController extends HttpServlet {
	  
	// 게시글 정보를 저장하는 리스트
	private List<EventVO> list;
	
	// 게시판 서비스 객체
	private EventService es;
	
	// 게시글 정보 객체
	private EventVO vo;

	// 서블릿 초기화 메서드, 서블릿 컨테이너에 의해 서블릿 초기화 시 호출됨
	public void init(ServletConfig config) throws ServletException {
		es = new EventService();
		vo = new EventVO();
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
	    
	    int no = 0;
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String ipart = request.getParameter("ipart");
		String reqTime = request.getParameter("reqTime");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String service = request.getParameter("service");
		String locate = request.getParameter("locate");
	    
	    String action = request.getPathInfo();
		System.out.println("eventController 2단계 요청주소: " + action);
		

		try {
			
			if(action.equals("/getList.do")) {
				//요청한 값 얻기
			    int pageNum = Integer.parseInt(request.getParameter("pageNum"));
			    int pageSize = Integer.parseInt(request.getParameter("pageSize"));
				System.out.println("con pagenum: " + pageNum);
				System.out.println("con pagesize: " + pageSize);
				
				JSONArray jsonArray = new JSONArray(); // [ ]
				
				list = es.getEventList(pageNum, pageSize); 
				System.out.println("list개수: " + list.size());
				
				for( EventVO vo : list ) { 
					JSONObject jsonObject = new JSONObject();
					
					jsonObject.put("no", vo.getNo());
					jsonObject.put("title", vo.getTitle());
					jsonObject.put("content", vo.getContent());
					jsonObject.put("ipart", vo.getIpart());
					jsonObject.put("reqTime", vo.getReqTime());
					jsonObject.put("startTime", vo.getStartTime());
					jsonObject.put("endTime", vo.getEndTime());
					jsonObject.put("service", vo.getService());
					jsonObject.put("locate", vo.getLocate());
					
					jsonArray.add(jsonObject);
					
				} //for
				
				out.print(jsonArray.toString());
				
				return;
				
			} else if(action.equals("/modEvent.do")) {
				no = Integer.parseInt( request.getParameter("no") );
				
				vo.setNo(no); vo.setTitle(title); vo.setContent(content); vo.setIpart(ipart); vo.setReqTime(reqTime); 
				vo.setStartTime(startTime); vo.setEndTime(endTime); vo.setService(service); vo.setLocate(locate);
				
				es.updateEvent(vo);
				
				nextPage = "/view/eventList.jsp";
				System.out.println("nextPage: " + nextPage);
				
			} else if(action.equals("/delEvent.do")) {
				no = Integer.parseInt( request.getParameter("no") );
				es.delEvent(no);
				
				nextPage = "/view/eventList.jsp";
				System.out.println("nextPage: " + nextPage);
				
			} else if(action.equals("/reg.do")) {
				System.out.println("action값: " + action);
				
				vo.setTitle(title);
				vo.setContent(content);
				vo.setIpart(ipart);
				vo.setReqTime(reqTime);
				vo.setService(service);
				vo.setStartTime(startTime);
				vo.setEndTime(endTime);
				vo.setLocate(locate);
				
				es.regEvent(vo);
				nextPage = "/view/eventList.jsp";
				System.out.println("nextPage: " + nextPage);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 다음 페이지로 포워드하기 위한 디스패처 객체 생성
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
		dispatch.forward(request, response); // 다음 페이지로 요청과 응답 객체를 포워드
		
	}
	
	
}
