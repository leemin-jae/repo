package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260_0221 {
	static int N, M , V;
	static int graph[][];
	static int check[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a][b] = 1;
			graph[b][a] = 1;
		}
		
		DFS(V, new boolean[N+1]);
		System.out.println();
		
		BFS(V);
	}

	public static void DFS(int start, boolean checked[]) {
		System.out.print(start + " ");
		checked[start] = true;
		
		for(int i = 1 ; i <= N ; i ++) {
			if(graph[start][i] == 1 && checked[i] != true) {
				DFS(i,checked);
			}
		}
		
	}
	
	public static void BFS(int start ) {
		
		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[N+1];
		
		queue.offer(start);
		visited[start] = true;

		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.print(current + " ");
			
			for (int j = 1; j <= N; j++) {
				if(!visited[j] && graph[current][j] > 0) {
					queue.offer(j);
					visited[j] = true;
				}
			}
			
			
		}
		
	}
}
