package algoritm.Boj;

import java.util.Arrays;
import java.util.Scanner;

public class Main_3040_0214 {
	static int [] t = new int[9];
	static boolean [] check = new boolean[9];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 0 ; tc< 9 ; tc ++) {
			t[tc] = sc.nextInt();
		}
		
		sub(0,0,0);
		
	}
	static void sub(int a,int sum, int cnt) {
		if(a == 9) {
			if(sum == 100 && cnt ==7) {
				for (int i = 0; i < 9; i++) {
					if(check[i]) {
						System.out.println(t[i] );
						
					}
				}
			}
		
			return;
		}
		check[a] = true;
		sub(a+1 , sum+t[a] , cnt+1);
		check[a] = false;
		sub(a+1,sum, cnt);
	}
}
