package ser_p;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.BoardService;
import model_p.BoardDAO;
import model_p.BoardDTO;

// BoardService에서 생성 BList에서 execute() 실행
public class BWriteForm implements BoardService{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		// 게시판 목록
		request.setAttribute("mainTitle", "게시판 목록");
		System.out.println("BList.execute() 실행");
		
	
	}
}
