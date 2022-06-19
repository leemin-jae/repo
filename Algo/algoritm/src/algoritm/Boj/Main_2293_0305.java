package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2293_0305 {
	static int N, M;
	static int dp[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		dp = new int[101][10001];
		int a = Integer.parseInt(br.readLine());
		int k = a;
		while (true) {
			if (k > M)
				break;
			dp[0][k]++;
			k += a;
		}
		for (int i = 1; i < N; i++) {
			a = Integer.parseInt(br.readLine());
			if(a > M) continue;
			for (int j = 1; j <= M; j++) {
				if (j < a) {
					dp[i][j] = dp[i - 1][j];
				} else if (j == a) {
					dp[i][j] = dp[i - 1][j] + 1;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - a];
				}
			}
		}

		System.out.println(dp[N - 1][M]);

	}

}
