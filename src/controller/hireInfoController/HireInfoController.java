package controller.hireInfoController;

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

		//요청할 값 얻기
		String cname = request.getParameter("cname");
		String divComp = request.getParameter("divComp");
		String htel = request.getParameter("htel");
		String homepage = request.getParameter("homepage");
		String jobType = request.getParameter("jobType");
		String workTime = request.getParameter("workTime");
		String legal = request.getParameter("legal");
		
		String action = request.getPathInfo();
		
		System.out.println("hireInfoController 2단계 요청주소: " + action);
		
		try {
			
			if(action.equals("/reg.do")) {
				System.out.println("action값: " + action);
				vo.setCname(cname);
				vo.setDivComp(divComp);
				vo.setHomepage(homepage);
				vo.setHtel(htel);
				vo.setJobType(jobType);
				vo.setLegal(legal);
				vo.setWorkTime(workTime);
				
				his.regHireInfo(vo);
				nextPage = request.getContextPath() + "/view/index.jsp";
				System.out.println("nextPage: " + nextPage);

				// 다음 페이지로 포워드하기 위한 디스패처 객체 생성
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
				dispatch.forward(request, response); // 다음 페이지로 요청과 응답 객체를 포워드
				
			} else if (action.equals("/getList.do")) {
				
				int pageNum = Integer.parseInt(request.getParameter("pageNum"));
				int pageSize = Integer.parseInt(request.getParameter("pageSize"));
				
				JSONArray jsonArray = new JSONArray(); // [ ]
				
				List<HireInfoVO> list = his.getHireInfoList(pageNum, pageSize); 
				
				for( HireInfoVO vo : list ) {
					JSONObject jsonObject = new JSONObject();
					
					jsonObject.put("cname", vo.getCname());
					jsonObject.put("htel", vo.getHtel());
					jsonObject.put("divComp", vo.getDivComp());
					jsonObject.put("homepage", vo.getHomepage());
					jsonObject.put("jobType", vo.getJobType());
					jsonObject.put("workTime", vo.getWorkTime());
					jsonObject.put("legal", vo.getLegal());
					
					jsonArray.add(jsonObject);
					
				} //for
				
				out.print(jsonArray.toString());
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
