package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_0217 {
	static int R, C, cnt;
	static char Map[][];

	static boolean[][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		Map = new char[R][];
		visited = new boolean[R][C];

		for (int i = 0; i < R; i++) {
			Map[i] = br.readLine().toCharArray();
		}

		makePipe();
		System.out.println(cnt);
	}

	public static void makePipe() {
		cnt = 0;

		for (int i = 0; i < R; i++) {
			visited[i][0] = true;
			dfs(i, 0);
		}
	}

	static int[] dr = { -1, 0, 1 };

	private static boolean dfs(int r, int c) {
		if (c == C - 1) {
			cnt++;
			return true;
		}

		int nr, nc = c + 1;

		for (int d = 0; d < 3; ++d) {

			nr = r + dr[d];

			if (nr < 0 || nr >= R || nc >= C || visited[nr][nc] || Map[nr][nc] == 'x')
				continue;

			visited[nr][nc] = true;

			if (dfs(nr, nc)) {
				return true;
			}

		}
		return false;

	}

}
