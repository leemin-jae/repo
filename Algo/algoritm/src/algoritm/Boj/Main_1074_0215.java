package algoritm.Boj;

import java.util.Scanner;

public class Main_1074_0215 {
	static int sum = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		
		check(r,c,N);
		
		System.out.println(sum);
	}

	public static void check(int r, int c, int n) {
		if(n == 0) return;
		
		int len = (int) Math.pow(2, n-1);   // 2의 n승 나누기 2 길이
		
		if (r >= len) {
			if (c >= len) {
				sum += 3*len*len;            
			} else {
				sum += 2*len*len;
			}
		} else {
			if (c >= len) {
				sum += len*len;
			} else {
				
			}
		}

		int x = (r >= len) ? r - len : r;           //다음 사분면에서 좌표 계산
		int y = (c >= len) ? c - len : c;

		check(x, y, n - 1);

	}
}
