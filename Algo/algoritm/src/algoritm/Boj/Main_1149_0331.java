package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_0331 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int pay[][] = new int[n][3];
		StringTokenizer st = null;
		for(int i = 0 ; i < n ; i ++) {
			st = new StringTokenizer(br.readLine());
			pay[i][0] = Integer.parseInt(st.nextToken());
			pay[i][1] = Integer.parseInt(st.nextToken());
			pay[i][2] = Integer.parseInt(st.nextToken());	
		}
		
		int money[][] = new int [n][3];
		
		money[0][0] = pay[0][0];
		money[0][1] = pay[0][1];
		money[0][2] = pay[0][2];
		
		for(int i = 1 ; i < n ; i++) {
			
			for(int j = 0 ; j < 3 ; j ++) {
				
				
				if(j == 0) {
					money[i][j] = pay[i][j] + Math.min(money[i-1][1],money[i-1][2]);
				}else if( j == 1) {
					money[i][j] = pay[i][j] + Math.min(money[i-1][0],money[i-1][2]);
				}else if(j == 2) {
					money[i][j] = pay[i][j] + Math.min(money[i-1][0],money[i-1][1]);
				}
				
			}
			
			
		}
		
		System.out.println(Math.min(money[n-1][2],Math.min(money[n-1][0], money[n-1][1])));
		
	}

}
