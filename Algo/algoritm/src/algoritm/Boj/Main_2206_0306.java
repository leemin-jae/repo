package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206_0306 {
	static int N, M;
	static int delta[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static char Map[][];
	static int check[][][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Map = new char[N][M];
		check = new int[N][M][2];

		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < M; j++) {
				Map[i][j] = s.charAt(j);
			}
		}

//		for(int i = 0 ; i < N; i ++) {
//			for(int j = 0 ; j < M ; j++) {
//				if(Map[i][j] == '1') {
//					check[i][j] = false;
//					bfs_1(0,0);
//					check[i][j] = true;
//				}
//					
//					
//			}
//		}

		bfs_1(0, 0);

	}

	public static void bfs_1(int x, int y) {

		Queue<int[]> que = new LinkedList<>();
		check[x][y][0] = 1;
		que.add(new int[] { x, y, 0 });

		while (!que.isEmpty()) {
			int[] current = que.poll();
			if (current[0] == N - 1 && current[1] == M - 1) {
				System.out.println(check[N - 1][M - 1][current[2]]);
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nextX = current[0] + delta[i][0];
				int nextY = current[1] + delta[i][1];

				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
					if (Map[nextX][nextY] == '1') {
						if (current[2] == 0 && check[nextX][nextY][1] == 0) {
							check[nextX][nextY][1] = check[current[0]][current[1]][current[2]] + 1;
							que.add(new int[] { nextX, nextY, 1 });
						}
					} else {
						if (check[nextX][nextY][current[2]] == 0) {
							check[nextX][nextY][current[2]] = check[current[0]][current[1]][current[2]] + 1;
							que.add(new int[] { nextX, nextY, current[2] });
						}
					}

				}
			}
		}
		System.out.println(-1);

	}
//	public static void bfs(int x, int y) {
//
//		Queue<int[]> que = new LinkedList<>();
//
//		check[x][y] = true;
//		que.add(new int[] { x, y, 1, 0 });
//
//		while (!que.isEmpty()) {
//			int[] current = que.poll();
//			if (current[0] == N - 1 && current[1] == M - 1) {
//				System.out.println(current[2]);
//				return;
//			}
//
//			for (int i = 0; i < 4; i++) {
//				int nextX = current[0] + delta[i][0];
//				int nextY = current[1] + delta[i][1];
//
//				if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
//					if(!check[nextX][nextY]) {
//						check[nextX][nextY] = true;
//						que.add(new int[] { nextX, nextY, current[2] + 1, current[3]});
//					}else if(check[nextX][nextY] && current[3] == 0) {
//						que.add(new int[] { nextX, nextY, current[2] + 1, 1 });
//					}
//					
//				}
//			}
//		}
//		System.out.println(-1);
//
//	}

}
