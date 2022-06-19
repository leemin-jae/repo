package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_19238_0322 {
	static int N, M, F, x, y;
	static boolean Map[][];
	static int checkMap[][];
	static int  end[][], delta[][] = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	static class Node implements Comparable<Node> {
		int r;
		int w;
		int f;

		Node(int r, int w, int f) {
			this.r = r;
			this.w = w;
			this.f = f;
		}

		@Override
		public int compareTo(Node o) {
			if (this.f != o.f) {
				return this.f - o.f;
			} else {
				if (this.r != o.r) {
					return this.r - o.r;
				} else {
					return this.w - o.w;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		
		Map = new boolean[N + 1][N + 1];
		checkMap = new int[N + 1][N + 1];
		end = new int[M + 1][2];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				if (st.nextToken().equals("1")) {
					Map[i][j] = true;
				}
			}
		}
		st = new StringTokenizer(br.readLine());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			checkMap[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = i;
			end[i][0] = Integer.parseInt(st.nextToken());
			end[i][1] = Integer.parseInt(st.nextToken());
		}

		// -------------------------------------------------------------------------------------------------------------

		for (int i = 0; i < M; i++) {
			bfs_start(x, y);
			bfs_end(x, y);
		}

		System.out.println(F);

	}

	public static void bfs_start(int r, int w) {
		if (F < 0)
			return;

		boolean[][] check = copy();
		Queue<Node> que = new LinkedList<>();
		PriorityQueue<Node> pq = new PriorityQueue<Node>();

		check[r][w] = true;
		que.add(new Node(r, w, 0));
		if (checkMap[r][w] != 0) {
			pq.add(new Node(r, w, 0));
		}

		while (!que.isEmpty()) {
			Node current = que.poll();

			if (checkMap[current.r][current.w] != 0 && current.f <= F) {
				pq.add(new Node(current.r, current.w, current.f));
			}
			if (current.f > F) {
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nextX = current.r + delta[i][0];
				int nextY = current.w + delta[i][1];

				if (nextX < 1 || nextX > N || nextY < 1 || nextY > N || check[nextX][nextY])
					continue;
				check[nextX][nextY] = true;
				que.add(new Node(nextX, nextY, current.f + 1));

			}
		}
		// System.out.println("------------------");
		if (!pq.isEmpty()) {
			Node now = pq.poll();
			x = now.r;
			y = now.w;
			F -= now.f;
		} else {
			F = -1;
		}
	}

	public static void bfs_end(int r, int w) {
		if (F < 0)
			return;
		boolean[][] check = copy();
		Queue<int[]> que = new LinkedList<>();
		
		boolean flag = false;

		int num = checkMap[r][w];
		checkMap[r][w] = 0;

		check[r][w] = true;
		que.add(new int[] { r, w, 0 });

		int arrive_r = end[num][0];
		int arrive_w = end[num][1];

		while (!que.isEmpty()) {
			int current[] = que.poll();

			if (current[0] == arrive_r && current[1] == arrive_w && current[2] <= F) {
				x = current[0];
				y = current[1];
				F += current[2];
				flag = true;
				break;
			}
			if (current[2] > F) {
				F = -1;
				flag = true;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nextX = current[0] + delta[i][0];
				int nextY = current[1] + delta[i][1];

				if (nextX < 1 || nextX > N || nextY < 1 || nextY > N || check[nextX][nextY])
					continue;
				check[nextX][nextY] = true;
				que.add(new int[] { nextX, nextY, current[2] + 1 });

			}

		}
		
		if(!flag) {
			F = -1;
		}

	}

	public static boolean[][] copy() {
		boolean[][] cop = new boolean[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (Map[i][j]) {
					cop[i][j] = true;
				}
			}
		}

		return cop;
	}
}
