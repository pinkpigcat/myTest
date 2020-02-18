package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.Q_DetailService;
import vo.ActionForward;

public class Q_WriteFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
//		System.out.println("Q_WriteFormAction");
		// 사용자가 1:1 작성한 것을 불러옴
		Q_DetailService q_DetailService = new Q_DetailService();
		q_DetailService.getArticle();
		
		forward = new ActionForward();
		forward.setPath("./board/Q_WriteForm.jsp");
		return forward;
	}

}
