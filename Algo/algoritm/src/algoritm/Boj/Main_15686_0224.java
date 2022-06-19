package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_15686_0224 {
	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;

		}

		public int getDis(Node n) {
			return Math.abs(this.x - n.x) + Math.abs(this.y - n.y);
		}

	}
	static int N, M;
	static int[][] Map;
	static ArrayList<Node> h = new ArrayList<>();
	static ArrayList<Node> c = new ArrayList<>();
	static ArrayList<Node> s = new ArrayList<>();

	static int min;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		min = Integer.MAX_VALUE;
		Map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());

				if (Map[i][j] == 1)
					h.add(new Node(i, j)); // 집정보 받아두기
				else if (Map[i][j] == 2)
					c.add(new Node(i, j)); // 치킨 정보 받아두기
			}

		}

		combi(0, 0);

		System.out.println(min);

	}

	private static void combi(int start, int cnt) {
		if (M == cnt) {
			int dis = distance();
			min = Math.min(dis, min);
			return;
		}

		for (int i = start; i < c.size(); i++) {
			s.add(c.get(i));
			combi(i + 1, cnt + 1);
			s.remove(s.size() - 1);
		}

	}

	private static int distance() {
		int sum = 0;
		for (Node current : h) {
			int m = Integer.MAX_VALUE;
			for (Node select : s) {
				m = Math.min(m, select.getDis(current));
			}
			sum += m;
		}
		return sum;
	}
}
