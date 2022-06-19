package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main_10026_0223 {
	static int delta[][] = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };
	static int N;
	
	static char map[][];
	static boolean[][] isCheck;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		isCheck = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!isCheck[i][j]) {

					RBG(i, j);
					cnt++;
				}
			}
		}

		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 'G') map[i][j] = 'R'; 
			}
		}
		
		int cnt_2 = 0;
		isCheck = new boolean[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!isCheck[i][j]) {

					RBG(i, j);
					cnt_2++;
				}
			}
		}

		System.out.println(cnt + " " + cnt_2);
	}

	public static void RBG(int x, int y) {
		isCheck[x][y] = true;
		char tmp_char = map[x][y];
		for (int i = 0; i < 4; i++) {
			int new_x = x + delta[i][0];
			int new_y = y + delta[i][1];
			
	         if (new_x<0 || new_y<0 || new_x>=N || new_y>=N){
	                continue;
	            }
	 
	            if (!isCheck[new_x][new_y] && map[new_x][new_y] == tmp_char){
	                RBG(new_x, new_y);
	            }
			
//			
//			if (nx >= 0 || nx < N || ny >= 0 || ny < N) {
//				if(!isCheck[x][y] &&  (map[x][y] == map[nx][ny])) {
//					RBG(nx, ny);
//				}
//				
//				
//			}
		}

	}
}
