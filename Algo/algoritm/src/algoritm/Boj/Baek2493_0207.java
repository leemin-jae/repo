package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Stack;
import java.util.StringTokenizer;

public class Baek2493_0207 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		StringTokenizer line = new StringTokenizer(br.readLine());
		Stack<Integer> st = new Stack<>();     // 높이를 저장
		Stack<Integer> st_2 = new Stack<>();   // 위치를 저장
		int a[] = new int[2]; // 입력받은 값을 저장

		for (int i = 0; i < T; i++) {
			a[0] = Integer.parseInt(line.nextToken());
			a[1] = i + 1;

			if (st.isEmpty()) {
				sb.append(0).append(" ");
				st.push(a[0]);
				st_2.push(a[1]);
			} else {
				while (true) {
					if (st.isEmpty()) {
						sb.append(0).append(" ");
						st.push(a[0]);
						st_2.push(a[1]);
						break;
					} 
					if (st.peek() > a[0]) {
						sb.append(st_2.peek()).append(" ");
						st.push(a[0]);
						st_2.push(a[1]);
						break;
					} else {
						st.pop();
						st_2.pop();
					}

				}

			}

		}
		System.out.println(sb);
	}

}
