package controller.cInfoController;

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

import DAO.CInfoDAO.CInfoDAO;
import VO.CMemberVO.CMemberVO;
import service.CInfoService.CInfoService;
import service.articlesService.ArticlesService;

@WebServlet("/CInfo/*")
public class CInfoController extends HttpServlet{
	
		// 게시판 서비스 객체
		private CInfoService cs;
		
		// 게시글 정보 객체
		private CMemberVO vo;
		
		// 서블릿 초기화 메서드, 서블릿 컨테이너에 의해 서블릿 초기화 시 호출됨
		public void init(ServletConfig config) throws ServletException {
			cs = new CInfoService();
			vo = new CMemberVO();
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
		    
			String action = request.getPathInfo();
			System.out.println("CInfoController 2단계 요청주소: " + action);
			//	 		/getCInfoList.do 기업정보 리스트를 조회한 페이지로 이동
			
		try {
			
			if(action.equals("/getCInfoList.do")) {
				
				List<CMemberVO> cInfoList = cs.getCInfoList(); // getCInfoList 메소드 호출

		        // 조회 결과를 request에 설정
		        request.setAttribute("cInfoList", cInfoList);
	
		        nextPage = "/view/cInfo/cInfo.jsp"; 
			
				// 다음 페이지로 포워드하기 위한 디스패처 객체 생성
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage); 
				dispatch.forward(request, response); // 다음 페이지로 요청과 응답 객체를 포워드
			
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace(); // 예외 발생 시 콘솔에 스택 트레이스 출력
		}
		
		
	}//doHandle end
}
