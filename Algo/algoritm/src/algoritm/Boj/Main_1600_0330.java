package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_0330 {
	static int K, N, M , Min;
	static int[][] Map;
	static int delta[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int delta_h[][] = { { -1, -2 }, { -2, -1 }, { 1, 2 }, { 2, 1 },{-2,1},{-1,2},{2,-1},{1,-2} };
	//static int delta_h[][] = {{ 1, 2 }, { 2, 1 }};
	static boolean check[][][];

	static class Node
	{
		int x;
		int y;
		int cnt;
		int jump;
		
		public Node(int x, int y, int cnt, int jump) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.jump = jump;
		}
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		Map = new int[N][M];
		check = new boolean[N][M][K+1];
		Min = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs(0,0);
		if(Min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(Min);
		}
		

	}
	static public void bfs(int x, int y) {
		Queue<Node> que = new LinkedList<>();
		que.add(new Node(x,y,0,0));
		check[0][0][0] = true;
		
		while(!que.isEmpty()) {
			Node current = que.poll();
			if(current.x == N-1 && current.y == M-1) { 
				Min = Math.min(Min, current.cnt);
				break;
			}
			
			if(current.jump <K) {
				for (int i = 0; i < delta_h.length; i++) {
					int nextX = current.x + delta_h[i][0];
					int nextY = current.y + delta_h[i][1];
					if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || check[nextX][nextY][current.jump+1] || Map[nextX][nextY] == 1) 
						continue;
					check[nextX][nextY][current.jump+1] = true;
					que.add(new Node (nextX,nextY,current.cnt+1,current.jump+1));
				}
				
			}
			
			for (int i = 0; i < 4; i++) {
				int nextX = current.x + delta[i][0];
				int nextY = current.y + delta[i][1];
				if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || check[nextX][nextY][current.jump] || Map[nextX][nextY] == 1) 
					continue;
				
				check[nextX][nextY][current.jump] = true;
				que.add(new Node(nextX,nextY,current.cnt+1,current.jump));
				
			}
		}
		
	}

}
