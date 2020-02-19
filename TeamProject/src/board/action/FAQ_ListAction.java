package board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.FAQ_ListService;
import board.svc.Q_ListService;
import vo.ActionForward;

public class FAQ_ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
//		System.out.println("FAQ 문의 내역 보기");
		
		FAQ_ListService faq_ListService = new FAQ_ListService();
		ArrayList list = faq_ListService.getList();
		
		forward = new ActionForward();
		forward.setPath("./board/FAQ_List.jsp");
		
		return forward;
	}

}
