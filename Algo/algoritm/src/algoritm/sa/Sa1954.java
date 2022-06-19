package algoritm.sa;

import java.util.Scanner;

public class Sa1954 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[][] delta = {{0,1},{1,0},{0,-1},{-1,0}};
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T ; tc++) {
			
			int N = sc.nextInt();
			
			int Map[][] = new int[N][N];
			boolean check[][] = new boolean[N][N];
			int x = 0;
			int y = 0;
			int del = 0;
			int del_x = 0;
			int del_y = 0;
			
			for(int i = 1; i <= N*N ; i++) {
				//System.out.println(x + " " + y);
				Map[x][y] = i;
				check[x][y] = true;
				
				del_x = x;
				del_y = y;
				
				x = x+delta[del][0];
				y = y+delta[del][1];
				
				//System.out.println(del + " " + delta[del][0] + " " + delta[del][1]);
				
				if(x < 0 || x == N || y < 0 || y == N || check[x][y] == true) {
					del += 1;
					if(del == 4) del = 0;
					x = del_x+delta[del][0];
					y = del_y+delta[del][1];
				}
//				if(check[x][y] == true) {
//					del += 1;
//					if(del == 4) del = 0;
//					x = del_x+delta[del][0];
//					y = del_y+delta[del][1];
//				}
//				
			}
			
			System.out.println("#"+ tc);
			for(int i =0; i < N; i++) {
				for(int j = 0 ; j < N; j++) {
					System.out.print(Map[i][j] + " ");
				}
				System.out.println();
			}
			
		}
	}

}
