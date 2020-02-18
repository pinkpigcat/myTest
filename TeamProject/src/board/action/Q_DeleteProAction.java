package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.Q_DeleteProService;
import vo.ActionForward;

public class Q_DeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		Q_DeleteProService q_DeleteProService = new Q_DeleteProService();
		q_DeleteProService.deleteArticle();
		
		forward = new ActionForward();
		forward.setPath("Q_List.bo");
		forward.setRedirect(true);
		return forward;
	}

}
