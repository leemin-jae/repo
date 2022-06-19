package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17144_0330 {
	static int N, M, T;
	static int Map[][];
	static int delta[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	static List<Integer> stand = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		Map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				Map[i][j] = Integer.parseInt(st.nextToken());
				if (Map[i][j] == -1) {
					stand.add(i);
				}
			}
		}

		for (int k = 0; k < T; k++) {
			first();

			//second(stand.get(0), stand.get(1));
			operate();
		}

		int sum = 0;

		for (int i[] : Map) {
			for (int j : i) {
				sum += j;
			}
		}

		System.out.println(sum+2);

	}

	public static void first() {

		int copy_Map[][] = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (Map[i][j] > 0) {
					int cnt = 0;
					int cul = Math.round(Map[i][j] / 5);
					for (int k = 0; k < 4; k++) {
						int x = i + delta[k][0];
						int y = j + delta[k][1];
						if (x < 0 || x >= N || y < 0 || y >= M || Map[x][y] == -1)
							continue;
						cnt++;
						copy_Map[x][y] = copy_Map[x][y] + cul;
					}
					copy_Map[i][j] = Map[i][j] - cul * cnt + copy_Map[i][j];
				}
			}
		}

		Map = copy_Map;
		Map[stand.get(0)][0] = -1;
		Map[stand.get(1)][0] = -1;
	}
private static void operate() {
        
        int top = stand.get(0);
        int down = stand.get(1);
        
        for (int i = top - 1; i > 0; i--) 
            Map[i][0] = Map[i-1][0];

        for (int i = 0; i < M - 1; i++) 
        	Map[0][i] = Map[0][i+1];

        for (int i = 0; i < top; i++) 
        	Map[i][M - 1] = Map[i + 1][M - 1];
 
        for (int i = M - 1; i > 1; i--) 
        	Map[top][i] = Map[top][i-1];

        Map[top][1] = 0;
        

        for (int i = down + 1; i < N - 1; i++) 
        	Map[i][0] = Map[i + 1][0];

        for (int i = 0; i < M - 1; i++) 
        	Map[N - 1][i] = Map[N - 1][i + 1]; 
        
        for (int i = N - 1; i > down; i--) 
        	Map[i][M - 1] = Map[i - 1][M - 1];
        
        for (int i = M - 1; i > 1; i--) 
        	Map[down][i] = Map[down][i - 1];

        Map[down][1] = 0;
    }
	public static void second(int one, int two) {
		int copy_Map[][] = new int[N][M];

		int x = one;
		int y = 0;
		// que.add(Map[x][y]);
		int delta_one[][] = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
		int d = 0;
		while (true) {
			int nextX = x + delta_one[d][0];
			int nextY = y + delta_one[d][1];

			if (nextX < 0 || nextX > one || nextY < 0 || nextY >= M) {
				d = (d + 1) % 4;
				nextX = x + delta_one[d][0];
				nextY = y + delta_one[d][1];
			}

			if (Map[nextX][nextY] == 0) {
				copy_Map[x][y] = -2;
			} else {
				copy_Map[x][y] = Map[nextX][nextY];
			}
			if (Map[nextX][nextY] == -1) {
				break;
			}
			x = nextX;
			y = nextY;
		}
		copy_Map[one][0] = -1;
		copy_Map[one][1] = -2;

		//////////////////////////////////////////////////////////////
		x = two;
		y = 0;
		// que.add(Map[x][y]);
		int delta_two[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		d = 0;
		while (true) {
			int nextX = x + delta_two[d][0];
			int nextY = y + delta_two[d][1];

			if (nextX < two || nextX >= N || nextY < 0 || nextY >= N) {
				d = (d + 1) % 4;
				nextX = x + delta_two[d][0];
				nextY = y + delta_two[d][1];
			}
			if (Map[nextX][nextY] == 0) {
				copy_Map[x][y] = -2;
			} else {
				copy_Map[x][y] = Map[nextX][nextY];
			}
			if (Map[nextX][nextY] == -1) {
				break;
			}
			x = nextX;
			y = nextY;

		}
		copy_Map[two][0] = -1;
		copy_Map[two][1] = -2;
		
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < M ; j++) {
				if(copy_Map[i][j] == 0) {
					continue;
				}else if(copy_Map[i][j] == -2) {
					Map[i][j] = 0;
				}else {
					Map[i][j] =copy_Map[i][j];
				}
			}
		}
	}

}
