package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_0330 {
	static int N, Q;
	static int Map[][];
	static int delta[][] = {{1,0},{0,1},{-1,0},{0,-1}};
	//static boolean check[][];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		Map = new int[N][Q];
		//check = new boolean[N][Q];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < Q; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int cnt = 0;
		int now = count();
		while(now != 0) {
		
			bfs();
			
			cnt++;
			
			int check = count();
			if(check == 0) {
				break;
			}else {
				now = check;
			}
			
		}
		
		System.out.println(cnt + "\n" + now);
	}
	
	public static void bfs() {
		Queue<int []> que = new LinkedList<>();
		boolean [][]check = new boolean[N][Q];
		
		check[0][0] = true;
		que.add(new int[] {0,0});
		
		while(!que.isEmpty()) {
			int current[] = que.poll();
			
			for(int i = 0 ; i < 4; i ++) {
				int x = current[0] + delta[i][0];
				int y = current[1] + delta[i][1];
				
				if(x <0 || x >= N || y < 0 || y >= Q || Map[x][y] == 1 || check[x][y]) continue;
				check[x][y] = true;
				que.add(new int[] {x,y});
			}
		}
		
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < Q ; j ++) {
				if(Map[i][j] == 1) {
					for(int k = 0 ; k < 4; k ++) {
						int x = i + delta[k][0];
						int y = j + delta[k][1];
						if(check[x][y]) {
							Map[i][j] = 0;
							break;
						}
					}
				}
			}
		}
		
		
		
	}
	
	public static int count() {
		int sum = 0;
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < Q ; j ++) {
				if(Map[i][j] == 1) {
					sum ++;
				}
			}
		}
		
		return sum;
	}

}
