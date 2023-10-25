package controller.hireInfoController;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Date;
import java.text.SimpleDateFormat;
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

import DAO.appFormDAO.AppFormDAO;
import DAO.hireInfoDAO.HireInfoDAO;
import VO.CMemberVO.CMemberVO;
import VO.IMemberVO.IMemberVO;
import VO.appFormVO.AppFormVO;
import VO.hireInfoVO.HireInfoVO;
import service.hireInfoService.HireInfoService;


@WebServlet("/hireInfo/*")
public class HireInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// 게시글 정보를 저장하는 리스트
	private List<HireInfoVO> list;
	
	// 게시판 서비스 객체
	private HireInfoService his;
	
	// 게시글 정보 객체
	private HireInfoVO vo;

	// 서블릿 초기화 메서드, 서블릿 컨테이너에 의해 서블릿 초기화 시 호출됨
	public void init(ServletConfig config) throws ServletException {
		his = new HireInfoService();
		vo = new HireInfoVO();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = "";
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
	    PrintWriter out = response.getWriter();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    
		//요청할 값 얻기
	    int pageNum = 1;
	    int pageSize = 9;
		String cname = request.getParameter("cname");
		String divComp = request.getParameter("divComp");
		String htel = request.getParameter("htel");
		String homepage = request.getParameter("homepage");
		String jobtype = request.getParameter("jobtype");
		String workTime = request.getParameter("workTime");
		String legal = request.getParameter("legal");
		String appType = request.getParameter("appType");
		String appstart = request.getParameter("appstart");
		String appexpire = request.getParameter("appexpire");
		
		String action = request.getPathInfo();
		
		System.out.println("hireInfoController 2단계 요청주소: " + action);
		
		try {
			
			if(action.equals("/reg.do")) {
				vo.setCname(cname);
				vo.setDivComp(divComp);
				vo.setHomepage(homepage);
				vo.setHtel(htel);
				vo.setJobtype(jobtype);
				vo.setLegal(legal);
				vo.setWorkTime(workTime);
				vo.setAppType(appType);
				vo.setAppstart(appstart); 
				vo.setAppexpire(appexpire);
				
				his.regHireInfo(vo);
				nextPage = "/view/hireInfo/myHireInfo.jsp?cname=" + cname;
				System.out.println("nextPage: " + nextPage);

				// 다음 페이지로 포워드하기 위한 디스패처 객체 생성
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
				dispatch.forward(request, response); // 다음 페이지로 요청과 응답 객체를 포워드
				
			} else if (action.equals("/regPage.do")) {
				
				nextPage = "/view/hireInfo/hireInfoReg.jsp?cname="+cname;

				// 다음 페이지로 포워드하기 위한 디스패처 객체 생성
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
				dispatch.forward(request, response); // 다음 페이지로 요청과 응답 객체를 포워드
				
			} else if (action.equals("/viewHireInfo.do")) {
				
				String expireDate = request.getParameter("expireDate");
				System.out.println("expiredate: " + expireDate);
				
				nextPage = "/view/hireInfo/viewHireInfo.jsp?cname="+cname+"&expireDate="+expireDate;

				// 다음 페이지로 포워드하기 위한 디스패처 객체 생성
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
				dispatch.forward(request, response); // 다음 페이지로 요청과 응답 객체를 포워드
				
			} else if (action.equals("/myHireInfo.do")) {
				
				nextPage = "/view/hireInfo/myHireInfo.jsp?cname="+cname;
				System.out.println("nextPage: " + nextPage);

				// 다음 페이지로 포워드하기 위한 디스패처 객체 생성
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
				dispatch.forward(request, response); // 다음 페이지로 요청과 응답 객체를 포워드
				
			} else if (action.equals("/getList.do")) {
				if(request.getParameter("pageNum") != null) pageNum = Integer.parseInt(request.getParameter("pageNum"));
				
				List<HireInfoVO> list = his.getHireInfoList(pageNum, pageSize); 
				request.setAttribute("list", list);
				
				nextPage = "/view/hireInfo/hireInfoList.jsp";

				// 다음 페이지로 포워드하기 위한 디스패처 객체 생성
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
				dispatch.forward(request, response); // 다음 페이지로 요청과 응답 객체를 포워드
				
			} else if(action.equals("/modPage.do")) {
				nextPage = "/view/hireInfo/modHireInfo.jsp?cname=" + cname;
				System.out.println("nextPage: " + nextPage);

				// 다음 페이지로 포워드하기 위한 디스패처 객체 생성
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
				dispatch.forward(request, response); // 다음 페이지로 요청과 응답 객체를 포워드
				
			} else if(action.equals("/mod.do")) {
				vo.setCname(cname); vo.setDivComp(divComp); vo.setHomepage(homepage);
				vo.setHtel(htel); vo.setJobtype(jobtype); vo.setLegal(legal); vo.setWorkTime(workTime);
				vo.setAppType(appType); vo.setAppstart(appstart); vo.setAppexpire(appexpire);
				
				his.updateHireInfo(vo);
				
				nextPage = "/view/hireInfo/myHireInfo.jsp";
				System.out.println("nextPage: " + nextPage);

				// 다음 페이지로 포워드하기 위한 디스패처 객체 생성
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
				dispatch.forward(request, response); // 다음 페이지로 요청과 응답 객체를 포워드
				
			} else if(action.equals("/del.do")) {
				System.out.println("cname: " + cname);
				his.delHireInfo(cname);
				
				nextPage = "/view/index.jsp";
				System.out.println("nextPage: " + nextPage);

				// 다음 페이지로 포워드하기 위한 디스패처 객체 생성
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
				dispatch.forward(request, response); // 다음 페이지로 요청과 응답 객체를 포워드
				
			} else if(action.equals("/applicatePage.do")) {
				String id = request.getParameter("id");
				String ssn = request.getParameter("ssn");
				
				AppFormVO vo = new AppFormDAO().getAppForm(ssn);
				IMemberVO ivo = new AppFormDAO().getImember(ssn);
				List<AppFormVO> careerExp = new AppFormDAO().getCareerExp(ssn);
				List<AppFormVO> license = new AppFormDAO().getLicense(ssn);
				List<AppFormVO> training = new AppFormDAO().getTraining(ssn);
				
				request.setAttribute("ivo", ivo);
				
				request.setAttribute("vo", vo);
				request.setAttribute("carExp", careerExp);
				request.setAttribute("license", license);
				request.setAttribute("training", training);
				
				if(careerExp != null || license != null || training != null) {
					nextPage = "/view/hireInfo/viewAppForm.jsp";
					System.out.println("if문 탑승: " + nextPage);
				} else if(careerExp == null || license == null || training == null) {
					nextPage = "/view/hireInfo/applicateForm.jsp";
					System.out.println("else if문 탑승: " + nextPage);
				}

				// 다음 페이지로 포워드하기 위한 디스패처 객체 생성
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
				dispatch.forward(request, response); // 다음 페이지로 요청과 응답 객체를 포워드
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		

	}

}
