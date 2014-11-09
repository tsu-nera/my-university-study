package kouki;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.math.*;


import java.io.FileReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Makuranosoushi {
	static int k=0;
	public static void main(String[] args) {
		int idt;
		int[][] A=new int[200000][2];
		
		
		
		//ファイルの読み込み
		 try{
		       FileReader fr= new FileReader("kouki/data.dat");
		       idt=fr.read();
		       A[0][0]=idt;
	    	   A[0][1]=1;
	    	   k++;
		       while((idt=fr.read())!=-1){
		    	   int j=0;
		    	   for(;j<k&&A[j][0]!=idt;j++){
		    	   }
		    	   if(A[j][0]==idt){
		    		   A[j][1]++;
		    	   }else{
		    		   A[k][0]=idt;
		    		   A[k][1]=1;
		    		   k++;
		    	   }
		    	   }
		   
		       
		       fr.close();
		    } catch(Exception e){
		        e.printStackTrace();
		    }
		    
		    
		    BubbleSort(1,A);
		    
		    //固定ビット長の計算
		    int l=0;
		    int L=0;
		    int n=0;
		    while(true){
		    	l++;
		    	L=(int) (L+Math.pow(2,l));
		    	if(L>k)break;
		    }
		    while(true){
		    	n++;
		    	L=(int) (Math.pow(2, n));
		    	if(L>l)break;
		    }
		    l=l+n;
		    
		    
		    //可変ビットの作成
		    int[][] C=new int[k][l];
			C[0][0]=0;
			C[0][1]=0;
			C[0][2]=0;
			C[0][3]=1;
			C[0][4]=0;
			
			C[1][0]=0;
			C[1][1]=0;
			C[1][2]=0;
			C[1][3]=1;
			C[1][4]=1;
		    for(int p=1;p<l;p++){
				for(int i=(int) (Math.pow(2,p+1)-2);i<Math.pow(2,p+1)-2+Math.pow(2,p)&&i<k;i++){
					int P=p+1;
					for(int q=0;q<n;q++){//p+1の二進表示
						if(P>=Math.pow(2, n-1-q))C[i][q]=1;
						else C[i][q]=0;
						P=(int) (P%Math.pow(2, n-1-q));
					}
					C[i][p+n]=0;
					for(int j=n;j<p+n;j++){
						C[i][j]=C[(int) (i-Math.pow(2,p))][j];
					}
				}
				
				for(int i=(int) (Math.pow(2,p+1)-2+Math.pow(2,p));i<Math.pow(2, p+2)-2&&i<k;i++){
					int P=p+1;
					for(int q=0;q<n;q++){//p+1の二進表示
						if(P>=Math.pow(2, n-1-q))C[i][q]=1;
						else C[i][q]=0;
						P=(int) (P%Math.pow(2, n-1-q));
					}
					C[i][p+n]=1;
					for(int j=n;j<p+n;j++){
						C[i][j]=C[(int) (i-Math.pow(2, p+1))][j];
					}
				}
			}
			
			//表示
			/*`for(int p=0;p<l;p++	){
				for(int i=(int) (Math.pow(2,p+1)-2);i<Math.pow(2, p+2)-2&&i<k;i++){
					for(int j=0;j<=p+n;j++){
						System.out.print(C[i][j]);
					}
					System.out.println();
				}
			}*/
		   
			//一文字ずつ格納する
			int[] D=new int[133123];
			int I=0;
			//ファイルの読み込み
			 try{
			       FileReader fr= new FileReader("kouki/data.dat");
			       
			       while((idt=fr.read())!=-1){
			    	  D[I]=idt;
			    	  I++;
			    	   }
			       fr.close();
			    } catch(Exception e){
			        e.printStackTrace();
			    }
			//暗号化    
			try{
				PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("kouki/data2.dat")));
				int i1=0;
				while(i1<133123){//4620){
					for(int j=0;j<k;j++){
						if(D[i1]==A[j][0]){
							int b=0;//jにおけるビット数の計算
							int B=0;
							while(true){
						    	b++;
						    	B=(int) (B+Math.pow(2,b));
						    	if(B>j)break;
						    }
						for(int a=0;a<b+n;a++){
							fout.print(C[j][a]);
						}
					}
					}
				i1++;
				}
				fout.close();
			}catch (Exception e){						//─┐
				System.out.println("書き込みエラー：" + e);		//　├指定ファイルに
				System.exit(1);						//　│書き込めないときの命令
			}
}
	
	

//	  並び替え用のメソッド
		public static void swap(int i,int j,int[][] x){
			int a=0;
			for(int k = 0 ; k <= 1; k++){
				a=x[j][k];
				x[j][k]=x[i][k];
				x[i][k]=a;
			}
		}
		
		//バブルソート
		public static void BubbleSort(int search,int[][] x){
			for(int i=k; i>=1 ; i--){
				for(int j=0 ; j<=i-1 ; j++){
					if(x[j][search] < x[j+1][search]){
						swap(j,j+1,x);
					}
				}
			}
		}

}

/* int[][] C=new int[k][l];
C[0][0]=0;
C[1][0]=1;
for(int p=1;p<l;p++){
	for(int i=(int) (Math.pow(2,p+1)-2);i<Math.pow(2,p+1)-2+Math.pow(2,p)&&i<k;i++){
		C[i][p]=0;
		for(int j=0;j<p;j++){
			C[i][j]=C[(int) (i-Math.pow(2,p))][j];
		}
	}
	for(int i=(int) (Math.pow(2,p+1)-2+Math.pow(2,p));i<Math.pow(2, p+2)-2&&i<k;i++){
		C[i][p]=1;
		for(int j=0;j<p;j++){
			C[i][j]=C[(int) (i-Math.pow(2, p+1))][j];
		}
	}
}

for(int p=0;p<l;p++	){
	for(int i=(int) (Math.pow(2,p+1)-2);i<Math.pow(2, p+2)-2&&i<k;i++){
		System.out.print("A="+(char)A[i][0]);
		System.out.print("  B="+A[i][1]+"  ");
		for(int j=0;j<=p;j++){
			System.out.print(C[i][j]);
		}
		System.out.println();
	}
}*/