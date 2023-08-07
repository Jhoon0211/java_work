package model_p;

import javax.servlet.http.HttpServletRequest;

// 1 2 3 4 5 처럼 데이터에 대한것은 여기서 처리
// 나머지 [이전], [다음]이 나타나고 안 나타고의 문제는 jsp에서 처리
public class PageData {

	public int limit = 3;
	public int pageLimit = 4;
	//int start = 0;
	public int page, start, pageStart, pageEnd, total, pageTotal;
	
	public PageData( HttpServletRequest request) {
		page = 1;
		
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
	}
	
	public void calc() {
		
		this.total = new BoardDAO().totalCnt();
		
		pageTotal = total/limit;
		
		// 만약 게시글이 13.6666.... 이렇게 떨어진다면(나머지가 있다면)
		// 페이징 처리 +1
		if(total%limit>0) {
			pageTotal++;
		}


		start = (page-1)*limit;
		pageStart = (page-1)/pageLimit*pageLimit+1;
		pageEnd = pageStart + pageLimit -1;
		
		// 끝 페이지 처리 (계속 증가 안하게)
		// 만약 페이지 끝이 전체 페이지보다 크다면 페이지 끝 = 전체 페이지
		if(pageEnd > pageTotal) {
			pageEnd = pageTotal;
		}
	}
	
	
	
	
	
}
