package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import admin.board.action.Action;
import board.svc.QWriteFormProService;
import vo.ActionForward;

public class QWriteFormProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("BoardQWriteFormProAction");
		
		
		QWriteFormProService boardQWriteFormProService = new QWriteFormProService();
		
		forward = new ActionForward();
		forward.setPath("/member/QList.jsp");
		return forward;
	}

}
