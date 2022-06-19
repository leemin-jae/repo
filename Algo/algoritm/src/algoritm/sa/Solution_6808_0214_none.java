package algoritm.sa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_6808_0214_none {
	static int[] number = new int[10];
	//static boolean check[] = new boolean[19];
	static boolean[] check;
	static boolean[] isboolean[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc <= T; tc++) {
			int bit = 0;
			st = new StringTokenizer(br.readLine());

			while (st.hasMoreTokens()) {

				check[Integer.parseInt(st.nextToken())] = true;
				System.out.println(1);
			}
			System.out.println(Arrays.toString(number));
			perm(0, check);

		}
	}

	static void perm(int a, boolean[] check) {
		if (a == 8) {
			System.out.println(Arrays.toString(number));
			return;
		}
		System.out.println(2);
		for (int i = 1; i <= 18; i++) {
			System.out.println("3");
			if (check[i] == true)
				continue;
			number[a] = i;
			check[i] = true;
			perm(a + 1, check);
			check[i] = false;
			System.out.println(1);

		}

	}

}
