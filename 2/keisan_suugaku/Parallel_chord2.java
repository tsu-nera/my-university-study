 package keisan_suugaku;

public class Parallel_chord2 {
	
	static double a =-0.7692923542386215;
	
	public static void main(String[] args) {
	
	    double[] x = new double[1001];
	    		
	    int iteration = 0;
		int n = 1000;
	    
	    
	    x[0] =5.0;
	    
	    double e =1.0e-10;
	    
		for(int k=0; k<n ;k++){
			if(Math.abs(f(x[k]))<e){			//Žû‘©”»’è
				iteration = k;
				break;
			}
			x[k+1] = x[k] - f(x[k])/g(x[0]);
			System.out.println(k+1+":"+x[k+1]);
			
			
			
			if(k == n-1){
				System.out.println("Žû‘©‚µ‚Ü‚¹‚ñ‚Å‚µ‚½");
				System.exit(1);
			}
		}
		
		System.out.println("”½•œ‰ñ”"+iteration+"‰ñ  ‰ð‚Í@x="+x[iteration]);
		System.out.println();
		System.out.println();
		
		System.out.println("â‘ÎŒë·‚Í");
		for(int k=0; k<n ;k++){
			System.out.println((k+1) +" :" + Math.abs(x[k+1] - a));
			if(Math.abs(f(x[k]))<e){			//Žû‘©”»’è
				break;
			}
		}
		
		System.out.println();	
		System.out.println("Žû‘©ŽŸ”‚Í");
		for(int i=0;i<n;i++){
			System.out.println(i+1+":"+convergence(x[i+1],x[i]));
			if(Math.abs(f(x[i]))<e){			//Žû‘©”»’è
				break;
			}
		}
		
	}

	
	static double f(double x){
		double p =0.0;
		//double[] a={1.0,-3.0,1.0,3.0};
		double[] a={32};
		for(int i=0;i<=a.length-1;i++){
			p = p*x +a[i];
		}
		return p;
	}
	
	static double g(double x){
		/*double p =2.0*x-3.0-3.0/(x*x);*/
		double p =0.0;
		//double[] a={3.0,-6.0,1.0};
		double[]  a={3.0,-2.0,-5.0};
		for(int i=0;i<=a.length-1;i++){
			p = p*x +a[i];
		}
		return p;
	}
	
	static double convergence(double x,double y){
		double p = Math.log10(Math.abs(x - a)) / Math.log10(Math.abs(y - a));
		return p;
	}
}