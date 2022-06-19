package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17406_2011 {
	static int delta[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static int N, M, R;
	static String Map[][];
	static int order[][];
	static int numbers[];
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		Map = new String[N + 1][M + 1];
		order = new int[R][3];
		numbers = new int[R];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 1; j <= M; j++) {
				Map[i][j] = st.nextToken();
			}

		}

		for (int tc = 0; tc < R; tc++) {
			st = new StringTokenizer(br.readLine());
			order[tc][0] = Integer.parseInt(st.nextToken());
			order[tc][1] = Integer.parseInt(st.nextToken());
			order[tc][2] = Integer.parseInt(st.nextToken());

			// rotation(r, c, s);
		}

/////////////////////////////////////////////////////////////////////////

		d(0, new boolean[R]);
		
		System.out.println(min);

	}

	public static void d(int cnt, boolean[] isSelected) {
		if (cnt == R) {
			String[][] ch  = new String[N+1][M+1];
			int sum;
			
			for(int i = 1 ; i <= N; i++) {
				for (int j = 1; j <= M; j++) {
					ch[i][j] = Map[i][j];
				}
			}
			
			for (int i = 0; i < numbers.length; i++) {
				ch = rotation(order[numbers[i]][0], order[numbers[i]][1], order[numbers[i]][2], ch);
			}
			
			
			
			for(int i = 1 ; i <= N; i++) {
				sum = 0;
				for (int j = 1; j <= M; j++) {
					sum +=Integer.parseInt(ch[i][j]);
				}
				if(sum <min) {
					min = sum;
				}
			}
			
			
			
			return;
		}

		for (int i = 0; i < R; i++) {
			if (isSelected[i])
				continue;

			numbers[cnt] = i;
			isSelected[i] = true;

			d(cnt + 1, isSelected);

			isSelected[i] = false;
		}
	}

	
	
	
	static String[][] rotation(int r, int c, int s, String[][] map) {

		Queue<String> que = new LinkedList<>();
		int x = r - s;
		int y = c - s;
		int x_next;
		int y_next;

		for (int re = 0; re < s; re++) {
			que.clear();
			x = r - s + re;
			y = c - s + re;

			int cnt = 0;
			while (true) {

				que.add(map[x][y]);
				x_next = x + delta[cnt][0];
				y_next = y + delta[cnt][1];

				if (x_next < r - s + re || x_next > r + s - re || y_next < c - s + re || y_next > c + s - re) {
					cnt = (cnt + 1) % 4;
					x_next = x + delta[cnt][0];
					y_next = y + delta[cnt][1];
				}
				x = x_next;
				y = y_next;

				if (x == r - s + re && y == c - s + re)
					break;

			}

			que.add(que.poll());
			cnt = 0;
			while (true) {

				map[x][y] = que.poll();
				x_next = x + delta[cnt][0];
				y_next = y + delta[cnt][1];

				if (x_next < r - s + re || x_next > r + s - re || y_next < c - s + re || y_next > c + s - re) {
					cnt = (cnt + 1) % 4;
					x_next = x + delta[cnt][0];
					y_next = y + delta[cnt][1];

				}

				x = x_next;
				y = y_next;

				if (x == r - s + re && y == c - s + re)
					break;
			}
		}
		return map;

	}

}
