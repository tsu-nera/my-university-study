package keisan_suugaku;

public class Norm {

	public static void main(String[] args) {
		double[] x = {	48.7,
				88.0,
				-16.0};
		
		/*double[] y = {7.232,	
				9.136,	
				9.359,	
				4.963,	
				-8.311,	
				10.000,	
				-9.883,	
				8.541,	
				-2.350,	
				8.929,	
				7.552,	
				-4.743,	
				-6.890,	
				-4.271,	
				-9.228,	
				-1.925,	
				1.424,	
				6.010,	
				-2.503,	
				-9.597,};
		double[] a= new double[20];
		
		for(int i=0;i<20;i++){
			a[i] = x[i] + y[i];
		}*/
		
		System.out.println("1-ƒmƒ‹ƒ€‚Ì‘å‚«‚³‚Í"+norm1(x)+"‚Å‚·");
		System.out.println("2-ƒmƒ‹ƒ€‚Ì‘å‚«‚³‚Í"+norm2(x)+"‚Å‚·");
		System.out.println("‡-ƒmƒ‹ƒ€‚Ì‘å‚«‚³‚Í"+norm_max(x)+"‚Å‚·");
		
	}
	
	static double norm1(double x[]){
		double p=0;
		for(int i=0;i<x.length;i++){
			p = p + Math.abs(x[i]);
		}
		return p;
	}
	
	static double norm2(double x[]){
		double p=0;
		for(int i=0;i<x.length;i++){
			p += Math.pow(Math.abs(x[i]),2);
		}
		return Math.sqrt(p);
	}
	
	static double norm_max(double x[]){
		double p=0;
		for(int i=0;i<x.length;i++){
			p = Math.max(p,Math.abs(x[i]));
		}
		return p;
	}

}
