package keisan_suugaku_kouki;

import java.math.BigDecimal;


public class Zensinsyoukyokatei {

	public static void main(String[] args) {
	
	double[][] a={
			 {-2.3,  2.5,-10.0,  1.5,  0.3, -5.0,  1.0,  9.0, -1.2,  0.5},
			{ 8.3, -8.6, -2.5, -3.6, -9.9, -6.4,  5.3, -3.8, -2.1,  1.8},
			 {-7.9, -2.6, -3.1, -0.6,-10.0,  3.0,  8.2, -3.6, -6.4, -0.5},
			 { 6.6,  7.8,  1.4, -7.3,  4.5,  6.6, -7.6,  3.9, -6.6,  3.1},
			 {-5.4, -6.2,  5.4,  4.7,  2.7, -5.4,  8.9, 10.0,  4.4,  5.0},
			 {-6.4,  1.0,  8.0, -7.7, -1.2,  6.6, -8.4, -9.3, -4.2, -5.0},
			 {-4.1, -9.9, -1.6, -5.8,  3.6,  3.4,  6.4, -5.7, -6.3,  0.0},
			 {0.5, -2.2,  5.4,  8.6, -5.1,  4.9,  0.3,  9.0, -8.1,  3.3},
			 {-9.6, -4.5, -1.7,  6.0,  0.0, -1.5, -6.1,  6.6, -6.2, -0.2},
			 {-5.0,  2.8, -0.4, -8.5,  5.1,  1.9,  3.4,  9.4,  9.8, -3.9}
	};
	
	double[] b={
			  38.7 ,
			  -116.4 ,
			   -53.9 ,
			   136.7 ,
			    64.8 ,
			   -67.2 ,
			  -118.4 ,
			   138.1 ,
			     9.7 ,
			    53.8 
	};
	
	double[] aa = new double[10];
	double[] x= new double[10];
	double[] c= new double[10];
	
	for(int k=0;k<10;k++){
		
		for(int i=k+1;i<10;i++){
			aa[i] = a[i][k]/a[k][k];
			//a[i][k] = a[i][k]/a[k][k];
			
			for(int j=k;j<10;j++){
				a[i][j] = a[i][j] - aa[i]*a[k][j];
				//a[i][j] = a[i][j] - a[i][k]*a[k][j];
			}
			
			b[i] = b[i] - aa[i]*b[k];
			
		}
	}
	
	x[9]=b[9]/a[9][9];
	
	for(int k=8;k>=0;k--){
		for(int l=9;l>k;l--){
			c[k]=a[k][l]*x[l];
		}
		x[k]=(b[k]-c[k])/a[k][k];
	}
	
	for(int i=0;i<10;i++){
		for(int j=0;j<10;j++){
			double su = a[i][j];
			BigDecimal bi = new BigDecimal(String.valueOf(su));
			double k3= bi.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();


			System.out.printf(k3+"@");
		}
		System.out.println();
	}
	
	System.out.println();

	for(int i=0;i<10;i++){
			double su = b[i];
			BigDecimal bi = new BigDecimal(String.valueOf(su));
			double k3= bi.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println(k3);
	}
	
	System.out.println();
	
	for(int k=0;k<10;k++){
		double su = x[k];
		BigDecimal bi = new BigDecimal(String.valueOf(su));
		double k3= bi.setScale(3, BigDecimal.ROUND_HALF_UP).doubleValue();
		System.out.println("x["+(k+1)+"]="+k3);
	
	}
	}
}
