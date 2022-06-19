package algoritm.sa;


import java.io.*;
import java.util.*;

public class Solution_5604_0412 {
	static int TC;
	static long A, B;
	static long[] cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		TC = Integer.parseInt(st.nextToken());

		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());

			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());

			long delta = 1;


			cnt = new long[10];
			while (A <= B) {
				
				for (; A % 10 != 0 && A <= B; A++) {
					parse(A, delta);

				}
				
				for (; B % 10 != 9 && A <= B; B--) {
					parse(B, delta);
				}

				
				if (A > B)
					break;

				A /= 10;
				B /= 10;

				
				long rowCnt = B - A + 1;
				for (int i = 0; i < 10; i++) {
					cnt[i] += delta * rowCnt;
				}

				delta *= 10;
			}

			long sum = 0;
			for (int i = 1; i < 10; i++) {
				sum += i * cnt[i];
			}

			sb.append("#").append(t).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}

	private static void parse(long x, long delta) {
		while (x > 0) {
			cnt[(int) (x % 10)] += delta;
			x /= 10;
		}
	}
}