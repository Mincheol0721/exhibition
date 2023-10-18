package controller.joinController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.CMemberVO.CMemberVO;
import VO.IMemberVO.IMemberVO;

import service.joinService.JoinService;


@WebServlet("/Join/*")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	//회원가입 서비스 변수 설정
	private JoinService joinService;
   
	
	//서블릿이 요청을 받았을때.. 가장처음에 JoinController클래스가 톰캣 메모리 로드되는 시점에
	//개발자가 변수의 값을 초기화 해놓을때 사용되는 init메소드 오버라이딩
	@Override
	public void init() throws ServletException {
		joinService = new JoinService();
		
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
		//개인 회원가입 요청
		//action변수에 저장한 값에 따라 if문을 분기해서 요청한 작업을 수행하는데...
		//만약 action변수에 저장된 값이 null이거나 /addIMember.do 2단계 요청주소를 받으면 회원가입하는 기능을 수행
		if(action == null || action.equals("/addIMember.do")) {
			//요청한 값얻기(입력한 가입할 새 회원 정보를 request객체 로 부터 얻습니다.)
			String id = request.getParameter("id");
			String password = request.getParameter("pwd");
			String ssn = request.getParameter("ssn");
			String name = request.getParameter("name");
			String address1 = request.getParameter("address1");
			String address2 = request.getParameter("address2");
			String address3 = request.getParameter("address3");
			String address4 = request.getParameter("address4");
			String addr = address1 + address2 + address3 + address4;
			String itel = request.getParameter("tel");
			String email = request.getParameter("email");
			
			
			
			//IMemberVO객체를 생성해서 각 변수에 저장
			IMemberVO imemberVO = new IMemberVO(id, password, ssn, name, addr, itel, email);
			
			//입력한 회원정보들을 DB의 IMember테이블에 insert명령하기 위해
			//JoinService객체의 addMember메소드 호출!
			joinService.serviceAddIMember(imemberVO);
			
			
			
			nextPage = "/view/index.jsp";
			
		
		//기업회원에 대한 회원가입 요청이 들어왔을때	
		}else if (action.equals("/addCMember.do")) {
			//요청한값얻기
			String cname = request.getParameter("cname"); //회사명
			String cno = request.getParameter("cno"); // 사업자 등록 번호
			String name = request.getParameter("name"); // 대표자명
			String ctel = request.getParameter("ctel"); // 회사 전화번호
			String password = request.getParameter("password"); //비밀번호
			String divcomp = request.getParameter("divcomp"); //사업체 구분(일반기업,공공기관.....)
			String jobtype = request.getParameter("jobtype"); // 모집직종(교육,여행,운전....)
			
			//유효성 검사 if문 필요
			
			//IMemberVO객체를 생성해서 각 변수에 저장
			CMemberVO cmemberVO = new CMemberVO(cno, ctel, name, cname, divcomp, jobtype, password); 
			
			//입력한 회원정보들을 DB의 IMember테이블에 insert명령하기 위해
			//JoinService객체의 addMember메소드 호출!
			joinService.serviceAddCMember(cmemberVO);
			
			//회원가입에 성공하면 index.jsp에 보여줄 성공 메세지를 request에 바인딩
			request.setAttribute("msg", "addMember");
			
			//새 회원정보를 DB의 IMember테이블에 insert성공시 재요청(포워딩)할 서블릿 페이지 주소
			//nextPage변수에 저장
			nextPage = "/view/index.jsp";
			
		}else if(action.equals("/joinIdCheck.me")) {
			//요청한 값 얻기
			String id = request.getParameter("id");
			
			//입력한 아이디가 DB에 저장되어 있는지 중복 체크 작업
			//true -> 중복 , false -> 중복아님 둘중 하나를 반환 받음
			boolean result = joinService.serviceOverLappedId(id);
			
			 
			//아이디 중복결과를 다시 한번 확인 하여 조건값을 
			//join.jsp파일과 연결된 join.js파일에 작성해 놓은
			//success:function의 data매개변수로 웹브라우저를 거쳐 보냅니다!
			if (result == true) {
				out.write("not_usable");
				return;
			} else if (result == false) {
				out.write("usable");
				return;
			}
		}else if (action.equals("/joinCnoCheck.me")) {
			//요청한 값 얻기
			String cno = request.getParameter("cno");
			
			//입력한 아이디가 DB에 저장되어 있는지 중복 체크 작업
			//true -> 중복 , false -> 중복아님 둘중 하나를 반환 받음
			boolean result = joinService.serviceOverLappedCno(cno);
			
			 
			//아이디 중복결과를 다시 한번 확인 하여 조건값을 
			//join.jsp파일과 연결된 join.js파일에 작성해 놓은
			//success:function의 data매개변수로 웹브라우저를 거쳐 보냅니다!
			if (result == true) {
				out.write("not_usable");
				return;
			} else if (result == false) {
				out.write("usable");
				return;
			}
		}else {
			nextPage = "/view/index.jsp";
		}
		
		//RequestDispatcher클래스를 이용한 디스패처 방식으로 View(jsp)를 재요청 하면서 request내장객체를 공유해야 한다.
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
								  dispatch.forward(request, response); //실제 포워딩(재요청)시 request,response 객체 공유
		}catch (Exception e) {
			e.printStackTrace();
		}
	}//doHandle 끝

}
