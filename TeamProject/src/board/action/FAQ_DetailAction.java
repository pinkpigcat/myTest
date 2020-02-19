package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.FAQ_DetailService;
import board.svc.Q_DetailService;
import vo.ActionForward;

public class FAQ_DetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		// FAQ 작성한 것을 불러옴
		FAQ_DetailService faq_DetailService = new FAQ_DetailService();
		faq_DetailService.getArticle();
		
		forward = new ActionForward();
		forward.setPath("./board/FAQ_Detail.jsp");
		return forward;
	}

}
