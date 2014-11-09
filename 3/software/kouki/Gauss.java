package kouki;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Gauss {
	public static void main(String[] args)throws IOException{
		int s,t;
		int order_row = 0;
		int order_col = 0;
		double a[][] = {{1,6,1},{1,4,2},{1,5,4}};//new double[20][20];
		double b[] ={4,4,2};// new double[3][1];
		double x[] = new double[3];
		double c[] = new double[3];
		double aa[] = new double[3];
		int n= a.length;
		double temp;
		double P=7;
		
		String str1,str2;
		StringTokenizer el;

		/*
		try{
		BufferedReader fin = new BufferedReader(new FileReader("keisan_suugaku_kouki/data20071018matrix3.txt"));
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
			BufferedReader fin = new BufferedReader(new FileReader("keisan_suugaku_kouki/data20071018vector3.txt"));
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
		*/
		
		for(int k=0;k<n;k++){
			
			for(int p=k;p<n;p++){//ピボット選択
				if(Math.abs(a[k][k])<Math.abs(a[p][k])){
					for(int q=k;q<n;q++){
					temp = a[k][q];
					a[k][q]=a[p][q];
					a[p][q]=temp;
					}
					temp = b[k];
					b[k] = b[p];
					b[p] = temp;
				}
			}
				for(int i=k+1;i<n;i++){//前進消去
					aa[i]=mod2(a[i][k],a[k][k],P);
					b[i]=b[i]-aa[i]*b[k];
					for(int j=k;j<n;j++){
						a[i][j] =a[i][j] - aa[i]*a[k][j];
				}
			}
		}
		System.out.println(mod2(-2,-3,7));
		
		x[n-1]=mod2(b[n-1],a[n-1][n-1],P);
		
		for(int k=n-2;k>=0;k--){//後退代入
			for(int l=n-1;l>k;l--){
				c[k]+=a[k][l]*x[l];
			}
			x[k]=mod2((b[k]- c[k]),a[k][k],P);
		}
		for(int i=0;i<n;i++){
			System.out.printf("x["+(i+1)+"]="+"%4.4f",x[i]);
			System.out.println();
		}
	}	
	
	static double mod2(double a,double b,double p){//逆元の割り算
		double i;
			for(int k=1;a<0;k++){
				a=a+p*k;
			}
			for(int k=1;b<0;k++){
				b=b+p*k;
			}
			for(i=0;a%p!=(b*i)%p;i++){;
		}
	
		return i;
	}
}
