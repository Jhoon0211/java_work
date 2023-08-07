package ser_p;

import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import control.BoardService;
import model_p.BoardDAO;
import model_p.BoardDTO;
import model_p.PageData;

public class BWriteReg implements BoardService{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		
		String path = request.getRealPath("up");
		// 실제 경로
		path = "C:\\green_project\\java_work\\mvcProj\\src\\main\\webapp\\up";
		
		
		try {
			MultipartRequest mr = new MultipartRequest(
					request,
					path,
					10*10*1024, // 10mb
					"utf-8",
					new DefaultFileRenamePolicy() // 이름 중복되면 이름 뒤에 번호 붙여서 처리
				); 
			
			BoardDTO dto = new BoardDTO();
			dto.setTitle(mr.getParameter("title"));
			dto.setPname(mr.getParameter("pname"));
			dto.setPw(mr.getParameter("pw"));
			dto.setContent(mr.getParameter("content"));
			// 받은 파일의 실질적으로 저장된 파일의 명 != originalFileName
			dto.setUpfile(mr.getFilesystemName("upfile"));
			
			new BoardDAO().write(dto);
			
			//System.out.println("newId:" + dto.getId());
			PageData pd = (PageData)request.getAttribute("pd");

			
			request.setAttribute("mainPage", "alert");
			request.setAttribute("msg","입력되었습니다.");
			request.setAttribute("goUrl","BDetail?id="+dto.getId()+"&page=" + pd.page);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println(path);
		// 이클립스의 가상 서버 주소 : 배포 시에는 실제로 쓰이나, 배포 전에는 실제 경로를 사용 해주어야 함
	}
}
