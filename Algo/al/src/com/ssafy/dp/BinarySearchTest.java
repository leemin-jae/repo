package com.ssafy.dp;

import java.util.Arrays;

public class BinarySearchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] values = {3,11,15,20,21,45};
		
		System.out.println(Arrays.binarySearch(values, 3));
		System.out.println(Arrays.binarySearch(values, 11));
		System.out.println(Arrays.binarySearch(values, 15));
		System.out.println(Arrays.binarySearch(values, 20));
		System.out.println(Arrays.binarySearch(values, 21));
		System.out.println(Arrays.binarySearch(values, 5));
		System.out.println(Arrays.binarySearch(values, 6));
		System.out.println(Arrays.binarySearch(values, 7));
	}

}
