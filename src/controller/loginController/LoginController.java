package controller.loginController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.LoginService.LoginService;


@WebServlet("/login/*")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private LoginService loginService;
	
	
	//서블릿이 요청을 받았을때.. 가장처음에 LoginController클래스가 톰캣 메모리 로드되는 시점에
	//개발자가 변수의 값을 초기화 해놓을때 사용되는 init메소드 오버라이딩
	@Override
	public void init() throws ServletException {
		loginService = new LoginService();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doHandle(request, response);
	}
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//한글처리
		request.setCharacterEncoding("UTF-8");
		
		response.setContentType("text/html;charset=utf8");
		//request객체의 getPathInfo()메소드를 호출하여 클라이언트가 요청한 2단계 요청주소 URL을 가져 옵니다.
		String action = request.getPathInfo();
		System.out.println("클라이언트가 요청한 주소 :" + action);
		
		//서블릿에서 재요청할 뷰 주소를 저장할 변수 선언
		String nextPage = null;
		
		//웹브라우저와 연결된 출력 스트림 통로 만들기
		PrintWriter out = response.getWriter();
		
		try {
			if(action == null || action.equals("/Ilogin.me")) {
	 			int result = -1;
				int isAdmin = -1;
				String id = request.getParameter("id");
				String pwd = request.getParameter("pwd");
				
				//서비스단에서 로그인 처리하기 위한 메소드
				result = loginService.serviceIlogin(id,pwd); 
				isAdmin = loginService.serviceAdmincheck(id);
				//
				
				if (result == 1) {
					HttpSession session = request.getSession();
					session.setAttribute("id", id);
					session.setAttribute("isAdmin", isAdmin);
				}else if(result == -1) {
					out.println("<script>");
					out.println("window.alert('아이디 틀림');");
					out.println("history.go(-1);");
					out.println("</script>");
					return;
				}else if (result == 0) {
					out.println("<script>");
					out.println("window.alert('비밀번호 틀림');");
					out.println("history.go(-1);");
					out.println("</script>");
					return;
				}
				System.out.println(isAdmin);
				nextPage = "/view/index.jsp";
			//기업회원의 로그인 요청
			}else if (action.equals("/Clogin.me")) {
					int result = -1;
					int isAdmin = 0;
					String cno = request.getParameter("cno");
					String cpwd = request.getParameter("cPwd");
					
					//서비스단에서 로그인 처리하기 위한 메소드
					result = loginService.serviceClogin(cno,cpwd); 
					
					//
					
					if (result == 1) {
						HttpSession session = request.getSession();
						session.setAttribute("cno", cno);
						
					}else if(result == -1) {
						out.println("<script>");
						out.println("window.alert('아이디 틀림');");
						out.println("history.go(-1);");
						out.println("</script>");
						return;
					}else if (result == 0) {
						out.println("<script>");
						out.println("window.alert('비밀번호 틀림');");
						out.println("history.go(-1);");
						out.println("</script>");
						return;
					}
				
				nextPage = "/view/index.jsp";
			}else {
				nextPage = "/view/index.jsp";
			}
			//포워딩 (디스패처 방식)
			RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
			dispatch.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}//doHandle 끝
}
