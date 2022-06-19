package algoritm.sa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_0222 {
	static int N, M;
	static int[] parents;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb;
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb = new StringBuilder();
			sb.append("#").append(tc).append(" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			makeSet();
			
			for (int i = 0; i < M; i++) {
				

				st = new StringTokenizer(br.readLine());
				
				if(st.nextToken().equals("0")) {
					union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				}else {
					if(findSet(Integer.parseInt(st.nextToken())) == findSet(Integer.parseInt(st.nextToken()))) {
						sb.append("1");
					}else {
						sb.append("0");
					}
				}
			}
			
			System.out.println(sb);
			
		}
	}

	public static void makeSet() {
		parents = new int[N+1];
		//자신의 부모노드를 자신의 값으로 세팅
		for(int i = 0 ; i < N+1 ; i++) {
			parents[i] = i;
		}
	}
	
	public static int findSet(int a) {
		if(a == parents[a]) return a;
		return parents[a] = findSet(parents[a]);
	}
	
	public static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
		
	}
	
}
