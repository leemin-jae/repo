package algoritm.sa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_0407 {
	static int[][] Map;
	static int N, M, R, C, L;
	static int delta[][][] = { {}, { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } }, { { 1, 0 }, { -1, 0 } },
			{ { 0, 1 }, { 0, -1 } }, { { -1, 0 }, { 0, 1 } }, { { 1, 0 }, { 0, 1 } }, { { 1, 0 }, { 0, -1 } },
			{ { 0, -1 }, { -1, 0 } } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());

			Map = new int[N][M];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					Map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			System.out.println("#" + tc + " " + bfs());
			

		}
	}

	static int bfs() {
		Queue<int[]> que = new LinkedList<>();
		boolean check[][] = new boolean[N][M];

		check[R][C] = true;
		que.add(new int[] { R, C, 1 });
		int space = 0;

		while (!que.isEmpty()) {
			int current[] = que.poll();
			int x = current[0];
			int y = current[1];
			int time = current[2];
			int line = Map[x][y];

			if (time <= L) {

//				for (boolean k[] : check) {
//					for (boolean j : k) {
//						System.out.print(j ? 1 : 0);
//						System.out.print(" ");
//					}
//					System.out.println();
//				}
//				System.out.println("=================");
				space++;
			}
			if (time > L) {
				break;
			}

			for (int i = 0; i < delta[line].length; i++) {
				int nextX = x + delta[line][i][0];
				int nextY = y + delta[line][i][1];

				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && !check[nextX][nextY]
						&& Map[nextX][nextY] != 0) {
					boolean go = false;
					for (int j = 0; j < delta[Map[nextX][nextY]].length; j++) {
						if (delta[Map[nextX][nextY]][j][0] + delta[line][i][0] == 0 && delta[Map[nextX][nextY]][j][1]
								+ delta[line][i][1] == 0) {
							go = true;
						}
					}
					if (go) {
						check[nextX][nextY] = true;
						que.add(new int[] { nextX, nextY, time + 1 });
					}
				}

			}

		}

		return space;

	}
}
