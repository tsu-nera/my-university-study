package keisan_suugaku_kouki;

public class Condition_number{
	
	double cond(double a[][], double b[][]){	//ğŒ”‚Ìƒƒ]ƒbƒg
		return  norm_max(a)*norm_max(b);
	}
	
	double norm_max(double x[][]){		//s—ñƒmƒ‹ƒ€‚Ì‡-ƒmƒ‹ƒ€‚Ìƒƒ]ƒbƒg
		double p=0;
		
		double[] a = new double[x.length];
		
		for(int k=0;k<x.length;k++){
			for(int j=0;j<x.length;j++){
				a[k] = a[k]+Math.abs(x[k][j]);
			}
		}
		
		for(int i=0;i<x.length;i++){
			p = Math.max(p,a[i]);
		}
		return p;
	}
	
	
	
	void lu_solution(double a[][],double u[][],double l[][]){	//‚k‚t•ª‰ğ‚Ìƒƒ]ƒbƒg
		int n = a.length;
		double[][] aa = new double[n][n];
	for(int k=0;k<n;k++){
		for(int p=k+1;p<aa.length;p++){
			aa[p][k] = a[p][k]/a[k][k];
			
			for(int q=k;q<a.length;q++){
				a[p][q] = a[p][q] - aa[p][k]*a[k][q];
			}
			
		}
	}
	
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			u[i][j] = a[i][j];
		}
	}
	
	for(int i=0;i<aa.length;i++){
		for(int j=0;j<aa.length;j++){
			if(j>i){
				l[i][j]=0;
			}else if(i==j){
				l[i][j]=1;
			}else{
				l[i][j]=aa[i][j];
			}
		}
	}
	
	}
	
	
	void anti_matrix(double a[][],double l[][],double u[][],double x[][]){//‹ts—ñ‚ğ‹‚ß‚éƒƒ]ƒbƒg
		int n = a.length;
		double[][]e =new double[n][n];
		double[] z = new double[n];
		
		for(int i=0;i<n;i++){			//’PˆÊs—ñ‚ğ¶¬
			for(int j=0;j<n;j++	){
				if(i==j) e[i][j]=1;
				else e[i][j]=0;
			}
		}
		
		for(int i=0;i<n;i++){
			double[] bb=new double[n];
			for(int j=0;j<n;j++){
				bb[j]=e[j][i];
			}
			gauss(l,bb,z);
			gauss(u,z,bb);
			for(int j=0;j<n;j++){
				x[i][j] = bb[j];
			}
			
		}
		
		
	}
	
	void gauss(double a[][],double b[],double x[]){
		int n= a.length;//ƒKƒEƒX‚ÌÁ‹–@‚Ìƒƒ]ƒbƒg
		double[] aa = new double[n];
		double temp;
		
		for(int k=0;k<n;k++){
			
			for(int p=k;p<n;p++){
				if(Math.abs(a[k][k])<Math.abs(a[p][k])){
					for(int q=k;q<n;q++){
					temp = a[k][q];
					a[k][q]=a[p][q];
					a[p][q]=temp;
					}
					temp = b[k];
					b[k]= b[p];
					b[p]= temp;
				}
			}
			
			for(int i=k+1;i<n;i++){
					aa[i]=a[i][k]/a[k][k];
					b[i]=b[i]-aa[i]*b[k];
					for(int j=k;j<n;j++){
						a[i][j] =a[i][j] - aa[i]*a[k][j];
					}
			}	
		}
		
		double sum =0;
		for(int k=n-1;k>=0;k--){
			sum =0;
			for(int l=k+1;l<n;l++){
				sum+=a[k][l]*x[l];
			}
			x[k]=(b[k]- sum)/a[k][k];
		}
	}

	

	public static void main(String[] args){
		double a[][]  = {{-6.746, 0.326, 0.082, 4.266,-0.053, 0.034},
		 {1.084, 2.211, 6.994, 0.002, 6.419, 0.007},
		 { 1.340, 3.775, 5.154,-1.757, 1.114, 9.817},
		 { 6.545,-7.765, 0.089, 0.829, 0.026,-0.083},
		{-0.264, 1.179,-6.774, 4.021,-0.007, 4.013},
		{-9.863,-2.389, 3.717, 0.471,-6.597,-0.503}};
		double[] b={-15.954,
		63.818,
		29.921,
		12.913,
		 1.591,
		-81.069};
		double[] x= new double[b.length];
		int n = a.length;
		double[][] l=new double[n][n];
		double[][] u=new double[n][n];
		double anti_a[][]  = new double[n][n];
		Condition_number f = new Condition_number();
		f.lu_solution(a,u,l);
		f.gauss(a, b, x);
		
		for(int i=0;i<n;i++){
			System.out.printf("x["+(i+1)+"]="+"%4.3f",x[i]);
			System.out.println();
		}
		System.out.println();
		f.anti_matrix(a,l,u,anti_a);
		System.out.println("ƒÈ(A)="+f.cond(a, anti_a));
	}
	
	
	
}