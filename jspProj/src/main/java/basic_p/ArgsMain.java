package basic_p;


public class ArgsMain {
	
	public static void main(String[] args) {
		System.out.println("내가 argsMain 이다. : " + args.length);
		
		// System.out.println(Arrays.toString(args));		
		int sum = 0; // sum 변수 초기화, sum = 숫자 중 짝수들의 합으로 설정

		
		// 합계
		for (String str : args) {		// arg를 str에 담는다
			int intValue = Integer.parseInt(str); // args 숫자로 변환
			if(intValue % 2 == 0) { // 입력받은 intValue 값이 만약 짝수이면
				sum += intValue; 
			}
			System.out.println("합계 : " + sum);

		}
		
		System.out.println("==========평균=========");
		
		// 평균
		int sum1 = 0; // sum 변수 초기화, sum = 숫자 중 짝수들의 합으로 설정
		int avg = 0; // 짝수들의 평균 값
		int count = 0; // 개수
		
		for (String str : args) { 
			int intValue = Integer.parseInt(str);
			if(intValue % 2 == 0) {  // args 값이 짝수면
 
				sum1 += intValue;
				count++;
				
			} 
		}
		avg = sum1 / count;
		System.out.println("평균 : " + avg);
	}

}
