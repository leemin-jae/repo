package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_20056_0320 {
	static int N, M, K;
	static ArrayList<int[]> list = new ArrayList<>();
	static int delta[][] = { { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 }, { -1, -1 } };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			list.add(new int[] { Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1,
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()) });
		}

		for (int i = 0; i < K; i++) {
			fire();
		}

		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i)[2];
		}

		System.out.println(sum);

	}

	public static void fire() {

		boolean Map[][] = new boolean[N][N];
		boolean check_Map[][] = new boolean[N][N];

		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < list.size(); i++) {
			q.add(list.get(i));
		}

		list.clear();

		while (!q.isEmpty()) {
			int[] current = q.poll();
			int x = current[0];
			int y = current[1];
			int weight = current[2];
			int speed = current[3];
			int del = current[4];

			int nextX = (x + (delta[del][0] * speed)) >= 0 ? (x + (delta[del][0] * speed)) % N
					: (N + (x + (delta[del][0] * speed)) % N)%N;
			int nextY = (y + (delta[del][1] * speed)) >= 0 ? (y + (delta[del][1] * speed)) % N
					: (N + (y + (delta[del][1] * speed)) % N )%N;
			if (!Map[nextX][nextY]) {
				Map[nextX][nextY] = true;
			} else {
				check_Map[nextX][nextY] = true;
			}

			list.add(new int[] { nextX, nextY, weight, speed, del });
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (check_Map[i][j]) {
					change(i, j);
				}
			}
		}

	}

	static public void change(int x, int y) {
		int size = list.size();
		int num = 0;
		int w = 0;
		int s = 0;
		int odd = 0;
		for (int i = size - 1; i >= 0; i--) {
			int[] current = list.get(i);
			if (current[0] == x && current[1] == y) {
				num++;
				w += current[2];
				s += current[3];
				odd += current[4] % 2;
				list.remove(i);
			}
		}
		if (w / 5 == 0)
			return;
		if (odd == 0 || odd == num) {
			for (int i = 0; i < 8; i += 2) {
				list.add(new int[] { x, y, w / 5, s / num, i });
			}
		} else {
			for (int i = 1; i < 8; i += 2) {
				list.add(new int[] { x, y, w / 5, s / num, i });
			}
		}

	}
}
