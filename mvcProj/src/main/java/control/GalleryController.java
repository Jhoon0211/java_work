package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/gallery/*")
public class GalleryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GalleryController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String serviceStr = request.getRequestURI().substring(
				(request.getContextPath() + "/gallery/").length()
				);
		System.out.println(serviceStr);
		
		// 다형성 걸기
		try {
			// 인코딩
			request.setCharacterEncoding("UTF-8");
			// serviceStr 넘기기
			request.setAttribute("mainPage", "gallery/" + serviceStr);
			
			GalleryService service = (GalleryService)Class.forName("ser_p." + serviceStr).newInstance();
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
