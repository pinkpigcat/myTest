package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.board.action.Action;
import board.action.QDeleteProAction;
import board.action.QModifyFormAction;
import board.action.QModifyProAction;
import board.action.QWriteFormProAction;
import member.book.action.QWriteListAction;
import member.book.action.QdetailAction;
import vo.ActionForward;

@WebServlet("*.bo")
public class BoardController extends HttpServlet {
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		
		
		request.setCharacterEncoding("utf-8");
		
		String command = request.getServletPath();
		System.out.println(command);
		
		
		Action action = null;
	ActionForward forward = null;
	
	if (command.equals("/QWriteForm.bo")) {//
		forward = new ActionForward();
		forward.setPath("/QWriteForm.jsp");
	}else if(command.equals("/WriteFormPro.bo")) {//
		action = new QWriteFormProAction();
		try {
			forward=action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else if(command.equals("/QModify.bo")) {//1:1문의 수정폼
		
		action = new QModifyFormAction();
		try {
			forward=action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else if(command.equals("/QModifyPro.bo")) {//1:1문의 수정
		
		action = new QModifyProAction();
		try {
			forward=action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else if(command.equals("/QDeletePro.bo")) {//1:1문의 삭제
		
		action = new QDeleteProAction();
		try {
			forward=action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else if(command.equals("/QWriteList.bo")) {//1:1 문의내역보기
		
		action = new QWriteListAction();
		try {
			forward=action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else if(command.equals("/Qdetail.bo")) {//1:1 문의내역보기
		
		action = new QdetailAction();
		try {
			forward=action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		
		
		
		
		
		
		if (forward!=null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
			
		}else {
			System.out.println("ActionFoward�� null �̴�");
		}
	}
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	
	
	
}
