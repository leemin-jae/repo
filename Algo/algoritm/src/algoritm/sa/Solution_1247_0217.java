package algoritm.sa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1247_0217 {
	static int N, min;
	static int number[], XY[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());

			XY = new int[N + 2][2];
			number = new int[N];
			min = Integer.MAX_VALUE;

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < XY.length; i++) {
				XY[i][0] = Integer.parseInt(st.nextToken());
				XY[i][1] = Integer.parseInt(st.nextToken());
			}

			per(0, new boolean[N + 2]);
			System.out.println("#" + tc + " " + min);
		}

	}

	public static void per(int cnt, boolean[] check) {
		if (cnt == N) {
			min = cal(number) < min ? cal(number) : min;
			return;
		}

		for (int i = 2; i < N + 2; i++) {
			if (check[i])
				continue;
			number[cnt] = i;
			check[i] = true;
			per(cnt + 1, check);
			check[i] = false;
		}
	}

	public static int cal(int num[]) {
		int len = 0;
		len += Math.abs(XY[0][0] - XY[num[0]][0]) + Math.abs(XY[0][1] - XY[num[0]][1]);
		len += Math.abs(XY[1][0] - XY[num[N - 1]][0]) + Math.abs(XY[1][1] - XY[num[N - 1]][1]);

		for (int i = 0; i < N - 1; i++) {
			len += Math.abs(XY[num[i]][0] - XY[num[i + 1]][0]) + Math.abs(XY[num[i]][1] - XY[num[i + 1]][1]);
		}
		return len;
	}

}
