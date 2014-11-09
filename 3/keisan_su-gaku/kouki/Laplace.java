package kouki;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Laplace {
	static int n=16;
	public static void main(String[] args) throws IOException{
		
			int s,t;
			int order_row = 0;
			int order_col = 0;
			double a[][] = new double[n][n];
			double b[][] = new double[n][1];
			double x[] = new double[n];
			double c[] = new double[n];
			double aa[] = new double[n];
			double temp;
			
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
			}					//─┘ {
			
			try{
				BufferedReader fin = new BufferedReader(new FileReader("kouki/Book2.csv"));
					s = 0;
					while((str1=fin.readLine()) != null){			//─┐
						t = 0;						//　│
						el = new StringTokenizer(str1,",");		//　│
						while(el.hasMoreTokens()){			//　├成分の読み込
							str2 = el.nextToken();			//　│
							b[s][t] = Double.parseDouble(str2);	//　│
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
				}				
			
			
			for(int k=0;k<n;k++){
				
				for(int p=k;p<n;p++){//ピボット選択
					if(Math.abs(a[k][k])<Math.abs(a[p][k])){
						for(int q=k;q<n;q++){
						temp = a[k][q];
						a[k][q]=a[p][q];
						a[p][q]=temp;
						}
				temp = b[k][0];
						b[k][0] = b[p][0];
						b[p][0] = temp;
					}
				}
				
					for(int i=k+1;i<n;i++){//前進消去
						aa[i]=a[i][k]/a[k][k];
						b[i][0]=b[i][0]-aa[i]*b[k][0];
						for(int j=k;j<n;j++){
							a[i][j] =a[i][j] - aa[i]*a[k][j];
					}
				}
			}
			
			x[n-1]=b[n-1][0]/a[n-1][n-1];
			
			for(int k=n-2;k>=0;k--){//後退代入
				for(int l=n-1;l>k;l--){
					c[k]+=a[k][l]*x[l];
				}
				x[k]=(b[k][0]- c[k])/a[k][k];
			}
			
			
			for(int i=0;i<n;i++){
				System.out.println(x[i]);
				//System.out.printf("x["+(i+1)+"]="+"%4.4f",x[i]);
				//System.out.println();
			}
	}
}