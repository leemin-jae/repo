package algoritm.sa;

import java.util.Arrays;
import java.util.Scanner;

public class Sa1208 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {

			int count = Integer.parseInt(sc.nextLine());
			//System.out.println(count);
			String s = sc.nextLine();

			String[] s_c = s.split(" ");
			int[] h = new int[s_c.length];

			for (int i = 0; i < s_c.length; i++) {
				h[i] = Integer.parseInt(s_c[i]);
			}

			int min = 99999;
			int min_count = 0;
			int max = -111;
			int max_count = 0;
			int result = 0;

			for (int i = 0; i < count; i++) {

				max = -11;
				min = 999;

				for (int k = 0; k < h.length; k++) {
					if (h[k] < min) {
						min = h[k];
						min_count = k;
						//System.out.println("min : " + min + " count : " + min_count);
					}
					if (h[k] > max) {
						max = h[k];
						max_count = k;
						//System.out.println("max : " + max + " count : " + max_count);
					}

				}

				if (max == min) {
					break;
				} else {
					h[min_count] += 1;
					h[max_count] -= 1;
					result = h[max_count] - h[min_count];
				}
			}
			
			
			max = -11;
			min = 999;

			for (int k = 0; k < h.length; k++) {
				if (h[k] < min) {
					min = h[k];
					min_count = k;
				
				}
				if (h[k] > max) {
					max = h[k];
					max_count = k;
				
				}

			}
			result = max - min;
			System.out.println("#" + tc + " " + Math.abs(result));

		}
	}

}
