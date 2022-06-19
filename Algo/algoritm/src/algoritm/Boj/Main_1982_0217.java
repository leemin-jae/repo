package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1982_0217 {
	static char Map[][];
	static int delta[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	static int R, C, max;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		System.out.println(((int)'A' - 65));
//		System.out.println(((int)'Z' -65));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		max = Integer.MIN_VALUE;
		Map = new char[R][];

		for (int i = 0; i < R; i++) {
			Map[i] = br.readLine().toCharArray();
		}

//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(Map[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		search(0,0,0,0);
		System.out.println(max);
	}

	public static void search(int x, int y ,int cnt, int flag) {
		
		int alpa = (int)Map[x][y] -'A';
		
		if((flag & (1 << alpa)) != 0) {
			max = Math.max(max, cnt);

			return;
		}
		
		flag = (flag | (1 << alpa));
		
		int nextX;
		int nextY;
		for(int i = 0 ; i < delta.length ; i++) {
			nextX = x + delta[i][0];
			nextY = y + delta[i][1];
			
			if(nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) continue;
			search(nextX, nextY ,cnt+1, flag);
		}
		
	}
}
