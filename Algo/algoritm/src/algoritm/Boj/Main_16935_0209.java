package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16935_0209 {
	static int A, B, R, count = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		String map[][];
		String map_sub[][];

		map = new String[100][100];
		map_sub = new String[100][100];

		for (int i = 0; i < A; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < B; j++) {
				map[i][j] = st.nextToken();
			}

		}

		st = new StringTokenizer(br.readLine());

		while (st.hasMoreTokens()) {
			cal(map, map_sub, Integer.parseInt(st.nextToken()));
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[0].length; j++) {
					if (map_sub[i][j] == null && map[i][j] == null)
						break;
					map[i][j] = map_sub[i][j];
					map_sub[i][j] = null;
				}
			}
		}

		for (int i = 0; i < map_sub.length; i++) {
			for (int j = 0; j < map_sub[0].length; j++) {
				if (map[i][j] == null)
					break;
				System.out.print(map[i][j] + " ");
			}
			if (map[i][0] == null)
				break;
			System.out.println();
		}

	}

	public static void cal(String[][] map, String[][] map_sub, int a) {

		int N = A;
		int M = B;
		if (count % 2 == 1) {
			N = B;
			M = A;
		}

		if (a == 1) {
			for (int i = 0; i < N / 2; i++) {
				for (int j = 0; j < M; j++) {
					map_sub[i][j] = map[N - i - 1][j];
					map_sub[N - i - 1][j] = map[i][j];
				}
			}
		} else if (a == 2) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M / 2; j++) {
					map_sub[i][j] = map[i][M - j - 1];
					map_sub[i][M - j - 1] = map[i][j];
				}
			}
		} else if (a == 3) {
			count++;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map_sub[j][N - 1 - i] = map[i][j];
				}
			}
		} else if (a == 4) {
			count++;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					map_sub[M - 1 - j][i] = map[i][j];
				}
			}
		} else if (a == 5) {
			for (int i = 0; i < N / 2; i++) { // 1번그룹
				for (int j = 0; j < M / 2; j++) {
					map_sub[i][M / 2 + j] = map[i][j];
				}
			}
			for (int i = 0; i < N / 2; i++) {
				for (int j = M / 2; j < M; j++) {
					map_sub[N / 2 + i][j] = map[i][j];
				}
			}
			for (int i = N / 2; i < N; i++) {
				for (int j = M / 2; j < M; j++) {
					map_sub[i][j - M / 2] = map[i][j];
				}
			}
			for (int i = N / 2; i < N; i++) {
				for (int j = 0; j < M / 2; j++) {
					map_sub[i - N / 2][j] = map[i][j];
				}
			}
		} else if (a == 6) {

			for (int i = 0; i < N / 2; i++) { // 1번그룹
				for (int j = 0; j < M / 2; j++) {
					map_sub[i + N / 2][j] = map[i][j];
				}
			}
			for (int i = 0; i < N / 2; i++) {
				for (int j = M / 2; j < M; j++) {
					map_sub[i][j - M / 2] = map[i][j];
				}
			}
			for (int i = N / 2; i < N; i++) {
				for (int j = M / 2; j < M; j++) {
					map_sub[i - N / 2][j] = map[i][j];
				}
			}
			for (int i = N / 2; i < N; i++) {
				for (int j = 0; j < M / 2; j++) {
					map_sub[i][j + M / 2] = map[i][j];
				}
			}

		}

	}
}
