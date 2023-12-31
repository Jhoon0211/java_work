package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model_p.PageData;
import ser_p.BList;

@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println(request.getRequestURI());  			  // /mvcProj/board/BList
		//System.out.println(request.getContextPath() + "/board/"); // /mvcProj/board
		
		// 클라이언트가 요청한 URI와 웹 애플리케이션이 배치된 컨텍스트 경로를 확인
		String serviceStr = request.getRequestURI().substring(
				(request.getContextPath() + "/board/").length()
				);
		System.out.println(serviceStr);  // *
		
		
		// 다형성 걸기
		try {
			// 인코딩
			request.setCharacterEncoding("UTF-8");
			// serviceStr 넘기기
			request.setAttribute("mainPage", "board/" + serviceStr);
			request.setAttribute("pd", new PageData(request));
			
			
			BoardService service = (BoardService)Class.forName("ser_p." + serviceStr).newInstance();
			service.execute(request, response);  // BList.execute() 실행

			RequestDispatcher dispatcher =
					request.getRequestDispatcher("/views/template.jsp");
			
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}

}
