package com.ssafy;

import java.util.Scanner;

public class CombinationNPTest2015 {
	//static int N,R;
	// static int[] input;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int R = sc.nextInt();
		
		int []input = new int[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		
		int[] p = new int[N];
		//p배열에 0보다 큰 값으로 R개를 맨뒤부터 채운다.
		//4C2 0011
		int cnt = 0;
		while(++cnt <= R) p[N-cnt] = 1;
		
		do {
			for (int i = 0; i < N; i++) {
				if(p[i] == 1) {
					System.out.print(input[i] + " ");
				}
				
			}
			System.out.println();
		}while(np(p));
		
		
	}
	private static boolean np(int[] p) {
		int N = p.length;
		
		int i = N-1;
		while(i>0 && p[i-1] >=p[i]) --i;
		
		if(i == 0) return false;
		
		int j = N-1;
		while(p[i-1] >=p[j]) --j;
		
		swap(p,i-1,j);
		
		int k = N-1;
		while(i<k) {
			swap(p,i++, k--);
		}
		return true;
	}
	
	public static void swap(int[] p, int i, int j) {
		int temp = p[i];
		p[i] = p[j];
		p[j] = temp;
	}
}
