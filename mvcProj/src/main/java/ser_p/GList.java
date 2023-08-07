package ser_p;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import control.GalleryService;
import model_p.BoardDAO;
import model_p.GalleryDAO;
import model_p.GalleryDTO;

public class GList implements GalleryService{
	
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		request.setAttribute("mainTitle","갤러리 목록");
		//request.setAttribute("mainData",new GalleryDAO().list());
		
        List<GalleryDTO> galleryList = new GalleryDAO().list();	
		request.setAttribute("mainData", galleryList);
		System.out.println(galleryList + "어 왔니?");

	}
}
