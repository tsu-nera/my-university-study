package keisan_suugaku;

public class Secant2 {
	
	static double a =-1.4728339089952602;
	

	public static void main(String[] args) {
		double[] x = new double[202];
		
	    int iteration = 0;
		int n = 200;
	    
	    
	    x[0] =2.0;
	    x[1] =1.0;
	    
	    
	    double e = 1.0e-10;
		
			
		for(int k=1; k<=n ;k++){
			if(Math.abs(f(x[k]))<e){
				iteration = k;
				break;
			}
			
			
			x[k+1] = x[k] - f(x[k])/g(x[k-1],x[k]);
			System.out.println(k+":"+x[k+1]);
			//System.out.println(k + "："+Math.abs(x[k+1] - a) /*+"　"+ x[k+1])*/);
			
			
			if(k == n){
				System.out.println("収束しませんでした");
				System.exit(1);	
			}
		}
		System.out.println();
		System.out.println("反復回数"+(iteration-1)+"回  解は　x="+x[iteration]);
		
		System.out.println();
		System.out.println();
		System.out.println("絶対誤差は");
		for(int i=1;i<n+1;i++){
			System.out.println(i + "："+Math.abs(x[i+1] - a));
			if(Math.abs(f(x[i]))<e){
				break;
		}
		}
		System.out.println("収束次数は");
		
		for(int i=1;i<=n;i++){
			System.out.println(i+":"+convergence(x[i+1],x[i]));
			if(Math.abs(f(x[i]))<e){
				break;
			}
		
		}
	}

	
	static double f(double x){
		double p =0.0;
		//double[] a={1.0,-3.0,1.0,3.0};
		double[] a={1.0,-1.0,-5.0,-2.0};
		for(int i=0;i<=a.length-1;i++){
			p = p*x +a[i];
		}
		return p;
	}
	
	static double g(double x, double y){
		double p =( f(y) - f(x))/(y-x);
		return p;
	}
	
	static double convergence(double x,double y){
		double p = Math.log10(Math.abs(x - a)) / Math.log10(Math.abs(y - a));
		return p;
	}

}
