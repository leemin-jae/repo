package algoritm.sa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Sa1225_0208 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s;
		int map[] = new int[8];
		Queue<Integer> que = new LinkedList<>();

		for (int tc = 1; tc <= 10; tc++) {
			que.clear();
			br.readLine();
			s = br.readLine();

			int min = Integer.MAX_VALUE;
			int p = -1;

			for (int i = 0; i < 8; i++) {
				 que.add(Integer.parseInt(s.split(" ")[i]));
			}

			
			int a;
			int cycle = 1;
			int re =0;
			while(true) {
				a = que.poll();
				re = a-cycle;
				if(re <= 0) {
					que.add(0);
					break;
				}
				que.add(re);
				cycle ++;
				if(cycle == 6) {
					cycle = 1;
				}
				
			}
			
			
			System.out.print("#" + tc + " " );
			Iterator iter = que.iterator();
			while (iter.hasNext())
				System.out.print(iter.next() + " ");
			System.out.println();

		}
	}

}
