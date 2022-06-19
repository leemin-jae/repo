package algoritm.sa;

import java.util.Scanner;

public class Sa1873 {
	static int[][] delta = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static char[] look = { 'v', '^', '>', '<' };
	static char Map[][];
	static char st;

	static int x;
	static int y;

	static void move(int del) {
		st = look[del];
		Map[x][y] = st;
		int x_l = x + delta[del][0];
		int y_l = y + delta[del][1];

		// x_l >= 0 && x_l <Map.length && y_l >=0 && y_l < Map[0].length
	
		if (x_l >= 0 && x_l < Map.length && y_l >= 0 && y_l < Map[0].length && Map[x_l][y_l] == '.' ) {
			Map[x][y] = '.';
			Map[x_l][y_l] = st;
			x = x_l;
			y = y_l;
		} else {
			return;
		}
	}

	static void shot() {
		int del = 0;
		for (int i = 0; i < 4; i++) {
			if(look[i] == st) del = i;
		}
		int x_l = x + delta[del][0];
		int y_l = y + delta[del][1];
		int i = 1;
		while(true) {
			x_l = x + delta[del][0] * i;
			y_l = y + delta[del][1] * i;
			
			if(x_l < 0 || x_l >= Map.length || y_l <0 || y_l >=Map[0].length || Map[x_l][y_l] == '#') {
				break;
			}
			if(Map[x_l][y_l] == '*') {
				Map[x_l][y_l] = '.';
				break;
			}
			i+=1;
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int H = sc.nextInt();
			int W = sc.nextInt();

			sc.nextLine(); // 개행문자 제거용

			Map = new char[H][W];
			String s;

			for (int i = 0; i < H; i++) {
				s = sc.nextLine();
				for (int j = 0; j < s.length(); j++) {
					Map[i][j] = s.charAt(j);
					if (Map[i][j] == '<' || Map[i][j] == '^' || Map[i][j] == 'v' || Map[i][j] == '>') {
						st = Map[i][j];
						x = i;
						y = j;
					}
				}
			}

			int count = sc.nextInt();
			sc.nextLine();

			s = sc.nextLine();

			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'U')
					move(1);
				else if (s.charAt(i) == 'D')
					move(0);
				else if (s.charAt(i) == 'L')
					move(3);
				else if (s.charAt(i) == 'R')
					move(2);
				else {
					shot();
				}

			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < Map.length; i++) {
				for (int j = 0; j < Map[i].length; j++) {
					System.out.print(Map[i][j]);
				}
				System.out.println();
			}

		}
	}

}
