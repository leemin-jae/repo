package algoritm.sa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9229_0208 {
	static int N, M;
	static int snak[];
	static int high;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			high = -1;

			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());

			snak = new int[N];
			int cnt = 0;
			while (st.hasMoreTokens()) {
				snak[cnt] = Integer.parseInt(st.nextToken());
				cnt++;
			}

			// check(0,0,0);

			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {

					if (snak[i] + snak[j] > high && snak[i] + snak[j] <= M) {
						high = snak[i] + snak[j];
					}

				}
			}
			if(high == 0) {
				System.out.println("#" + tc + " " + -1);
			}
			else{
				System.out.println("#" + tc + " " + high);
			}

		}
	}

	public static void check(int index, int w, int R) {

		if (R == 2) {
			if (w <= M && w >= high) {
				high = w;
			}
			return;
		}
		if (w > M || index + 1 == N) {
			return;
		}

		check(index + 1, w + snak[index], R + 1);
		check(index + 1, w, R);
	}

}
