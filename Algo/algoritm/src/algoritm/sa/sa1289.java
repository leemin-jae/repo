package algoritm.sa;

import java.util.Scanner;

public class sa1289 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			String a = sc.next();
			
			char b = '0';
			int sum = 0;
			for(int i =0; i < a.length(); i ++) {
				if(b != a.charAt(i)) {
					sum += 1;
					if(b == '0') {
						b ='1';
					}else {
						b = '0';
					}
					
				}
				
			}
			
			System.out.println("#"+ test_case +" " + sum);
			
		}
	}

}
