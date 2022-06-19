package algoritm.Boj;

import java.util.Scanner;

public class Main_2563_0210 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int x,y;
		
		int Map[][] = new int[100][100];
		
		for (int tc = 0; tc < T; tc++) {
			
			x = sc.nextInt();
			y = sc.nextInt();

			for(int i = x;  i < x+10; i ++) {
				for(int j = y; j <y+10; j ++) {
					Map[i][j] = 1;
				}
			}
			
		}
		
		int cnt = 0;
		
		for(int i =0 ; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(Map[i][j] == 1) cnt++;	
			}
		}
		
		System.out.println(cnt);

		
	}

}
