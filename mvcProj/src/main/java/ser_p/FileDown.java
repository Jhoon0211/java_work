package ser_p;

import java.io.FileInputStream;
import java.net.URLEncoder;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.BoardService;

public class FileDown implements BoardService{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// URI에 파일 이름 추가 (fName)
		// http://localhost:8080/mvcProj/noneJsp/FileDown?fName= [day1.txt]
		String fName = request.getParameter("fName");
		//System.out.println("FileDown.execute() 실행");	
		
		String path = request.getRealPath("up");
		// 실제 경로
		path = "C:\\green_project\\java_work\\mvcProj\\src\\main\\webapp\\up";
		
		// 파일을 받아서 내려보낼 처리 완료
		try {
			FileInputStream fis = new FileInputStream(path+"\\"+fName);
			String encFName = URLEncoder.encode(fName, "utf-8");
			System.out.println(fName+"->"+encFName);
			response.setHeader("Content-Disposition", "attachment;filename="+encFName);
			
			// 내용 가져오기
			ServletOutputStream sos = response.getOutputStream();
			
			// 내용 쓰기 - 가장 좁은 길을 기준으로
			byte [] buf = new byte[1024];
			
			
			// int cnt = 0;
			while(fis.available()>0) { // 보낼 것이 남아있다면
				// buf에 남은 개수가 출력(읽어서 buf에 넣음)ㄴ
				// len : 넣은 byte 길이
				int len = fis.read(buf);
				
				sos.write(buf, 0, len); // 보낸다 : buf의 0부터 len 만큼
				
				// 어떻게 넘겨 받았는지 확인
				// cnt++;
				// System.out.println(cnt+":"+len);
				/*
					1:1024
					2:1024
					3:1024
					4:1024
					5:14
				*/
			}
			
			// 닫는 것이 중요
			sos.close();
			fis.close();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		System.out.println(path);
		// 이클립스의 가상 서버 주소 : 배포 시에는 실제로 쓰이나, 배포 전에는 실제 경로를 사용 해주어야 함
	}
}
