package controller.JobExpController;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import VO.JobExpVO.CJobExpVO;
import VO.JobExpVO.IJobExpVO;
import service.JobExpService.JobExpService;


@WebServlet("/jobExp/*")
public class JobExpController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doHandle(request, response);
	}

	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String action = request.getPathInfo();
		System.out.println("2단계 요청 주소: "+action);
		
		JobExpService jobExpService = new JobExpService();
		CJobExpVO cjobExpVO = new CJobExpVO();
		IJobExpVO ijobExpVO = new IJobExpVO();
		String nextPage = null;
				
		if(action == null || action.equals("/jobExpBoard.do")) {
			
			ArrayList expolist = jobExpService.getcjobExpListSerivce();
			

			
			
			request.setAttribute("expolist", expolist);
			
			nextPage="/view/jobExp/JobExpBoard.jsp";
			
		}else if(action.equals("/IJobExpReg.do")) {
			System.out.println("asd");
			nextPage="/view/jobExp/IJobExpReg.jsp";
		
		
		}else if(action.equals("/IJobExpReg2.do")) {
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			System.out.println(name);
			System.out.println(tel);
			ijobExpVO.setName(name);
			ijobExpVO.setTel(tel);			
			jobExpService.insertIjobExpSerivce(ijobExpVO);
			
			nextPage="/view/jobExp/JobExpBoard.jsp";
			
			
		}else if(action.equals("/CJobExpReg.do")) {
			
			nextPage="/view/jobExp/CJobExpReg.jsp";
			
		}else if(action.equals("/CJobExpReg2.do")) {
			
			String path = getServletContext().getRealPath("/upload/");
			int maxSize = 1024 * 1024 * 1024;
			MultipartRequest multipartRequest = new MultipartRequest(request,
																	 path,
																	 maxSize,
																	 "UTF-8", 
																	 new DefaultFileRenamePolicy());
			
			String cname = multipartRequest.getParameter("cname");
			String title = multipartRequest.getParameter("title");
			String content = multipartRequest.getParameter("content");
			String iPart = multipartRequest.getParameter("iPart");
			String teacher = multipartRequest.getParameter("teacher");
			String startTime = multipartRequest.getParameter("startTime");
			String endTime = multipartRequest.getParameter("endTime");
			String locate = multipartRequest.getParameter("locate");
			
			
			cjobExpVO.setCname(cname);
			cjobExpVO.setTitle(title);
			cjobExpVO.setContent(content);
			cjobExpVO.setiPart(iPart);
			cjobExpVO.setTeacher(teacher);
			cjobExpVO.setStartTime(startTime);
			cjobExpVO.setEndTime(endTime);
			cjobExpVO.setLocate(locate);
			
			
			
			
			
			//4. 실제 업로드 하기 전의  파일업로드를 하기 위해 fileUpload.jsp에서 선택했던 원본파일명 얻기
			//   <input type="file" name="file"> 은 파일 업로드하기 위해 선택하는 <input>입니다.
			//   아래의 메소드 호출시 name속성의 값을 매개변수로 전달하면  실제 업로드하기전의 선택했던 원본파일명을 문자열로 얻는다.
			String fileName = multipartRequest.getOriginalFileName("file");
			
			//5. 실제 upload업로드폴더(실제 서버 업로드폴더경로)에  업로드된 실제 파일명 얻기 
			String fileRealName = multipartRequest.getFilesystemName("file");
			
			
			
			cjobExpVO.setFileName(fileName);
			cjobExpVO.setFileRealName(fileRealName);
			
			jobExpService.insertCjobExpSerivce(cjobExpVO);
			System.out.println(cname);
			System.out.println(title);
			
			nextPage="/view/jobExp/JobExpBoard.jsp";
		}
	
		//포워딩 (디스패처 방식)
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
						  dispatch.forward(request, response);
		}
	}
