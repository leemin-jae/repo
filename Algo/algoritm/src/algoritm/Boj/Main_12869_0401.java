package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_12869_0401 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int check[][] = {{9,3,1},{9,1,3},{1,3,9},{1,9,3},{3,1,9},{3,9,1}};
		int hp[] = new int[3];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i <n ; i ++) {
			hp[i] = Integer.parseInt(st.nextToken());
		}
		
		int dp[][][] = new int[61][61][61];
		
		for(int i = 0; i <= hp[0] ; i ++) {
			for(int j = 0 ; j <= hp[1] ; j++) {
				for(int k = 0 ; k <= hp[2] ; k++) {
					
					dp[i][j][k] = Integer.MAX_VALUE;
					
				}
			}
		}
		dp[0][0][0] = 0;
		
		for(int i = 0; i <= hp[0] ; i ++) {
			for(int j = 0 ; j <= hp[1] ; j++) {
				for(int k = 0 ; k <= hp[2] ; k++) {
					
			
					
					for(int d = 0 ; d < check.length ; d++) {
						int a = i - check[d][0] < 0 ? 0 : i - check[d][0];
						int b = j	- check[d][1] < 0 ? 0 : j - check[d][1];
						int c = k	- check[d][2]  < 0 ? 0 : k - check[d][2];
						
						dp[i][j][k] =Math.min(dp[i][j][k],dp[a][b][c] + 1);
						
					}
					
					
					
				}
			}
		}
		
		
		System.out.println(dp[hp[0]][hp[1]][hp[2]]);
		
		
	}

}
