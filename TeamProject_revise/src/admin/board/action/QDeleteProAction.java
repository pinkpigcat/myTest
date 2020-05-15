package admin.board.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import action.Action;
import admin.board.svc.BoardService;
import vo.ActionForward;
import static access.Access.*;
public class QDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		HttpSession session = request.getSession();
		// 관리자 체크
		if(!isAdmin(session)) {
			forward = deniedAccess(session);
			return forward;
		}
		BoardService boardService = new BoardService();
		int boardNum = Integer.parseInt(request.getParameter("boardNum"));
		String boardReRef = request.getParameter("boardReRef");
		String k1 ="1:1문의";
		
		int deleteCount = boardService.deleteArticle(boardNum, k1);
		
		forward = new ActionForward();
		if(deleteCount != 0) {
			// 글 삭제 성공 시 반응 디테일로 돌아감
			forward.setPath("./QDetail.adb?boardNum=" + boardReRef);
			forward.setRedirect(true);
		} else {
			// 글 삭제 실패 시 반응
			session.setAttribute("ErrorMSG", "답변 삭제에 실패하였습니다.");
			forward.setPath("failed.adb");
			forward.setRedirect(true);
		}
		
		return forward;
	}

}
