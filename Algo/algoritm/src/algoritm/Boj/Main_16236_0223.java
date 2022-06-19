package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16236_0223 {
	static int N , Max;
	static int Map[][];
	static int nowX, nowY, nowSize;
	static int delta[][] = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

	static class Fish implements Comparable<Fish> {
		int x;
		int y;
		int size;

		Fish(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}

		@Override
		public int compareTo(Fish o) {
			// TODO Auto-generated method stub

			if (this.size == o.size) {
				if (this.x == o.x) {
					return this.y - o.y;
				} else {
					return this.x - o.x;
				}
			} else {
				return this.size - o.size;

			}
		}

		@Override
		public String toString() {
			return "Fish [x=" + x + ", y=" + y + ", size=" + size + "]";
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		Map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
				if (Map[i][j] == 9) {
					nowX = i;
					nowY = j;
					nowSize = 2;
					Map[i][j] = 0;
				}
			}
		}
		
		int cnt = 0;
		Max = 0;
		while(true) {
			
			if(!bfs(nowX,nowY)) {
				break;
			}
			
			cnt++;
			
			if(cnt == nowSize) {
				nowSize++;
				cnt = 0;
			}
		}
		System.out.println(Max);
		

	}

	public static boolean bfs(int r, int w) {
		boolean[][] check = new boolean[N][N];
		Queue<int[]> q = new LinkedList<>();
		
		PriorityQueue<Fish> pq = new PriorityQueue<Fish>();
		
		q.add(new int[] { r, w, 0 });
		check[r][w] = true;

		while (!q.isEmpty()) {
			int current[] = q.poll();
			int x = current[0];
			int y = current[1];
			int len = current[2];

			for (int i = 0; i < 4; i++) {
				int nextX = x + delta[i][0];
				int nextY = y + delta[i][1];

				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N || Map[nextX][nextY] > nowSize
						|| check[nextX][nextY])
					continue;
				check[nextX][nextY] = true;
				q.add(new int[] { nextX, nextY, len + 1 });
				if(Map[nextX][nextY] < nowSize && Map[nextX][nextY] != 0) {
					pq.add(new Fish(nextX,nextY,len+1));
				}

			}

		}
		
		if(!pq.isEmpty()) {
			Fish f = pq.poll();

			nowX = f.x;
			nowY = f.y;
			Max += f.size;
			Map[nowX][nowY] = 0;
			return true;
		}else {
			return false;
		}

	}
}
