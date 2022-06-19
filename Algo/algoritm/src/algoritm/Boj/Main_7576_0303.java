package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_0303 {
	static int N, M , max, cnt;
	static int Map[][];
	static boolean check[][];
	static int delta[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Map = new int[M][N];
		check = new boolean[M][N];
		Queue<int[]> que = new LinkedList<>();
		cnt = M*N;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());

				if (Map[i][j] == -1) {
					check[i][j] = true;
					cnt--;
				}
				
				if (Map[i][j] == 1) {
					check[i][j] = true;
					que.add(new int[] { i, j, 0 });
				}
			}
		}
		max = 0;
		while (!que.isEmpty()) {
			cnt--;
			int[] next = que.poll();
			int x = next[0];
			int y = next[1];
			max = Math.max(max, next[2]);
			
			for(int i = 0 ; i < 4; i ++) {
				int nextX = x + delta[i][0];
				int nextY = y + delta[i][1];
				
				if(nextX < 0 || nextY < 0 || nextX >=M|| nextY >=N || check[nextX][nextY]) continue;
				
				check[nextX][nextY] = true;
				que.add(new int[] { nextX, nextY , next[2]+1});
				
				
			}
		}

		System.out.println(cnt == 0 ? max : "-1");

	}

}
