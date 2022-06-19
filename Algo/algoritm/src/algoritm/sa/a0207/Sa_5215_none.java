package algoritm.sa.a0207;

import java.util.Arrays;
import java.util.Scanner;

public class Sa_5215_none {
	static int N;
	static int L;
	static int R;
	static int in[][];
	static int sum_N = 0;
	static int numbers[];
	static int numbers_L[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			
			in = new int[N][2];
			numbers = new int[N];
			numbers_L = new int[N];
			for(int i = 0 ; i < N; i ++) {
				in[i][0] = sc.nextInt();
				in[i][1] = sc.nextInt();
			}
			
			for(int i = 0; i <= N ; i ++) {
				R = i;
				a(0 , 0);
			}
			
			
			System.out.println("#"+tc + " " + sum_N);
		}
	}
	
	public static void a(int cnt, int start) {
		if (cnt == R) {
			int tmp = 0;
			int sum = 0;
			for(int i = 0 ; i < N; i ++) {
				if(numbers[i] != 0) {
					tmp += numbers[i];
					sum += numbers_L[i];
				}
			}
			
			if(sum <= 1000 && sum_N < tmp) {
				sum_N = tmp;
				//System.out.println(sum_N);
				//System.out.println(sum);
			}
			
			//System.out.println(Arrays.toString(numbers));
			return;
		}
		
		for(int i  = start; i < N; i++) {
			numbers[cnt] = in[i][0];
			numbers_L[cnt] = in[i][1];
			a(cnt+1, i+1);
		}
	}
}
