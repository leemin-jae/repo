package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_21610_0321 {
	static int N, M, K;
	static int Map[][];
	static ArrayList<int[]> list = new ArrayList<>();

	static int delta[][] = { {}, { 0, -1 }, { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 } };

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		Map = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int order[][] = new int[M][2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			order[i][0] = Integer.parseInt(st.nextToken());
			order[i][1] = Integer.parseInt(st.nextToken());
		}

		list.add(new int[] { N, 1 });
		list.add(new int[] { N, 2 });
		list.add(new int[] { N - 1, 1 });
		list.add(new int[] { N - 1, 2 });

		for (int i = 0; i < M; i++) {
			cloud(order[i][0], order[i][1]);
			copyWater();
//			for(int[] k  : list) {
//				System.out.println(k[0] + " " + k[1]);
//			}
//			System.out.println(list.size());
//			System.out.println("----------------------");
		}
		
		int sum = 0 ;
		for (int i = 1; i <=N; i++) {
			for (int j = 1; j <= N; j++) {
				sum+= Map[i][j];
			}
		}
		System.out.println(sum);
	}

	public static void cloud(int d, int s) {
		for (int i = 0; i < list.size(); i++) {
			int[] current = list.get(i);
			int x = current[0];
			int y = current[1];

			int checkX = (x + (delta[d][0] * s)) % N;
			int nextX = checkX;
			//>= 0 ? (x + (delta[d][0] * s)) % N : (N + (x + (delta[d][0] * s)) % N) % N;
			if(checkX == 0) {
				nextX = N;
			}else if(checkX < 0) {
				nextX = N + checkX;
			}
			
			int checkY = (y + (delta[d][1] * s)) % N;
			int nextY = checkY;
			//>= 0 ? (x + (delta[d][0] * s)) % N : (N + (x + (delta[d][0] * s)) % N) % N;
			if(checkY == 0) {
				nextY = N;
			}else if(checkY < 0) {
				nextY = N + checkY;
			}
			
			
			
			list.set(i, new int[] { nextX, nextY });
			Map[nextX][nextY] += 1;
		}
	}

	public static void copyWater() {
		int del[][] = { { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };
		boolean check[][] = new boolean[N+1][N+1];
		
		for (int i = 0; i < list.size(); i++) {
			int[] current = list.get(i);
			int x = current[0];
			int y = current[1];
			check[x][y] = true;
			
			int sum = 0;
			for (int j = 0; j < 4; j++) {
				int nextX = x + del[j][0];
				int nextY = y + del[j][1];
				if (nextX < 1 || nextX > N || nextY < 1 || nextY > N || Map[nextX][nextY] == 0)
					continue;
				sum += 1;
			}
			Map[x][y] += sum;
		}
		
		list.clear();
		
		for(int i = 1 ; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(Map[i][j] >= 2 && !check[i][j]) {
					list.add(new int[] {i,j});
					Map[i][j] -= 2;
				}
			}
		}

	}

}
