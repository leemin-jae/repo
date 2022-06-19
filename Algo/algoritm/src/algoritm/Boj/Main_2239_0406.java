package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2239_0406 {
	static int Map[][];
	static boolean W[][], H[][], Square[][];
	static int flag = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		W = new boolean[9][10];
		H = new boolean[9][10];
		Square = new boolean[9][10];
		Map = new int[9][9];
		

		for (int i = 0; i < 9; i++) {
			String s = br.readLine();
			for (int j = 0; j < 9; j++) {
				Map[i][j] = s.charAt(j) - '0';

				W[i][Map[i][j]] = true; // 가로
				H[j][Map[i][j]] = true; // 세로
				Square[cal_Square(i, j)][Map[i][j]] = true;
			}
		}
		
		dfs(0);

	}

	public static void dfs(int now) {
		if (now == 81 && flag == 0) {

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(Map[i][j]);
				}
				System.out.println();
			}
			flag = 1;
			return;
		}
		if(flag == 1) {
			return;
		}

		int x = now / 9;
		int y = now % 9;

		if (Map[x][y] != 0) {
			dfs(now + 1);
		} else {
			for (int i = 1; i <= 9; i++) {
				if (!W[x][i] && !H[y][i] && !Square[cal_Square(x, y)][i]) {
					W[x][i] = true;
					H[y][i] = true;
					Square[cal_Square(x, y)][i] = true;
					Map[x][y] = i;
					dfs(now + 1);
					Map[x][y] = 0;
					W[x][i] = false;
					H[y][i] = false;
					Square[cal_Square(x, y)][i] = false;

				}
			}
		}
	}

	public static int cal_Square(int x, int y) {
		return y / 3 + (x / 3) * 3;
	}

}
