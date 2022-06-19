package algoritm.sa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1861_0211 {
	static int[][] delta = { { -1, 0 }, { 0, -1 }, { 0, 1 }, { 1, 0 } };
	static int Map[][];
	static int N, cnt, p ,cnt_l;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());

			
			Map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					Map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			cnt_l = -1;
			// ===============================================================================
		
			for (int i = 0; i < N ; i++) {
				for (int j = 0; j < N; j++) {
					
					cnt = 1;
					find(i,j);
					//System.out.println(cnt_l);
					if(cnt > cnt_l) {
						cnt_l = cnt;
						p = Map[i][j];
					}else if(cnt == cnt_l) {
						p = Math.min(p, Map[i][j]);
					}
					
				}
			}

			System.out.println("#" + tc + " " + p + " " +  cnt_l);
		}
	}
	static void find(int x, int y) {

		for(int i = 0 ; i < 4 ; i ++) {
			int x_l = x + delta[i][0];
			int y_l = y + delta[i][1];
			if(x_l >= 0  && x_l < N && y_l >= 0 && y_l < N && Map[x_l][y_l] == (Map[x][y]+1)) {
				cnt++;
				find(x_l,y_l);

			}
		}
		
	}
}
