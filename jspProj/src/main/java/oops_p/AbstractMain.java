package oops_p;

// 선언과 정의가 동시에 이루어 짐
abstract class AbsPar{
	int a = 10, b = 20;
	
	// 선언
	void meth_1() {
		// 정의
		System.out.println("부모 meth_1()");
	}
	
	// abstract는 선언만 존재, 정의 없음
	// 다른 package에서는 사용 불가능 함, class와 파일명이 동일해야 하는데 그렇지 못함 ==> 사용 불가
	// interface는 정의된 메소드가 없으므로 주체가 없음
	abstract void meth_2();

}

class AbsChild extends AbsPar{
	int c = 3000;
	
	void meth_3() {
		System.out.println("자식 meth_3()");
	}
	
	// 부모가 abstract 한 것은 자식이 반드시 오버라이드(재정의) 해주어야 함 
	void meth_2() {
		System.out.println("자식 meth_2()");
	}
}

// 실행
public class AbstractMain {

	public static void main(String[] args) {
		
		AbsChild cc = new AbsChild();
		cc.meth_1();
		cc.meth_2(); // 값 없음 ==> 강제성 부여해야 함
		cc.meth_3();
		
	}

}


