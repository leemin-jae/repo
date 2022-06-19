package algoritm.sa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1233_0210_none {
	static int node_N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		List<String> list = new LinkedList<>();

		for (int tc = 1; tc <= 10; tc++) {

			node_N = Integer.parseInt(br.readLine());

			for (int i = 1; i <= node_N; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				list.add(st.nextToken());

			}

			
			
			
			
			for (Iterator iterator = list.iterator(); iterator.hasNext();) {
				String string = (String) iterator.next();
				System.out.println(string);

			}

		}

	}
	
	static public void dfs(int current) {
		
		if(current > node_N) return;
		
		
		dfs(current*2);
		dfs(current*2+1);

		
	}

}
