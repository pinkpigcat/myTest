package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.board.action.Action;
import member.account.action.OrderListAction;
import member.book.action.ExchangeFormAction;
import member.book.action.OrderCancelFormAction;
import member.book.action.OrderCancelProAction;
import member.book.action.OrderDeliveryAction;
import member.book.action.OrderDetailAction;
import member.book.action.OrderQListAction;
import member.book.action.OrderRefundFormAction;
import member.book.action.OrderRefundFormActionPro;
import member.book.svc.ExchangeProAction;
import vo.ActionForward;

@WebServlet("*.mb")
public class MemberBookController extends HttpServlet {
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
		
		//��ǰ��ȸ �����ȸ 
		
		request.setCharacterEncoding("utf-8");
		
		String command = request.getServletPath();
		System.out.println(command);
		
		
		Action action = null;
	ActionForward forward = null;
	
	if (command.equals("/OrderList.mb")) {//상품구매리스트
		action = new OrderListAction();
		
		try {
			forward=action.execute(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}else if(command.equals("/OrderDetail.mb")) {//
		action = new OrderDetailAction();
		try {
			forward=action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else if(command.equals("/OrderDelivery.mb")) {// 배송조회
		action = new OrderDeliveryAction();
		try {
			forward=action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else if(command.equals("/OrderCancel.mb")) {// 주문취소
		action = new OrderCancelFormAction();
		try {
			forward=action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else if(command.equals("/OrderCancelPro.mb")) {// 주문취소 누름
		action = new OrderCancelProAction();
		try {
			forward=action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else if(command.equals("/OrderExchange.mb")) {// 주문교환신청
		action = new ExchangeFormAction();
		try {
			forward=action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else if(command.equals("/OrderExchangePro.mb")) {// 주문교환신청 누름
		action = new ExchangeProAction();
		try {
			forward=action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else if(command.equals("/OrderQList.mb")) {
		action = new OrderQListAction();
		try {
			forward=action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else if(command.equals("/OrderRefund.mb")) {
		action = new OrderRefundFormAction();
		try {
			forward=action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else if(command.equals("/OrderRefundPro.mb")) {
		action = new OrderRefundFormActionPro();
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
			System.out.println("ActionFoward 객체 널 값");
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
