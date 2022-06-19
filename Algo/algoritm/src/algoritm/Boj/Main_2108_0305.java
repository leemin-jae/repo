package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main_2108_0305 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int[] pq = new int[T];
		int[] check = new int[8002];
		
		int sum = 0;
		int num = 0;
		for(int i = 0 ; i < T ; i++) {
			int x = Integer.parseInt(br.readLine());
			pq[i] = x;
			sum += x;
			check[x+4000] += 1;
			if(check[x+4000] > num) {
				num = check[x+4000];
			}
		}
		
		Arrays.sort(pq);
//		for(int i : pq) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
		
		PriorityQueue<Integer> que = new PriorityQueue<Integer>();
		
		for(int i = pq[0]+4000 ; i <= pq[T-1]+4000 ; i++) {
			if(check[i] == num) {
				//System.out.println(i);
				que.add(i);
			}
		}
		if(que.size() > 1) {
			que.poll();
		}
		
		System.out.println(Math.round((double)sum/(double)T));
		System.out.println(pq[T/2]);
		System.out.println(que.poll()-4000);
		System.out.println(pq[T-1] - pq[0]);
	}

}
