package controller.cjobExpController;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import VO.cjobExpVO.CjobExpVO;
import service.cjobExpService.CjobExpService;


@WebServlet("/cjobExp/*")
public class CjobExpController extends HttpServlet {

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
		
		CjobExpService cjobExpService = new CjobExpService();
		CjobExpVO cjobExpVO = new CjobExpVO();
		String nextPage = null;
				
		if(action == null || action.equals("/cjobExpBoard.do")) {
			
			ArrayList expolist = cjobExpService.getcjobExpListSerivce();
			

			
			
			request.setAttribute("expolist", expolist);
			
			nextPage="/view/cjobExpBoard.jsp";
			
		}
		
		//포워딩 (디스패처 방식)
		RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
						  dispatch.forward(request, response);
		}
	}
