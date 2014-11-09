package keisan_suugaku_kouki;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class GS200711081406085 {//Gauss_Seidel法のアルゴリズム
	final static int n=16;
	int N;
	public static void main(String[] args)throws IOException{
		int s,t;
		double a[][] =new double[n][n];
		double A[][] =new double[n][n+1];
		double b[]=new double[n];
		double x[]= new double[n];
		for(int i=0;i<n;i++){
			x[i] =0;
		}
		String str1,str2;
		StringTokenizer el;

		
		try{
			BufferedReader fin = new BufferedReader(new FileReader("keisan_suugaku_kouki/Book1.csv"));
				s = 0;
				while((str1=fin.readLine()) != null){		//─┐
					t = 0;									//　│
					el = new StringTokenizer(str1,",");		//　│
					while(el.hasMoreTokens()){				//　├成分の読み込
						str2 = el.nextToken();				//　│
						A[s][t] =Double.parseDouble(str2);	//　│
						t = t+1;							//　│
					}										//─┘
					s= s+1;
				}
				fin.close();	//ファイル・クローズ
			}catch(Exception e){						//─┐
				System.out.println("読み込みエラー:" + e);		//　├指定ファイルが開けないときの命令
				System.exit(1);						//　│
			}
			
			
			for(int i=0;i<n;i++	){
				for(int j=0;j<n+1;j++){
					if(j<n) {
						a[i][j] = A[i][j];
					}
					if(j==n){
						b[i] = A[i][j];
					}
				}
			}
			
			
	GS200711081406085 g = new GS200711081406085();
		g.Gauss_Seidel(a, b, x);
		for(int i=0;i<a.length;i++){
			System.out.printf("x["+(i+1)+"]="+"%10.8f",x[i]);
			System.out.print("　　");
			if(i%4==0)System.out.println();
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

	void Gauss_Seidel(double a[][],double b[],double x[]){
		double e =1.0e-10;
		for(int m=0;m<1000;m++){
		double temp[] = new double[x.length];
		//double temp2[] = new double[x.length];
		double sum,sum1,sum2;
		for(int i=0;i<n;i++){
			sum =0;
			for(int j=0;j<n;j++){
				sum=sum+a[i][j]*x[j];
			}
		temp[i]=b[i]-sum;
		}
		if(norm_max(temp)<e){
			N = m;
			System.out.println(N+"回で収束");
			break;
		}else if(m==998){
			System.out.println("収束しませんでした");
			break;
		}
		System.out.println("**************");
		System.out.println(norm_max(temp));
			System.out.println("**********************************");
		
		System.out.println();
		
		
			for(int i=0;i<n;i++){
				sum1 =0;
				sum2 =0;
				for(int j=0;j<i;j++){
					sum1 =sum1+a[i][j]*x[j];
				}
				for(int j=i+1;j<n;j++){
					sum2 =sum2+a[i][j]*x[j];
				}
			//temp2[i] = x[i];
			x[i]=(b[i]-sum1-sum2)/a[i][i];
			}
			for(int i=0;i<a.length;i++){
				System.out.printf("x["+(i+1)+"]="+"%10.8f",x[i]);
				System.out.print("　　");
				if(i%4==0)System.out.println();
			}
			System.out.println();
			/*double[] temp2 = new double[x.length];
			for(int k=0;k<n;k++){
				temp2[k]=(x[k]-temp[k]);
			}
			
			if(norm_max(temp2)<e){
				N = (m+1);
				System.out.println(N+"回で収束");
				break;
			}else if(m==99){
				System.out.println("収束しませんでした");
				break;
			}
			System.out.println();
		}*/
		}
	}
	
	double norm_max(double x[]){
		double p=0;
		for(int i=0;i<n;i++){
			p=Math.max(p, Math.abs(x[i]));
		}
		return p;
	}
}
