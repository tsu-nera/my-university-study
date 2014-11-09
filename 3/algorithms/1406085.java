public class 1406085{

	
	static double f_function (double z){
	    double f;
	    f=z;
	    return(f);
	  }
	
	static double g_function (double y,double z){
	    double g;
	    g=(1-y*y)*z-y;
	    return(g);
	  }
	
	public static void main(String[] args) {
		double h,xe;//double x0,xe,y0,z0,h;
	    double x,y,z;
	    long m,n;
	    double x0 =1.0;
	    
	    x =1.0;
	    y =1.0;
	    z =0.0;
	    xe =4.0;
	    h  =0.0000001;
	    
	    n=(int) ((xe-x)/h+0.05); 
	    m=(n/10); 
	    
	    double k1,k2,k3,k4,l1,l2,l3,l4;
	    //オイラー法
	  /*for(int i=1 ; i<=n ; i++){
	    	double a=y;
	        y = y +h*f_function(z);
	        
	    	z = z + h*g_function(a,z);
	        
	       x=x+h;
	        
	       if(i%m == 0){
	          System.out.println(x
	                            +"    "+y);
	        }
	      } 
	   */
	   
	   //四次のRunge-kutta法
	    /*k1=h*f_function(z);
	    l1=h*g_function(y, z);
	    k2=h*f_function(z+l1/2);
	    l2=h*g_function(y+k1/2, z+l1/2);
	    k3=h*f_function(z+l2/2);
	    l3=h*g_function(y+k2/2, z+l2/2);
	    k4=h*f_function(z+l3);
	    l4=h*g_function(y+k3/2, z+l3/2);
	    
	  
	    
	    System.out.println((k1+2*k2+k3*2+k4)/6);
	    System.out.println((l1+2*l2+l3*2+l4)/6);
	    System.out.println();*/
	    
	  for(long i=1 ; i<=n ; i++){
	    	k1=h*f_function(z);
		    l1=h*g_function(y, z);
		    k2=h*f_function(z+l1/2);
		    l2=h*g_function(y+k1/2, z+l1/2);
		    k3=h*f_function(z+l2/2);
		    l3=h*g_function(y+k2/2, z+l2/2);
		    k4=h*f_function(z+l3);
		    l4=h*g_function(y+k3/2, z+l3/2);
	        
	        y = y + (k1+2*k2+k3*2+k4)/6;
	        
	    	z = z + (l1+2*l2+l3*2+l4)/6;
	        
	        x=x0+i*h;
	        if(i%m == 0){
	          System.out.println(x
	                            +"    "+y);
	        }
	      } 

	}

}
