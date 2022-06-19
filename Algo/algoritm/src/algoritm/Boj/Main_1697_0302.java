package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697_0302 {
	static int N, K;
	static boolean check[] = new boolean[300000];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		if (K < N) {
			System.out.println(N - K);
		} else {
			bfs(N);
		}
	}

	public static void bfs(int x) {
		Queue<int[]> que = new LinkedList<>();
		check[x] = true;
		que.add(new int[] { x, 0 });

		while (!que.isEmpty()) {
			int now[] = que.poll();
			// System.out.println(now[0]);

			if (now[0] == K) {
				System.out.println(now[1]);
				return;
			}

			if (now[0] * 2 < K * 2 && !check[now[0] * 2]) {
				que.add(new int[] { now[0] * 2, now[1] + 1 });
				check[now[0] * 2] = true;
			}
			if (!check[now[0] + 1]) {
				que.add(new int[] { now[0] + 1, now[1] + 1 });
				check[now[0] + 1] = true;
			}
			if (now[0] - 1 >= 0 && !check[now[0] - 1]) {
				que.add(new int[] { now[0] - 1, now[1] + 1 });
				check[now[0] - 1] = true;
			}

		}
	}

}
