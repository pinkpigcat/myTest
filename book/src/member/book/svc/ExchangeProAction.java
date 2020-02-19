package member.book.svc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.board.action.Action;
import vo.ActionForward;

public class ExchangeProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("ExchangeProAction");
		
		ExchangeProService ExchangeProService = new ExchangeProService();
		
		
		
		
		forward = new ActionForward(); 
		forward.setPath("OrderList.mb");
		forward.setRedirect(true);
		
		return forward;
	}

}
