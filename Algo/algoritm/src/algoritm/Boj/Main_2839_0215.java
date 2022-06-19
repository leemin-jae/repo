package algoritm.Boj;

import java.util.Scanner;

public class Main_2839_0215 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int max = 999999999;
		int cnt = 0;


		while (N >= 0) {

			if (N % 3 == 0 && cnt + (N / 3) < max)
				max = cnt + (N / 3);
			cnt++;
			N -= 5;
		}

		System.out.println(max==999999999? -1:max);
	}

}
