package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_0303 {
	static int N, M , max;
	static int Map[][];
	static boolean check[][];
	static int delta[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static ArrayList<int[]> array = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Map = new int[N][M];
		check = new boolean[N][M];
		max = Integer.MIN_VALUE;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
				if (Map[i][j] != 0)
					check[i][j] = true;;
				if (Map[i][j] == 2)
					array.add(new int[] { i, j });
			}
		}
		
		find(0);
		
		System.out.println(max);
	}

	static public void find(int cnt) {
		if (cnt == 3) {
			max = Math.max(max,bfs());
			return;
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!check[i][j]) {
					check[i][j] = true;
					find(cnt + 1);
					check[i][j] = false;
				}
			}
		}

	}

	static public int bfs() {
		
		boolean [][] check_copy = new boolean[N][M];
		int sum = 0;
		
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				check_copy[i][j] = check[i][j];
			}
		}
		
		Queue<int[]> que = new LinkedList<>();
		for (int[] i : array) {
			que.add(i);
		}

		while (!que.isEmpty()) {
			int[] next = que.poll();
			int x = next[0];
			int y = next[1];
			
			for(int i = 0 ; i < 4 ; i ++) {
				int nextX = x + delta[i][0];
				int nextY = y + delta[i][1];
				
				if(nextX  < 0 || nextX >= N || nextY < 0 || nextY >= M || check_copy[nextX][nextY]) continue;
				check_copy[nextX][nextY] = true;
				que.add(new int[] {nextX, nextY});
			}
			
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < M ; j++) {
				if(!check_copy[i][j]) sum++;
			}
		}
		
		return sum;
	}
}
