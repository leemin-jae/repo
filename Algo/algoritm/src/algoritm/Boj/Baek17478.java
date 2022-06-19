package algoritm.Boj;

import java.util.Scanner;

public class Baek17478 {
	static int rep = 0;
	static void p(int a) {
		for(int i = 0 ; i < a; i ++) {
			System.out.print("____");
		}
	}
	static void JH(int a) {

		if(a == 0) {
			p(rep);
			System.out.println("\"재귀함수가 뭔가요?\"");
			p(rep);
			System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			return;
		}
		p(rep);
		System.out.println("\"재귀함수가 뭔가요?\"");
		p(rep);
		System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		p(rep);
		System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		p(rep);
		System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");

		rep += 1;
		JH(a-1);
	
		p(rep);
		System.out.println("라고 답변하였지.");
		
		rep -= 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		
		int a = sc.nextInt();
		

		System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
		//System.out.println("재귀함수가 뭔가요?");

		JH(a);
		System.out.println("라고 답변하였지.");

		
	}

}
