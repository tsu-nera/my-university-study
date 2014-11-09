package keisan_suugaku_kouki;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Bekijouhou_gauss_seidel {//べき乗法のプログラム
	final static int n=20;
	int N;
	public static void main(String[] args)throws IOException{
		int s,t;
		double a[][] =new double[n][n];
		double A[][] =new double[n][21];
		double b[]=new double[n];
		double x[]= new double[n];
		double y[]=new double[n];
		double[][] a_anti=new double[n][n];
		double temp2;
		double λ=0;
		for(int i=0;i<n;i++){
			x[i] =2;
		}
		String str1,str2;
		StringTokenizer el;
		double epsilon =1.0e-10;
		
		try{
		BufferedReader fin = new BufferedReader(new FileReader("keisan_suugaku_kouki/200712_3.txt"));
			s = 0;
			while((str1=fin.readLine()) != null){			//─┐
				t = 0;						//　│
				el = new StringTokenizer(str1,",");		//　│
				while(el.hasMoreTokens()){			//　├成分の読み込
					str2 = el.nextToken();			//　│
					A[s][t] = Double.parseDouble(str2);	//　│
					t = t+1;				//　│
				}						//─┘
				s= s+1;
			}
			fin.close();	//ファイル・クローズ
		}catch(Exception e){						//─┐
			System.out.println("読み込みエラー:" + e);		//　├指定ファイルが開けないときの命令
			System.exit(1);						//　│
		}
		
		for(int i=0;i<n;i++	){
			for(int j=0;j<n;j++){
				a[i][j] = A[i][j];
				if(i<j)  a[i][j]=0;//ガウスザイデルの反復
			}
		}
		for(int i=0;i<n;i++	){
			b[i]=A[i][20];
		}
		
		
		
		Bekijouhou_gauss_seidel f= new Bekijouhou_gauss_seidel();
		f.anti_matrix(a,a_anti);
		
		double nn[][]=new double[n][n];
		for(int i=0;i<n;i++	){
			for(int j=0;j<20;j++){
				nn[i][j] =A[i][j];
				if(i>=j)  nn[i][j]=0;
			}
		}
		
		double tt[][]=new double[n][n];
		for(int i=0;i<n;i++	){
			for(int j=0;j<n;j++){
				tt[i][j]=0;
			}
		}
		
		for(int j=0;j<n;j++	){
			for(int i=0;i<n;i++){
				for(int k=0;k<n;k++){
					tt[i][j]=tt[i][j]+a_anti[i][k]*nn[k][j];
				}
			}
		}
		
		double[] c=new double[n];
		for(int i=0;i<n;i++	){
				c[i]=0;
		}
		
		for(int i=0;i<n;i++	){
			for(int j=0;j<n;j++){
				c[i]=c[i]+a_anti[i][j]*b[j];
			}
		}
		f.show2(tt);
		double temp_max;
		//ここまでが反復行列Ｔの計算だった
		
		int k;
		double[] temp=new double[n];
		for(k=0;k<100000;k++){
			for(int i=0;i<n;i++	){
			y[i]=0;
		}
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++	){
					y[i]=y[i]+tt[i][j]*x[j];
				}
				y[i]=c[i]-y[i];
			}
			for(int i=0;i<n;i++	){
				temp[i]=0;
		}
			for(int i=0;i<n;i++	){
				temp[i]=y[i]-x[i];
				x[i]=y[i];
		}	
			if(norm_max(temp)<epsilon)break;
			
		}
		
for(int i=0;i<n;i++){
			
			System.out.printf("x["+(i+1)+"]="+"%8.4f",x[i]);
			System.out.print("　　");
			if(i%4==0)System.out.println();
		}
		System.out.println(k);
		System.out.println();
		System.out.println();
		
		for(int i=0;i<n;i++){
			x[i] =2;
		}
		
		int i=0;
		do{
			temp_max=0;
			temp2=0;
			for(int r=0;r<n;r++){
				y[r]=0;
			}
			
			for(int q=0;q<n;q++){
				for(int r=0;r<n;r++){
					y[q]=y[q]+(tt[q][r]*x[r]);
				}
			}
			for(int j=0;j<n;j++){
				temp2=Math.abs(y[j]/x[j]);
				if(temp_max<temp2)temp_max=temp2;
			}
			
			if(Math.abs(temp_max-λ)<epsilon){
				break;
			}
			λ=temp_max;
			for(int r=0;r<n;r++){
				x[r]=y[r];
			}
			i++;
		}while(true);
		
		System.out.println(λ);
		System.out.println(i);
		
	
//	固有ベクトルの最大値の計算
	double u=0;
	for(i=0;i<n;i++){
		if(u<x[i])u=x[i];
	}
	u=u/Math.pow(λ, i);
	
	System.out.println("|u|="+u);
	System.out.println("マイナス１０乗/|u|="+(epsilon/u));
	System.out.println(Math.log(epsilon/u)/Math.log(λ));
	System.out.println(Math.log(epsilon)/Math.log(λ));
	//System.out.println((-10.0-Math.log10(u))/Math.log10(λ));
	
	}
	
	static double norm_max(double x[]){
			double p=0;
			for(int i=0;i<n;i++){
				p=Math.max(p, Math.abs(x[i]));
			}
			return p;
		}
	
	/*void lu_solution(double a[][],double u[][],double l[][]){	//ＬＵ分解のメゾット
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
	*/
	
	void anti_matrix(double a[][],double b[][]){//逆行列を求めるメゾット
		boolean pivot=true;
		double max,d,temp;
		int i,j,k,l,max_i=0;
		double epsilon = 1.0e-10;
		
		for(i=0;i<n;i++){			//単位行列を生成
			for(j=0;j<n;j++	){
				if(i==j) b[i][j]=1.0;
				else b[i][j]=0.0;
			}
		}
		
		for(k=0;k<n-1;k++){
			//ピボット選択
			if(pivot){
				max=Math.abs(a[k][k]);
				max_i=k;
				for(i=k+1;i<n;i++){
					if(Math.abs(a[k][k])<Math.abs(a[i][k])){
						max=Math.abs(a[i][k]);
						max_i=i;
					}
				}
				if(max<epsilon){
					System.out.println("この行列は非正則です");
					System.exit(1);
				}
				for(j=0;j<n;j++){
					temp = a[k][j];
					a[k][j]=a[max_i][j];
					a[max_i][j]=temp;
					temp = b[k][j];
					b[k][j]= b[max_i][j];
					b[max_i][j]= temp;
				}
			}
			
			for(i=k+1;i<n;i++){
				d=a[i][k]/a[k][k];
				for(j=k+1;j<n;j++){
					a[i][j]=a[i][j]-d*a[k][j];
				}
				for(j=0;j<n;j++){
					b[i][j]=b[i][j]-d*b[k][j];
				}
			}
			
		}
		
		
		for(k=0;k<n;k++){
			for(i=n-1;i>=0;i--){
				d=b[i][k];
				for(j=i+1;j<n;j++){
					d=d-a[i][j]*b[j][k];
				}
				b[i][k]=d/a[i][i];
			}
		}
		
	
		
	}
	
	/*void gauss(double a[][],double b[],double x[]){
		int n= a.length;//ガウスの消去法のメゾット
		double[] aa = new double[n];
		double temp;
		
		for(int k=0;k<n-1;k++){
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
	}*/
	
	void show2(double x[][]){
		for(int i=0;i<x.length;i++){
			System.out.print("[");
			for(int j=0;j<x[0].length;j++){
				System.out.printf("%10.7f",x[i][j]);
			}
		System.out.println("]");
		}
	}
	
	double norm_max(double x[][]){		//行列ノルムの∞-ノルムのメゾット
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
}