package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20058_0325_none {
	static int N, Q;
	static int Map[][];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		Map = new int[8][8];
		for (int i = 0; i < 8; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 8; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		change(4,4,4);

	}

	static public void binary(int x, int y, int n, int order) { // (x,y,N)
		// 0-n/2 ; 0-n/2 1 4 4 (8-8, 8-8 , 8/2) (x-N , y-N , N/2)
		// 0 - n/2 , n/2 -n 2 4 8 (8-8,8 - 8/2, 8/2) (X-N, y - N/2 , N/2)
		// n/2 - n , 0-n/2 3 8 4 (8 - 8/2 ,8-8,8/2) (X-N/2 , y -N , N/2)
		// n/2 - n , n/2 - n 4 8 8 (8 - 8/2,8 - 8/2,8/2) (X-N/2 , y-N/2 , N/2)

		if (n == order) {

		}
		binary(x - n, y - n, n / 2, order);
		binary(x - n, y - n / 2, n / 2, order);
		binary(x - n / 2, y - n, n / 2, order);
		binary(x - n / 2, y - n / 2, n / 2, order);
	}

	static public void change(int x, int y, int n) {
		int stand_x = x + n / 2;
		int stand_y = y + n / 2;
		int now[][] = new int[8][8];
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (i < stand_x && j < stand_y) {
					now[j][n - (i + 1)] = Map[i][j];
				} else if (i >= stand_x && j < stand_y) {
					now[j][n - (i + 1)] = Map[i][j];
				} else if (i < stand_x && j >= stand_y) {
					now[j][n - (i + 1)] = Map[i][j];
				} else if (i >= stand_x && j >= stand_y) {
					now[j][n - (i + 1)] = Map[i][j];
				}
			}
		}
		
		for(int i[] : now) {
			for(int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
	
	static public void change2(int x, int y, int n) {
		int stand_x = x + n / 2;
		int stand_y = y + n / 2;
		int now[][] = new int[8][8];
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (i < stand_x && j < stand_y) {
					now[j][n - (i + 1)] = Map[i][j];
				} else if (i >= stand_x && j < stand_y) {
					now[j][n - (i + 1)] = Map[i][j];
				} else if (i < stand_x && j >= stand_y) {
					now[j][n - (i + 1)] = Map[i][j];
				} else if (i >= stand_x && j >= stand_y) {
					now[j][n - (i + 1)] = Map[i][j];
				}
			}
		}
		
		for(int i[] : now) {
			for(int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}
}
