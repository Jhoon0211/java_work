package oops_p;

class Par{
	int a = 10;
	int b = 20;
	
	void meth_1() {
		System.out.println("부모 meth_1() : " + a + "," + b);
	}
	
	void meth_2() {
		System.out.println("부모 meth_2() : " + a + "," + b);
	}
}

// Par의 요소를 담고있으므로 부모로 사용 가능
class Child1 extends Par{
	int a = 1000;	// hiding : 멤버변수
	int c = 3000;
	
	void meth_1() {	// overriding
		System.out.println("자식1 meth_1() : " + a + "," + b +  "," + c);
	}
	
	void meth_3() {
		System.out.println("자식1 meth_3()");
	}
}

class Child2 extends Par{
	int d = 1234;
	
	void meth_4() {
		System.out.println("자식2 meth_4()");
	}
	
}

class Uncle{
	
}

public class DynamicMain {

	public static void main(String[] args) {
		Par pp = new Par();
		Child1 cc1 = new Child1();
		Child2 cc2 = new Child2();
		
		System.out.println("pp : " + pp.a + "," + pp.b);
		// System.out.println("pp : " + pp.a + "," + pp.b + "," + pp.c); 부모는 자식의 변수를 가져올 수 없음
		pp.meth_1(); // 자신 메서드
		pp.meth_2(); // 자신 메서드
		// pp.meth_3(); 부모는 자식 메서드 불러올 수 없음 
		// pp.meth_4(); 부모는 자식 메서드 불러올 수 없음 
		
		System.out.println("cc1 : " + cc1.a + "," + cc1.b + "," + cc1.c);
		cc1.meth_1(); // 부모 메서드 가져올 수 있음
		cc1.meth_2(); // 부모 메서드 가져올 수 있음
		cc1.meth_3(); // 부모 메서드 가져올 수 있음
		// cc1.meth_4(); 형제메서드 가져올 수 없음
		
		System.out.println("cc2 : " + cc2.a + "," + cc2.b + "," + cc2.d);
		cc2.meth_1(); // 부모 메서드 가져올 수 있음
		cc2.meth_2(); // 부모 메서드 가져올 수 있음
		//cc2.meth_3(); 형제메서드 가져올 수 없음
		cc2.meth_4(); // 자신 메서드

		System.out.println("=========================");
		
		Par dpp = new Par();
		Par dpc = new Child1();
		// Child1 dcp = new Par(); 자식이 부모를 받아올 수 없음 ==> 애초에 자식이 더 커서 (부모로부터 받아오는 멤버변수 + 자신의 멤버변수)
		Child1 dcc = new Child1();
		
		System.out.println("dpp : " + dpp.a + "," + dpp.b);
		dpp.meth_1(); 
		dpp.meth_2(); 
		// dpp.meth_3(); 
		
		System.out.println("dpc : " + dpc.a + "," + dpc.b);
		// System.out.println("dpc : " + dpc.a + "," + dpc.b + "," + dpc.c); dpc.c 못 받아옴 안보여서
		dpc.meth_1(); 
		dpc.meth_2(); 
		// dpc.meth_3();
		
		System.out.println("dcc : " + dcc.a + "," + dcc.b + "," + dcc.c); 

		dcc.a = 1111;
		dcc.b = 2222;
		dcc.c = 3333;
		
		System.out.println("dcc : " + dcc.a + "," + dcc.b + "," + dcc.c); 
		dcc.meth_1(); 
		dcc.meth_2(); 
		dcc.meth_3();

		
		Par dpcc = dcc;
		System.out.println("dpcc : " + dpcc.a + "," + dpcc.b); 
		// System.out.println("dpcc : " + dpcc.a + "," + dpcc.b + "," + dpcc.c); 
		dpcc.meth_1(); 
		dpcc.meth_2(); 
		//dpcc.meth_3();

		// Child1 dcpcc = dpcc; 부모값은 다시 자식 받아올 수 없음 ↙
		/* 형변환 */
		Child1 dcpcc = (Child1)dpcc; // 형변환 하면 받아올 수 있음
		System.out.println("dcpcc : " + dcpcc.a + "," + dcpcc.b + "," + dcpcc.c); 
		dcpcc.meth_1(); 
		dcpcc.meth_2(); 
		dcpcc.meth_3();
		
		// Child1 cpp = (Child1)pp; 에러 남
		
		System.out.println(pp instanceof Par); // true
		System.out.println(pp instanceof Child1); // false
		System.out.println(cc1 instanceof Par); // true
		System.out.println(cc1 instanceof Child1); // true

		// System.out.println(cc1 instanceof Uncle); instanceof : 현재 만들어진 인스턴스가 상속관계에서만 유효
		

		
		// overriding : 재정의
		// 부모(super)의 멤버변수 그대로 받아옴 == > hiding
		
		
		
	}

}
