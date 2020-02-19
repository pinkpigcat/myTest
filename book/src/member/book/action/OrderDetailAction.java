package member.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.board.action.Action;
import member.book.svc.OrderDetailService;
import vo.ActionForward;

public class OrderDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("OrderDetailAction");
		
		
		OrderDetailService OrderDetailService = new OrderDetailService();
		

		forward = new ActionForward();
		forward.setPath("/member/OrderDetail.jsp");
		return forward;
	}

}
