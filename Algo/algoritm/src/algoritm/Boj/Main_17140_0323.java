package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17140_0323 {
	static int R, C, K, check_r, check_c;
	static int[][] Map = new int[101][101];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 3; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		check_r = 3;
		check_c = 3;

		int result = -1;
		for (int i = 0; i <= 100; i++) {
			if (Map[R][C] == K) {
				result = i;
				break;
			}
			
			cul();
		}

		System.out.println(result);

//		row_cul();
//		col_cul();
//
//		for (int i = 1; i < 10; i++) {
//			for (int j = 1; j < 10; j++) {
//				System.out.print(Map[i][j] + " ");
//			}
//			System.out.println();
//		}

	}

	public static void cul() {
		if (check_r >= check_c) {
			row_cul();
		} else {
			col_cul();
		}
	}

	public static void row_cul() {
		int[][] check = new int[101][101];
		int[][] next = new int[101][101];

		int max = -1;
		int size = -1;
		for (int i = 1; i <= check_r; i++) {
			for (int j = 1; j <= check_c; j++) {
				//System.out.println(i + " " + j);
				if (Map[i][j] != 0) {
					check[i][Map[i][j]]++;
					max = Math.max(max, check[i][Map[i][j]]);
				}
			}
		}

		for (int i = 1; i <= check_r; i++) {
			int cnt = 1;
			for (int j = 1; j <= max; j++) {
				if (cnt > 100)
					break;
				for (int k = 1; k <= 100; k++) {
					if (cnt > 100)
						break;
					if (check[i][k] == j) {
						next[i][cnt++] = k;
						next[i][cnt++] = j;
						size = Math.max(size, cnt);
					}
				}
			}
		}

		check_c = size - 1;
		Map = next;
	}

	public static void col_cul() {
		int[][] check = new int[101][101];
		
		int[][] next = new int[101][101];

		int max = -1;
		int size = -1;
		for (int i = 1; i <= check_c; i++) {
			for (int j = 1; j <= check_r; j++) {
				//System.out.println(i + " " + j);
				if (Map[j][i] != 0) {
					check[i][Map[j][i]]++;
					max = Math.max(max, check[i][Map[j][i]]);
				}
			}
		}

		for (int i = 1; i <= check_c; i++) {
			int cnt = 1;
			for (int j = 1; j <= max; j++) {
				if (cnt > 100)
					break;
				for (int k = 1; k <= 100; k++) {
					if (cnt > 100)
						break;
					if (check[i][k] == j) {
						next[cnt++][i] = k;
						next[cnt++][i] = j;
						size = Math.max(size, cnt);
					}
				}
			}
		}

		check_r = size - 1;
		Map = next;
	}
}
