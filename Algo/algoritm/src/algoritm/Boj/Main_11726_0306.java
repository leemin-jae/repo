package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11726_0306 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		
		int dp[] = new int[1001];
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i = 3 ; i <= N; i++) {
			
			dp[i] = (dp[i-2] + dp[i-1])%10007;
		}
		System.out.println(dp[N]);
	}
	static public int dp(int n) {
		if (n == 1) {
			return 1;
		}
		if(n == 2) {
			return 2;
		}
		
		return dp(n-1) + dp(n-2);
	}
}
