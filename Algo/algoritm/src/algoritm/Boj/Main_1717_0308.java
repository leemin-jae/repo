package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1717_0308 {
	static int N , M;
	static int parents[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		makeSet();
		
		for(int i = 0 ; i < M ; i ++) {
			st = new StringTokenizer(br.readLine());
			if(st.nextToken().equals("0")) {
				unionSet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}else {
				sb.append(findUnionSet(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()))).append("\n");
			}
			
			
		}
		
		System.out.println(sb);
	}
	
	static public void makeSet() {
		parents = new int[N+1];
		for(int i = 1; i <= N ; i ++) {
			parents[i] = i;
		}
	}
	
	static public int findSet(int a) {
		if(parents[a] == a) return a;
		return parents[a] = findSet(parents[a]);
	}
	static public String findUnionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) {
			return "YES";
			
		}
		return "NO";
	}
	static public boolean unionSet(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
}
