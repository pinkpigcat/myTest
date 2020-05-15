package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import board.action.FAQ_DeleteProAction;
import board.action.FAQ_DetailAction;
import board.action.FAQ_ListAction;
import board.action.FAQ_ModifyFormAction;
import board.action.FAQ_ModifyProAction;
import board.action.FAQ_WriteProAction;
import board.action.Q_DeleteProAction;
import board.action.Q_DetailAction;
import board.action.Q_ListAction;
import board.action.Q_ModifyFormAction;
import board.action.Q_ModifyProAction;
import board.action.Q_WriteFormAction;
import board.action.Q_WriteProAction;
import vo.ActionForward;


@WebServlet("*.bo")
public class BoardController extends HttpServlet{
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String command = request.getServletPath();
		System.out.println("command : " + command);
		
		Action action = null;
		ActionForward forward = null;
		
		// 서블릿 주소에 따라 각각 다른 작업을 수행
		if(command.equals("/Q_List.bo")) {	// ------------------- 1:1 목록
			// --- 1:1 목록 Q_ListAction()
			action = new Q_ListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/Q_WriteForm.bo")) {
			// --- 1:1 답변 작성 폼 (사용자가 작성한 내용을 불러와야 함)
			action = new Q_WriteFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/Q_WritePro.bo")) {
			// --- 1:1 작성 작업 Q_WriteProAction()
			action = new Q_WriteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/Q_Detail.bo")) {
			// --- 1:1 답변 상세보기
			action = new Q_DetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/Q_ModifyForm.bo")) {
			// --- 1:1 답변 수정 폼 (사용자가 작성한 내용 & 관리자가 작성한 내용 불러옴)
			action = new Q_ModifyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/Q_ModifyPro.bo")) {
			// --- 1:1 답변 수정 작업 
			action = new Q_ModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/Q_DeleteForm.bo")) {
			// --- 1:1 답변 삭제 폼
			forward = new ActionForward();
			forward.setPath("./board/Q_DeleteForm.jsp");
		} else if(command.equals("/Q_DeletePro.bo")) {
			// --- 1:1 답변 삭제 작업 
			action = new Q_DeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/FAQ_List.bo")) {	// -------------------  FAQ 목록
			// --- FAQ 목록 FAQ_ListAction()
			action = new FAQ_ListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/FAQ_WriteForm.bo")) {
			// --- FAQ 작성 폼 
			forward = new ActionForward();
			forward.setPath("./board/FAQ_WriteForm.jsp");
		} else if(command.equals("/FAQ_WritePro.bo")) {
			// --- FAQ 작성 작업 FAQ_WriteProAction()
			action = new FAQ_WriteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/FAQ_Detail.bo")) {
			// --- FAQ 상세보기
			action = new FAQ_DetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/FAQ_ModifyForm.bo")) {
			// --- FAQ 수정 폼 (사용자가 작성한 내용 & 관리자가 작성한 내용 불러옴)
			action = new FAQ_ModifyFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/FAQ_ModifyPro.bo")) {
			// --- FAQ 수정 작업 
			action = new FAQ_ModifyProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/FAQ_DeleteForm.bo")) {
			// --- FAQ 삭제 폼
			forward = new ActionForward();
			forward.setPath("./board/FAQ_DeleteForm.jsp");
		} else if(command.equals("/FAQ_DeletePro.bo")) {
			// --- FAQ 삭제 작업 
			action = new FAQ_DeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		//=================================================================================
		// ActionForward 객체의 포워딩 방식
		if(forward != null) {
			if(forward.isRedirect()) {	// true일 경우 -> Redirect 방식
				// redirect 는 페이지 이동시 
				// 서블릿 주소 -> 서블릿 주소
				// - 주소가 새롭게 변하는 경우 사용 ( 예) writepro -> list로 페이지 넘어가야하는 경우)
				// - 전 페이지의 request 객체를 전달할 필요가 없을 경우
				response.sendRedirect(forward.getPath());
			} else {					// false일 경우 -> Dispatch 방식
				// 서블릿 주소 -> VIEW페이지 (jsp)
				// dispatch 는 페이지 이동시 
				// - 주소가 똑같이 유지되는 사용
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		} else {
			System.out.println("ActionForward 값이 null입니다");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	
}
