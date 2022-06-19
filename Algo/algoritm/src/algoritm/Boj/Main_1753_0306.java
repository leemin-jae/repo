package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1753_0306 {
	static int V, E;
	static int Nodes[][];

	static class Node {
		int vertex;
		int weight;
		Node link;

		public Node(int vertex, Node link, int weight) {
			this.vertex = vertex;
			this.link = link;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Node [vertex=" + vertex + ", weight=" + weight + ", link=" + link + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		Node[] adjList = new Node[V + 1];

		int start = Integer.parseInt(br.readLine());	

		// Nodes = new int[V + 1][V + 1];

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adjList[from] = new Node(to, adjList[from], w);
		}

//		for (Node head : adjList) {
//			System.out.println(head);
//		}

		//bfs(adjList, start);

		int[] distance = new int[V+1];
		boolean[] visited = new boolean[V+1];
		
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;
		
		for(int i = 0 ; i < V ; i ++) {
			
			int min = Integer.MAX_VALUE , current = 0;
			for (int j = 0; j < V; j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			
			visited[current] = true;
			
			
			for (Node temp = adjList[current]; temp != null; temp = temp.link) {
				if (!visited[temp.vertex] && distance[temp.vertex] > distance[current] + temp.weight ) {
					distance[temp.vertex] = distance[current] + temp.weight;
				}
			}
			
		}
		
		for(int i = 1 ; i <= V ; i++) {
			if(distance[i] == Integer.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);
			}
		}
		
		
		
	}

	public static void bfs(Node[] adjList, int start) {
		int[] w = new int[V + 1];
		for (int i = 0; i < w.length; i++) {
			w[i] = 99999999;
		}

		Queue<Integer> queue = new LinkedList<>();

		queue.add(start);
		w[start] = 0;

		while (!queue.isEmpty()) {
			int current = queue.poll();

			for (Node temp = adjList[current]; temp != null; temp = temp.link) {
				if (w[temp.vertex] > w[current] + temp.weight) {
					w[temp.vertex] = w[current] + temp.weight;
					queue.offer(temp.vertex);
				}
			}

		}

		for (int i = 1; i < w.length; i++) {
			if (w[i] == 99999999) {
				System.out.println("INF");
			} else {
				System.out.println(w[i]);
			}
		}

	}

	public static void search(int start) {
		int[] w = new int[V + 1];
		for (int i = 0; i < w.length; i++) {
			w[i] = 99999999;
		}
		Queue<Integer> queue = new LinkedList<>();

		queue.add(start);
		w[start] = 0;
		while (!queue.isEmpty()) {
			int s = queue.poll();

			for (int i = 1; i < w.length; i++) {
				if (Nodes[s][i] > 0) {
					w[i] = w[i] > w[s] + Nodes[s][i] ? w[s] + Nodes[s][i] : w[i];
					queue.add(i);
				}
			}

		}

		for (int i = 1; i < w.length; i++) {
			if (w[i] == 99999999) {
				System.out.println("INF");
			} else {
				System.out.println(w[i]);
			}
		}

	}

}
