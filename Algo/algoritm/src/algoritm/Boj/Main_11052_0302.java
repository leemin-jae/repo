package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11052_0302 {
	static int N;
	static int price[];
	static int p[];
	static int min;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		price = new int[N + 1];
		p = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			price[i] = Integer.parseInt(st.nextToken());
			if(i == 1) p[i] = price[i];
			if(i == 2) p[i] = Math.max(price[i] , p[1]+p[1]);
		}
		
		for(int i = 3; i <=N ; i++) {
			int max = price[i];
			for(int j = 1; j <= i/2 ; j ++) {

				max = Math.max(max, p[i-j] + p[j]);
			}
			p[i] = max;
		}
		
		System.out.println(p[N]);


		
		
		//buy(1, 0, 0);
		//System.out.println(min);
	}

//	static public void buy(int start, int cnt, int p) {
//		if (cnt >= N) {
//			if (min < p && cnt == N)
//				min = p;
//			return;
//		}
//
//		for (int i = start; i <= N; i++) {
//			buy(i, cnt + i, p + price[i]);
//		}
//
//	}

}
