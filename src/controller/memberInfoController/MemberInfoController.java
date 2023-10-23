package controller.memberInfoController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import VO.CMemberVO.CMemberVO;
import VO.IMemberVO.IMemberVO;
import VO.appFormVO.AppFormVO;
import VO.iJobExpVO.IjobExpVO;
import VO.iapplicationVO.AllAppFormVO;
import VO.iapplicationVO.CareerExpVO;
import VO.iapplicationVO.LicenseVO;
import VO.iapplicationVO.TrainingVO;
import service.memberInfoService.MemberInfoService;


@WebServlet("/memberInfo/*")
public class MemberInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MemberInfoService memberInfoservice;
	
	// 게시글 정보를 저장하는 리스트
	private List<AllAppFormVO> list;
	
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
	 			
			}else if(action.equals("/application.me")) {
				
				AllAppFormVO vo = null;
				
				
				//요청한값 얻기
				HttpSession session = request.getSession();
				
				String id = (String)session.getAttribute("id");
				
				vo = memberInfoservice.serviceSearchMyinfo2(id);
				List<AllAppFormVO> career = memberInfoservice.serviceSearchCareerInfo(vo);
				List<AllAppFormVO> license = memberInfoservice.serviceSearchLicenseInfo(vo);
				List<AllAppFormVO> training = memberInfoservice.serviceSearchTrainingInfo(vo);
				List<AllAppFormVO> appForm = memberInfoservice.serviceSearchAppFormInfo(vo);
				
				request.setAttribute("vo", vo);
	 			request.setAttribute("career", career);
	 			request.setAttribute("license", license);
	 			request.setAttribute("training", training);
	 			request.setAttribute("appForm", appForm);
				nextPage = "/view/mypage/iapplication.jsp";
				
			}else if(action.equals("/addRegister.me")) {
				IMemberVO iMemVO = null;
				AppFormVO appVO;
				CareerExpVO carVO;
				LicenseVO licenseVO;
				TrainingVO tVO;
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
				HttpSession session = request.getSession();
				String id = (String)session.getAttribute("id");
				String fileName = multipartRequest.getOriginalFileName("file");
				String fileRealName = multipartRequest.getFilesystemName("file");
				
				
				//요청한 값얻기(입력한 가입할 새 회원 정보를 request객체 로 부터 얻습니다.)
				// 개인회원 테이블에 insert할 값
				String addr1 = multipartRequest.getParameter("address1");
				String addr2 = multipartRequest.getParameter("address2");
				String addr3 = multipartRequest.getParameter("address3");
				String addr4 = multipartRequest.getParameter("address4");
				String tel = multipartRequest.getParameter("tel");
				//IMemberVO객체를 생성해서 각 변수에 저장
				iMemVO = new IMemberVO(addr1, addr2, addr3, addr4, tel, fileName, fileRealName);
				
				// 입사지원 테이블에 insert할 값
				String name = multipartRequest.getParameter("name");
				String ssn = multipartRequest.getParameter("ssn");
				String addr = addr2 + addr4;
				String milServ = multipartRequest.getParameter("milServ");
				String edu = multipartRequest.getParameter("edu");
				String eduStat = multipartRequest.getParameter("eduStat");
				appVO = new AppFormVO(name, ssn, addr, tel, milServ, edu, eduStat);
				
				//경력 사항 테이블에 insert할 값
				String no1 = multipartRequest.getParameter("no1");
				String no2 = multipartRequest.getParameter("no2");
				String no3 = multipartRequest.getParameter("no3");
				String careerName1 = multipartRequest.getParameter("careerName1");
				String careerName2 = multipartRequest.getParameter("careerName2");
				String careerName3 = multipartRequest.getParameter("careerName3");
				String careerCname1 = multipartRequest.getParameter("careerCname1");
				String careerCname2 = multipartRequest.getParameter("careerCname2");
				String careerCname3 = multipartRequest.getParameter("careerCname3");
				String careerStartDate1 = multipartRequest.getParameter("careerStartDate1");
				String careerStartDate2 = multipartRequest.getParameter("careerStartDate2");
				String careerStartDate3 = multipartRequest.getParameter("careerStartDate3");
				String careerEndDate1 = multipartRequest.getParameter("careerEndDate1");
				String careerEndDate2 = multipartRequest.getParameter("careerEndDate2");
				String careerEndDate3 = multipartRequest.getParameter("careerEndDate3");
				String damdang1 = multipartRequest.getParameter("damdang1");
				String damdang2 = multipartRequest.getParameter("damdang2");
				String damdang3 = multipartRequest.getParameter("damdang3");
				carVO = new CareerExpVO(no1, careerName1, careerStartDate1, careerCname1, careerEndDate1, damdang1, 
						no2, careerName2, careerStartDate2, careerCname2, careerEndDate2, damdang2, 
						no3, careerName3, careerStartDate3, careerCname3, careerEndDate3, damdang3);
				
				//자격면허 테이블에 insert할 값
				String licenseName1 = multipartRequest.getParameter("licenseName1");//이름
				String licenseName2 = multipartRequest.getParameter("licenseName2");
				String licenseName3 = multipartRequest.getParameter("licenseName3");
				String lname1 = multipartRequest.getParameter("lname1");//종목
				String lname2 = multipartRequest.getParameter("lname2");
				String lname3 = multipartRequest.getParameter("lname3");
				String lnum1 = multipartRequest.getParameter("lnum1");// 등록번호
				String lnum2 = multipartRequest.getParameter("lnum2");
				String lnum3 = multipartRequest.getParameter("lnum3");
				String getDate1 = multipartRequest.getParameter("getDate1");// 발급일자
				String getDate2 = multipartRequest.getParameter("getDate2");
				String getDate3 = multipartRequest.getParameter("getDate3");
				String pub1 = multipartRequest.getParameter("pub1");// 발급처
				String pub2 = multipartRequest.getParameter("pub2");
				String pub3 = multipartRequest.getParameter("pub3");
				licenseVO = new LicenseVO(licenseName1, licenseName2, licenseName3, 
						lname1, lname2, lname3, 
						lnum1, lnum2, lnum3, 
						getDate1, getDate2, getDate3, 
						pub1, pub2, pub3);
				
				//교육및 훈련사항테이블 insert할 값
				String tno1 = multipartRequest.getParameter("tno1");// 교육 번호
				String tno2 = multipartRequest.getParameter("tno2");
				String tno3 = multipartRequest.getParameter("tno3");
				String tname1 = multipartRequest.getParameter("tname1");// 지원자명 
				String tname2 = multipartRequest.getParameter("tname2");
				String tname3 = multipartRequest.getParameter("tname3");
				String eduName1 = multipartRequest.getParameter("eduName1");// 교육 훈련 기관
				String eduName2 = multipartRequest.getParameter("eduName2");
				String eduName3 = multipartRequest.getParameter("eduName3");
				String tStartDate1 = multipartRequest.getParameter("tStartDate1"); //교육 시작 일시
				String tStartDate2 = multipartRequest.getParameter("tStartDate2");
				String tStartDate3 = multipartRequest.getParameter("tStartDate3");
				String tEndDate1 = multipartRequest.getParameter("tEndDate1"); //교육 종료 일시
				String tEndDate2 = multipartRequest.getParameter("tEndDate2");
				String tEndDate3 = multipartRequest.getParameter("tEndDate3");
				String content1 = multipartRequest.getParameter("content1");// 교육내용
				String content2 = multipartRequest.getParameter("content2");
				String content3 = multipartRequest.getParameter("content3");
				tVO = new TrainingVO(tno1, tno2, tno3, 
						tname1, tname2, tname3, 
						eduName1, eduName2, eduName3, 
						tStartDate1, tStartDate2, tStartDate3, 
						tEndDate1, tEndDate2, tEndDate3, 
						content1, content2, content3);
				
				//입력한 회원정보들을 DB의 IMember테이블에 insert명령하기 위해
				//memberInfoservice객체의 addMember메소드 호출!
//				memberInfoservice.serviceAddRegister();
				
				memberInfoservice.serviceAddRegister(iMemVO,appVO,carVO,licenseVO,tVO,id);
				
				
				System.out.println("c값" + careerStartDate1);
				nextPage = "/memberInfo/application.me";
				
				
				
			}else if (action.equals("/reservationStatus.me")) {
				IMemberVO vo = null;
				
				//요청한값 얻기
				HttpSession session = request.getSession();
				
				String id = (String)session.getAttribute("id");
				
				vo = memberInfoservice.serviceSearchMyInfo(id);
				
				System.out.println(vo.getName());
				List<IjobExpVO> membersList = memberInfoservice.servicelistMembers(vo);
				
				//request내장객체 영역에 웹브라우저로 응답할 조회된회원정보들이 저장된 ArrayList배열을 바인딩 합니다.
				request.setAttribute("membersList", membersList);
				
				nextPage = "/view/mypage/reservationStatus.jsp";
				
			}else if(action.equals("/delMember.me")){
				//요청한 값 얻기 (삭제할 회원의 ID 얻기)
				String no = request.getParameter("no");
				
				//ID에 해당되는 회원정보를 DB의 t_member테이블에서 삭제 하는 명령!
				memberInfoservice.serviceDelMember(no);
				
				//삭제에 성공하면 listMembers.jsp에 삭제작업 완료 메세지를 전달 하기 위해
				//request에 삭제 성공 조건 값을 바인딩합니다.
				request.setAttribute("msg", "deleted");
				
				nextPage = "/memberInfo/reservationStatus.me";
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
