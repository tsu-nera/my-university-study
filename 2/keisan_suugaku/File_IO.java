package keisan_suugaku;

import java.io.*;
import java.util.*;

public class File_IO{	
	public static void main(String args[]) throws IOException
	{

	/* 初期設定 */
	int i,j;
	int order_row = 0;
	int order_col = 0;
	double a[][] = new double[100][100];	//成分の配列の設定
	double x[][] = new double[100][1];
	double b[][] = new double[100][1];
	double c[][] = new double[100][1];
	double d[][] = new double[100][1];
	String str1,str2;
	StringTokenizer el;

	/* ファイル読み込み */
	try{
	BufferedReader fin = new BufferedReader(new FileReader("data20071011.txt"));	//ファイル・オープン開始 ***** ここで入力ファイル名を指定する
		/* 行列のファイルからの入力 */
		i = 0;
		while((str1=fin.readLine()) != null){			//─┐
			j = 0;						//　│
			el = new StringTokenizer(str1,",");		//　│
			while(el.hasMoreTokens()){			//　├成分の読み込
				str2 = el.nextToken();			//　│
				a[i][j] = Double.parseDouble(str2);	//　│
				j = j+1;				//　│
			}						//─┘
			order_row = j-1;				//列数の決定
			i = i+1;
		}
		fin.close();						//ファイル・クローズ
		order_col = i-1;					//行数の決定
	}
	
	catch(Exception e){						//─┐
		System.out.println("読み込みエラー:" + e);		//　├指定ファイルが開けないときの命令
		System.exit(1);						//　│
	}								//─┘

	
	/* ファイル読み込み */
	try{
	BufferedReader fin = new BufferedReader(new FileReader("data20070712vectorx.txt"));	//ファイル・オープン開始 ***** ここで入力ファイル名を指定する
		/* 行列のファイルからの入力 */
		i = 0;
		while((str1=fin.readLine()) != null){			//─┐
			j = 0;						//　│
			el = new StringTokenizer(str1,",");		//　│
			while(el.hasMoreTokens()){			//　├成分の読み込
				str2 = el.nextToken();			//　│
				x[i][j] = Double.parseDouble(str2);	//　│
				j = j+1;				//　│
			}						//─┘
			order_row = j-1;				//列数の決定
			i = i+1;
		}
		fin.close();						//ファイル・クローズ
		order_col = i-1;					//行数の決定
	}
	
	catch(Exception e){						//─┐
		System.out.println("読み込みエラー:" + e);		//　├指定ファイルが開けないときの命令
		System.exit(1);						//　│
	}								//─┘
	
	/* ファイル読み込み */
	try{
	BufferedReader fin = new BufferedReader(new FileReader("keisan_suugaku/data20070712vectorb.txt"));	//ファイル・オープン開始 ***** ここで入力ファイル名を指定する
		/* 行列のファイルからの入力 */
		i = 0;
		while((str1=fin.readLine()) != null){			//─┐
			j = 0;						//　│
			el = new StringTokenizer(str1,",");		//　│
			while(el.hasMoreTokens()){			//　├成分の読み込
				str2 = el.nextToken();			//　│
				b[i][j] = Double.parseDouble(str2);	//　│
				j = j+1;				//　│
			}						//─┘
			order_row = j-1;				//列数の決定
			i = i+1;
		}
		fin.close();						//ファイル・クローズ
		order_col = i-1;					//行数の決定
	}
	
	catch(Exception e){						//─┐
		System.out.println("読み込みエラー:" + e);		//　├指定ファイルが開けないときの命令
		System.exit(1);						//　│
	}								//─┘
	
	
	/*-------------------ここに作業するプログラムを書く--------------------------------*/

	for(int k=0;k<100;k++){
		for(int l=0;l<100;l++){
			c[k][0]+=a[l][k]*x[l][0];
		}
	}
	
	for(int k=0;k<100;k++){
		d[k][0] = c[k][0] - b[k][0];
	}

	/*-------------------作業するプログラムの終わり------------------------------------*/


	try{
	PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("LU200710111406085.txt")));//ファイル・オープン開始 ***** ここで出力ファイル名を指定する

	/* 行列のファイルへの出力 */
	fout.println("=========< 行列 >==========");
	/*fout.println("\t");
	for(i=0 ; i<order_col+1 ; i++){
		for(j=0 ; j<order_row+1 ; j++){
			fout.printf("%10.5f \t",x[i][j]);	//行列の成分の出力
		}
		fout.println("\t");					//改行
	}
	fout.close();							//ファイル・クローズ
	}*/
	
	fout.println("\t");
	for(i=0 ; i<order_col+1 ; i++){
			fout.printf("%10.5f \t",d[i][0]);	//行列の成分の出力
		fout.println("\t");					//改行
	}
	fout.close();							//ファイル・クローズ
	}

	catch (Exception e){						//─┐
		System.out.println("書き込みエラー：" + e);		//　├指定ファイルに
		System.exit(1);						//　│書き込めないときの命令
	}								//─┘

	for(int k=0;k<100;k++){
		System.out.println(d[k][0]);
	}
	System.out.println();
	System.out.println(norm_max(d));
}
	
	static double norm_max(double x[][]){
		double p=0;
		for(int i=0;i<x.length;i++){
			p = Math.max(p,Math.abs(x[i][0]));
		}
		return p;
	}
}