package keisan_suugaku;

public class Siguma {

	
	public static void main(String[] args) {
		int n = 50;
		double p = 0.0;
		
		for(int k=1;k<=n;k++){
			p =p + 1/Math.pow(2.0, k);
		}
		
		System.out.println(p);
	}
	

}
