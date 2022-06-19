package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14499_0308 {
	static int N, M, X, Y, K, Max;
	static int Map[][];
	static int delta[][] = {{},{0,1},{0,-1},{-1,0},{1,0}};
	static class Node {
		int top;
		int bot;
		int front;
		int back;
		int right;
		int left;

		public void next(int x) {
			int temp = bot;
			int nextX = X + delta[x][0];
			int nextY = Y + delta[x][1];
			if(nextX < 0 || nextY <0 || nextX >= N || nextY >= M) return;
			
			X = nextX;
			Y = nextY;
			
			if (x == 1) {
				bot = right;
				right = top;
				top = left;
				left = temp;
			}
			if (x == 2) {
				bot = left;
				left = top;
				top = right;
				right = temp;
			}
			if (x == 3) {
				bot = back;
				back = top;
				top = front;
				front = temp;
			}
			if (x == 4) {
				bot = front;
				front = top;
				top = back;
				back = temp;
			}
			
			if(Map[X][Y] == 0) {
				Map[X][Y] = bot;
			}else {
				bot = Map[X][Y];
				Map[X][Y] = 0;
			}
			
//			System.out.println(this.toString());
//			
//			for(int i = 0 ; i < N ; i ++) {
//				for(int j = 0 ; j < M ; j ++) {
//					System.out.print(Map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			
			
			System.out.println(top );
		}

		@Override
		public String toString() {
			return "Node [top=" + top + ", bot=" + bot + ", front=" + front + ", back=" + back + ", right=" + right
					+ ", left=" + left + "]" + X +" " + Y;
		}
		
		
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Map = new int[N][M];
		Node current = new Node();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		while(st.hasMoreTokens()) {
			current.next(Integer.parseInt(st.nextToken()));
		}

	}

}
