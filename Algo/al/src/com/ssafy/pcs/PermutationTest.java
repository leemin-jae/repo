package com.ssafy.pcs;

import java.util.Arrays;
import java.util.Scanner;

//nPr
//n개의 수 입력받아 처리
public class PermutationTest {
	static int N, R;
	static int[] input, numbers;
	static boolean[] isSelected;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		numbers= new int[R];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		
		permutation(0);
	}
	
	//현재 자리에 수 뽑기
	public static void permutation(int cnt) { // cnt : 진전까지 뽑은 수 개수
		
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// 입력받은 모든 수를 현재 자리에 넣기
		for (int i = 0; i < N; i++) {
			//기존 자리의 수들과 중복되는지 체크
			if(isSelected[i]) continue;
			
			numbers[cnt] = input[i];
			isSelected[i] = true;
			//다음수 뽑으러 가기
			permutation(cnt+1);
			isSelected[i] = false;
			
		}
	}

}
