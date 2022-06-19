package com.ssafy.compare;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {

	private static class MyComparator implements Comparator<int[]>{

		@Override
		public int compare(int[] o1, int[] o2) {
			// TODO Auto-generated method stub
			int diff = o1[1] - o2[1];
			return diff != 0? diff : o1[0] - o2[0];
		}
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int [][]arr = new int[][] {{1,10},{3,50},{4,52},{2,80},{5,52}};
		print(arr);
		System.out.println("==========정렬 후==========");
		//여기서 원소는 1차원 배열 int[] <-- 얘가 원소, 크기 판단의 기분 아무것도 없음
		//어쩔수 없이 원소에게 비교를 맡기는게 아니라, 판단의 기분인 Comparator를 넣어서 
		Arrays.sort(arr, new MyComparator());
		print(arr);
	}
	
	private static void print(int[][] arr) {
		for(int[] is : arr) {
			System.out.println(Arrays.toString(is));
		}
	}

}
