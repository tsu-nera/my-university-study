package keisan_suugaku;

public class M_eps {

	public static void main(String[] args) {
		double eps = 1.0;
		double x = 1.0 + eps;
		while(x!=1.0){
			eps/=2.0;
			x=1.0+eps;
		}
		System.out.println(eps*2);
	}

}
