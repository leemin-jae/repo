package algoritm.Boj;

import java.util.Scanner;

public class Baek1212 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String a = sc.next();
		
		String b = "";
		
		
		for(int i =0; i <a.length() ; i++) {
			int k  = a.charAt(i) - '0';

			for(int j = 2 ; j >= 0 ; j++) {
				 b = b + Double.toString((k/Math.pow(2, j)));
				
			}
		}

		System.out.print(a);
		sc.close();
	}

}
