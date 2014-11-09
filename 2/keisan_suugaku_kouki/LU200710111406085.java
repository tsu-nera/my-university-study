package keisan_suugaku_kouki;

import java.io.*;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class LU200710111406085 {

	public static void main(String[] args)throws IOException{
		int s,t;
		int order_row = 0;
		int order_col = 0;
		int n=6;
		double a[][] = new double[n][n];
		double aa[][] = new double[n][n];
		double l[][] = new double[n][n];
		
		String str1,str2;
		StringTokenizer el;

		
		try{
		BufferedReader fin = new BufferedReader(new FileReader("keisan_suugaku_kouki/data2007102511A.txt"));
			s = 0;
			while((str1=fin.readLine()) != null){			//─┐
				t = 0;						//　│
				el = new StringTokenizer(str1,",");		//　│
				while(el.hasMoreTokens()){			//　├成分の読み込
					str2 = el.nextToken();			//　│
					a[s][t] = Double.parseDouble(str2);	//　│
					t = t+1;				//　│
				}						//─┘
				order_row = t-1;				//列数の決定
				s= s+1;
			}
			fin.close();						//ファイル・クローズ
			order_col = s-1;					//行数の決定
		}
		
		catch(Exception e){						//─┐
			System.out.println("読み込みエラー:" + e);		//　├指定ファイルが開けないときの命令
			System.exit(1);						//　│
		}								//─┘ {
	
		
		for(int k=0;k<a.length;k++){
			
			for(int p=k+1;p<aa.length;p++){
				aa[p][k] = a[p][k]/a[k][k];
				//a[i][k] = a[i][k]/a[k][k];
				
				for(int q=k;q<a.length;q++){
					a[p][q] = a[p][q] - aa[p][k]*a[k][q];
					//a[i][j] = a[i][j] - a[i][k]*a[k][j];
				}
				
			}
		}
		
		for(int i=0;i<aa.length;i++){
			for(int j=0;j<aa.length;j++){
				if(j>i){
					l[i][j]=0;
				}else if(i==j){
					l[i][j]=1;
				}else{
					a[i][j]=aa[i][j];
				}
			}
		}
		LU200710111406085 f = new LU200710111406085();
		f.show2(a);
		System.out.println();
		f.show2(l);
		
	}
		
		
		
		void show2(double x[][]){
			for(int i=0;i<x.length;i++){
				System.out.print("[");
				for(int j=0;j<x[0].length;j++){
					System.out.printf("%10.7f",x[i][j]);
				}
			System.out.println("]");
			}
		}//─┘
	}

