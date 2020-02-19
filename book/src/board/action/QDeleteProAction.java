package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.board.action.Action;
import board.svc.QDeleteProService;
import vo.ActionForward;

public class QDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("BoardQDeleteAction");
	
		
		
		QDeleteProService boardQDeleteService = new QDeleteProService();
		
		
		forward = new ActionForward();
		forward.setPath("/member/QList.jsp");
		return forward;
	}

}
