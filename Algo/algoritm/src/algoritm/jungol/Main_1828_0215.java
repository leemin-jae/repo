package algoritm.jungol;

import java.util.Arrays;
import java.util.Scanner;

public class Main_1828_0215 {
	static class Temp implements Comparable<Temp>{
		int low;
		int high;
		
		public Temp(int low, int high) {
			this.low = low;
			this.high = high;
		}
		@Override
		public int compareTo(Temp o) {
			// TODO Auto-generated method stub
			return (this.high == o.high)? -1*(this.low - o.low) : -1*( this.high - o.high);   //오름차순으로 정렬
		}



	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		Temp[] m = new Temp[N];
		
		for (int i = 0; i < N; i++) {
			m[i] = new Temp(sc.nextInt(),sc.nextInt());
		}
		
		Arrays.sort(m);     // 입력받은 배열을 높은 값을 오름차순으로 정렬
		
		int t_low = m[0].low;           // 첫번째 값을 기준으로 정함
		int cnt = 1;                    // 냉장고 개수, 시작할때 1개
		for(int i = 1 ; i < m.length ; i ++) { 
			//if(i == m.length) break;
			if(t_low > m[i].high) {                   //지금 냉장고가 가능한 가장 낮은 온도가 다음 약품기준의 최대값 보다 높을 경우 
				cnt++;                                // 냉장고 +1
				t_low = m[i].low;                     // 냉장고 기준 온도를 이번 약품의 최저 온도로 변경
				continue;
			}else if(t_low < m[i].low ) {             //다음 약품 최저온도가 기준 온도보다 높을 경우  
				t_low = m[i].low;					  //기준 온도를 줄여줌
			}
		}

		System.out.println(cnt);
		
	}
}
