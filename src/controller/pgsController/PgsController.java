package controller.pgsController;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.pgsVO.PgsVO;
import service.pgsService.PgsService;

@WebServlet("/pgs/*")
public class PgsController extends HttpServlet {
	
	private List<PgsVO> list;
	
	private PgsService ps; 
	
	private PgsVO vo;

	@Override
	// 서블릿 초기화 메서드, 서블릿 컨테이너에 의해 서블릿 초기화 시 호출됨
	public void init() throws ServletException {
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
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    
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
	    String pgtype = request.getParameter("pgtype");
	    String pgname = request.getParameter("pgname");
	    String title = request.getParameter("title");
	    String content = request.getParameter("content");
	    String ipart = request.getParameter("ipart");
	    String teacher = request.getParameter("teacher");
	    if(teacher == null || teacher.length() == 0) { teacher = "-"; }
	    String startDate = request.getParameter("startDate");
	    String endDate = request.getParameter("endDate");
	    String startTime = request.getParameter("startTime");
	    String endTime = request.getParameter("endTime");
	    String locate = request.getParameter("locate");
	    
	    String action = request.getPathInfo();
		System.out.println("action: " + action);

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
				
				nextPage = "/view/admin/viewPg.jsp";
				
			} else if(action.equals("/pgRegPage.do")) {
				nextPage = "/view/admin/pgReg.jsp";
				
			} else if(action.equals("/reg.do")) {
				vo.setPgtype(pgtype); vo.setPgname(pgname); vo.setTitle(title); vo.setContent(content); 
				vo.setIpart(ipart); vo.setTeacher(teacher); vo.setStartDate(startDate); vo.setEndDate(endDate); 
				vo.setStartTime(startTime); vo.setEndTime(endTime); vo.setLocate(locate);
				
				ps.regPgs(vo);
				nextPage = "/admin/getList.do?pageNum=" + pageNum;
				
			} else if(action.equals("/modPage.do")) {
				System.out.println(pno);
				nextPage = "/view/admin/modPg.jsp?pno=" + pno;
				
			} else if(action.equals("/modPgs.do")) {
				vo.setPno(pno); vo.setPgtype(pgtype); vo.setPgname(pgname); vo.setTitle(title); 
				vo.setContent(content); vo.setIpart(ipart); vo.setTeacher(teacher); vo.setStartDate(startDate); 
				vo.setEndDate(endDate); vo.setStartTime(startTime); vo.setEndTime(endTime); vo.setLocate(locate);
				
				ps.updatePgs(vo);
				nextPage = "/pgs/getPgs.do?pno=" + pno;
				
			} else if(action.equals("/del.do")) {
				ps.delPgs(pno);
				nextPage = "/pgs/getList.do?pageNum=" + pageNum;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// 다음 페이지로 포워드하기 위한 디스패처 객체 생성
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
		dispatch.forward(request, response); // 다음 페이지로 요청과 응답 객체를 포워드
		
	}
}
