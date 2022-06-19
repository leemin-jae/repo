package algoritm.Boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2477_0223 {
	static int lens[][] = new int[6][2];
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());	// 1m당 참외 개수
		
		int max_h = -999999;  
		int max_w = -999999;
		int h = 0;
		int w = 0;
		
		for (int i = 0; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			lens[i][0] = Integer.parseInt(st.nextToken());
			lens[i][1] = Integer.parseInt(st.nextToken());
			
			if((lens[i][0] == 4 || lens[i][0] == 3 ) && max_h < lens[i][1]) {
				max_h = lens[i][1];
				h = lens[i][0];
				
			}else if((lens[i][0] == 1 || lens[i][0] == 2 )&& max_w < lens[i][1]) {
				max_w = lens[i][1];
				w = lens[i][0];
			}
		}
		
		
		//System.out.println(max_h + " " + max_w);
		int k = 0;
		int next;
		int minus = 0;  // 4 2 
		while(true) {
			next = (k+1)%6;
			if(lens[k][0] == h && lens[next][0] != w) {
				minus = lens[(k+2)%6][1] * lens[(k+3)%6][1];
				break;
			}else if(lens[k][0] == w && lens[next][0] != h) {
				minus = lens[(k+2)%6][1] * lens[(k+3)%6][1];
				break;
			}
			k = next;
		}
		System.out.println((max_h*max_w - minus)*T);
		
	}

}
