package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1912_0305 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int T = Integer.parseInt(br.readLine());

		int num[] = new int[T];
		// int[][] dp = new int[T][];

		int max = Integer.MIN_VALUE;
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < T; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int k[] = new int[T];
		k[0] = num[0];
		max = num[0];

		for (int i = 1; i < T; i++) {
			k[i] = Math.max(k[i-1] + num[i], num[i]);
			max = Math.max(max, k[i]);
		}



		System.out.println(max);
	}

}
