package algoritm.sa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5656_0405 {
//	static ArrayList<Integer> list[];
	// static boolean[][] check;
	static int N, W, H, Map[][],Sum;
	static int delta[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

//			list = new ArrayList[W];
//			for(int i = 0 ; i < W ; i ++) {
//				list[i] = new ArrayList<Integer>();
//			}
			Map = new int[H][W];
			Sum = 99999999;
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
//					list[i].add(Integer.parseInt(st.nextToken()));
					Map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
//			bomb(2 ,Map);
//			bomb(2 ,Map);
//			
//			for (int i = 0; i < H; i++) {
//			
//						for (int j = 0; j < W; j++) {
//							System.out.print(Map[i][j]);
//							System.out.print(" ");
//						}
//						System.out.println();
//					}
					
			
			all_bomb(0, Map);
			System.out.println("#" + tc + " " + Sum);
		}

	}

	public static void all_bomb(int cnt, int Map[][]) {
		if (cnt == N) {
			int sum = 0;
			for (int i = 0; i < H; i++) {

				for (int j = 0; j < W; j++) {
					if(Map[i][j] != 0) sum++;
				}
			}
			Sum = Math.min(sum, Sum);
			
//			if(Sum > sum) {
//				Sum = sum;
//				System.out.println(sum);
//				
//				
//				for (int i = 0; i < H; i++) {
//
//					for (int j = 0; j < W; j++) {
//						System.out.print(Map[i][j]);
//						System.out.print(" ");
//					}
//					System.out.println();
//				}
//				
//				
//			}
			return;
		}
		
		for (int i = 0; i < W; i++) {
			int[][] copy = copy(Map);
			bomb(i, copy);
			all_bomb(cnt + 1, copy);
		}

	}

	public static int[][] copy(int[][] Map) {
		int[][] Map_copy = new int[H][W];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				Map_copy[i][j] = Map[i][j];
			}
		}
		return Map_copy;

	}

	public static void bomb(int start, int Map[][]) {

		int first = -1;
		boolean[][] check = new boolean[H][W];
		for (int i = 0; i < H; i++) {
			if (Map[i][start] != 0) {
				first = i;
				break;
			}
		}

		if (first == -1)
			return;

		/////////////////////////////////////////////////////////////////

		// System.out.println(list[start].get(first));

		second(first, start, check, Map);

		for (int i = 0; i < H; i++) {

			for (int j = 0; j < W; j++) {
				if (check[i][j]) {
					Map[i][j] = 0;
				}
			}

		}

//		for (int i = 0; i < H; i++) {
//
//			for (int j = 0; j < W; j++) {
//				System.out.print(Map[i][j]);
//				System.out.print(" ");
//			}
//			System.out.println();
//		}
//		

		List<Integer> list = new ArrayList<>();
		int[][] Map_copy = new int[H][W];
		for (int i = 0; i < W; i++) {
			for (int j = H - 1; j >= 0; j--) {
				if (Map[j][i] != 0) {
					list.add(Map[j][i]);
				}
			}

			for (int j = 1; j <= list.size(); j++) {
				Map_copy[H - j][i] = list.get(j - 1);
			}
			list.clear();
		}
		
		for (int i = 0; i < W; i++) {
			for (int j = H - 1; j >= 0; j--) {
				Map[j][i] = Map_copy[j][i];
			}
		}

		//Map = Map_copy;

//		for (int i = 0; i < H; i++) {
//
//			for (int j = 0; j < W; j++) {
//				System.out.print(Map_copy[i][j]);
//				System.out.print(" ");
//			}
//			System.out.println();
//		}
//		

	}

	public static void second(int x, int y, boolean[][] check, int Map[][]) {
		check[x][y] = true;

		if (Map[x][y] == 1) {
			return;
		}

		for (int i = 0; i < 4; i++) {
			int nextX = x;
			int nextY = y;

			for (int j = 0; j < Map[x][y] - 1; j++) {
				nextX += delta[i][0];
				nextY += delta[i][1];

				if (nextX < 0 || nextX >= H || nextY < 0 || nextY >= W || check[nextX][nextY] || Map[nextX][nextY] == 0)
					continue;
				second(nextX, nextY, check, Map);

			}
		}

	}

}
