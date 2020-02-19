package board.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.svc.Q_ListService;
import vo.ActionForward;

public class Q_ListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
//		System.out.println("1:1 문의 내역 보기");
		
		Q_ListService q_ListService = new Q_ListService();
		ArrayList list = q_ListService.getList();
		
		forward = new ActionForward();
		forward.setPath("./board/Q_List.jsp");
		
		return forward;
	}

}
