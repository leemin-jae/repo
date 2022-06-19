package com.ssafy;

import java.util.Scanner;

/*
 * 


6 21
5 21 11 16 6 10
 * 
 * 
 */
public class SubsetSumTest2 {
	static int N, input[], S, ans;
	static boolean[] isSelected;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 집합의 크기
		S = sc.nextInt(); // 목표합
		ans = 0;

		input = new int[N];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		generateSubset(0 , 0);
		System.out.println(ans);
	}

	public static void generateSubset(int cnt, int sum) { // 부분집합에 고려해야하는 원소, 직전까지 고려한 원소 수
															// sum : 직전까지 구성된 부분집합의 합

		if (sum == S) {
			++ans;
			for (int i = 0; i < cnt; i++) {
				System.out.print(isSelected[i] ? input[i] + " " : "");
			}
			System.out.println();
			return;
		}
		if (sum > S) {
			return;
		}
		if (cnt == N) {
			return;
		}

		// 현재 원소를 선택
		isSelected[cnt] = true;
		generateSubset(cnt + 1, sum + input[cnt]);
		// 현재 원소를 비선택
		isSelected[cnt] = false;
		generateSubset(cnt + 1, sum);

	}
}
