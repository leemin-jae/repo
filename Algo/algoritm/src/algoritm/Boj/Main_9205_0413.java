package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205_0413 {
	static int N ,x, y;
	static int Map[][];
	static boolean check[] , flag;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			flag = false;
			Map = new int[N+2][2];
			check = new boolean[N+2];
			st = new StringTokenizer(br.readLine());
			Map[0][0] = Integer.parseInt(st.nextToken());
			Map[0][1] = Integer.parseInt(st.nextToken());
			for(int i = 1; i <=N; i++) {
				st = new StringTokenizer(br.readLine());
				Map[i][0] = Integer.parseInt(st.nextToken());
				Map[i][1] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			Map[N+1][0] = Integer.parseInt(st.nextToken());
			Map[N+1][1] = Integer.parseInt(st.nextToken());
			
//			
//			if(Map[N+1][0] - Map[0][0] < 0) x = -1;
//			else x = 1;
//			
//			if(Map[N+1][1] - Map[0][0] < 1) y = -1;
//			else y = 1;
			
//			dfs(0);
			bfs(0);
			
			if(flag) {
				System.out.println("happy");
			}else {
				System.out.println("sad");
			}
			
		}
			
	}
	static public void bfs(int now) {
		Queue<Integer> que = new LinkedList<>();
		check[now] = true;
		
		que.add(now);
		
		while(!que.isEmpty()) {
			
			int current = que.poll();
			if(current == N+1) {
				flag = true;
				break;
			}
			
			for(int i = 0 ; i <= N+1 ; i++) {
				int distance = Math.abs(Map[current][0] - Map[i][0]) + Math.abs(Map[current][1] - Map[i][1]);
				
				if(distance <= 1000 && !check[i]) {
					check[i] = true;
					que.add(i);
				}
			}
			
			
			
		}
		
		
	}
	static public void dfs(int now) {
		if(flag) {
			return;
		}
		if(now == N+1) {
			flag = true;
			return;
		}
		
		check[now] = true;
		
		for(int i = 0 ; i <= N+1 ; i++) {
			int lx = Map[i][0] - Map[now][0];
			int ly = Map[i][1] - Map[now][1];
			
			if(lx*x < 0 && ly*y <0) continue;
			
			int distance = Math.abs(Map[now][0] - Map[i][0]) + Math.abs(Map[now][1] - Map[i][1]);
			
			if(distance <= 1000 && !check[i]) {
				check[i] = true;
				dfs(i);
				check[i] = false;
			}
			
			
		}
		
		
		
		
	}

}
