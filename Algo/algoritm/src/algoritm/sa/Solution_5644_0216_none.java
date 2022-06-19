package algoritm.sa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5644_0216_none {
	static int[][] map;
	static int M, num;
	static int[][] delta = { { 0, 0 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
	static int[] move_A, move_B;
	static AP[] bc;
	static int sum;

	static class AP implements Comparable<AP> {
		int x;
		int y;
		int c;
		int power;

		public AP(int x, int y, int c, int power) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
			this.power = power;
		}

		@Override
		public int compareTo(AP o) {
			// TODO Auto-generated method stub
			return o.power == 0 ? 1 : o.power - this.power;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			sum = 0;
			map = new int[11][11];

			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());

			move_A = new int[M];
			move_B = new int[M];

			bc = new AP[num + 1];

			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				move_A[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				move_B[j] = Integer.parseInt(st.nextToken());
			}

			bc[0] = new AP(0, 0, 0, 0);
			for (int i = 1; i <= num; i++) {
				st = new StringTokenizer(br.readLine());
				bc[i] = new AP(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			Arrays.sort(bc);

			for (int i = 1; i <= 10; i++) {
				for (int j = 1; j <= 10; j++) {

					for (int k = 1; k <= num; k++) {
						if (Math.abs(bc[k].x - i) + Math.abs(bc[k].y - j) <= bc[k].c) {
							map[i][j] = map[i][j] | (1 << k);
						}
					}

				}
			}
			
			for (int i = 1; i <= 10; i++) {
				for (int j = 1; j <= 10; j++) {
					System.out.print(map[i][j] + " ");

				}
				System.out.println();
			}

			////////////////////////////////////////////////////////////////////////////////////////////////////////////

			int x_A = 1;
			int y_A = 1;
			int x_B = 10;
			int y_B = 10;

			check(x_A, y_A, x_B, y_B);
			// delta[move_A[i]][0] delta[move_A[i]][1]
			for (int i = 0; i < M; i++) {
				x_A = x_A + delta[move_A[i]][0];
				y_A = y_A + delta[move_A[i]][1];
				x_B = x_B + delta[move_B[i]][0];
				y_B = y_B + delta[move_B[i]][1];
				System.out.println(x_A+ " " + y_A);
				check(x_A, y_A, x_B, y_B);

			}

			System.out.println("#" + tc + " " + sum);

		}
	}

	static void check(int x_a, int y_a, int x_b, int y_b) {
		int A = 0;
		int B = 0;

		if (map[x_a][y_a] != 0) {
			while ((map[x_a][y_a] & (1 << A)) == 0) {
				A++;
			}
		}
		
		if (map[x_b][y_b] != 0) {
			while ((map[x_b][y_b] & (1 << B)) == 0) {
				B++;
			}
		}

		
		
		if (A == B) {
			if (map[x_a][y_a] == map[x_b][y_b]) {

				sum += bc[A].power;

			} else if (map[x_a][y_a] > map[x_b][y_b]) {

				A++;
				while ((map[x_a][y_a] & (1 << A)) == 0) {
					A++;
				}
				sum += (bc[A].power + bc[B].power);

			} else {

				B++;
				while ((map[x_b][y_b] & (1 << B)) == 0) {
					B++;
				}
				sum += (bc[A].power + bc[B].power);

			}
		} else {

			sum += (bc[A].power + bc[B].power);

		}
		
		System.out.println("A : " + A + " power " + bc[A].power + " B : " + B + " power" + bc[B].power + " sum :  " + sum);
	}

}
