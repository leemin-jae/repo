package algoritm;

public class DP_연습문제2_이민재 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dp[] = new int [9];
		
		dp[0] = 0;
		dp[1] = 2;
		dp[2] = 5;
		
		for(int i = 3 ; i <= 8 ; i ++) {
			dp[i] = dp[i-1] + dp[i-1] + dp[i-2];
		}
		
		System.out.println(dp[6]);
	}

}
