package algoritm.sa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Sa2001 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			int Map[][] = new int [M][M];
			
			for(int i = 0; i < M; i++) {
				String s = br.readLine();
				for(int j =0 ; j < M ; j++) {
					Map[i][j] = Integer.parseInt(s.split(" ")[j]);
				}
			}
			
			int max = -1;
			
			for(int i = 0; i <= M-N ; i ++) {
				for (int j = 0; j <= M-N; j++) {

					int sum = 0;
					
					for(int a = 0; a < N; a++) {
						for (int b = 0; b < N; b++) {
							sum += Map[i+a][j+b];
						}
					}
					
					if(max < sum) {
						max = sum;

					}
					
				}
			}
			
			
			System.out.println("#" + tc + " " + max);
			
			
//			for (int i = 0; i < Map.length; i++) {
//				for (int j = 0; j < Map.length; j++) {
//					System.out.print(Map[i][j] + "\t" );
//				}
//				System.out.println();
//			}
			
			
		}
		
	}

}
