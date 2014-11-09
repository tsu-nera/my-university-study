package keisan_suugaku_kouki;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Midterm_Test {
	static int n = 2;
	public static void main(String[] args) {
		String str1,str2;
		StringTokenizer el;

		double[][] a ={ {3,1},{2,4}};//new double[n][n];
		//小数点は、１．０まで入力
		
		double[] b = new double[n];
		int s,t;
		/*try{
		BufferedReader fin = new BufferedReader(new FileReader("keisan_suugaku_kouki/data20071129_4A2.txt"));
			s = 0;
			while((str1=fin.readLine()) != null){			//─┐
				t = 0;						//　│
				el = new StringTokenizer(str1,",");		//　│
				while(el.hasMoreTokens()){			//　├成分の読み込
					str2 = el.nextToken();			//　│
					a[s][t] = Double.parseDouble(str2);	//　│
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
			BufferedReader fin = new BufferedReader(new FileReader("keisan_suugaku_kouki/data20071129_4b2.txt"));
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
		
		
		
		double[] x = new double[n];
		double[][] l = new double[n][n];
		double[][] u = new double[n][n];
		double[][] anti_a = new double[n][n];
		Midterm_Test f = new Midterm_Test();
		System.out.println("行列の∞ーノルムは"+f.norm_max2(a));
		System.out.println();
		System.out.println("*************ＬＵ分解**********");
		f.lu_solution(a, u, l);
		System.out.println("L = ");
		f.show2(l);
		System.out.println("U = ");
		f.show2(u);
		System.out.println();
		System.out.println("***************ＬＵ分解を利用してAx=bを解く*************");
		f.lu_used_solution(l, u, x, b);
		System.out.println("ｘ = ");
		f.show1(x);
		System.out.println();
		System.out.println("**************逆行列を求める**************");
		f.anti_matrix(l, u, anti_a);
		f.show2(anti_a);
		System.out.println();
		System.out.println("**************逆行列の行列ノルム∞***********");
		System.out.println(f.norm_max2(anti_a));
		System.out.println();
		System.out.println("**************条件数（∞）****************");
		System.out.println("cond(A)="+f.norm_max2(a)*f.norm_max2(anti_a));
		
		
		System.out.println("*********ガウスの消去法で解く**********");
		f.gauss(a,b,x);
		f.show1(x);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//LU分解
	void lu_solution(double a[][],double u[][],double l[][]){
		double[][] aa = new double[n][n];
	for(int k=0;k<n;k++){
		for(int p=k+1;p<n;p++){
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
//ＬＵ分解を利用した方程式の解法メゾット
	void lu_used_solution(double l[][],double u[][],double x[],double b[]){
		double[] y = new double[n];
		//前進代入
		double sum =0;
		for(int k=0;k<n;k++){
			sum =0;
			for(int i=0;i<k+1;i++){
				sum+=l[k][i]*y[i];
			}
			y[k]=(b[k]- sum);
		}
		//後退代入
		sum =0;
		for(int k=n-1;k>=0;k--){
			sum =0;
			for(int j=k+1;j<n;j++){
				sum+=u[k][j]*x[j];
			}
			x[k]=(y[k]- sum)/u[k][k];
		}
	}
	
//	ガウスの消去法のメゾット
	void gauss(double a[][],double b[],double x[]){
		double[] aa = new double[n];
		double temp;
		
		for(int k=0;k<n;k++){
			//ピボット選択
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
			//前進消去
			for(int i=k+1;i<n;i++){
					aa[i]=a[i][k]/a[k][k];
					b[i]=b[i]-aa[i]*b[k];
					for(int j=k;j<n;j++){
						a[i][j] =a[i][j] - aa[i]*a[k][j];
					}
			}	
		}
		//後退代入
		double sum =0;
		for(int k=n-1;k>=0;k--){
			sum =0;
			for(int l=k+1;l<n;l++){
				sum+=a[k][l]*x[l];
			}
			x[k]=(b[k]- sum)/a[k][k];
		}
	}
	
	
	
//	逆行列を求めるメゾット
	void anti_matrix(double l[][],double u[][],double x[][]){
		double[][]e =new double[n][n];
		double[] z = new double[n];
		
		for(int i=0;i<n;i++){			//単位行列を生成
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
			lu_used_solution(l,u,z,bb);
			for(int j=0;j<n;j++){
				x[j][i] = z[j];
			}
			
		}	
	}
	
	
	
	//∞ノルム（変数１つ）
	double norm_max1(double x[]){
		double p=0;
		for(int i=0;i<n;i++){
			p=Math.max(p, Math.abs(x[i]));
		}
		return p;
	}
	
//	∞ノルム（変数２つ）
	double norm_max2(double x[][]){
		double p=0;
		double sum=0;
		for(int i=0;i<x.length;i++){
			sum=0;
			for(int j=0;j<x[0].length;j++){
				sum= sum+Math.abs(x[i][j]);
				if(sum>p)  p=sum;
			}
		}
		return p;
	}
//	１ノルム（変数２つ）
	double norm_1_2(double x[][]){
		double p=0;
		double sum=0;
		for(int i=0;i<x[0].length;i++){
			sum=0;
			for(int j=0;j<x.length;j++){
				sum= sum+Math.abs(x[j][i]);
				if(sum>p)  p=sum;
			}
		}
		return p;
	}

	//行列の表示
	void show1(double x[]){
		for(int i=0;i<x.length;i++){
		System.out.println("["+x[i]+"]");
		}
	}
	void show2(double x[][]){
		for(int i=0;i<x.length;i++){
			System.out.print("[");
			for(int j=0;j<x[0].length;j++){
				System.out.printf("%3.3f",x[i][j]);
			}
		System.out.println("]");
		}
	}
}

