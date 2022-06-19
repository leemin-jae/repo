import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 
5
0 5 10 8 7 
5 0 5 3 6 
10 5 0 1 3 
8 3 1 0 1 
7 6 3 1 0

output==>10

7
0 32 31 0 0 60 51
32 0 21 0 0 0 0
31 21 0 0 46 0 25
0 0 0 0 34 18 0
0 0 46 34 0 40 51
60 0 0 18 40 0 0
51 0 25 0 51 0 0

output==>175
 * 
 */


public class MST2_PrimTest_0223 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N =  Integer.parseInt(in.readLine());
		
		int[][] adjMatrix = new int[N][N];
		int[] minEdge = new int[N];
		boolean[] visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			
			minEdge[i] = Integer.MAX_VALUE;
		}
		
		int result = 0;
		minEdge[0] = 0;
		
		for(int c = 0 ; c < N ; c++) {
			
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			
			for (int i = 0; i < N; i++) {
				if(!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			
			//선택된 정점을 신장트리에 포함
			visited[minVertex] = true;
			result += min;
			
			//선택된 정점 기준으로 신장트리에 포함되지 않은 다른 정점으로의 간선비용을 따져보고 최소값 갱신
			for (int i = 0; i < N; i++) {
				if(!visited[i] && adjMatrix[minVertex][i] != 0 &&  minEdge[i] > adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
					System.out.println(Arrays.toString(minEdge));
				}
			
			}
			
			
		}
		
		System.out.println(result);
	}

}
