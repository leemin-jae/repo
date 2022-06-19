package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import algoritm.Boj.Main_19238_0322.Node;

public class Main_17142_0323 {
	static int N, M , full , min;
	static int Map[][];
	static int number[];
	static ArrayList<int[]> list = new ArrayList<>();
	static int delta[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Map = new int[N][N];
		number = new int[M];
		full = N*N;
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
				if(Map[i][j] == 1) {
					full --;
				}
				if (Map[i][j] == 2) {
					list.add(new int[] { i, j });
					full--;
				}
			}
		}

		select(0, 0);
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}

	}

	static public void select(int start, int cnt) {
		if (cnt == M) {
			bfs(number);
			return;

		}

		for (int i = start; i < list.size(); i++) {
			number[cnt] = i;
			select(i + 1, cnt + 1);
		}

	}

	static public void bfs(int[] number) {
		boolean check[][] = new boolean[N][N];
		Queue<int[]> que = new LinkedList<>();
		
		int sum = full;
		int max = Integer.MIN_VALUE;
		for (int i : number) {
			int start[] = list.get(i);
			que.add(new int[] { start[0], start[1], 0 });
			check[start[0]][start[1]] = true;
		}

		while (!que.isEmpty()) {
			int[] current = que.poll();
			if(Map[current[0]][current[1]] != 2) {
				sum--;
			}
			if(sum == 0) {
				min = Math.min(min, current[2]);
				return;
			}
			max = Math.max(max, current[2]);
			for (int i = 0; i < 4; i++) {
				int nextX = current[0] + delta[i][0];
				int nextY = current[1] + delta[i][1];

				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= N || check[nextX][nextY] || Map[nextX][nextY] == 1)
					continue;
				check[nextX][nextY] = true;
				que.add(new int[] { nextX, nextY, current[2] + 1 });

			}
		}
		

		
	}
}
