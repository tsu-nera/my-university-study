package first;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class First_1 {
	static int n=6;  //馬の数
	public static void main(String[] args) {
		int i,j;
		
		double[][] horse = new double[n][4];
		String[]  name= new String[n];
		//２．期待値　３．標準偏差　４．オッズ５．確率
		String str1,str2;
		StringTokenizer el;
		double[] x=new double[4];
		
		try{
			BufferedReader fin = new BufferedReader(new FileReader("first/桜花賞.csv"));	
				i = 0;
				while((str1=fin.readLine()) != null){			//─┐
					j = 0;						//　│
					el = new StringTokenizer(str1,",");		//　│
					while(el.hasMoreTokens()){			//　├成分の読み込
						str2 = el.nextToken();
						if(j==0)name[i]=str2;
						else horse[i][j] = Double.parseDouble(str2);	//　│
						j = j+1;				//　│
					}						//─┘
					i = i+1;
				}
				fin.close();						//ファイル・クローズ
			}
			
			catch(Exception e){	
				System.out.println("読み込みエラー:" + e);
				System.exit(1);	
			}
			
			//シュミレーションの開始
			double[] trial1=new double[n];  //一回の試行に対する馬の能力
			double[] trial2=new double[n];  //一回の試行に対する馬の能力
			double[] trial=new double[2];  //一回の試行に対する馬の能力
			int N=0;	  //試行回数
			int[] win=new int[n];  //一等になった回数のカウント
			int K=0; //１等になった馬の番号の記録
			double max;//１等になった馬の記録

			while(N<5000){
			for(int k=0;k<n;k++){
				trial=normal(horse[k][1],horse[k][2]);
				trial1[k]=trial[0];
				trial2[k]=trial[1];
			}
			max=0;
			for(int k=0;k<n;k++	){
				if(max<trial1[k]){
					K=k;
					max=trial1[k];
				}
			}
			for(int k=0;k<n;k++){
				if(K==k)win[k]++;
			}
			for(int k=0;k<n;k++	){
				if(max<trial2[k]){
					K=k;
					max=trial2[k];
				}
			}
			for(int k=0;k<n;k++){
				if(K==k)win[k]++;
			}
			N++;
			}
			
			double[] p=new double[n];
			
			
			
			//確率の計算
			System.out.println("単勝");
			for(int k=0;k<n;k++	){
				p[k]=(double)win[k]/(2*N);
				System.out.println(/*name[k]+":"+*/p[k]);
			}
			System.out.println();
			//馬連の計算
			System.out.println("馬連");
			double[][] p_2=new double[n][n];
			
			for(int a=n-1;a>0;a--){
				for(int b=a-1;b>=0;b--){
					p_2[a][b]=p[a]*p[b]*(2-p[a]-p[b])/((1-p[a])*(1-p[b]));
				}
			}
			double[][]p_02= new double[n*(n-1)/2][3];
			int s=0;
			for(int a=n-1;a>0;a--){
				for(int b=a-1;b>=0;b--){
					p_02[s][0]=p_2[a][b];
					p_02[s][1]=a;
					p_02[s][2]=b;
					s++;
				}
			}
			BubbleSort(0, p_02);
			for(i=0;i<20;i++){
				System.out.println((int)p_02[i][1]+1+"-"+(int)(p_02[i][2]+1)+","+p_02[i][0]);
				
			}
	}
	
//	並び替え用のメソッド
	public static void swap(int i,int j,double[][] x){
		double a=0;
		for(int k =0 ; k < 3 ; k++){
			a=x[j][k];
			x[j][k]=x[i][k];
			x[i][k]=a;
		}
	}
	
	//バブルソート
	public static void BubbleSort(int search,double[][] x){
		for(int i=(n*(n-1)/2)-1 ; i>=1 ; i--){
			for(int j=0 ; j<=i-1 ; j++){
				if(x[j][search] < x[j+1][search]){
					swap(j,j+1,x);
				}
			}
		}
	}

	
	
	//正規乱数の生成
	static double[] normal(double μ,double σ){
		double u[]=new double[2];
		double z[]=new double[2];
			u[0]=Math.random();
			u[1]=Math.random();
		
			z[0]=Math.pow((-2)*Math.log(u[0]), 0.5)*Math.cos(2*Math.PI*u[1]);
			z[1]=Math.pow((-2)*Math.log(u[0]), 0.5)*Math.sin(2*Math.PI*u[1]);
		
			z[0]=μ+σ*z[0];
			z[1]=μ+σ*z[1];
			
			return z;
	}
}

/*ポートフォリオの計算
static double[] portfolio(double p[],double b[]){
	for(int i=0;i<p.length;i++){
		b[i]=(Math.rint(p[i]*100))/100;
	}
	return b;
}*/

/*double[] spead = new double[n];//スピード指数
for(i=0;i<n;i++){
	spead[i]=(horse[i][1]-horse[i][0]+horse[i][2])*5.7+80.0+horse[i][3]+horse[i][4];
	//スピード指数の算出
}
System.out.println(spead[0]);
double x[]=new double[102];
normal(x);

double class[] = new double[20];
for(int i=0;i<100;i++){
	for(int j=)
}
for(i=0;i<100;i++){
	System.out.println(x[i]);
}*/