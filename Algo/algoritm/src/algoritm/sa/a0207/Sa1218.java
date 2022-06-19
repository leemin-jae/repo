package algoritm.sa.a0207;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class Sa1218 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		// StringBuilder sb = new StringBuilder();
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {

			// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			// int len = Integer.parseInt(br.readLine());


			int len = Integer.parseInt(sc.nextLine().trim());
			String s = sc.nextLine();

			Stack<Character> st = new Stack<>();

			// String s = br.readLine();

			int re = 1;

			for (int i = 0; i < len; i++) {
				if (re == 0)
					break;
				char check = s.charAt(i);

				switch (check) {
				case '{':
				case '(':
				case '[':
				case '<':
					st.push(check);
					break;
				case '}':
					if (st.pop() != '{')
						re = 0;
					break;
				case '>':
					if (st.pop() != '<')
						re = 0;
					break;
				case ')':
					if (st.pop() != '(')
						re = 0;
					break;
				case ']':
					if (st.pop() != '[')
						re = 0;
					break;

				}
			}
			System.out.println("#" + tc + " " + re);
			// sb.append(re).append("\n");

		}
	}

}
