package algoritm.sa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210_0209 {
	static int[][] delta = { { -1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		String[][] map = new String[100][100];
		


		
		for (int tc = 1; tc <= 10; tc++) {
			
			int x = 99, y = 0;
			br.readLine();

			for (int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 100; j++) {
					map[i][j] = st.nextToken();
				}
			}


			for (int i = 0; i <= 99; i++) {
				if(map[99][i].equals("2")) {
					y = i;
				}
			}
			

			
			
			while(true) {
				x = x + delta[0][0];
				
				if(y+1 < 100 && map[x][y+1].equals("1")) {
					while(true) {
						if(y >= 100 || map[x][y].equals("0")) break;
						y++;
					}
					y--;
					
				}else if(y-1 >= 0  && map[x][y-1].equals("1")) {
					while(true) {
						if(y < 0 || map[x][y].equals("0")) break;
						y--;
					}
					y++;
				}
				
				
				if(x == 0) {
					break;
				}
				
			}
			
			
			
			
//				if (roal == 1)
//					break;
//				if (map[99][i].equals("2")) {
//					System.out.println("y : " + i);
//					y = i;
//					while (true) {
//						x = x - delta[0][0];
//						// System.out.println(x);
//						if (x == 0) {
//							System.out.println(x +  " " + y);
//							roal = 1;
//							start = y;
//							break;
//						}
//						// System.out.println(x);
//						if (y + delta[1][1] >= 0 && y + delta[1][1] < 100 && map[x][y + delta[1][1]].equals("1")) {
//							while (y + delta[1][1] >= 0 && y + delta[1][1] < 100
//									&& map[x][y + delta[1][1]].equals("1")) {
//								y = y + delta[1][1];
//							}
//							y -= delta[1][1];
//						} else if (y + delta[2][1] < 100 && y + delta[2][1] >= 0 && map[x][y + delta[2][1]].equals("1")) {
//							while (y + delta[2][1] < 100 && y + delta[2][1] >= 0
//									&& map[x][y + delta[2][1]].equals("1")) {
//								y = y + delta[2][1];
//							}
//							y -= delta[2][1];
//
//						};
//					}
				

			System.out.println("#" + tc + " " + y);

		}
	}

}
