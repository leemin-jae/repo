package algoritm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class IMTest {
	static int A,B;
	static class Node implements Comparable<Node>{
		int a;
		
		Node(int a){
			this.a = a;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			System.out.println(A);
			return Math.abs(A -this.a) - Math.abs(A-o.a);
		}
		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		System.out.println('1' - '0');
	
	}

}
