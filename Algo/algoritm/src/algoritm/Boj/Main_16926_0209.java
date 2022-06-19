package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16926_0209 {
	static int delta[][] = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	static int N, M, R;
	static String map[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		int r = Math.min(N, M) / 2;
		map = new String[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < M; j++) {
				map[i][j] = st.nextToken();
			}

		}

		Queue<String> que = new LinkedList<>();
		int x, y, x_l, y_l;

		for (int i = 0; i < r; i++) {
			que.clear();
			x = i;
			y = i;
			int p = 0;
			while (true) {
				// System.out.println(x + " " + y);
				que.add(map[x][y]);
				x_l = x + delta[p][0];
				y_l = y + delta[p][1];

				if (x_l < i || x_l >= N - i || y_l < i || y_l >= M - i) {
					p++;
					x_l = x + delta[p][0];
					y_l = y + delta[p][1];
				}
				x = x_l;
				y = y_l;
				if (x == i && y == i)
					break;
			}
			for (int j = 0; j < R; j++) {
				que.add(que.poll());
			}

			while (true) {
				map[x][y] = que.poll();
				x_l = x + delta[p][0];
				y_l = y + delta[p][1];

				if (x_l < i || x_l >= N - i || y_l < i || y_l >= M - i) {
					p = (p + 1) % 4;
					x_l = x + delta[p][0];
					y_l = y + delta[p][1];
				}
				x = x_l;
				y = y_l;
				if (x == i && y == i)
					break;
			}

		}

		for (int i = 0; i <N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}

	}

}
