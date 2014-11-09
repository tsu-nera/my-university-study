package keisan_suugaku;

public class Bisection {
	
	public static void main(String[] args) {
		double a =1.9;
		double b =3.0;
		double c =0.0;
		double eps=1.0e-10;
		int k;
		
		if(f(a)*f(b)>0)
			System.out.println("初期点が不適切です");
		
		for(k=0;k<1000;k++){
			c=Math.abs(a+b)/2;
			
			if(f(a)*f(c)<0) b=c;
			else if(f(c)*f(b)<0	) a =c;
			else break;
		}

		System.out.println("反復回数："+k);
		System.out.println("x="+c);
	}
	
	static double f(double x){
		return Math.pow(x,3)-2*x*x-x+2;
	}

}
