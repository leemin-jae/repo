package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_0302 {
	static int N, M, Min;
	static char Map[][];
	static boolean check[][];
	static int delta[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Min = 0;

		Map = new char[N + 1][M + 1];
		check = new boolean[N + 1][M + 1];
		String s = null;

		for (int i = 1; i <= N; i++) {
			s = br.readLine();
			for (int j = 1; j <= M; j++) {
				Map[i][j] = s.charAt(j-1);
			}
		}
		bfs();
//		check[1][1] = true;
//		dfs(1,1,0);
		System.out.println(Min+1);

	}
	public static void bfs() {

		Queue<int[]> que = new LinkedList<>();
		check[1][1] = true;
		que.add(new int[] {1,1,0});
		
		while(!que.isEmpty()) {
			int[] next = que.poll();
			int x = next[0];
			int y = next[1];
			Min = next[2];
			
			//System.out.println(x + " " + y + " " + Min);
			
			if(x == N && y == M) return;
			
			for(int i = 0 ; i < 4 ; i ++) {
				int nextX = x + delta[i][0];
				int nextY = y + delta[i][1];
				
				if(nextX  < 1 || nextX > N || nextY < 1 || nextY > M || Map[nextX][nextY] == '0' || check[nextX][nextY]) continue;
				check[nextX][nextY] = true;
				que.add(new int[] {nextX, nextY, Min+1});
			}
			
			
		}
		
		
	}
	public static void dfs(int x, int y,int cnt) {
		if(cnt > Min ) return;
		
		if(x == N && y == M) {
			if(Min > cnt) Min = cnt;
			return;
		}
		
		for(int i = 0 ; i < 4 ; i ++) {
			int nextX = x + delta[i][0];
			int nextY = y + delta[i][1];
			
			if(nextX  < 1 || nextX > N || nextY < 1 || nextY > M || Map[nextX][nextY] == '0' || check[nextX][nextY]) continue;
			check[nextX][nextY] = true;
			dfs(nextX , nextY, cnt+1);
			check[nextX][nextY] = false;
			
		}
	}
}
