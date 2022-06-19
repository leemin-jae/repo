package algoritm.Boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_2309_0209 {
	static int [] t = new int[9];
	static boolean [] check = new boolean[9];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		for(int tc = 0 ; tc< 9 ; tc ++) {
			t[tc] = sc.nextInt();
			sum += t[tc];
		}
		
		Arrays.sort(t);
		
		out :
		for(int i = 0 ; i < 8; i ++) {
			for(int j = i+1 ; j < 9; j++) {
				if(sum - t[i] - t[j] == 100) {
					//System.out.println(i + " "+j);
					check[i] =true;
					check[j] =true;
					break out;
				}
			}
		}
		
		for (int i = 0; i < t.length; i++) {
			if(check[i] == false) {
				System.out.println(t[i]);
			}
		}
	}

}
