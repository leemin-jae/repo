package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2667_0302 {
	static int N , Min;
	static char Map[][];
	static boolean check[][];
	static int delta[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		N = Integer.parseInt(br.readLine());
		Map = new char[N][N];
		check = new boolean[N][N];
		
		String s = null;

		for (int i = 0; i < N; i++) {
			s = br.readLine();
			for (int j = 0; j < N; j++) {
				Map[i][j] = s.charAt(j);
				if(Map[i][j] == '0') {
					check[i][j] = true;
				}
			}
		}
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(!check[i][j] && Map[i][j] == '1') {
					Min = 1;
					dfs(i,j);
					pq.add(Min);
				}
			}
		}
		
		System.out.println(pq.size());
		while(!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
	}
	static public void dfs(int x , int y ) {
		check[x][y] = true;
		
		
		for(int i = 0 ; i < 4 ; i ++) {
			int nextX = x + delta[i][0];
			int nextY = y + delta[i][1];
			
			if(nextX  < 0 || nextX >= N || nextY < 0 || nextY >= N || Map[nextX][nextY] == '0' || check[nextX][nextY]) continue;
			check[nextX][nextY] = true;
			Min++;
			dfs(nextX , nextY);
			
		}
	}

}
