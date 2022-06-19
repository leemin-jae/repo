package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_15961_0405 {
	static int N, d, k, c, count;
	static int check[], belt[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		check = new int[d + 1];
		int max = -1;
		belt = new int[N];
		count = 0;

		for (int i = 0; i < N; i++) {
			belt[i] = Integer.parseInt(br.readLine());
		}

		push(c);
		
		for (int i = 0; i < k-1; i++) {
			push(belt[i]);
		}
		max = count;
		
		for(int i = k-1; i <N+k-1 ; i++) {
			push(belt[i%N]);
			
			max = Math.max(max, count);
			
			pop(belt[i-k+1]);
			
		}
		
		System.out.println(max);


	}

	public static void push(int c) {
		if (check[c] == 0) {
			count++;
		}
		check[c]++;

	}
	public static void pop(int num) {
		check[num]--;
		if(check[num] == 0) {
			count--;
		}
	}

}
