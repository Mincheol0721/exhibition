package controller.memberInfoController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import VO.CMemberVO.CMemberVO;
import VO.IMemberVO.IMemberVO;
import service.LoginService.LoginService;
import service.memberInfoService.MemberInfoService;


@WebServlet("/memberInfo/*")
public class MemberInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MemberInfoService memberInfoservice;
	
	
	//서블릿이 요청을 받았을때.. 가장처음에 LoginController클래스가 톰캣 메모리 로드되는 시점에
	//개발자가 변수의 값을 초기화 해놓을때 사용되는 init메소드 오버라이딩
	@Override
	public void init() throws ServletException {
		memberInfoservice = new MemberInfoService();
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
			if(action == null || action.equals("/imodify.me")) {
				IMemberVO vo = null;
				int check = -1;
				//요청한값 얻기
				HttpSession session = request.getSession();
				String id = (String)session.getAttribute("id");
				String pwd = request.getParameter("pwd");
	 			String name = request.getParameter("name");
	 			String tel = request.getParameter("tel");
	 			String email = request.getParameter("email");
	 			String addr1 = request.getParameter("address1");
	 			String addr2 = request.getParameter("address2");
	 			String addr3 = request.getParameter("address3");
	 			String addr4 = request.getParameter("address4");
	 			String emailchk =  "^[a-zA-Z0-9_+&*-]+(?:\\." +
	 			        "[a-zA-Z0-9_+&*-]+)*@" +
	 			        "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
	 			        "A-Z]{2,7}$";
	 			vo = new IMemberVO(pwd, name, addr1, addr2, addr3, addr4, tel, email);
	 			
	 			if (pwd.length() < 4) {
	 				
					out.print("<script>");
						out.print("alert('4글자 이상 입력해 주세요');");
						out.print("location.href='"+request.getContextPath()+"/memberInfo/iInfo.me';");
					out.print("</script>");
					return;
	 			}
	 			
	 			if (name.length() < 2 && name.length() < 6 ) {
					out.print("<script>");
						out.print("alert('이름을 제대로 입력하여 주세요');");
						out.print("location.href='"+request.getContextPath()+"/memberInfo/iInfo.me';");
					out.print("</script>");
					return;
				}
	 			
	 			if (tel.matches("/^0[0-9]{8,10}$/")) {
					out.print("<script>");
						out.print("alert('전화번호 형식이 올바르지 않습니다.');");
						out.print("location.href='"+request.getContextPath()+"/memberInfo/iInfo.me';");
					out.print("</script>");
					return;
				}
	 			
	 			if (!(email.matches(emailchk))) {
					out.print("<script>");
						out.print("alert('이메일 형식이 올바르지 않습니다.');");
						out.print("location.href='"+request.getContextPath()+"/memberInfo/iInfo.me';");
					out.print("</script>");
					return;
				}
	 			
	 			
	 			check = memberInfoservice.serviceModifyMyInfo(vo,id);
	 			
	 			if (check == 1) {
	 				//request내장객체 영역에 웹브라우저로 응답할 조회된회원정보들이 저장된 ArrayList배열을 바인딩 합니다.
	 				request.setAttribute("msg", "modifyOk");
				}
	 			
	 			nextPage = "/memberInfo/iInfo.me";
	 			
	 			
	 			
			}else if(action.equals("/iInfo.me")) {
				IMemberVO vo = null;
				
				//요청한값 얻기
				HttpSession session = request.getSession();
				
				String id = (String)session.getAttribute("id");
				
				vo = memberInfoservice.serviceSearchMyInfo(id);
				
				request.setAttribute("vo", vo);
	 			
				nextPage = "/view/mypage/Iinfo.jsp";
				
			}else if (action.equals("/cInfo.me")) {
				CMemberVO cvo = null;
				
				//요청한값 얻기
				HttpSession session = request.getSession();
				
				String cno = (String)session.getAttribute("cno");
				
				cvo = memberInfoservice.serviceSearchCInfo(cno);
				
				request.setAttribute("cvo", cvo);
	 			
				nextPage = "/view/mypage/cinfo.jsp";
				
			}else if(action.equals("/cmodify.me")) {
				CMemberVO vo = null;
				int check = -1;
				//요청한값 얻기
				HttpSession session = request.getSession();
				String cno = (String)session.getAttribute("cno");
				String cname = request.getParameter("cname");
				String password = request.getParameter("password");
	 			String name = request.getParameter("name2");
	 			String ctel = request.getParameter("ctel");
	 			String jobtype = request.getParameter("jobtype");
	 			String divcomp = request.getParameter("divcomp");
	 			String addr1 = request.getParameter("addr1");
	 			String addr2 = request.getParameter("addr2");
	 			String addr3 = request.getParameter("addr3");
	 			String addr4 = request.getParameter("addr4");
	 			
	 			System.out.println(cname);
	 			
	 			if (cname.length() < 1 && cname.length() > 10 ) {
					out.print("<script>");
						out.print("alert('회사명을 제대로 입력하여 주세요');");
						out.print("location.href='"+request.getContextPath()+"/memberInfo/cInfo.me';");
					out.print("</script>");
					return;
				}
	 			System.out.println(cname);
	 			if (name.length() < 2 && name.length() < 6  ) {
					out.print("<script>");
						out.print("alert('이름을 제대로 입력하여 주세요');");
						out.print("location.href='"+request.getContextPath()+"/memberInfo/cInfo.me';");
					out.print("</script>");
					return;
				}
	 			
	 			if ((ctel.matches("/^0[0-9]{8,10}$/"))) {
					out.print("<script>");
						out.print("alert('전화번호 형식이 올바르지 않습니다.');");
						out.print("location.href='"+request.getContextPath()+"/memberInfo/cInfo.me';");
					out.print("</script>");
					return;
				}
	 			
	 			if (password.length() < 4) {
					out.print("<script>");
						out.print("alert('4글자 이상 입력해 주세요');");
						out.print("location.href='"+request.getContextPath()+"/memberInfo/cInfo.me';");
					out.print("</script>");
					return;
				}
	 			vo = new CMemberVO(ctel, name, cname, divcomp, jobtype, password, addr1, addr2, addr3, addr4);	
	 			
	 		check = memberInfoservice.serviceModifyCInfo(vo,cno);
	 		
	 		if (check == 1) {
 				//request내장객체 영역에 웹브라우저로 응답할 조회된회원정보들이 저장된 ArrayList배열을 바인딩 합니다.
 				request.setAttribute("msg", "modifyOk");
			}
	 		
	 		nextPage = "/memberInfo/cInfo.me";
	 			
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
