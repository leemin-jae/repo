package com.ssafy.compare;

import java.util.Arrays;

public class SrotTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer []arr = new Integer[] {2,8,4,6,7};
		System.out.println("정렬 전 : " + Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("정렬 후 : " + Arrays.toString(arr));
	
		String[] city = {"대전","광주","서울","구미","부울결"};
		System.out.println("정렬 전 : " + Arrays.toString(city));
		Arrays.sort(city);
		System.out.println("정렬 후 : " + Arrays.toString(city));
		
	
	
	}

}
