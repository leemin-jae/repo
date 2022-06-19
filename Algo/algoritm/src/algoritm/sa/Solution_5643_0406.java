package algoritm.sa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_5643_0406 {
	static final int INF = 9999;
	static int N, M, adjMatrix[][];

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());

			adjMatrix = new int[N + 1][N + 1];

			for (int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine());

				adjMatrix[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;

			}

			for (int i = 1; i <= N; ++i) {
				for (int j = 1; j <= N; ++j) {
					if (i != j && adjMatrix[i][j] == 0) {// 자기자신으로의 인접 정보가 아니고 인접해있지 않다면 INF로 채우기
						adjMatrix[i][j] = INF;
					}
				}
			}

			for (int k = 1; k <= N; ++k) {
				for (int i = 1; i <= N; ++i) {
					if (i == k)
						continue; // 출발지와 경유지가 같다면 다음 출발지
					for (int j = 1; j <= N; ++j) {
						if (i == j || k == j)
							continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
						// 간선이 양수이면...
						if (adjMatrix[i][j] > adjMatrix[i][k] + adjMatrix[k][j]) {
							adjMatrix[i][j] = adjMatrix[i][k] + adjMatrix[k][j];
						}
					}
				}
			}

//			
//			for(int i=1; i<=N; ++i) {
//				for(int j=1; j<=N; ++j) {
//					System.out.print(adjMatrix[i][j]+"\t");
//				}
//				System.out.println();
//			}
//			System.out.println("=====================================");
//			

			int cnt[] = new int[N + 1];

			for (int i = 1; i <= N; ++i) {
				for (int j = 1; j <= N; ++j) {
					if(adjMatrix[i][j] < 1000 &&  adjMatrix[i][j] != 0) {
						cnt[j]++;
						cnt[i]++;
					}
				}
			}
			
			
			
			int sum = 0;
			
			for(int i = 1; i <= N; i++) {
				if(cnt[i] == N-1) sum++;
				//System.out.print(cnt[i] + " ");
			}
			
			System.out.println("#" + tc + " " + sum);

		}

	}

}
