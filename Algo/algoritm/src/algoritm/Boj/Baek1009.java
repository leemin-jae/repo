package algoritm.Boj;

import java.util.Scanner;

public class Baek1009 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int a, b;
		int num = 1;
		for(int test_case = 0; test_case < T ; test_case ++) {
			num = 1;
			
			a = sc.nextInt();
			b = sc.nextInt();
			
			for(int i =0 ; i < b ; i ++) {
				num = (num*a)%10;
			}
			if(num == 0) num = 10;
			System.out.println(num);
		}

		sc.close();
	}

}
