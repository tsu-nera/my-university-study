package keisan_suugaku_kouki;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class SOR200712061406085 {//SOR法のプログラム
	final static int n=16;
	public static void main(String[] args)throws IOException{
		int s,t;
		double a[][] =new double[n][n];
		double b[]=new double[n];
		double x[]= new double[n];
		double A[][] = new double[n][n+1];
		double w = 0.1;
		for(int i=0;i<n;i++){
			x[i] =0;
		}
		String str1,str2;
		StringTokenizer el;

		
		try{
		BufferedReader fin = new BufferedReader(new FileReader("keisan_suugaku_kouki/Book1.csv"));
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
		
		/*try{
			BufferedReader fin = new BufferedReader(new FileReader("keisan_suugaku_kouki/data20071206vector1.txt"));
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
			}	*/
			
			
			for(int i=0;i<n;i++	){
				for(int j=0;j<n+1;j++){
					if(j<n) a[i][j] = A[i][j];
					if(j==n)b[i]=A[i][j];
				}
			}
			
		
						
		SOR200712061406085 g = new SOR200712061406085();
		g.SOR(a, b, x);
	
	/*for(w=0.1;w<2.0;w=w+0.1){
		w=1.0;
		for(int i=0;i<n;i++){
			x[i] =2.0;
		}
		double[][] mm=new double[n][n];
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i>j)mm[i][j]=a[i][j];
				if(i==j)mm[i][j]=a[i][j]/w;
				if(i<j)mm[i][j]=0.0;
			}
		}
		
		double[][] nn=new double[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				if(i>j)nn[i][j]=0.0;
				if(i==j)nn[i][j]=a[i][j]*(1.0-w)/w;
				if(i<j)nn[i][j]=(-1.0)*a[i][j];
			}
		}
		double[][] a_anti=new double[n][n];
		g.anti_matrix(mm,a_anti);
		
		double tt[][]=new double[n][n];
		for(int i=0;i<n;i++	){
			for(int  j=0;j<n;j++){
				tt[i][j]=0;
			}
		}
		
		for(int j=0;j<n;j++	){
			for(int  i=0;i<n;i++){
				for(int k=0;k<n;k++){
					tt[i][j]=tt[i][j]+a_anti[i][k]*nn[k][j];
				}
			}
		}
		
		double[] c=new double[n];
		for( int i=0;i<n;i++	){
				c[i]=0;
		}
		
		for(int i=0;i<n;i++	){
			for( int j=0;j<n;j++){
				c[i]=c[i]+a_anti[i][j]*b[j];
			}
		}
		
		g.show2(tt);
		
		int k,N=0;
		double y[]=new double[n];
		double[] temp=new double[n];
		double epsilon =1.0e-10;
		
		
		
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
			
		}*/
		
		System.out.println();
		for( int i=0;i<a.length;i++){
			System.out.printf("x["+(i+1)+"]="+"%10.8f",x[i]);
			System.out.println();
		
	}
		
		
		
	}
		
		
		
		
		
		
		/*try{
			PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("keisan_suugaku_kouki/GS200711081406085.txt")));//ファイル・オープン開始 ***** ここで出力ファイル名を指定する

			for(int i=0 ; i<a.length ; i++){
						fout.printf("x["+(i+1)+"]="+"%10.8f",x[i]);
					fout.println();
			}
					fout.close();			
			}catch (Exception e){						//─┐
				System.out.println("書き込みエラー：" + e);		//　├指定ファイルに
				System.exit(1);						//　│書き込めないときの命令
			}
		}*/

	void SOR(double a[][],double b[],double x[]){
		double e =1.0e-10;
		double sum;
		double[] temp2= new double[n];
		for(double w=1.2;w<1.3;w=w+0.01){
			System.out.println();
			for(int  i=0;i<a.length;i++){
				System.out.printf("x["+(i+1)+"]="+"%10.8f",x[i]);
				System.out.println();
			}
			for(int i=0;i<n;i++){
				x[i] =2.0;
			}
			
		for(int m=0;m<200;m++){
			
			for(int i=0;i<n;i++){
				sum=0.0;
				for(int p=0;p<n;p++){
					sum=sum+a[i][p]*x[p];
				}
				temp2[i]=b[i]-sum;
			}
			
			if(norm_max(temp2)<e){
				int N = m;
				System.out.printf("w ="+"%2.1f"+"のとき、"+N+"回で収束",w);
				System.out.println();
				break;
			}else if(m==199){
				System.out.printf("w ="+"%2.1f"+"のとき、収束しない",w);
				System.out.println();
				break;
			}
			
			
			double temp[] = new double[x.length];
			for(int i=0;i<n;i++){
				
				double sum1 =0;
				double sum2 =0;
				for(int j=0;j<i;j++){
					sum1 =sum1+a[i][j]*x[j];
				}
				for(int j=i+1;j<n;j++){
					sum2 =sum2+a[i][j]*x[j];
				}
			temp[i] = x[i];
			x[i]=(b[i]-sum1-sum2)/a[i][i];
			x[i]=(1-w)*temp[i]+w*x[i];
			}
		}}
		}
	
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
	
	static double norm_max(double x[]){
		double p=0;
		for(int i=0;i<n;i++){
			p=Math.max(p, Math.abs(x[i]));
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
	
	/*double norm_2(double x[]){
		double p=0;
		for(int i=0;i<x.length;i++){
			p += Math.pow(Math.abs(x[i]),2);
		}
		return Math.sqrt(p);
	}*/
}
