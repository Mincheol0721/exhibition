package controller.appFormController;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

import com.oreilly.servlet.multipart.Part;

import DAO.appFormDAO.AppFormDAO;
import VO.IMemberVO.IMemberVO;
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
	    
	    //요청한 값 얻기
	    int pageNum = 1;
	    if(request.getParameter("pageNum") != null) {
	    	pageNum = Integer.parseInt(request.getParameter("pageNum"));
	    }
	    int pageSize = 6;
	    if(request.getParameter("pageSize") != null) {
	    	pageSize = Integer.parseInt(request.getParameter("pageSize"));
	    }
	    String cname = request.getParameter("cname");
	    String name = request.getParameter("name");
	    String ssn = request.getParameter("ssn");
	    String addr = request.getParameter("addr");
	    String tel = request.getParameter("tel");
	    String milServ = request.getParameter("milServ");
	    String edu = request.getParameter("edu");
	    String eduStat = request.getParameter("eduStat");
	    String imageId = request.getParameter("imageId");
	    String cstartDate = request.getParameter("cstartDate");
	    String cendDate = request.getParameter("cendDate");
	    String damdang = request.getParameter("damdang");
	    String lname = request.getParameter("lname");
	    String lnum = request.getParameter("lnum");
	    String getDate = request.getParameter("getDate");
	    String pub = request.getParameter("pub");
	    String eduName = request.getParameter("eduName");
	    String tstartDate = request.getParameter("tstartDate");
	    String tendDate = request.getParameter("tendDate");
	    String content = request.getParameter("content");
	    String carCname = request.getParameter("carCname");
	    
	    
	    String action = request.getPathInfo();
		

		try {
			
			if(action.equals("/getList.do")) {
				System.out.println("AppFormController 2단계 요청주소: " + action);
				System.out.println("con pagenum: " + pageNum);
				System.out.println("con pagesize: " + pageSize);
				System.out.println("con cname: " + cname);
				
				list = as.getAppFormList(pageNum, pageSize, cname); 
				System.out.println("list개수: " + list.size());
				
				request.setAttribute("list", list);
				
				nextPage = "/view/appForm/appFormList.jsp";
				
			} else if(action.equals("/getAppForm.do")) {
				System.out.println("AppFormController 2단계 요청주소: " + action);
//				ssn = request.getParameter("ssn");
				System.out.println("ssn: " + ssn);
				
				vo = as.getAppForm(ssn);
				List<AppFormVO> careerExp = as.getCareerExp(ssn);
				List<AppFormVO> license = as.getLicense(ssn);
				List<AppFormVO> training = as.getTraining(ssn);
				IMemberVO ivo = as.getImember(ssn);
				request.setAttribute("ivo", ivo);
				
				request.setAttribute("vo", vo);
				request.setAttribute("carExp", careerExp);
				request.setAttribute("license", license);
				request.setAttribute("training", training);
				
				// 이전에 DB에서 이미지를 읽어왔다고 가정
		        byte[] imageBytes = getImageBytesFromDatabase(imageId);
		        
		        if (imageBytes != null) {
		            // 이미지 콘텐츠 타입 설정
		            response.setContentType("image/jpg"); // 이미지 포맷에 따라 변경 가능
		            
		            // 이미지 출력
		            response.getOutputStream().write(imageBytes);
		        } 
		        request.setAttribute("img", imageBytes);
				
				nextPage = "/view/appForm/viewAppForm.jsp?ssn=" + ssn; 
				System.out.println("nextPage: " + nextPage);
				
			} else if(action.equals("/applicateComp.do")) {
				String id = request.getParameter("id");
				System.out.println("cname: " + cname);
				
				vo.setName(name); vo.setSsn(ssn); vo.setTel(tel); vo.setMilServ(milServ);
				vo.setAddr(addr); vo.setEdu(edu); vo.setEduStat(eduStat); vo.setCname(cname);
				vo.setCalCname(carCname); vo.setCstartDate(cstartDate); vo.setCendDate(cendDate); vo.setDamdang(damdang);
				vo.setLname(lname); vo.setLnum(lnum); vo.setGetDate(getDate); vo.setPub(pub);
				vo.setEduName(eduName); vo.setTstartDate(tstartDate); vo.setTendDate(tendDate); vo.setContent(content);
				
				as.insertAppForm(vo, id);
				
				nextPage = "/hireInfo/getList.do?pageNum=" + pageNum;
				
				
			}
			
			// 다음 페이지로 포워드하기 위한 디스패처 객체 생성
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
			dispatch.forward(request, response); // 다음 페이지로 요청과 응답 객체를 포워드
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	// DB에서 이미지 바이트 배열을 가져오는 메서드
	private byte[] getImageBytesFromDatabase(String imageId) {
	    return new AppFormService().getImageBytesFromDatabase(imageId);
	}

	
}
