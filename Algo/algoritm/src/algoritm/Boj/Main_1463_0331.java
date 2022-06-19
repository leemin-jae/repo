package algoritm.Boj;

import java.util.Scanner;

public class Main_1463_0331 {
	static int check[] = new int[10000001];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		
		for(int i = 2; i <= n ; i++) {
			int Min = Integer.MAX_VALUE;
			if(i%6 == 0) {
				Min = Math.min(check[i/2] + 1, Math.min(check[i/3] + 1 , check[i-1] + 1));
			}else if(i%3 == 0) {
				Min = Math.min(check[i/3] + 1 , check[i-1] + 1);
			}else if(i%2 == 0) {
				Min = Math.min(check[i/2] + 1, check[i-1] + 1);
			}else {
				Min = check[i-1]+1;
			}
			
			check[i] = Min;
			
			
		}
		System.out.println(check[n]);
		
	}
		
}
