package controller.applicantController.copy;

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
import VO.applicantVO.ApplicantVO;
import service.appFormService.AppFormService;
import service.applicantService.copy.ApplicantService;

@WebServlet("/applicant/*")
public class ApplicantController extends HttpServlet {
	  
	// 게시글 정보를 저장하는 리스트
	private List<ApplicantVO> list;
	
	// 게시판 서비스 객체
	private ApplicantService as;
	
	// 게시글 정보 객체
	private ApplicantVO vo;

	// 서블릿 초기화 메서드, 서블릿 컨테이너에 의해 서블릿 초기화 시 호출됨
	public void init(ServletConfig config) throws ServletException {
		as = new ApplicantService();
		vo = new ApplicantVO();
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
	    int no = 0;
	    if(request.getParameter("no") != null) {
	    	no = Integer.parseInt(request.getParameter("no"));
	    }
	    String cname = request.getParameter("cname");
	    String constype = null;
		if(request.getParameter("constype") == null) {
			constype = "자기소개서";
		} else {
			constype = request.getParameter("constype");
		}
		System.out.println("constype: " + constype);
	    String action = request.getPathInfo();

	    try {
			
			if(action.equals("/getCList.do")) {
				
				list = as.getCList(pageNum, pageSize);
				
				request.setAttribute("clist", list);
				
				nextPage = "/view/admin/cjobExp.jsp";
				
			} else if(action.equals("/getIList.do")) {
				
				list = as.getIList(pageNum, pageSize);
				
				request.setAttribute("ilist", list);
				
				nextPage = "/view/admin/ijobExp.jsp" ;
				
			} else if(action.equals("/getCons.do")) {
				constype = request.getParameter("constype");
//				System.out.println(constype);
				
				list = as.getConsList(pageNum, pageSize, constype);
				
				request.setAttribute("Cons", list);
				
				nextPage = "/view/admin/Cons.jsp?constype=" + constype + "&pageNum=" + pageNum;
				
			} else if(action.equals("/modPage.do")) {
//				System.out.println("no: " + no);
				vo = as.getMeeting(no);
				
				request.setAttribute("vo", vo);
				
				nextPage = "/view/admin/modCons.jsp?no=" + no;
				
			} else if(action.equals("/modCons.do")) {
				String name = request.getParameter("name");
				String sitel = request.getParameter("sitel");
				String regDate = request.getParameter("regDate");
				String startTime = request.getParameter("startTime");
				String endTime = request.getParameter("endTime");
//				System.out.println(name + ", " + sitel + ", " + regDate + ", " + startTime);
				
				vo.setName(name); vo.setSitel(sitel); vo.setRegDate(regDate); vo.setStartTime(startTime); vo.setEndTime(endTime);
				
				as.modCons(vo, no);
				
				list = as.getConsList(pageNum, pageSize, constype);
				request.setAttribute("Cons", list);
				
				nextPage = "/applicant/getCons.do?constype=" + constype;
				System.out.println(nextPage);
				
			} else if(action.equals("/delCons.do")) {
				
				as.delCons(no);
				
				nextPage = "/applicant/getCons.do?constype=" + constype;
				
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 다음 페이지로 포워드하기 위한 디스패처 객체 생성
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
		dispatch.forward(request, response); // 다음 페이지로 요청과 응답 객체를 포워드
		
	}
	
	
}
