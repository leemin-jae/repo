package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471_0406 {
	static int N,min;
	static int people[], Map[][];
	static boolean num[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		people = new int[N + 1];
		Map = new int[N + 1][N + 1];
		num = new boolean[N + 1];
		min = Integer.MAX_VALUE;
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int now = Integer.parseInt(st.nextToken());
			for (int j = 0; j < now; j++) {
				Map[i][Integer.parseInt(st.nextToken())] = 1;
			}
		}

		for (int i = 1; i <= N / 2; i++) {
			cal(1, 0, i);
		}
		System.out.println(min == Integer.MAX_VALUE? -1 : min);

	}

	static void cal(int start, int cnt, int k) {
		if (cnt == k) {
			if (check(num)) {
				int sum = 0;
				for (int i = 1; i <= N; i++) {
					if (num[i])
						sum += people[i];
					else
						sum -= people[i];
				}
				
				min = Math.min(min, Math.abs(sum));


			}
			
			
			return;
		}

		for (int i = start; i <= N; i++) {
			num[i] = true;
			cal(i + 1, cnt + 1, k);
			num[i] = false;
		}
	}

	static boolean check(boolean[] is) {
		boolean[] one = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			if (is[i]) {

				Queue<Integer> que = new LinkedList<>();
				one[i] = true;
				que.add(i);

				while (!que.isEmpty()) {
					int now = que.poll();

					for (int k = 1; k <= N; k++) {

						if (Map[now][k] != 0 && !one[k] && is[k]) {
							que.add(k);
							one[k] = true;
						}

					}

				}
				break;
			}
		}

		for (int i = 1; i <= N; i++) {
			if (!is[i]) {

				Queue<Integer> que = new LinkedList<>();
				one[i] = true;
				que.add(i);

				while (!que.isEmpty()) {
					int now = que.poll();

					for (int k = 1; k <= N; k++) {

						if (Map[now][k] != 0 && !one[k] && !is[k]) {
							que.add(k);
							one[k] = true;
						}

					}

				}
				break;
			}
		}

		for (int i = 1; i <= N; i++) {
			if (!one[i])
				return false;
		}
		return true;

	}
}
