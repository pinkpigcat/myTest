package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import vo.ActionForward;

@WebServlet("*.adm")
public class AdminController extends HttpServlet {

	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String command = request.getServletPath();
		System.out.println("command : " + command);
		
		Action action = null;			
		ActionForward forward = null;	
		
		
		
		//=================================================================================
		
		// 서블릿 주소에 따라 각각 다른 작업을 수행
		if(command.equalsIgnoreCase("/")) {
			forward = new ActionForward();
			forward.setPath("./");
		} else if(command.equalsIgnoreCase("/")) {
			action = null;
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} 
		
		
		//=================================================================================
		// ActionForward 객체의 포워딩 방식
		if(forward != null) {
			if(forward.isRedirect()) {	// true일 경우 -> Redirect 방식
				response.sendRedirect(forward.getPath());
			} else {					// false일 경우 -> Dispatch 방식
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		} else {
			System.out.println("ActionForward 값이 null입니다");
		}
	}	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
}