package first;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Portfolio {

	public static void main(String[] args) {
		String str1,str2;
		StringTokenizer el;
		int i,j;
		int n=14;
		double[][] x= new double[n][2];
		try{
			BufferedReader fin = new BufferedReader(new FileReader("first/Book1.csv"));	
				i = 0;
				while((str1=fin.readLine()) != null){			//─┐
					j = 0;						//　│
					el = new StringTokenizer(str1,",");		//　│
					while(el.hasMoreTokens()){			//　├成分の読み込
						str2 = el.nextToken();
						if(j==0)x[i][0]=Double.parseDouble(str2);
						else x[i][1]= Double.parseDouble(str2);	//　│
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
			
			double[] b=new double[n];
			double[] exp=new double[n];
			double[] var=new double[n];
			double V=0;
			for(i=0;i<n;i++){
				exp[i]=(x[i][1]+1)*x[i][0]-1;
				System.out.println(exp[i]);
			}
			System.out.println();
			for(i=0;i<n;i++){
				var[i]=x[i][0]*(x[i][1]-exp[i])*(x[i][1]-exp[i])+(1-x[i][0])*(-1-exp[i])*(-1-exp[i]);
			}
			for(i=0;i<n;i++){
				V=V+1/var[i];
			}
			for(i=0;i<n;i++){
				b[i]=1/(V*var[i]);
				System.out.println(b[i]*5000);
			}
			
			System.out.println();
			V=0;
			for(i=0;i<n;i++){
				V=V+b[i];
			}
			System.out.println(V);
	}
	
	static double Exp(double x[],double prob[]){
		double m=0;
		for(int i=0;i<4;i++){
			m=m+x[i]*prob[i];
		}
		return m;
	}
	
	static double Var(double m,double x[],double prob[]){
		double v=0;
		for(int i=0;i<x.length;i++){
			v=v+(x[i]-m)*(x[i]-m)*prob[i];
		}
		return v;
	}

}
