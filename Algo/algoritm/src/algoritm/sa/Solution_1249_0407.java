package algoritm.sa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1249_0407 {
	static int[][] Map;
	static int[][] Map2;
	static int N, Min;
	static int[][] delta = { { 1, 0 }, { 0, 1 } , {-1,0},{0,-1} };
	static boolean check[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			N = Integer.parseInt(br.readLine());
			Map = new int[N][N];
			Map2 = new int[N][N];
			check = new boolean[N][N];
			Min = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				for (int j = 0; j < N; j++) {
					Map[i][j] = s.charAt(j) - '0';
					Map2[i][j] = Integer.MAX_VALUE;
				}
			}

//
//			check[0][0] = true;
//			dfs(0, 0, 0);
//			
			bfs();

			System.out.println("#" + tc + " " + Map2[N - 1][N - 1]);

		}
	}

	static void bfs() {

		Queue<int[]> que = new LinkedList<>();
		check[0][0] = true;
		Map2[0][0] = 0;
		que.add(new int[] { 0, 0 });

		while (!que.isEmpty()) {

			int current[] = que.poll();

			if (current[0] == N - 1 && current[1] == N - 1) {
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nextX = current[0] + delta[i][0];
				int nextY = current[1] + delta[i][1];

				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N) {
					if (Map2[nextX][nextY] > Map2[current[0]][current[1]] + Map[nextX][nextY]) {
						Map2[nextX][nextY] = Map2[current[0]][current[1]] + Map[nextX][nextY];
						que.add(new int[] { nextX, nextY });
					}

				}

//				if (current[2] < Min) {
//					check[nextX][nextY] = true;
//					que.add(new int[] { nextX, nextY, current[2] + Map[nextX][nextY] });
//				}
			}
		}

	}

	static void dfs(int x, int y, int cnt) {
		if (x == N - 1 && y == N - 1) {
			Min = Math.min(Min, cnt);
			// System.out.println(cnt);
			return;
		}
		if (cnt > Min) {
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nextX = x + delta[d][0];
			int nextY = y + delta[d][1];

			if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || check[nextX][nextY])
				continue;

			check[nextX][nextY] = true;
			dfs(nextX, nextY, cnt + Map[nextX][nextY]);
			check[nextX][nextY] = false;

		}

	}

}
