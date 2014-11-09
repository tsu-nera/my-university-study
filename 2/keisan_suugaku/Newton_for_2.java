 package keisan_suugaku;

public class Newton_for_2 {
	
	static double a =1.0;
	
	public static void main(String[] args) {
	
	    double[] x = new double[201];
	    		
	    int iteration = 0;
		int n = 200;
	    
	    
	    x[0] =10.0;
	    double e =1.0e-10;
	    
		for(int k=0; k<n ;k++){
			if(Math.abs(f(x[k]))<e){			//Žû‘©”»’è
				iteration = k;
				break;
			}
			x[k+1] = x[k] - /*f(x[k])/g(x[k])*/(1.0 - 2.0/(x[k]+1.0));
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
		//p = 10.0/(x*x+3);
		//p = x - Math.sin(x);
		p = Math.pow(x - 1, 2)*Math.pow(Math.E, x);
		return p;
	}
	
	static double g(double x){
		double p =0.0;
		//p = -20*x/Math.pow(x*x+3, 2);
		//p=1-Math.cos(x);
		p =(x*x - 1)*Math.pow(Math.E, x);
		return p;
	}
	
	static double convergence(double x,double y){
		double p = Math.log10(Math.abs(x - a)) / Math.log10(Math.abs(y - a));
		return p;
	}
}
