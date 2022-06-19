package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9251_0408 {
	static String A, B;
	static boolean check_A[] , check_B[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		A = br.readLine();
		B = br.readLine();
		check_A = new boolean[A.length()];
		check_B = new boolean[B.length()];
		for(int i = 0; i < A.length() ; i++) {
			check_A[A.charAt(i)-'A'] = true;
		}
		for(int i = 0; i < B.length() ; i++) {
			check_B[B.charAt(i)-'A'] = true;
		}

	}

}
