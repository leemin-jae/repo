package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1992_0216 {
	static String map[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		map = new String[N][N];

		for (int i = 0; i < N; i++) {
			map[i] = br.readLine().split("");
		}

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
//		System.out.print("(");
		tree(0,0,N);
//		System.out.print(")");
		
	}

	static void tree(int x, int y, int N) {

		String check = map[x][y];
		if(N == 1) {
			System.out.print(check);
			return;
		}
		
		boolean next = false;
		for (int i = x; i < x+N; i++) {
			for (int j = y; j < y+N; j++) {
				if (!map[i][j].equals(check)) {
					next = true;
					break;
				}
			}
		}
		if(next) {
			System.out.print("(");
			tree(x,y,N/2);          // 첫번째 
			tree(x,y+N/2,N/2);        // 두번째
			tree(x+N/2,y,N/2);
			tree(x+N/2,y+N/2,N/2);
			System.out.print(")");
		}else {
			System.out.print(check);
		}

		

	}

}
