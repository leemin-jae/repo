package com.ssafy;

import java.util.Scanner;

public class SquareNumberDivideTest0215 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int n = sc.nextInt();
		System.out.println(exp(x,n));
		System.out.println(callCnt);
	}
	static int callCnt = 0;
	
	public static long exp(long x, long n) {
		callCnt++;
		if(n==1) return x;
		
		long y = exp(x,n/2);
		
		return (n%2 == 0)? y*y:y*y*x;
	}

}
