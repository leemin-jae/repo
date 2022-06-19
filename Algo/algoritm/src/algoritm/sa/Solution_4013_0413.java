package algoritm.sa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_4013_0413 {
	static int K;
	static ArrayList<Integer> list[] = new ArrayList[4];
	static int delta[] = { 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		for (int tc = 1; tc <= T; tc++) {

			K = Integer.parseInt(br.readLine());

			for (int i = 0; i < 4; i++) {
				list[i] = new ArrayList<>();
				st = new StringTokenizer(br.readLine());
				while (st.hasMoreTokens()) {
					list[i].add(Integer.parseInt(st.nextToken()));
				}
			}
			
			
			for(int i = 0 ; i < K ; i ++) {
				st = new StringTokenizer(br.readLine());
				
				spin(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),new boolean[4]);
				
				
//				for(int j = 0 ;  j < 4;  j ++) {
//					for(int k : list[j]) {
//						System.out.print(k+ " ");
//					}System.out.println();
//				}
//				
			}
			
			int result = cal();
			
			System.out.println("#" + tc + " " + result);

		}
	}

	static public void spin(int num, int sp, boolean[] check) {
		int now = num - 1;

		if (check[now] == true) {
			return;
		}

		check[now] = true;

		// 2, 7

		for (int i = 0; i < 2; i++) {
			int next = now + delta[i];

			if (next >= 0 && next < 4 && !check[next]) {
				if (delta[i] == -1 && list[now].get(6) != list[next].get(2)) {
					spin(next+1 , sp*-1 , check);
				} else if (delta[i] == 1 && list[now].get(2) != list[next].get(6)) {
					spin(next+1 , sp*-1 , check);
				}
			}

		}
		
		if(sp == 1) {
			int ch = list[now].get(7);
			list[now].remove(7);
			list[now].add(0, ch);
		}else {
			int ch = list[now].get(0);
			list[now].remove(0);
			list[now].add(ch);
		}
		
	}
	static public int cal() {
		int sum = 0;
		int score = 1;
		for(int i = 0 ; i < 4 ; i++) {
			sum += list[i].get(0)*score;
			score = score*2;
		}
		return sum;
	}

}
