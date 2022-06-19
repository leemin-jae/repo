package algoritm.sa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1767_0404 {
	static int Map[][];
	static int delta[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int n, cnt, c, max;
	static List<int[]> list = new ArrayList<>();
	static boolean check[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			list.clear();
			n = Integer.parseInt(br.readLine());
			Map = new int[n][n];
			check = new boolean[n][n];
			cnt = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					Map[i][j] = Integer.parseInt(st.nextToken());
					if (Map[i][j] == 1) {
						list.add(new int[] { i, j });
						check[i][j] = true;
					}
				}
			}

			back(0, check, 0);
			System.out.println("#" + tc + " " + cnt);
		}

	}

	public static void back(int start, boolean ch[][], int k) {
		if (start == list.size()) {
			if (max < k) {
				max = k;
				cnt = count(ch) - list.size();
			} else if (max == k) {
				cnt = Math.min(cnt, count(ch) - list.size());
			}
			return;
		}


		for (int i = start; i < list.size(); i++) {

			int current[] = list.get(i);
			int x = current[0];
			int y = current[1];

			if (x == 0 || x == n - 1 || y == 0 || y == n - 1) {
				back(i + 1, ch, k + 1);
				break; // 끝에 있는거
			}

			for (int d = 0; d < 4; d++) {
				boolean co[][] = copy(ch);

				int nextX = x;
				int nextY = y;

				while (true) {

					nextX = nextX + delta[d][0];
					nextY = nextY + delta[d][1];
					
					if (!co[nextX][nextY]) {
						co[nextX][nextY] = true;
						if (nextX == 0 || nextX == n - 1 || nextY == 0 || nextY == n - 1) {
							back(i + 1, co, k + 1);
							break;
						}
					} else {
						break;
					}
				}
				//back(i + 1, co, k); // 아무곳도 연결 안하고 넘어갈때
			}
		}
	}

	public static boolean[][] copy(boolean ch[][]) {
		boolean copy[][] = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copy[i][j] = ch[i][j];
			}
		}

		return copy;
	}

	public static int count(boolean ch[][]) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (ch[i][j])
					sum++;
			}
		}

		return sum;
	}
}
