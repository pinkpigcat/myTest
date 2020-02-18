package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.FAQ_WriteProService;
import vo.ActionForward;

public class FAQ_WriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		FAQ_WriteProService faq_WriteProService = new FAQ_WriteProService();
		faq_WriteProService.writeArtice();
		
		forward = new ActionForward();
		// FAQ 작성한거 상세보기
		forward.setPath("./board/FAQ_Detail.jsp");
		
		return forward;
	}

}
