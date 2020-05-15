package member.book.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import admin.book.svc.ListService;
import member.book.svc.BookListService;
import vo.ActionForward;
import vo.BookBean;
import vo.PageInfo;

public class BookListAcion implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		
		int page = 1;
		int limit = 6;
		int bk2 = 0;
		int bkID = 0;
		int listCount = 0;
		ArrayList<BookBean> bookList = null;
		
		BookListService bookListService = new BookListService();
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page")); //정수로 변환하여 저장
		}
		
		// 단계별 
		System.out.println(page);
		if(request.getParameter("bk2") != null) {
			bk2 = Integer.parseInt(request.getParameter("bk2"));
			bookList = bookListService.userbk2BookList(page, limit, bk2);
			listCount = bookListService.userbk2ListCount(bk2);
		} 
		System.out.println(bk2);
	
		
		// 과목별
		if(request.getParameter("BKID") != null) {
			bkID = Integer.parseInt(request.getParameter("BKID"));
			bookList = bookListService.userbkIDBookList(page, limit, bkID);
			listCount = bookListService.userbkIDListCount(bkID);
		}
		System.out.println(bkID);
			
		//svc에 만들기
		
		
		
		// 책 목록 가져오기
		
		// 책 전체 개수
		
		
		// 1. 총 페이지 수 계산
		int maxPage = listCount / limit + (listCount % limit == 0 ? 0 : 1);
		// 페이징 사이즈(한 화면 페이지 번호 개수)
		int pageBlock = 6;
		// 2. 시작 페이지 번호
		int startPage = ((page - 1) / pageBlock) * pageBlock + 1;
		// 3. 마지막 페이지 번호
		int endPage = startPage + pageBlock - 1;
		
		// 마지막 페이지 번호가 총 페이지 수보다 클 경우
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageInfo pageInfo = new PageInfo(page, maxPage, startPage, endPage, pageBlock, listCount);
		
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("bookList", bookList);

//		System.out.println("총 게시물 수 : " + listCount);
//		ArrayList<BoardBean> articleList = new ArrayList<BoardBean>(); //null값줘도됨 어짜피 만들어서 리턴할거라서
//		ArrayList<BoardBean> articleList = boardListService.articleList(page,limit);
		
//		int maxPage = (int)((double)listCount / limit + 0.95);
//		int startPage = (((int)((double)page / 10 + 0.9)) - 1) + 1;
//		int endPage = startPage + 10 - 1;
//		if(endPage > maxPage) {
//			endPage = maxPage;
//		}
		
		
//		PageInfo pageInfo = new PageInfo(page, maxPage, startPage, endPage, listCount);
//		request.setAttribute("pageInfo", pageInfo);
//		request.setAttribute("articleList", articleList);
		
		forward = new ActionForward();
		forward.setPath("/book/book_list.jsp");
		//재사용
		
		return forward;

	}

}
