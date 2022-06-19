package algoritm.sa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1228_0208 {

	public static void main(String[] args) throws IOException {
		int T = 10;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<String> que = new LinkedList<>();
		Queue<String> que_sub = new LinkedList<>();
		
		String st[];

		for (int tc = 1; tc <= T; tc++) {
			que.clear();
			
			String len = br.readLine();
			//System.out.println(len);
			st = br.readLine().split(" ");
			
			for(int i =0 ; i < st.length; i ++) {
				que.add(st[i]);
			}
			
			br.readLine();
			
			st = br.readLine().split(" ");
			
			
			int size;
			for (int i = 0; i < st.length; i++) {
				//System.out.println(st[i]);
				if(st[i].equals("I")) {                    //I를 기점으로 계산
					
					for(int j =0 ; j < Integer.parseInt(st[i+1]) ; j++) {  //들어갈 앞부분을 서브큐에 저장
						que_sub.add(que.poll());
					}
					
					for(int j = 0 ; j < Integer.parseInt(st[i+2]); j ++) {  //새로 입력해야 되는 부분을 저장
						que_sub.add(st[i+3+j]);
					}
					size = que.size();
					que.addAll(que_sub);             // 원래 큐에 서브큐의 내용을 전부 뒤에 저장
					for(int j = 0; j <size; j++) {     // 앞부분에 남은 데이터를 뒤로 이동
						que.add(que.poll());
					}
					
					i = i + Integer.parseInt(st[i+2]);
					que_sub.clear();
					//st[i+1]
					//st[i+2]
					//i+st[i+2]
				}
			}
			int a = 0;
			System.out.print("#" + tc +" ");
			while(a < 10) {
				System.out.print(que.poll() + " ");
				a++;
			}
			System.out.println();
			
			
			

		}

	}
}
