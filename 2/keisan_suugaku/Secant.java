package keisan_suugaku;

public class Secant {
	
	public static void main(String[] args) {
		
	    double[] x = new double[100000];
	    double[] f = new double[100000];
	    
	    x[0] = 10.0;
	    x[1] = 8.0;
		
		int n = 0;
		double a = 0;
	    
	    double e=0.00000001;
			
		for(int i = 0 ;; i++){
			
			f[i]= x[i]*x[i]-7.0*x[i]+13.0;
		    f[i+1]= x[i+1]*x[i+1]-7.0*x[i+1]+13.0;
			 x[i+2] = x[i+1] - f[i+1]*(x[i+1] - x[i])/(f[i+1] - f[i]);
			
			 if( Math.abs((x[i+2]-x[i+1])/x[i+1])<e){
			 n = i+1;
			 a = x[i+2];
			 break;
			 }
		}
		
		System.out.println(a);
		System.out.println(n);

	}

}
