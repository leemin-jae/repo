package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503_0305 {
	static int N, M, R, C, D, cnt;
	static int Map[][];
	static int delta[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Map = new int[N][M];

		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		cnt = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}

		}

		clean(R, C, D);
		System.out.println(cnt);

	}

	public static void clean(int x, int y, int d) {
		if (Map[x][y] == 0) {
			Map[x][y] = 2;
			cnt++;
//			System.out.println(cnt);
//			System.out.println(x + " " + y);
//			for (int i = 0; i < N; i++) {
//
//				for (int j = 0; j < M; j++) {
//					System.out.print(Map[i][j] + " ");
//
//				}
//				System.out.println();
//			}
//			System.out.println("------------------------------------------------");

		}
		int look = -1;
		int X = -1;
		int Y = -1;
		for (int i = 1; i <= 4; i++) {
			int del = d - i < 0 ? 4 - i + d : d - i;
			int nextX = x + delta[del][0];
			int nextY = y + delta[del][1];

			if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < M && Map[nextX][nextY] == 0) {
				X = nextX;
				Y = nextY;
				look = del;
				break;
			}
		}
		if (X == -1 && Y == -1) {
			int nX = x + delta[(d + 2) % 4][0];
			int nY = y + delta[(d + 2) % 4][1];
			if (Map[nX][nY] == 1) {
				return;
			} else {
				clean(nX, nY, d);
			}

		} else {
//			System.out.println(X + " " + Y + " " + look);
			clean(X, Y, look);
		}

	}

}
