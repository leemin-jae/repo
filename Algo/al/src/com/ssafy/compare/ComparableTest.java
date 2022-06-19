package com.ssafy.compare;

import java.util.Arrays;
import java.util.Comparator;

public class ComparableTest {
	private static class StudentComparator implements Comparator<Student>{

		@Override
		public int compare(Student o1, Student o2) {
			// TODO Auto-generated method stub
			return -1*(o1.no - o2.no);
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student[] student = new Student[] {
			new Student(1,10),
			new Student(5,52),
			new Student(2,100),
			new Student(4,52),
			new Student(3,80)
		};
		
		System.out.println("=========정렬 전 ==========");
		System.out.println(Arrays.toString(student));
		
		//comparable : 자기 자신과 타원소 비교
		//comparable이 없으면 에러 발생
		//comparable implements 및 compareTo() 재정의 필수
		// return에 ㄸㅏ라서 정렬 수행
		Arrays.sort(student);
		
		System.out.println("=========Comparable 객체에 구현 완료, 오름차순 ==========");
		System.out.println(Arrays.toString(student));
		
		
		System.out.println("=========Comparator 사용, 내림차순 ==========");
		Arrays.sort(student, new StudentComparator());
		System.out.println(Arrays.toString(student));
		
		
		System.out.println("=========Comparator 일회성, 점수 내림차순 ==========");
		Arrays.sort(student, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// TODO Auto-generated method stub
				return o2.score - o1.score;
			}
		});
		
		System.out.println(Arrays.toString(student));
		
		System.out.println("=========Comparator 일회성, 점수 오름차순 ==========");
		//람다식?
		Arrays.sort(student, (o1,o2) -> o1.score - o2.score );
		System.out.println(Arrays.toString(student));
	}

}
