package controller.applicantController;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import VO.IMemberVO.IMemberVO;
import VO.applicantVO.ApplicantVO;
import service.applicantService.ApplicantService;

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
	    String constype;
	    String name;
		String sitel;
		String regDate;
		String startTime;
		String endTime;
//		System.out.println(name + ", " + sitel + ", " + regDate + ", " + startTime);
		if(request.getParameter("constype") == null) {
			constype = "자기소개서";
		} else {
			constype = request.getParameter("constype");
		}
//		System.out.println("constype: " + constype);
		String id = request.getParameter("id");
		String itel;
		String ssn;
		String email;
		String addr1;
		String addr2;
		String addr3;
		String addr4;
		int isSeek = 0;

	    String action = request.getPathInfo();
	    System.out.println("action: "  + action);

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
				name = request.getParameter("name");
				sitel = request.getParameter("sitel");
				regDate = request.getParameter("regDate");
				startTime = request.getParameter("startTime");
				endTime = request.getParameter("endTime");
				
				vo.setName(name); vo.setSitel(sitel); vo.setRegDate(regDate); vo.setStartTime(startTime); vo.setEndTime(endTime);
				
				as.modCons(vo, no);
				
				list = as.getConsList(pageNum, pageSize, constype);
				request.setAttribute("Cons", list);
				
				nextPage = "/applicant/getCons.do?constype=" + constype;
				System.out.println(nextPage);
				
			} else if(action.equals("/delCons.do")) {
				
				as.delCons(no);
				
				nextPage = "/applicant/getCons.do?constype=" + constype;
				
			} else if(action.equals("/getImember.do")) {
				
				List<IMemberVO> list = as.getImemberList(pageNum, pageSize);
				request.setAttribute("imember", list);
				
				nextPage = "/view/admin/jobSeekers.jsp";
//				System.out.println(nextPage);
				
			} else if(action.equals("/getJobSeeker.do")) {
				
				IMemberVO vo = as.getJobSeeker(id);
				request.setAttribute("vo", vo);
				
				nextPage = "/view/admin/viewJobSeeker.jsp";
				System.out.println(nextPage);
				
			} else if(action.equals("/modJSPage.do")) {
				id = request.getParameter("id");
				IMemberVO vo = as.getJobSeeker(id);
				request.setAttribute("vo", vo);
				
				nextPage = "/view/admin/modJobSeeker.jsp";
				System.out.println(nextPage);
				
			} else if(action.equals("/modJobSeeker.do")) {
				id = request.getParameter("id");
				IMemberVO vo = new IMemberVO();
				System.out.println("modJobSeeker 탑승");
				name = request.getParameter("name");
				itel = request.getParameter("itel");
				ssn = request.getParameter("ssn");
				email = request.getParameter("email");
				addr1 = request.getParameter("addr1");
				addr2 = request.getParameter("addr2");
				addr3 = request.getParameter("addr3");
				addr4 = request.getParameter("addr4");
				regDate = request.getParameter("regDate");
				isSeek = Integer.parseInt(request.getParameter("isSeek"));
				System.out.println(name);
				System.out.println(itel);
				System.out.println(ssn);
				System.out.println(email);
				System.out.println(addr1);
				System.out.println(addr2);
				System.out.println(addr3);
				System.out.println(addr4);
				System.out.println(regDate);
				System.out.println(isSeek);
				
				vo.setId(id); vo.setName(name); vo.setItel(itel); vo.setSsn(ssn);
				vo.setEmail(email); vo.setAddr1(addr1); vo.setAddr2(addr2); vo.setAddr3(addr3); vo.setAddr4(addr4);
				vo.setRegDate(regDate); vo.setIsSeek(isSeek);
				
				as.updateJobSeeker(vo, id);
				
				nextPage = "/applicant/getJobSeeker.do?id=" + id;
				System.out.println(nextPage);
				
			} else if(action.equals("/delJobSeeker.do")) {
				id = request.getParameter("id");
				System.out.println(id);
				as.delJobSeeker(id);
				
				nextPage = "/applicant/getImember.do?pageNum=" + pageNum; 
				System.out.println(nextPage);
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
//		// 다음 페이지로 포워드하기 위한 디스패처 객체 생성
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
		dispatch.forward(request, response); // 다음 페이지로 요청과 응답 객체를 포워드
		
	}
	
	
}
