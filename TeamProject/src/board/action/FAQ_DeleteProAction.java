package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.FAQ_DeleteProService;
import board.svc.Q_DeleteProService;
import vo.ActionForward;

public class FAQ_DeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		FAQ_DeleteProService faq_DeleteProService = new FAQ_DeleteProService();
		faq_DeleteProService.deleteArticle();
		
		forward = new ActionForward();
		forward.setPath("FAQ_List.bo");
		forward.setRedirect(true);
		return forward;
	}

}
