package algoritm.sa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_키순서1_BFS {
	static int[][] adjMartrix;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <=TC; tc++) {
			N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());
			
			adjMartrix = new int[N+1][N+1];
			
			StringTokenizer st =  null;
			
			int a, b;
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				adjMartrix[a][b] = 1;
				
			}
			
			int answer = 0;
			
			
			for(int i = 1; i <= N ;i ++) {
				if(gtBFS(i, new boolean[N+1]) + ltBFS(i, new boolean[N+1]) == N-1) ++answer;
			}
			
			System.out.println("#" + tc + " " + answer);
			
			
			
			
		}
	}
	
	static int gtBFS(int start, boolean[] visited) {
		
		int cnt = 0;
		Queue<Integer> que = new LinkedList<>();
		visited[start] = true;
		que.add(start);
		
		while(!que.isEmpty()) {
			
			int cur = que.poll();
			
			for( int i = 0 ; i < N; i++) {
				if(adjMartrix[cur][i] != 0 && !visited[i]) {
					++cnt;
					visited[i] = true;
					que.add(i);
					
				}
			}
		}
		return cnt;
		
	}
	static int ltBFS(int start, boolean[] visited) {
		int cnt = 0;
		Queue<Integer> que = new LinkedList<>();
		visited[start] = true;
		que.add(start);
		
		while(!que.isEmpty()) {
			
			int cur = que.poll();
			
			for( int i = 0 ; i < N; i++) {
				if(adjMartrix[i][cur] != 0 && !visited[i]) {
					++cnt;
					visited[i] = true;
					que.add(i);
					
				}
			}
		}
		return cnt;
		
	}

}
