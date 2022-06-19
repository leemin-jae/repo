package algoritm.sa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1206_0223 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;



		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			int sum = 0;
			String[] b = br.readLine().split(" ");
			int [] buliding = new int[b.length];
			for(int i = 0 ; i < b.length ; i ++) {
				buliding[i] = Integer.parseInt(b[i]);
			}
			
			boolean[] check = new boolean[buliding.length];
			for (int i = 2; i < buliding.length - 2; i++) {
				if (!check[i]) {
					int left = Math.max(buliding[i - 2] , buliding[i - 1] );
				
					int right = Math.max(buliding[i + 2], buliding[i + 1]);

					if (right <= buliding[i] - '0') {
						check[i + 1] = true;
						check[i + 2] = true;
					}
					if (Math.max(left, right) <= (buliding[i] )) {
						//System.out.println(Math.max(left, right));
						sum += (buliding[i]) - Math.max(left, right);
					}
				}

			}

			System.out.println("#" + tc + " " + sum);

		}

	}

}
