package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_10814_0304 {
	static int N;

	static class Node implements Comparable<Node> {
		int age;
		String name;
		int sep;

		Node(int age, String name, int sep) {
			this.age = age;
			this.name = name;
			this.sep = sep;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.age == o.age ? this.sep - o.sep : this.age - o.age;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());

		PriorityQueue<Node> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			pq.add(new Node(Integer.parseInt(st.nextToken()), st.nextToken(),i));
		}

		while (!pq.isEmpty()) {
			Node a = pq.poll();
			System.out.println(a.age + " " + a.name);
		}

	}

}
