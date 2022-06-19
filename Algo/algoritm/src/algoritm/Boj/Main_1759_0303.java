package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1759_0303 {
	static int L, C;
	static char Password[];
	static ArrayList<Character> list_a = new ArrayList<>();
	static ArrayList<Character> list_b = new ArrayList<>();
	static ArrayList<String> result = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		Password = new char[L];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < C; i++) {
			char current = st.nextToken().charAt(0);
			list_a.add(current);
//			if (current == 'a' || current == 'e' || current == 'i' || current == 'o' || current == 'u') {
//				list_a.add(current);
//			} else {
//				list_b.add(current);
//			}
		}
		
		Collections.sort(list_a);
		
		pass(0,0);
//		for(int i = 1,j = L-i; i<=list_a.size() && j >= 2  ; i++) {
//			pass_a(0,0,i,list_a);
//		}
//		
//		Collections.sort(result);
//		
//		for(String i : result) {
//			System.out.println(i);
//		}
	}

	public static void pass(int cnt ,int next) {
		if(cnt == L) {
			if(check()) {
				for(char i : Password) {
					System.out.print(i);
				}
				System.out.println();
			}

			return;
		}
		
		for(int i = next ; i < C ; i ++) {
			Password[cnt] = list_a.get(i);
			pass(cnt+1, i+1);
		}
	}


	public static void pass_b(int cnt ,int next, int end , ArrayList<Character> a) {
		if(cnt == L) {
			StringBuilder sb = new StringBuilder();
			char[] p = Password.clone();
			Arrays.sort(p);
			for(char i : p) {
				sb.append(i);
			}
			result.add(sb.toString());
			return;
		}

		for(int i = next ; i < a.size() ; i ++) {
			Password[cnt] = a.get(i);
			pass_b(cnt+1, i+1 , end, a);
		}
	}
	
	public static boolean check() {
		int m = 0;
		int j = 0;
		for(int i = 0 ; i < L ; i++) {
			if (Password[i] == 'a' || Password[i] == 'e' || Password[i] == 'i' || Password[i] == 'o' || Password[i] == 'u') m ++;
			else j++;
		}
		
		if(m >= 1 && j >=2) {
			return true;
		}else {
			return false;
		}
	
	}

}
