package controller.joinController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

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
			//파일 업로드할 객체 얻기
			ServletContext application = request.getServletContext();
			String path = application.getRealPath("/upload/");
			out.print(path + "<br>");
			//2. 한번에 업로드할 파일의 최대 사이즈 설정  1GB = 1024MB
			int maxSize = 1024 * 1024 * 1024;
			//3. cos.jar파일 에서 제공해주는 MultiPartRequest클래스에 대한 객체를 생성해서 요청받은 파일을 upload폴더에 업로드 시킵니다.
			//요약. 요청한 파일정보를 이용해 파일업로드
			//객체 생성시 생성자로 전달할 정보들
			MultipartRequest multipartRequest = new MultipartRequest(request,
					 path,
					 maxSize,
					 "UTF-8", 
					 new DefaultFileRenamePolicy());
			String fileName = multipartRequest.getOriginalFileName("file");
			
			String fileRealName = multipartRequest.getFilesystemName("file");
			//요청한 값얻기(입력한 가입할 새 회원 정보를 request객체 로 부터 얻습니다.)
			String id = multipartRequest.getParameter("id");
			String password = multipartRequest.getParameter("pwd");
			String ssn = multipartRequest.getParameter("ssn");
			String name = multipartRequest.getParameter("name");
			String addr1 = multipartRequest.getParameter("address1");
			String addr2 = multipartRequest.getParameter("address2");
			String addr3 = multipartRequest.getParameter("address3");
			String addr4 = multipartRequest.getParameter("address4");
			String itel = multipartRequest.getParameter("tel");
			String email = multipartRequest.getParameter("email");
			
			
			
			//IMemberVO객체를 생성해서 각 변수에 저장
			IMemberVO imemberVO = new IMemberVO(id, password, ssn, name, addr1, addr2, addr3, addr4, itel, email, fileName, fileRealName);
			
			//입력한 회원정보들을 DB의 IMember테이블에 insert명령하기 위해
			//JoinService객체의 addMember메소드 호출!
			joinService.serviceAddIMember(imemberVO);
			
			
			
			nextPage = "/view/index.jsp";
			
		
		//기업회원에 대한 회원가입 요청이 들어왔을때	
		}else if (action.equals("/addCMember.do")) {
			//파일 업로드할 객체 얻기
			ServletContext application = request.getServletContext();
			String path = application.getRealPath("/upload/");
			out.print(path + "<br>");
			//2. 한번에 업로드할 파일의 최대 사이즈 설정  1GB = 1024MB
			int maxSize = 1024 * 1024 * 1024;
			//3. cos.jar파일 에서 제공해주는 MultiPartRequest클래스에 대한 객체를 생성해서 요청받은 파일을 upload폴더에 업로드 시킵니다.
			//요약. 요청한 파일정보를 이용해 파일업로드
			//객체 생성시 생성자로 전달할 정보들
			MultipartRequest multipartRequest = new MultipartRequest(request,
					 path,
					 maxSize,
					 "UTF-8", 
					 new DefaultFileRenamePolicy());
			
			String fileName = multipartRequest.getOriginalFileName("file2");
			
			String fileRealName = multipartRequest.getFilesystemName("file2");
			
			//요청한값얻기
			String cname = multipartRequest.getParameter("cname"); //회사명
			String cno = multipartRequest.getParameter("cno"); // 사업자 등록 번호
			String name = multipartRequest.getParameter("name2"); // 대표자명
			String ctel = multipartRequest.getParameter("ctel"); // 회사 전화번호
			String password = multipartRequest.getParameter("password"); //비밀번호
			String divcomp = multipartRequest.getParameter("divcomp"); //사업체 구분(일반기업,공공기관.....)
			String jobtype = multipartRequest.getParameter("jobtype"); // 모집직종(교육,여행,운전....)
			String addr1 = multipartRequest.getParameter("addr1");
			String addr2 = multipartRequest.getParameter("addr2");
			String addr3 = multipartRequest.getParameter("addr3");
			String addr4 = multipartRequest.getParameter("addr4");
			//유효성 검사 if문 필요
			
			//IMemberVO객체를 생성해서 각 변수에 저장
			CMemberVO cmemberVO = new CMemberVO(cno, ctel, name, cname, divcomp, jobtype, password, fileName, fileRealName, addr1, addr2, addr3, addr4); 
			
			//입력한 회원정보들을 DB의 IMember테이블에 insert명령하기 위해
			//JoinService객체의 addMember메소드 호출!
			joinService.serviceAddCMember(cmemberVO);
			
			
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
			boolean result2 = joinService.serviceOverLappedCno(cno);
			
			 
			//아이디 중복결과를 다시 한번 확인 하여 조건값을 
			//join.jsp파일과 연결된 join.js파일에 작성해 놓은
			//success:function의 data매개변수로 웹브라우저를 거쳐 보냅니다!
			if (result2 == true) {
				out.write("not_check");
				return;
			} else if (result2 == false) {
				out.write("checkOk");
				return;
			}
			System.out.println(result2);
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
