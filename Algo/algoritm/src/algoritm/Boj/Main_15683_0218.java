package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15683_0218 {
	static int N, M;
	static String Map[][];
	static boolean check[][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Map = new String[N][];
		
		for(int i = 0 ; i < N ; i ++) {
			Map[i] = br.readLine().split(" ");
		}
		
		
		for(int i = 0; i < N ; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(Map[i][j]);
			}
			System.out.println();
		}
		
		
		
	}
	
}
