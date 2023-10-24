package controller.consController;

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
import VO.consVO.ConsVO;
import service.JobExpService.JobExpService;
import service.consService.copy.ConsService; 


@WebServlet("/cons/*") 
public class ConsController extends HttpServlet {

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
		
		String contextpath = request.getContextPath();
		String action = request.getPathInfo();
		System.out.println("2단계 요청 주소: "+action);
		
		ConsService consService = new ConsService();
		ConsVO consVO = new ConsVO();
		String nextPage = null;
				
		if(action == null || action.equals("/consBoard.do")) {
			
			ArrayList conslist = consService.getIntroConsListSerivce();
			

			
			
			request.setAttribute("conslist", conslist);
			
			nextPage="/view/cons/introconsBoard.jsp";
			
			
		}/*else if(action.equals("/consReg2.do")) {
			
			ConsVO consVO = new ConsVO();
			
			String name = request.getParameter("name");
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			String iPart = request.getParameter("iPart");
			String sitel = request.getParameter("sitel");
			String ampm = request.getParameter("ampm");
			String startTime = request.getParameter("startTime");
			String endTime = request.getParameter("endTime");
			String locate = request.getParameter("locate");
			String homepage = request.getParameter("homepage");
			String fileName = request.getParameter("fileName");
			String fileRealName = request.getParameter("fileRealName");
			String usePeople = request.getParameter("usePeople");
			String regDate = request.getParameter("regDate");
			String reservation = request.getParameter("reservation");
			String consType = request.getParameter("consType");
			
			
			consVO.set
			consVO.setTitle(title);
			consVO.setContent(content);
			consVO.setiPart(iPart);
			consVO.setStartTime(startTime);
			consVO.setEndTime(endTime);
			consVO.setLocate(locate);
			
			
			
			
			
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
		}*/
	
		//포워딩 (디스패처 방식)
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
						  dispatch.forward(request, response);
		}
	}
