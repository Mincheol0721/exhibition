package controller.jobLectureController;

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
import VO.jobLectureVO.JobLectureVO;
import service.JobExpService.JobExpService;
import service.consService.copy.ConsService;
import service.jobLectureService.JobLectureService;


@WebServlet("/jobLecture/*")
public class JobLectureController extends HttpServlet {

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
		
		JobLectureService jobLectureService = new JobLectureService();
		JobLectureVO lectureVO = new JobLectureVO();
		String nextPage = null;
				
		if(action == null || action.equals("/jobLectureBoard.do")) {
			
			ArrayList jobLecturelist = jobLectureService.getJobLectureListSerivce();
			

			
			
			request.setAttribute("jobLecturelist", jobLecturelist);
			
			nextPage="/view/jobLecture/jobLectureBoard.jsp";
			
			
		}
	
		//포워딩 (디스패처 방식)
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
						  dispatch.forward(request, response);
		}
	}
