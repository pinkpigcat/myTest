package member.book.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.board.action.Action;
import vo.ActionForward;

public class QdetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		
		ActionForward forward = null;
		System.out.println("QdetailAction");
		
		
		
		
		
		forward = new ActionForward();
		forward.setPath("/member/Qdetail.jsp");
		return forward;
	}

}
