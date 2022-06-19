package algoritm.sa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1238_0221 {
	static int N, M, V;
	static int graph[][];
	static int check[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int tc = 1; tc <= 10; tc++) {

			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			V = Integer.parseInt(st.nextToken());
			graph = new int[101][101];
			check = new int[101];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N / 2; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a][b] = 1;
			}
			
			System.out.println("#" + tc + " " +BFS(V));
			
	
		}
				
	}

	public static int BFS(int start) {

		Queue<Integer> queue = new LinkedList<>();
		boolean[] visited = new boolean[101];
		int level = 1;
		queue.offer(start);
		visited[start] = true;
		check[start] = level;
		
		
		while (!queue.isEmpty()) {
			int current = queue.poll();
			//System.out.print(current + " ");

			for (int j = 1; j <= 100; j++) {
				if (!visited[j] && graph[current][j] > 0) {
					queue.offer(j);
					visited[j] = true;
					check[j] = check[current] + 1;
					level = Math.max(level, check[j]);
				}
			}

		}
		
		int max = 0;
		for (int i = 1; i <= 100; i++) {
			if(check[i] == level) {
				max = i;
				//System.out.println(max);
			}
			
		}
		
		return max;

	}
}
