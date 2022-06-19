package algoritm.sa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607_0411 {
	static long f[];
	static int m = 1234567891;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st = null;

		f = new long[1000000 + 1];
		f[0] = 1;
		for (int i = 1; i <= 1000000; i++)
			f[i] = (f[i - 1] * i) % m;

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			int n = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());

			long top = f[n] % m;
			long bottom = ((f[n - r] % m) * (f[r] % m)) % m;

			long moveToTop = powCalc(bottom, m - 2);

			System.out.println("#" + tc + " " + ((top * moveToTop) % m));

		}
	}

	static long powCalc(long num, int p) {
		if (p == 0)
			return 1;

		long half = powCalc(num, p / 2);

		if (p % 2 == 0) {
			return ((half % m) * (half % m)) % m;
		} else
			return (((half * num) % m) * (half % m)) % m;
	}

}
