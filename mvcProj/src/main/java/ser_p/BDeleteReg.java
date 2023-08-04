package ser_p;

import java.io.File;
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

public class BDeleteReg implements BoardService{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		
		String path = request.getRealPath("up");
		// 실제 경로
		path = "C:\\green_project\\java_work\\mvcProj\\src\\main\\webapp\\up";
		
		BoardDTO dto = new BoardDTO();
		dto.setId(Integer.parseInt(request.getParameter("id")));
		dto.setPw(request.getParameter("pw"));
				
		// 실패 시
		String msg = "비밀번호가 일치하지 않습니다.";
		String goUrl = "BDeleteForm?id="+dto.getId();
		
		// ID / PW / 파일 정보 가져오기
		BoardDTO delDto = new BoardDAO().idPwChk(dto);
		
		// 성공 시
		if(delDto!=null) {
			
			// 파일이 존재 한다면
			if(!delDto.getUpfile().equals("")) {
				new File(path+"\\"+delDto.getUpfile()).delete(); 
			}
			new BoardDAO().delete(dto);
			msg = "삭제되었습니다.";
			goUrl = "BList";
		}

		request.setAttribute("mainPage", "alert");
		request.setAttribute("msg", msg);
		request.setAttribute("goUrl", goUrl);

	}		
	
}