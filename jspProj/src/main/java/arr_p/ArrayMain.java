package arr_p;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayMain {
	
	public static void main(String[] args) {
		int a = 10;
		
		int [] arr1 = {11,22,33}; // 배열 생성 및 초기화 후 주소 대입
		
		System.out.println("a : " + a);
		System.out.println("arr1 : " + arr1+"=>"+arr1.length); // [I@515f550a
		// [ : 배열의 차원
		// I : int
		// @ : 구분
		// 515f550a : hash 코드 16진수로 표현
		
		a = 23;
		// arr1 = {55,66,77}; 주소를 받기때문에 불가능
		// new int [] 는 최초 배열변수 선언 시에만 가능
		
		arr1 = new int [] {55,66,77,88,99};
		System.out.println("a : " + a);
		System.out.println("arr1 : " + arr1 +"=>"+ arr1.length);
		
		int [] arr2 = new int[4];
		System.out.println("a : " + a);
		System.out.println("arr2 : " + arr2 +"=>"+ arr2.length);
		
		int [] arr3 = arr1;	// 얕은 복사 (shallow copy) : 주소만 복사
		
		// arr4 - 깊은 복사 (deep copy) : 공간 새로 생성
		int [] arr4 = new int[arr1.length];
		for (int i = 0; i < arr4.length; i++) {
			arr4[i] = arr1[i];
		}
		
		int [] arr5 = arr1.clone(); // deep copy
		
		
		System.out.println("arr3 : " + arr3 +"=>"+ arr3.length);
		System.out.println("arr4 : " + arr4 +"=>"+ arr4.length);
		System.out.println("arr5 : " + arr5 +"=>"+ arr5.length);
		
		System.out.println("arr1 : " + Arrays.toString(arr1));
		System.out.println("arr3 : " + Arrays.toString(arr3));
		System.out.println("arr4 : " + Arrays.toString(arr4));
		System.out.println("arr5 : " + Arrays.toString(arr5));
		
		int b = a;
		System.out.println("a : " + a + ", b" + b);
		a=77;
		arr1[1] = 6543;
		
		System.out.println("a : " + a + ", b" + b);
		System.out.println("arr1[1] : "+ arr1[1]);
		System.out.println("arr3[1] : "+ arr3[1]);
		
		System.out.println("arr1 : " + Arrays.toString(arr1));
		System.out.println("arr3 : " + Arrays.toString(arr3));
		System.out.println("arr4 : " + Arrays.toString(arr4));
		System.out.println("arr5 : " + Arrays.toString(arr5));

		// 점수 : 87,65,82,46,98,65,72,34,91,79,45,67
		// 점수에 대응하는 수우미양가 등급 배열을 구하시오
		
		int [] number = {87,65,82,46,98,65,72,34,91,79,45,67}; //
		String [] grade = new String[12];
		
		
		for (int i = 0; i < number.length; i++) {
			if(90 < number[i]  &&  number[i] < 100) {
				grade[i] = "수";
			}else if(80 < number[i]  &&  number[i] < 90) {
				grade[i] = "우";		
			}else if(70 < number[i]  &&  number[i] < 80) {
				grade[i] = "미";		
			}else if(60 < number[i]  &&  number[i] < 70) {
				grade[i] = "양";
			}else if(0 < number[i]  &&  number[i] < 60) {
				grade[i] = "가";			
			}	
		}System.out.println(Arrays.toString(grade));
	}
}
