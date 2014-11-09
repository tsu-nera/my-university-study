package keisan_suugaku_kouki;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;

public class Ja200711011406085 {//Jacobi法のアルゴリズム
	final static int n=20;
	public static void main(String[] args)throws IOException{
		int s,t;
		double A[][] = new double[20][21];
		double a[][] = new double[n][n];
		double b[]= new double[n];
		double x[]= new double[n];
		double y[]= new double[n];
		double temp[]= new double[n];
		for(int i=0;i<n;i++){
			x[i] =0.7;
		}
		double sum;
		double epsilon = 1.0e-10;
		
		/*double d[][] = new double[n][n];
		double f[][] = new double[n][n];*/
		
		String str1,str2;
		StringTokenizer el;

		
		try{
		BufferedReader fin = new BufferedReader(new FileReader("keisan_suugaku_kouki/200712_4.txt"));
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
			for(int j=0;j<21;j++){
				if(j<20) a[i][j] = A[i][j];
				if(j==20)b[i]=A[i][j];
			}
		}
		
		System.out.println(norm_max(b));
		System.out.println(norm_max2(a));
		/*try{
			BufferedReader fin = new BufferedReader(new FileReader("keisan_suugaku_kouki/data20071108vector1.txt"));
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
			*/
		
		for(int k=0;k<10000;k++){
			for(int i=0;i<n;i++){
				sum=0.0;
				for(int p=0;p<n;p++){
					sum=sum+a[i][p]*x[p];
				}
				temp[i]=b[i]-sum;
			}
			
			if(norm_max(temp)<epsilon){
					int N = k;
					System.out.println(N+"回で収束");
					break;
			}else if(k==9999){
					System.out.println("収束しませんでした");
					break;
				}
			//ここまで、残差による収束判定
			
			for(int i=0;i<n;i++){
				sum=0.0;
				for(int j=0;j<n;j++){
					if(i!=j){
						sum=sum+a[i][j]*x[j];
					}
				}
			x[i]=(b[i]-sum)/a[i][i];
			}
		}
		
		for(int i=0;i<n;i++){
			
			System.out.printf("x["+(i+1)+"]="+"%10.8f",x[i]);
			System.out.print("　　");
			if(i%4==0)System.out.println();
		}
	}	
		/*Ja200711011406085 g = new Ja200711011406085();
		g.def(a,d,f);
		g.jacobi(d, f, b, x);
		for(int i=0;i<n;i++){
			System.out.printf("x["+(i+1)+"]="+"%10.3f",x[i]);
			System.out.println();
		}}
		
		
		try{
			PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("keisan_suugaku_kouki/Ja200711011406085.txt")));//ファイル・オープン開始 ***** ここで出力ファイル名を指定する

			for(int i=0 ; i<8 ; i++){
						fout.printf("x["+(i+1)+"]="+"%10.8f",x[i]);
					fout.println();
			}
					fout.close();			
			}catch (Exception e){						//─┐
				System.out.println("書き込みエラー：" + e);		//　├指定ファイルに
				System.exit(1);						//　│書き込めないときの命令
			}
		}
	
		
	
	void def(double a[][],double d[][],double f[][]){
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++	){
				if(i==j) d[i][j]=a[i][j];
				else d[i][j]=0;
			}
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++	){
				f[i][j]= a[i][j]-d[i][j];
			}
		}
	}
	
	void jacobi(double d[][],double f[][],double b[],double x[]){
		double e =1.0e-8;
		double[] temp=new double[x.length];
		
		for(int m=0;m<100;m++){
			
			for(int i=0;i<n;i++){
				temp[i]=x[i];
				double sum =0;
				for(int j=0;j<n;j++){
					sum +=f[i][j]*x[j];
				}
			x[i]=(b[i]-sum)/d[i][i];
			temp[i]=(x[i]-temp[i]);
			}
			if(norm_max(temp)<e){
				int N = m+1;
				System.out.println(N+"回で収束");
				break;
			}else if(m==99){
				System.out.println("収束しませんでした");
				break;
			}
		}*/
	
	static double norm_max(double x[]){
		double p=0;
		for(int i=0;i<n;i++){
			p=Math.max(p, Math.abs(x[i]));
		}
		return p;
	}
	
	static double norm_max2(double x[][]){		//行列ノルムの∞-ノルムのメゾット
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
	
	void show2(double x[][]){
		for(int i=0;i<x.length;i++){
			System.out.print("[");
			for(int j=0;j<x[0].length;j++){
				System.out.printf("%10.7f",x[i][j]);
			}
		System.out.println("]");
		}
	}
}
