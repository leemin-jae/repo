package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_20051_0320 {
	static int N, K;
	static ArrayList<Integer> A = new ArrayList<Integer>(), B = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 2 * N; i++) {
			A.add(Integer.parseInt(st.nextToken()));
			B.add(0);
		}

		int robot_number = 1;
		int now = 0;
		while (true) {
			// System.out.println(now + "_---------------------------------");
//			System.out.print("bebefore ");
//			for (int i : B) {
//				System.out.print(i + " ");
//
//			}
//			System.out.println();
			go();
			robot();

			if (A.get(0) != 0) {
				int nowA = A.get(0) - 1;
				B.set(0, robot_number);
				robot_number++;
				A.set(0, nowA);
			}

			int sum = 0;
			for (int i = 0; i < 2 * N; i++) {
				if (A.get(i) == 0)
					sum++;
			}

			now++;
			if (sum >= K)
				break;

		}
		System.out.println(now);
	}

	public static void robot() {

		for (int i = N - 1; i >= 0; i--) {
			if (B.get(i) != 0) {
				if (B.get(i + 1) == 0 && A.get(i + 1) != 0) {
					int nowA = A.get(i + 1);
					int nowB = B.get(i);
					B.set(i + 1, nowB);
					B.set(i, 0);
					A.set(i + 1, nowA - 1);
				}
			}
		}
		B.set(N - 1, 0);
	}

	public static void go() {

		int now = A.get(2 * N - 1);
		A.remove(2 * N - 1);
		A.add(0, now);

//		for(int i : A) {
//			System.out.print(i + " ");
//			
//		}System.out.println();
//		

		B.remove(2 * N - 1);
		B.add(0, 0);

		B.set(N - 1, 0);
	}

}
