package member.account.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.account.svc.MiddleBookService;
import vo.ActionForward;
import vo.BookBean;

public class MainAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		MiddleBookService middleBookService = new MiddleBookService();  
		
		// main에서 배너 뿌려줌
		
		
		// main에서 새로운 책 들고옴 - 중앙 배너에 사용
		ArrayList<BookBean> bookList = middleBookService.getMiddleBookList();
		
		// 베스트 셀러 5개 들고오기
		ArrayList<BookBean> bestList = middleBookService.getBestBookList();
		
		request.setAttribute("bookList",bookList);
		request.setAttribute("bestList",bestList);
		forward = new ActionForward();
		forward.setPath("main.jsp");
		return forward;
	}

}
