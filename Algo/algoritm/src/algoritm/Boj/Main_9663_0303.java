package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9663_0303 {
	static int N,cnt;
	static int queen[];

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		cnt = 0;
		queen = new int[N];
		nQueen(0);
		
		System.out.println(cnt);
	}

	static public void nQueen(int start) {
		if (start == N) {
			cnt++;
			return;
		}

		for (int i = 0; i < N; i++) {
			queen[start] = i;
			if (check(start)) {
				nQueen(start + 1);
			}
		}
	}

	static public boolean check(int end) {

		for (int i = 0; i < end; i++) {
			if (queen[i] == queen[end] || queen[end] == queen[i] + (end - i) || queen[end] == queen[i] - (end - i))
				return false;
		}
		return true;
	}
}
