package oops_p;

import java.util.Arrays;

public class Exam {
	
	// 멤버변수
	String name, grade; // 이름, 등급
	int [] jum; // 점수
	int tot, avg, rank; // 총합, 평균, 순위
	
	// 시험 메서드
	public Exam(String name, String ... jum) {
		super();
		this.name = name; // 이름 받고
		this.jum = new int [jum.length]; // 점수는 배열 만들어서 받고
		
		
		for (int i=0; i <jum.length; i++) {
			this.jum[i] = Integer.parseInt(jum[i]);  // 점수 한개씩 정수로 받기
		}
		calc(); // calc메서드 실행
	}
	
	void calc() {
		tot = 0; // 총합 변수 초기화
		for(int i : jum) { // 점수를 i라는 변수에 넣는다
			tot += i;  // 
		}
		
		avg = tot/jum.length; // 평균 계산
		
		grade = "가가가가가가양미우수".charAt(avg/10)+"";  // 등급 계산
	}
	

	// 순위 메서드 (계산)
	void rankCalc(Exam [] exArr) {
		rank = 1; // 순위 변수 초기화
		for(Exam you : exArr) {
			if(avg < you.avg) { // 평균 값이 상대 평균 값보다 낮으면
				rank++;  // 순위 값 증가
			}
		}
	}
	
	// 출력
	@Override
	public String toString() {
		return "Exam [name=" + name + ", grade=" + grade + ", jum=" + Arrays.toString(jum) + ", tot=" + tot + ", avg="
				+ avg + ", rank=" + rank + "]";
	}
	
	
}





