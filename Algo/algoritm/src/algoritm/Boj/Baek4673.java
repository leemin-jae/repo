package algoritm.Boj;

public class Baek4673 {
	
	public static int d(String n) {
		
		int sum = 0;
		
		for(int i =0; i <n.length(); i ++) {
			sum += n.charAt(i)-'0';
		}
		
		sum += Integer.parseInt(n); 
		if(sum > 10000) sum = 10000;
		return sum;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean check[] = new boolean[10001];
		int d = 0;
		for(int i = 1; i <10001 ; i++) {
			if(check[i] == false) {
				d = d(Integer.toString(i));
				
				while(d < 10000) {

					check[d] = true;
					d = d(Integer.toString(d));
				}
				
			}
		}
		
		for(int i = 1; i<10000; i++) {
			if(check[i] == false) {
				System.out.println(i + " ");
			}
		}
		
	}

}
