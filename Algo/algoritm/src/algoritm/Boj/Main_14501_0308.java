package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501_0308 {
	static int N , Max;
	static int work[][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		work = new int[N][2];
		Max = Integer.MIN_VALUE;
		for(int i =0 ; i < N; i ++) {
			st =  new StringTokenizer(br.readLine());
			work[i][0] = Integer.parseInt(st.nextToken());
			work[i][1] = Integer.parseInt(st.nextToken());
		}
		
		find(0,0);
		System.out.println(Max);
	}
	public static void find(int start, int money) {
		Max = Math.max(money, Max);
		for(int i = start ; i < N ; i ++) {
			if(i + work[i][0] > N) continue;
			find(i + work[i][0] , money + work[i][1]);
		}
		
	}
}
