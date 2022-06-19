package algoritm.Boj;

import java.util.Scanner;

public class Main_2851_0307 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		for(int i = 0 ; i < 10 ; i ++) {
			int x = sc.nextInt();
			int sum_n = sum;
			
			sum_n += x;
			
			if( Math.abs(100 - sum_n ) <= Math.abs(100 - sum)) {
				sum = sum_n;
			}else {
				break;
			}
			
		}
		
		System.out.println(sum);
	}

}
