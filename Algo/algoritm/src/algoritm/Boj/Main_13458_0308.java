package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13458_0308 {
	static int N, B, C;
	static int Map[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		Map = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			Map[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());

		B = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		long max = 0;
		for (int i = 0; i < N; i++) {
			int k = Map[i] - B;
			max++;

			if (k <= 0)
				continue;
			
			if(k % C != 0) {
				max = max + k/C +1;
			}else {
				max += k/C;
			}
		}
		
		System.out.println(max);
	}
}
