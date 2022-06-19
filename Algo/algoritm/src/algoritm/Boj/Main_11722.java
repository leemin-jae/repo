package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11722 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int num[] = new int[N];
		int dp[] = new int[N];
		int Max = Integer.MIN_VALUE;
		for(int i=0 ; i < N ; i ++) {
			num[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}
		
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < i ; j++) {
				if(num[i] < num[j]) dp[i] = Math.max(dp[i],dp[j]+1); 
			}
			Max = Math.max(Max, dp[i]);
		}
		System.out.println(Max);
	}

}
