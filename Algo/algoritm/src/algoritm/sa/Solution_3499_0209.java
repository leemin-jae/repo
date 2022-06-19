package algoritm.sa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3499_0209 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			int len = Integer.parseInt(br.readLine());
			int a = len / 2;
			if (len % 2 == 1)
				a += 1;
			//System.out.println("LEN , A " + len + " " + a);
			String[] first = new String[a];
			String[] second = new String[len - a];

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < first.length; i++) {
				if (st.hasMoreTokens()) {
					first[i] = st.nextToken();
				}
			}
			for (int i = 0; i < second.length; i++) {
				if (st.hasMoreTokens()) {
					second[i] = st.nextToken();
				}
			}

			int check = 0;
			System.out.print("#" + tc + " " );
			while (true) {
					System.out.print(first[check] + " ");
					System.out.print(second[check] + " ");
				check++;
				if (check == second.length)
					break;
			}
			
			if(len%2 == 1) System.out.print(first[len/2] + " ");
			System.out.println();

		}
	}

}
