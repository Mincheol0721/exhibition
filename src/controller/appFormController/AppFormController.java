package controller.appFormController;

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

import VO.appFormVO.AppFormVO;
import service.appFormService.AppFormService;

@WebServlet("/appForm/*")
public class AppFormController extends HttpServlet {
	  
	// 게시글 정보를 저장하는 리스트
	private List<AppFormVO> list;
	
	// 게시판 서비스 객체
	private AppFormService as;
	
	// 게시글 정보 객체
	private AppFormVO vo;

	// 서블릿 초기화 메서드, 서블릿 컨테이너에 의해 서블릿 초기화 시 호출됨
	public void init(ServletConfig config) throws ServletException {
		as = new AppFormService();
		vo = new AppFormVO();
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
	    
	    String cname = request.getParameter("cname");
	    String name = request.getParameter("name");
	    String ssn = request.getParameter("ssn");
	    String addr = request.getParameter("addr");
	    String tel = request.getParameter("tel");
	    String milServ = request.getParameter("milServ");
	    String edu = request.getParameter("edu");
	    String eduStat = request.getParameter("eduStat");
	    
	    String action = request.getPathInfo();
		System.out.println("AppFormController 2단계 요청주소: " + action);
		

		try {
			
			if(action.equals("/getList.do")) {
				//요청한 값 얻기
			    int pageNum = Integer.parseInt(request.getParameter("pageNum"));
			    int pageSize = Integer.parseInt(request.getParameter("pageSize"));
				System.out.println("con pagenum: " + pageNum);
				System.out.println("con pagesize: " + pageSize);
				
				JSONArray jsonArray = new JSONArray(); // [ ]
				
				list = as.getAppFormList(pageNum, pageSize, cname); 
				System.out.println("list개수: " + list.size());
				
				for( AppFormVO vo : list ) { 
					JSONObject jsonObject = new JSONObject();
					
					jsonObject.put("name", vo.getName());
					jsonObject.put("ssn", vo.getSsn());
					jsonObject.put("addr", vo.getAddr());
					jsonObject.put("tel", vo.getTel());
					jsonObject.put("milServ", vo.getMilServ());
					jsonObject.put("edu", vo.getEdu());
					jsonObject.put("eduStat", vo.getEduStat());
					jsonArray.add(jsonObject);
					
				} //for
				
				out.print(jsonArray.toString());
				
				return;
				
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 다음 페이지로 포워드하기 위한 디스패처 객체 생성
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
		dispatch.forward(request, response); // 다음 페이지로 요청과 응답 객체를 포워드
		
	}
	
	
}
