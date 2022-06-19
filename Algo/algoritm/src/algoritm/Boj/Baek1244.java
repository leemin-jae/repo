package algoritm.Boj;
import java.util.Scanner;

public class Baek1244 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] sw = new int[101];

		for (int i = 1; i <= N; i++) {
			sw[i] = sc.nextInt();
		}

		int rp = sc.nextInt();

		for (int i = 0; i < rp; i++) {
			int s = sc.nextInt();
			int check = sc.nextInt();
			int g = 0;
			
			if (s == 1) {
				for (int j = 1; j <= N; j++) {
					if (j % check == 0) {
						sw[j] = Math.abs(sw[j] - 1);
					}
				}
			} else {
				for (int j = 1; j <= N / 2; j++) {
					 if(check-j < 1 || check+j >N) break;
					if(sw[check-j] == sw[check+j]) {
						g = j;
					}else{
						break;
					}
				}

				
				for(int j = check-g; j<=check+g;j++) {
					sw[j] = Math.abs(sw[j] - 1);

				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			System.out.print(sw[i] + " ");
			if(i%20 == 0 ) System.out.println();
		}
	}

}
