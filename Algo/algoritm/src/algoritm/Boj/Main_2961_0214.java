package algoritm.Boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2961_0214 {
	static int N, SB[][], number[], sum_S, sum_B, result;
	static boolean[] check;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		SB = new int[N][2];
		check = new boolean[N];

		result = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			SB[i][0] = sc.nextInt();
			SB[i][1] = sc.nextInt();
		}
		//System.out.println(Arrays.toString(SB[0]));
		per(0);

		System.out.println(result);
	}

	static void per(int a) {
		if (a == N) {
			sum_S = 1;
			sum_B = 0;
			for (int i = 0; i < SB.length; i++) {
				if (check[i])
					continue;
				sum_S *= SB[i][0];
				sum_B += SB[i][1];
			}
			if (sum_B != 0) {
				result = Math.min(result, Math.abs(sum_S - sum_B));
			}
			return;
		}

		check[a] = true;
		per(a + 1);
		check[a] = false;
		per(a + 1);

	}
}
