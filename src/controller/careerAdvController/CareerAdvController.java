package controller.careerAdvController;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.careerAdvService.CareerAdvService;



@WebServlet("/careerAdv/*")
public class CareerAdvController extends HttpServlet {
	
           
    public CareerAdvController() {
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}
	
	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String action = request.getPathInfo();
		System.out.println("2단계 요청 주소: "+action);
		
		String nextPage = null;
		
		if(action == null || action.equals("/careerAdvBoard.do")) {
			
		
			

			CareerAdvService careerAdvService = new CareerAdvService();
			ArrayList careerAdvlist	= careerAdvService.careerAdvListSerivce();
			
							request.setAttribute("careerAdvlist", careerAdvlist);
			
			
			nextPage="/view/careerAdv/careerAdvBoard.jsp";
			
		}
		//포워딩 (디스패처 방식)
				RequestDispatcher dispatch = request.getRequestDispatcher(nextPage);
								  dispatch.forward(request, response);
	}//doHandle

}
