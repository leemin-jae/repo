package com.ssafy.compare;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorReverseTest {
	//Comparator에 reverseOrder()메서드 사용
	// 현재 정렬에서 역순으로 바꿔주는 메서드, 기본은 내림차순으로 바꿔줌.
	public static void main(String[] args) {
		// API정의 되어 있는 Integer에 메서드 사용
		Integer[] arr = new Integer[] {4,3,7,5,10};
		System.out.println("========정렬 전 : " + Arrays.toString(arr));
		Arrays.sort(arr, Comparator.reverseOrder());
		System.out.println("========정렬 후 : " +Arrays.toString(arr));
		
		//내가 정의한 클래스?
		Student[] student = new Student[] {
				new Student(1,10),
				new Student(5,52),
				new Student(2,100),
				new Student(4,52),
				new Student(3,80)
		};
		
		System.out.println("========정렬 전 : " + Arrays.toString(student));
		Arrays.sort(student, Comparator.reverseOrder());
		System.out.println("========정렬 후 : " +Arrays.toString(student));
		

		
	}

}
