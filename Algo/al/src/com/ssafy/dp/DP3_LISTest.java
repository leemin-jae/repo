package com.ssafy.dp;

import java.util.Arrays;
import java.util.Scanner;

public class DP3_LISTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] LIS = new int[N];

		for (int i = 0; i < LIS.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0;
		for (int i = 0; i < LIS.length; i++) {
			LIS[i] = 1;  // 자기 혼자 LIS 구성할때 길이 1 초기화
			
			for (int j = 0; j < i; j++) { // 첫 원소부터 i원소 직전까지 비교
				if(arr[j] < arr[i] && LIS[i] < LIS[j] +1) {
					LIS[i] = LIS[j] +1;
				}
				
			}
			if(max < LIS[i]) max = LIS[i];
			
		}
		
		System.out.println(max);

	}

}
