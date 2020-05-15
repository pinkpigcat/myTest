package member.account.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import member.account.svc.ModifyFormService;
import member.account.svc.ModifyProService;
import vo.ActionForward;
import vo.MemberBean;

public class ModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		System.out.println("ModifyProAction");
		
		ModifyProService modifyProAction =new ModifyProService();
		
		String uID=request.getParameter("uID");
		String pw=request.getParameter("pw");
		String u_name=request.getParameter("u_name");
		String address=request.getParameter("address");
		String phone_num=request.getParameter("phone_num");
		String email=request.getParameter("email");
		String tell_num=request.getParameter("tell_num");
		String address2=request.getParameter("address2");
		
		
		MemberBean memberBean = new MemberBean(uID, pw, u_name, address, phone_num, email, tell_num, address2);
		
	    int modifySuccess=modifyProAction.memberInfoModify(memberBean);
		
		if (modifySuccess>0) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>"); 
			out.println("alert('회원정보 수정 완료')");
			out.println("</script>"); 
			forward = new ActionForward();
			forward.setPath("index.jsp");
			forward.setRedirect(true);
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>"); 
			out.println("alert('회원정보 수정 실패')");
			out.println("history.back()");
			out.println("</script>"); 
		}
		
		return forward;
		
	}

}
