package keisan_suugaku;

public class kainokousiki {
	public static void main(String[] args) {
		 double a = 1.0;
		 double b = -Math.pow(10, 5.8);
		 double c = 1.0;

		
		System.out.println(f(a,b,c));
	}
	
	static double f(double a,double b,double c){
		double p = (-b-Math.sqrt(b*b - 4*a*c))/2*a;
		return p;
	}

	static double ff(double x){
		double p=0.0;
		double[] a= {1.0,-Math.pow(10,5.8),1.0};
		for(int i=0;i<a.length;i++){
			p = p*x + a[i];
		}
		
		return p;
}
}