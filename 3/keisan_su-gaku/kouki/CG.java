package kouki;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class CG{//CG法のプログラム
	final static int n=16;
	public static void main(String[] args)throws IOException{
		int s,t;
		double b[]=new double[n];
		double x[]= new double[n];
		double A[][] = new double[n][n+1];
		for(int i=0;i<n;i++){
			x[i] =0;
		}
		String str1,str2;
		StringTokenizer el;

		
		try{
		BufferedReader fin = new BufferedReader(new FileReader("kouki/Book1.csv"));
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
		
		try{
			BufferedReader fin = new BufferedReader(new FileReader("kouki/Book2.csv"));
				s = 0;
				while((str1=fin.readLine()) != null){			//─┐
					t = 0;						//　│
					el = new StringTokenizer(str1,",");		//　│
					while(el.hasMoreTokens()){			//　├成分の読み込
						str2 = el.nextToken();			//　│
						b[s] = Double.parseDouble(str2);	//　│
						t = t+1;				//　│
					}						//─┘
					s= s+1;
				}
				fin.close();	//ファイル・クローズ
			}catch(Exception e){						//─┐
				System.out.println("読み込みエラー:" + e);		//　├指定ファイルが開けないときの命令
				System.exit(1);						//　│
			}
			
		
		
	
		
		int k,N=0;
		double[] p=new double[n];
		double[] r=new double[n];
		double[] w=new double[n];
		double aa,bb,wp;
		double r2;
		double epsilon =0.01;//1.0e-10;
		
		
		//ここからCG法
		for(int i=0;i<n;i++	){
			p[i]=b[i];
			r[i]=b[i];
	}
		
		for(k=0;k<16;k++){
			for(int j=0;j<n;j++){//step1
				w[j]=0;
			}
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){//step1
					w[i]=w[i]+A[i][j]*p[j];
				}
			}
			wp=0;//step2
			for(int i=0;i<n;i++){
				wp=wp+w[i]*p[i];
			}
			r2=norm_2(r);
			aa=(r2*r2)/wp;
			for(int i=0;i<n;i++	){//step3,4
				x[i]=x[i]+aa*p[i];
				r[i]=r[i]-aa*w[i];
				
			}
			System.out.println(r[0]);
			bb=(norm_2(r)*norm_2(r))/(r2*r2);//step6
			for(int i=0;i<n;i++	){//step7
				p[i]=r[i]+bb*p[i];
			}
			
		}
		
		//行列の表示
		for( int i=0;i<n;i++){
			System.out.print(x[i]+" ");
			if(i%4==3)System.out.println();
		}
	}
	
		
		
		
		
		
		
		
	
	static double norm_max(double x[]){
		double p=0;
		for(int i=0;i<n;i++){
			p=Math.max(p, Math.abs(x[i]));
		}
		return p;
	}
	
	static double norm_2(double x[]){
		double p=0;
		for(int i=0;i<x.length;i++){
			p += Math.pow(Math.abs(x[i]),2);
		}
		return Math.sqrt(p);
	}
}
