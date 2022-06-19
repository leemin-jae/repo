package algoritm.Boj;

import java.math.BigInteger;
import java.util.Scanner;

public class Main_2407_0304 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int Ncopy = N;
		int Mcopy = M;
		BigInteger son = new BigInteger("1");
		BigInteger mom = new BigInteger("1");
		for(int i = 0 ; i < M ; i ++) {
			son = son.multiply(new BigInteger(Integer.toString(Ncopy)));
			mom = mom.multiply(new BigInteger(Integer.toString(Mcopy)));
			
			Ncopy--;
			Mcopy--;
		}
		
		System.out.println(son.divide(mom));
	}

}
