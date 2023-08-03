package control;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// interface는 선언만 담당, 일하는 주체가 없음
// field는 상수만 들어감 (final ==> 대입불가)
public interface BoardService {	
	
//	void meth_1() {
//		System.out.println("부모 meth_1()");
//	}
	
	void execute(HttpServletRequest request, HttpServletResponse response);
}
