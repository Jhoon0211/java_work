package oops_p;

import java.util.Arrays;

public class ExamMain {

	public static void main(String[] args) {
		
		// 이름, 국영수 점수 받아오기
		String [] names = {"현빈","원빈","투빈","장희빈","미스터빈"};
		
		String [] kor = "75,55,95,65,85".split(",");
		String [] eng = "73,53,93,63,83".split(",");
		String [] mat = "78,58,98,68,88".split(",");
		
		
		// 시험 배열
		// 현재 배열은 비어있는 상태임 - 객체가 들어갈 칸과, 객체 자체는 다른 것임
		// 각 칸에 원소를 넣어야 함
		
		// 이름의 개수만큼 arr이라는 배열을 만든다 즉 5개 만든다는 뜻 임 
		Exam [] arr = new Exam[names.length];
		
		System.out.println(arr);	// 주소값
		System.out.println(arr.length);  // 칸의 개수
		System.out.println(arr[0]);  // 안에 원소가 없으므로 null

		Exam ex0 = new Exam(names[0], kor[0], eng[0], mat[0]);
		Exam ex1 = new Exam(names[1], kor[1], eng[1], mat[1]);
		
		System.out.println(ex0);
		
		// 인스턴스 주소를 원소로 하는 배열
		// 인스턴스 주소, 배열 변수 - 객체는 주소 참조
		Exam [] arr2 = {ex0,
						ex1,
						new Exam(names[2], kor[2], eng[2], mat[2]),
						new Exam(names[3], kor[3], eng[3], mat[3]),
						new Exam(names[4], kor[4], eng[4], mat[4])
						};
		
		System.out.println(Arrays.toString(arr2));
		
		System.out.println("=================================");
		
		
		// 입력부
		for(int i = 0; i < arr.length; i++) {
			// arr[i] = ex0;
			arr[i] = new Exam(names[i], kor[i], eng[i], mat[i]);
			
		}
		
		// rank를 받아라
		for (Exam exam : arr) {
            exam.rankCalc(arr);
        }
		
		// 결과 출력
        for (Exam exam : arr) {
            System.out.println(exam);
        }
        
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println(arr[3]);
		System.out.println(arr[4]);
		
	}
}