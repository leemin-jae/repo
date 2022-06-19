package algoritm.sa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8458_0411 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			int n = Integer.parseInt(br.readLine());

			int dot[] = new int[n];
			int Max = Integer.MIN_VALUE;
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				dot[i] = Math.abs(Integer.parseInt(st.nextToken())) +Math.abs(Integer.parseInt(st.nextToken()));
				Max = Math.max(Max, dot[i]);
			}

			int check = dot[0] % 2;
			boolean flag = false;
			for (int i = 1; i < n; i++) {
				if (dot[i] % 2 != check) {
					flag = true;
					break;
				}
			}

			if (flag) {
				System.out.println("#" + tc + " " + -1);
			} else {
				int i = 0;
				int sum = 0;
				while (true) {
					if (Max <= sum && sum % 2 == check) {
						System.out.println("#" + tc + " " + i);
						break;
					}
					i++;
					sum += i;
				}

			}

		}
	}

}
