package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_12100_0310 {
	static int N;
	static int M[][];
	static int Max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		M = new int[N][N];
		Max = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				M[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i = 0 ; i < 4; i ++) {
			check(i,0,M);
		}



		System.out.println(Max);
	}

	public static void check(int r, int cnt, int Map[][]) {
		if (cnt == 5)
			return;

		int copy[][] = array_copy(Map);

		switch (r) {
		case 0:
			up(copy);
			break;
		case 1:
			down(copy);
			break;
		case 2:
			left(copy);
			break;
		case 3:
			right(copy);
			break;
		}

		Max = Math.max(Max, array_Max(copy));

		for (int i = 0; i < 4; i++) {
			check(i, cnt + 1, copy);
		}

	}

	public static int[][] array_copy(int Map[][]) {
		int copy[][] = new int[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				copy[i][j] = Map[i][j];
			}
		}
		return copy;
	}

	public static int array_Max(int Map[][]) {
		int max = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				max = Math.max(max, Map[i][j]);
			}
		}

		return max;
	}

	public static void up(int Map[][]) {

		Stack<Integer> s = new Stack<>();

		for (int j = 0; j < N; j++) {
			for (int i = N - 1; i >= 0; i--) {
				if (Map[i][j] != 0) {
					s.push(Map[i][j]);
					Map[i][j] = 0;
				}

			}

			int i = 0;
			while (!s.isEmpty()) {
				int current = s.pop();
				if (s.isEmpty()) {
					Map[i++][j] = current;
					break;
				}
				int now = s.peek();

				if (current == now) {
					Map[i++][j] = current * 2;
					s.pop();
				} else {
					Map[i++][j] = current;
				}
			}

		}
	}

	public static void down(int Map[][]) {
		Stack<Integer> s = new Stack<>();

		for (int j = 0; j < N; j++) {
			for (int i = 0; i < N; i++) {
				if (Map[i][j] != 0) {
					s.push(Map[i][j]);
					Map[i][j] = 0;
				}

			}

			int in = N - 1;
			while (!s.isEmpty()) {
				int current = s.pop();
				if (s.isEmpty()) {
					Map[in--][j] = current;
					break;
				}
				int now = s.peek();

				if (current == now) {
					Map[in--][j] = current * 2;
					s.pop();
				} else {
					Map[in--][j] = current;
				}
			}

		}

	}

	public static void right(int Map[][]) {
		Stack<Integer> s = new Stack<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (Map[i][j] != 0) {
					s.push(Map[i][j]);
					Map[i][j] = 0;
				}

			}

			int in = N - 1;
			while (!s.isEmpty()) {
				int current = s.pop();
				if (s.isEmpty()) {
					Map[i][in--] = current;
					break;
				}
				int now = s.peek();

				if (current == now) {
					Map[i][in--] = current * 2;
					s.pop();
				} else {
					Map[i][in--] = current;
				}
			}

		}

	}

	public static void left(int Map[][]) {
		Stack<Integer> s = new Stack<>();

		for (int i = 0; i < N; i++) {
			for (int j = N - 1; j >= 0; j--) {
				if (Map[i][j] != 0) {
					s.push(Map[i][j]);
					Map[i][j] = 0;
				}

			}

			int in = 0;
			while (!s.isEmpty()) {
				int current = s.pop();
				if (s.isEmpty()) {
					Map[i][in++] = current;
					break;
				}
				int now = s.peek();

				if (current == now) {
					Map[i][in++] = current * 2;
					s.pop();
				} else {
					Map[i][in++] = current;
				}
			}

		}
	}
}
