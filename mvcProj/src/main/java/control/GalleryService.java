package control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface GalleryService {
	
	void execute(HttpServletRequest request, HttpServletResponse response);
}
