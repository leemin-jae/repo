package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2252_0418 {
	static int N, M;
	static int adj[];
	static boolean check[];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		adj = new int[N + 1];
		check = new boolean[N + 1];
		for (int i = 0; i <= N; i++) {
			adj[i] = i;
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adj[to] = from;
		}

		for (int i = 1; i <= N; i++) {
			print(i);
		}
//		boolean check[] = new boolean[N + 1];
//		int k = 0;
//		while (k != N) {
//			k++;
//			for (int i = 1; i <= N; i++) {
//				if(check[i]) continue;
//				int sum = 0;
//				for (int j = 1; j <= N; j++) {
//					if (adj[j][i] == 1 && !check[j]) {
//						sum += adj[j][i];
//						break;
//					}
//				}
//				if (sum == 0) {
//					System.out.print (i + " ");
//					check[i] = true;
//				}
//			}
//		}

	}

	static public void print(int now) {
		if (adj[now] == now) {
			if (!check[adj[now]]) {
				System.out.print(now + " ");
				check[now] = true;
			} else {
				return;
			}
		} else {
			if (check[adj[now]]) {
				if (!check[now]) {
					System.out.print(now + " ");
					check[now] = true;
				}
			} else {
				print(adj[now]);
				if (!check[now]) {
					System.out.print(now + " ");
					check[now] = true;
				}
			}
		}
	}

}
