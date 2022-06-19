import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest1 {
/*
 * 
 * 5
0 2 2 5 9
2 0 3 4 8
2 3 0 7 6
5 4 7 0 5
9 8 6 5 0

output==> 8


6
0 3 5 0 0 0
0 0 2 6 0 0
0 1 0 4 6 0
0 0 0 0 2 3
3 0 0 0 0 6
0 0 0 0 0 0

output==> 12


10
0 4 6 0 0 0 0 0 0 0
0 0 0 9 8 0 0 0 0 0
0 3 0 0 2 3 0 0 0 0
0 0 0 0 0 0 6 0 0 0
0 0 0 2 0 1 3 7 0 0 
0 0 0 0 0 0 0 4 8 0
0 0 0 0 0 0 0 0 0 13
0 0 0 0 0 0 0 0 0 9
0 0 0 0 0 0 0 0 0 4
0 0 0 0 0 0 0 0 0 0


output ==> 21

============= 인접리스트 테스트케이스 
10 17
0 1 4
0 2 6
1 3 9
1 4 8
2 1 3
2 4 2
2 5 3
3 6 6
4 3 2
4 5 1
4 6 3
4 7 7
5 7 4
5 8 8
6 9 13
7 9 9
8 9 4

output ==> 21
 * */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(br.readLine());

		int[][] adjMatrix = new int[V][V];
		int start = 0;

		StringTokenizer st = null;

		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());

			}
		}

		int[] distance = new int[V];
		boolean[] visited = new boolean[V];

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0; // 시작점 0

		for (int i = 0; i < V; i++) {
			// 최소비용 확정되지 않은 정점중 최소비용의 정점 선택
			int min = Integer.MAX_VALUE, current = 0;
			for (int j = 0; j < V; j++) {
				if (!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}

			visited[current] = true;
 // 선택된 정점을 경유지로 하여 아직 초소비용이 결정되지 않은 다른 정점의 최소비용을 고려
			for (int j = 0; j < V; j++) {
				if (!visited[j] && adjMatrix[current][j] != 0
						&& distance[j] > distance[current] + adjMatrix[current][j]) {
					distance[j] = distance[current] + adjMatrix[current][j];
				}
			}

		}
		
		System.out.println(Arrays.toString(distance));

	}

}
