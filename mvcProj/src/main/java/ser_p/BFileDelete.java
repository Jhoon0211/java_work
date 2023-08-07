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
import model_p.PageData;

public class BFileDelete implements BoardService{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		
		String path = request.getRealPath("up");
		// 실제 경로
		path = "C:\\green_project\\java_work\\mvcProj\\src\\main\\webapp\\up";
		PageData pd = (PageData)request.getAttribute("pd");

		
		try {
			MultipartRequest mr = new MultipartRequest(
					request,
					path,
					10*10*1024, // 10mb
					"utf-8",
					new DefaultFileRenamePolicy() // 이름 중복되면 이름 뒤에 번호 붙여서 처리
				); // 생성 시 업로드 완료 
			
			// 아이디와 패스워드만 가져옴
			// Delete
			BoardDTO dto = new BoardDTO();
			dto.setId(Integer.parseInt(mr.getParameter("id")));
			dto.setTitle(mr.getParameter("title"));
			dto.setPname(mr.getParameter("pname"));
			dto.setPw(mr.getParameter("pw"));
			dto.setContent(mr.getParameter("content"));
			dto.setUpfile(mr.getFilesystemName("upfile"));
			
			String msg = "비밀번호가 일치하지 않습니다.";
			String goUrl = "BModifyForm?id="+dto.getId()+"&page=" + pd.page;
			
			System.out.println(dto);
			
			// ID / PW / 파일 정보 가져오기
			BoardDTO delDto = new BoardDAO().idPwChk(dto);
			
			// 성공 시
			if(delDto!=null) {
		
				// 파일삭제
				new File(path+"\\"+delDto.getUpfile()).delete();
				new BoardDAO().fileDelete(dto); // db통째로 삭제되는 것임
						
				msg = "파일이 삭제되었습니다.";
				//goUrl = "BList";
			}
			
			
			request.setAttribute("mainPage", "alert");
			request.setAttribute("msg",msg);
			request.setAttribute("goUrl",goUrl);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println(path);
		// 이클립스의 가상 서버 주소 : 배포 시에는 실제로 쓰이나, 배포 전에는 실제 경로를 사용 해주어야 함
	}
}
