package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_0401 {
	static int N, M , Min;
	static char Map[][];
	static int delta[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	static class Node {
		int x;
		int y;
		int cnt;
		int key;

		Node(int x, int y, int cnt, int key) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key;
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		Min = Integer.MAX_VALUE;
		Map = new char[N][M];
		int start_x = 0;
		int start_y = 0;
		for (int i = 0; i < N; i++) {
			String now = br.readLine();
			for (int j = 0; j < M; j++) {
				Map[i][j] = now.charAt(j);
				if (Map[i][j] == '0') {
					start_x = i;
					start_y = j;
					Map[i][j] = '.';
				}
			}
		}
		
		
		bfs(start_x,start_y);
		
		if(Min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		
	}

	static public void bfs(int x, int y) {

		boolean check[][][] = new boolean[N][M][2 << 6];
		Queue<Node> que = new LinkedList<>();

		que.add(new Node(x, y, 0, 0));
		check[x][y][0] = true;

		while (!que.isEmpty()) {
			Node current = que.poll();
			
			if(Map[current.x][current.y] == '1') {
				Min = Math.min(Min, current.cnt);
				System.out.println(Min);
				return;
			}
			
			for (int i = 0; i < 4; i++) {
				int nextX = current.x + delta[i][0];
				int nextY = current.y + delta[i][1];
				
				if (nextX >= 0 && nextX < N && nextY >= 0 & nextY < M && !check[nextX][nextY][current.key] && Map[nextX][nextY] != '#') {
					if (Map[nextX][nextY] - 97 >= 0 && Map[nextX][nextY] - 97 < 6) {
						if((current.key & 1 << Map[nextX][nextY] - 97) == 0) {
							que.add(new Node(nextX , nextY , current.cnt+1 , (current.key | 1 << Map[nextX][nextY] - 97)));
							check[nextX][nextY][(current.key | 1 << Map[nextX][nextY] - 97)] = true;
						}else {
							que.add(new Node(nextX , nextY , current.cnt+1 , current.key));
							check[nextX][nextY][current.key] = true;
						}
					} else if (Map[nextX][nextY] - 65 >= 0 && Map[nextX][nextY] - 65 < 6) {
						if((current.key & 1 << Map[nextX][nextY] - 65) != 0) {
							que.add(new Node(nextX , nextY , current.cnt+1 , current.key));
							check[nextX][nextY][current.key] = true;
						}
					} else{
						que.add(new Node(nextX , nextY , current.cnt+1 , current.key));
						check[nextX][nextY][current.key] = true;
					}
				}
			}
		}
	}

}
