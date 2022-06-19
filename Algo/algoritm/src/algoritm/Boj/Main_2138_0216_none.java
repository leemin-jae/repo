package algoritm.Boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2138_0216_none {
	static int[] after;
	static int N;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.nextLine();
		String s1 = sc.nextLine();
		String s2 = sc.nextLine();

		int[] before = new int[N];
		after = new int[N];

		for (int i = 0; i < N; i++) {
			before[i] = s1.charAt(i) - '0';
			after[i] = s2.charAt(i) - '0';
		}
		//System.out.println(find(before));
		check(find(before), 0, before);
		// check(-1,0,before);
	}

	public static void check(int a, int cnt, int[] map) {
		if (a == -1) {
			System.out.println(cnt);
			return;
		}

		if (a == 0) {

			System.out.println("3");
			//check(a + 1, cnt, map);
			map[a] = Math.abs(map[a] - 1);
			map[a + 1] = Math.abs(map[a + 1] - 1);
			System.out.println(	Arrays.toString(map) +" " + find(map));
			check(find(map), cnt + 1, map);

		} else if (a == N - 1) {

			System.out.println("2");
			//check(a - 1, cnt, map);
			map[a] = Math.abs(map[a] - 1);
			map[a - 1] = Math.abs(map[a + 1] - 1);
			System.out.println(	Arrays.toString(map) +" " + find(map));
			check(find(map), cnt + 1, map);

		} else {
			System.out.println("1");
			//check(a - 1, cnt, map);
			//check(a + 1, cnt, map);
			map[a] = Math.abs(map[a] - 1);
			map[a + 1] = Math.abs(map[a + 1] - 1);
			map[a - 1] = Math.abs(map[a - 1] - 1);
			System.out.println(	Arrays.toString(map) +" " + find(map));
			check(find(map), cnt + 1, map);

		}
	}

	static int find(int[] map) {
		int f = -1;

		for (int i = 0; i < N; i++) {
			if (map[i] != after[i]) {
				f = i;
			}
		}
		System.out.println(	"find : " + Arrays.toString(after) + " " + f);
		System.out.println(	"find : " + Arrays.toString(map) + " " + f);
		return f;
	}

}
