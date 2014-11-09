package keisan_suugaku;

public class Parallel_chord {

	public static void main(String[] args) {
		
		double[] x = new double[1000000];
	    double[] f = new double[1000000];
	    
	    x[0] =10.0;
		
		int n = 0;
		double a = 0;
	    
	    double e=0.00000001;
			
		for(int i = 0 ;; i++){
			
			f[i]= x[i]*x[i]-7.0*x[i]+13.0;
			x[i+1] = x[i] - f[i]/(2*(10.0)-7.0);
			
			 if( Math.abs((x[i+1]-x[i])/x[i])<e){
			 n = i+1;
			 a = x[i+1];
			 break;
			 }
		}
		
		System.out.println(a);
		System.out.println(n);

	}

}
