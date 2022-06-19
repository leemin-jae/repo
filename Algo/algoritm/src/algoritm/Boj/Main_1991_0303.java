package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1991_0303 {
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		N = Integer.parseInt(br.readLine());
		char[][] tree = new char[N][3];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			tree[i][0] = st.nextToken().charAt(0);
			tree[i][1] = st.nextToken().charAt(0);
			tree[i][2] = st.nextToken().charAt(0);
		}

		pre(tree, tree[0][0]);
		System.out.println();
		mid(tree, tree[0][0]);
		System.out.println();
		post(tree, tree[0][0]);
	}

	static public void pre(char[][] tree, char start) {
		if (start == '.')
			return;

		for (int i = 0; i < N; i++) {
			if (tree[i][0] == start) {
				System.out.print(tree[i][0]);
				pre(tree, tree[i][1]);
				pre(tree, tree[i][2]);
			}
		}

	}

	static public void mid(char[][] tree, char start) {
		if (start == '.')
			return;

		for (int i = 0; i < N; i++) {
			if (tree[i][0] == start) {
				mid(tree, tree[i][1]);
				System.out.print(tree[i][0]);
				mid(tree, tree[i][2]);
			}
		}

	}
	
	static public void post(char[][] tree, char start) {
		if (start == '.')
			return;

		for (int i = 0; i < N; i++) {
			if (tree[i][0] == start) {
				post(tree, tree[i][1]);
				post(tree, tree[i][2]);
				System.out.print(tree[i][0]);
			}
		}

	}

}
