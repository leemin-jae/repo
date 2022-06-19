package algoritm.Boj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1158_0210 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		Queue<Integer> que = new LinkedList<>();

		for (int i = 1; i <= M; i++) {
			que.add(i);

		}
		System.out.print("<");
		while (!que.isEmpty()) {
			for (int i = 0; i < N; i++) {
				if (i == N-1) {
					System.out.print(que.poll());
					break;
				}
				que.add(que.poll());
			}
			if (!que.isEmpty()) {
				System.out.print(", ");
			}
		}
		System.out.print(">");
	}

}
