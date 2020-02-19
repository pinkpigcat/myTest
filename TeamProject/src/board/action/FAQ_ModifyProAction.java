package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.FAQ_ModifyProService;
import board.svc.Q_ModifyProService;
import vo.ActionForward;

public class FAQ_ModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		FAQ_ModifyProService faq_ModifyProService = new FAQ_ModifyProService();
		faq_ModifyProService.modifyArticle();
		
		forward = new ActionForward();
		forward.setPath("./board/FAQ_Detail.jsp");
		
		return forward;
	}

}
