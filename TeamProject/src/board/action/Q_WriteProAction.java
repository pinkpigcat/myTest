package board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.Q_WriteProService;
import vo.ActionForward;

public class Q_WriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		
		// 작성자 답변 등록 method()
		Q_WriteProService q_WriteProService = new Q_WriteProService();
		q_WriteProService.writeArticle();
		
		forward = new ActionForward();
		// 1:1 답변 작성한거 상세보기
		forward.setPath("./board/Q_Detail.jsp");
		
		return forward;
	}

}
