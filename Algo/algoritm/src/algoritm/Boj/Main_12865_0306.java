package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_12865_0306 {
	static int N, K, check, ch;
	static ArrayList<int[]> weight = new ArrayList<>();


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		long dp[][] = new long[101][100001];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());

			weight.add(new int[] { w, h });
		}

		int[] current = weight.get(0);

		for (int j = 1; j <= K; j++) {
			if (current[0] > j) {
				dp[0][j] = 0;
			} else {
				dp[0][j] = current[1];
			}
		}

		for (int i = 1; i < N; i++) {
			current = weight.get(i);

			for (int j = 1; j <= K; j++) {
				if (current[0] > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(current[1] + dp[i - 1][j - current[0]], dp[i - 1][j]);
				}
			}
		}
		
		System.out.println(dp[N-1][K]);

	}

}
