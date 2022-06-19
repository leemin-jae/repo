package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500_0308 {
	static int N, M, Max;
	static int Map[][];
	static int square[][] = { { 0, 0 }, { 0, 1 }, { 1, 1 }, { 1, 0 } };
	static int tetro[][] = { { -1, 0 }, { 0, 2 }, { 2, 1 }, { 1, -1 } };

	static int square_r[][] = { { 0, 1 }, { 1, 1 }, { 1, 0 }, { 0, 0 } };
	static int tetro_r[][] = { { -1, 1 }, { 1, 2 }, { 2, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Max = Integer.MIN_VALUE;
		Map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				find(i, j);
			}
		}
		System.out.println(Max);

	}

	public static void find(int x, int y) {
		int stand = 0;
		if (x < N - 1 && y < M - 1) {
			stand = Map[x][y] + Map[x][y + 1] + Map[x + 1][y] + Map[x + 1][y + 1];
			Max = Math.max(Max, stand);

			for (int i = 0; i < 4; i++) {
				int tX = x + tetro[i][0];
				int tY = y + tetro[i][1];
				if (tX < 0 || tY < 0 || tX >= N || tY >= M)
					continue;
				int num = stand + Map[tX][tY];
				for (int j = 0; j < 4; j++) {
					if (j == i)
						continue;
					Max = Math.max(Max, num - Map[x + square[j][0]][y + square[j][1]]);
				}

			}

			for (int i = 0; i < 4; i++) {
				int tX = x + tetro_r[i][0];
				int tY = y + tetro_r[i][1];
				if (tX < 0 || tY < 0 || tX >= N || tY >= M)
					continue;
				int num = stand + Map[tX][tY];
				for (int j = 0; j < 4; j++) {
					if (j == i)
						continue;
					Max = Math.max(Max, num - Map[x + square_r[j][0]][y + square_r[j][1]]);
				}

			}
		}
		if (x < N - 3) {
			stand = Map[x][y] + Map[x + 1][y] + Map[x + 2][y] + Map[x + 3][y];
			Max = Math.max(Max, stand);
		}
		if (y < M - 3) {
			stand = Map[x][y] + Map[x][y + 1] + Map[x][y + 2] + Map[x][y + 3];
			Max = Math.max(Max, stand);
		}

	}

}
