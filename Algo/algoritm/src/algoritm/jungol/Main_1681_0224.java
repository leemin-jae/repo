package algoritm.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1681_0224 {
	static int N;
	static int Map[][], numbers[];
	static boolean check[];
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		Map = new int[N][N];
		//numbers = new int[N];
		check = new boolean[N];
		min = Integer.MAX_VALUE;
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		check[0] = true;
		dfs(0, check, 0, 0);
		System.out.println(min);

	}

	static public void dfs(int start, boolean[] isSelected, int sum, int cnt) {
		if (sum > min)
			return;

		if (cnt == N - 1) {
			if (Map[start][0] > 0) {
				//numbers[cnt] = 0;
				sum += Map[start][0];
				min = min > sum ? sum : min;
//				System.out.println(sum + " " + cnt);
//				System.out.println(Arrays.toString(numbers));
				return;
			}else {
				return;
			}
		}

		for (int i = 0; i < N; i++) {
			if (!isSelected[i] && Map[start][i] > 0) {
				isSelected[i] = true;
				//numbers[cnt] = i;
				dfs(i, isSelected, sum + Map[start][i], cnt + 1);
				isSelected[i] = false;
			}
		}

	}
}
