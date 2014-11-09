
import java.io.*;
import java.util.*;
public class File_IO{

	static int heigth=0,width=7;			//読み込んだデータの行/列数。heightは行列読み込み時に決定

	public static void main(String args[]) throws IOException{
		
		int fl;
		String chr[] = new String [8];
		
		chr[1]="  (1) BubbleSort                           ";
		chr[2]="  (2) SelectionSort                        ";
		chr[3]="  (3) 基本挿入法                           ";
		chr[4]="  (4) シェルソート                         ";
		chr[5]="  (5) ヒープソート        　                ";
		chr[6]="  (6) QuickSort                            ";
		chr[7]="  (7) 未実装                               ";
		System.out.println("");
		System.out.println("+-------------- Solved Method --------------+");
		System.out.println("|"+chr[1]+"|");
		System.out.println("|"+chr[2]+"|");
		System.out.println("|"+chr[3]+"|");
		System.out.println("|"+chr[4]+"|");
		System.out.println("|"+chr[5]+"|");
		System.out.println("|"+chr[6]+"|");
		System.out.println("|"+chr[7]+"|");
		System.out.println("+-------------------------------------------+");
		System.out.println("");
		fl=intDataRead("Input number for method -------> ");
		
		int data[][]=File_in("seiseki.dat");		//データを読み込む。
		int right = heigth-1;				//クイックソート用変数
		int left = 0;
		
		for(int i=0 ; i < heigth ; i++){
			for(int j=2 ; j < width ; j++){
				if(data[i][j]==-1){
						//何か処理する可能性があるので今のところ。
				}else{
					data[i][width] += data[i][j];			//合計得点を出す。
				}
			}
		}
		int search = width;		//一応、成績の合計以外でもソートできた方が便利だと思うので、後付けが楽なように別変数。
		
		if(fl==1){
			BubbleSort(search,data);
		}else if(fl==2){
			SelectionSort(search,data);
		}else if(fl==3){
			BasicInsertion(search,data);
		}else if(fl==4){
			ShellSort(search,data);
		}else if(fl==5){
			HeapSort(search,data);
		}else if(fl==6){
			QuickSort(search,right,left,data);
		}else if(fl==7){
			
		}else{
			System.out.println("正確な数値を入力して下さい");
			System.exit(1);
		}
		
		System.out.println(fl);
		System.out.println(heigth);
		System.out.println(width);
		
		Scorerank(search,data);			//順位を付ける。
		double[] Ave = ScoreAve(data);					//平均点を求める。
		
	/*-------------------作業するプログラムの終わり------------------------------------*/
		//↓出力
		File_out("seiseikekka.dat",data,Ave);
		//↑出力
	}
	
	//順位を付けるメソッド
	public static void Scorerank(int search,int[][] x){
		int rank=0;
		for(int i=0 ; i<heigth ; i++){
			x[i][0] = rank+1;
			if(x[i][search]>x[i+1][search]){
				rank = i+1;
			}
		}
	}
	
	//平均を求めるメソッド
	public static double[] ScoreAve(int[][] x){
		int sum = 0;
		int ninzu = 0;
		double[] Ave = new double[width-2];
		for(int i=0 ; i<Ave.length ; i++){
			sum = 0;
			ninzu = 0;
			for(int j=0 ; j<heigth ; j++){
				if(x[j][i+2]!=-1){				//頭二つが順位と番号なため+2。
					sum += x[j][i+2];			//-1だった場合は分母からも分子からも無くす。
					ninzu++;
				}
			}
			Ave[i]=(double)sum/(double)ninzu;
		}
		return Ave;
	}
	
	//並び替え用のメソッド
	public static void swap(int i,int j,int[][] x){
		int a=0;
		for(int k = 1 ; k <= width ; k++){
			a=x[j][k];
			x[j][k]=x[i][k];
			x[i][k]=a;
		}
	}
	
	//バブルソート
	public static void BubbleSort(int search,int[][] x){
		for(int i=heigth-1 ; i>=1 ; i--){
			for(int j=0 ; j<=i-1 ; j++){
				if(x[j][search] < x[j+1][search]){
					swap(j,j+1,x);
				}
			}
		}
	}
	
	//セレクションソート
	public static void SelectionSort(int search,int[][] x){
		for(int i=heigth-1 ; i>=1 ; i--){
			for(int j=0 ; j<=i-1; j++){
				if(x[j][search] < x[i][search]){
					swap(i,j,x);
				}
			}
		}
	}
	
	//基本挿入法
	public static void BasicInsertion(int search,int[][] x){
		for(int i=1 ; i<=heigth-1 ; i++){
			for(int j=i-1 ; j>=0 ; j--){
				if(x[j][search] < x[j+1][search]){
					swap(j,j+1,x);
				}
			}
		}
	}
	
	//シェルソート
	public static void ShellSort(int search,int[][] x){
		for(int span=heigth/2; span>0; span/=2){
			for(int grp=0; grp<span; grp++){
				//ここから基本挿入法
				for(int i=grp+span; i<heigth; i+=span){
					for(int j=i-span; j>=grp; j-=span){
						if(x[j][search] < x[j+span][search]){
							swap(j+span,j,x);	
						}	
					}
				}
			}
		}
	}
	
	
	
/*
	//***完全二分木をつくるメゾッド 一つ目
	public static void ShiftDown(int search,int last,int[][] x){
		int j=1;
		 for(int i=last-1;i;){
				if(x[i-1][search]>x[i][search]) i--;  //二つの子同士の比較
				if(j>1&&x[i-1][search]<x[j-1][search]){
				swap(i-1,j-1,x);	//親と子の交換
				i=j;    //下の階層の比較へ
				j=i/2;	
				}
			}
	}
	
	//ヒープソートメインメソッド
	public static void HeapSort(int search,int[][] x){
		int  last= heigth-1;
		ShiftDown(search,last,x);   //ヒープに並び替える
		while(last>=1){
			swap(0,last,x);  //根を整列済みの配列に入れる
			last--;
			ShiftDown(search,last,x);
		}
	}*/
	

/*
	//***ヒープソート***二つ目
	
	public static void insert(int search,int num,int[][] x){
		int k=1,l=2;
		while(l<=num){	
			if(l<num && x[l-1][search]>x[l][search])l++;//子供同士の交換。子がひとつならば何もしない
			if(x[k-1][search]>x[l-1][search]){
				swap(k-1,l-1,x);
			}
			k=l;
			l=k*2;
		}
	}
	
	//ヒープソートメインメソッド
	public static void HeapSort(int search,int[][] x){
		int num=heigth;
		// 並び替える
		for(int i=0;i<heigth;i++){
			insert(search,num,x);
		}
		// 一番上の要素を最後にする
		while(num>0){
			num--;
			swap(0,num,x);
			insert(search,num,x);
		}
	}*/
	
	/*public static void MakeHeap(int search,int i,int max,int[][] x){三つ目
		int j=i*2;
		int k=i*2+1;
		int d;
		if(j>max) return;
		else if(j==max){
			if(x[j][search]>x[i][search]) 
				swap(i,j,x);
				return;
		}
			MakeHeap(search,j,max,x);
			MakeHeap(search,k,max,x);
			if(x[j][search]>x[k][search]){
				d=j;
			}else d=k;
			
			if(x[i][search]<x[d][search]){
				swap(i,d,x);
				MakeHeap(search,d,max,x);
			}
			
		
		
	}
	
	public static void HeapSort(int search,int[][] x){
		int max=heigth-1;
		while(max>1){
			MakeHeap(search,0,max,x);
			swap(0,max,x);
			max--;
		}
	}*/

	//四つ目
	/*public static int num;
	 public static void Insert(int search,int[][] x){
		    num++;
			int k=num,l=k/2;
			while(k>1 && x[k-1][search]<x[l-1][search]){					//change
				swap(k-1,l-1,x);	
				k=l;
				l=k/2;	
			}
		  }

	public static void ShiftDown(int search,int[][] x){
		    int k=1,l=2;
		    while(l<=num){
		    	if(l<num&&x[l-1][search]>x[l][search]) 	l++;
		    	if(x[k-1][search]>x[l-1][search])	swap(k-1,l-1,x);
		        k=l;
		        l=k*2;
		    }
		  }

		 //ヒープソートメインメゾッド
		  public static void HeapSort(int search,int[][] x){
		    num=0;

		    for(int i=0;i<heigth;i++){
				Insert(search,x);
			}
		    // ヒープから取り出しながら配列に格納します。
		    while(num>0){
		    	num--;
		    	swap(0,num,x);
		    	ShiftDown(search,x);
		    }
		  }*/
	
	public static int num;
	 public static void Insert(int search,int[][] x){
			int k=num,l=k/2;
			while(k>1 && x[k-1][search]<x[l-1][search]){					//change
				swap(k-1,l-1,x);
				k=l;
				l=k/2;	
			}
		  }

	public static void ShiftDown(int search,int[][] x){
		    int k=1,l=k*2;
		    while(l<=num){
		    	if(l<num&&x[l-1][search]>x[l][search]) 	l++;
		    	if(x[k-1][search]>x[l-1][search])	swap(k-1,l-1,x);
		        k=l;
		        l=k*2;
		    }
		  }

		 //ヒープソートメインメゾッド
		  public static void HeapSort(int search,int[][] x){
		    num=0;
		    
		    while(num<heigth){
		    	num++;
		    	Insert(search,x);
		    }
		    // ヒープから取り出しながら配列に格納します。
		    while(num>0){
		    	num--;
		    	swap(0,num,x);
		    	ShiftDown(search,x);
		    }
		  }
		  
		  
		  
	//クイックソートのメソッド
	public static void QuickSort(int search,int right,int left,int[][] x){
		if(right<=left) return;
		int pivot = x[right][search];
		int sakai =Bunkatu(search,right,left,pivot,x);
		
		QuickSort(search,sakai-1,left,x);
		QuickSort(search,right,sakai+1,x);
	}
	
	//pivotより大きい値を左へ、小さい値を右へ移動させるメソッド
	public static int Bunkatu(int search,int right,int left,int pivot,int[][] x){
		int r = right-1;
		int l = left;
		
		while(l<=r){
			while(r>=left && x[r][search]<=pivot) r--;
			while(l<=right && x[l][search]>pivot) l++;
			if(l>r) break;
			swap(l,r,x);
			r--;
			l++;
		}
		swap(l,right,x);
		return	l;
	}
	
	//最初にキーボードから数字を入力するためのメソッド
	public static int intDataRead(String str){
		String c = null;
		int x;
		InputStreamReader keyin = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader (keyin);
		try{
			System.out.print(str);
			c = buff.readLine();
		}
		catch (IOException e){
			System.out.println(e.getMessage());
			System.exit(1);
		}
		x = Integer.parseInt(c);
		return (x);
	}
	
	//行列を読み込むメソッド
	public static int[][] File_in(String File_Name){
		int i,j,k;
		int col=8;//行列の行数
		int row=20001;//行列の列数
		String str1,str2;
		str2=" ";
		StringTokenizer el;
		/* ファイル読み込み */

		//row×colの行列の定義
		int a[][]=new int[row][col];

		for(i=0 ; i<row ; i++){
			for(j=0 ; j<col ; j++){
				a[i][j] = -1;						//一応、「-1」を投入。
			}
		}
		i = 0;
		j = 0;
		k = 0;

		try{
			//ファイル・オープン開始 ***** ここで入力ファイル名を指定する
			BufferedReader fin = new BufferedReader(new FileReader(File_Name));	
			/* 行列のファイルからの入力 */
			i = 0;
			
			//成分の読み込みここから
			while((str1=fin.readLine()) != null){
				j = 1;
				el = new StringTokenizer(str1," ",true);
				str2 = el.nextToken();
				while(str2.equals(" ")){		//一番最初のデータまで読み進める
					str2 = el.nextToken();
				}
				a[i][j] = Integer.parseInt(str2);
				j = j+1;
				
				while(el.hasMoreTokens()){
					str2 = el.nextToken();
					while(str2 . equals(" ")){
						k = k+1;
						if(k>=4){				//4つ半角スペースが続いたら空白データとみなして-1を代入
							a[i][j] = -1;
							j = j+1;
							k = 0;
						}
						if(j == width){
							break;
						}
						str2 = el.nextToken();
					}
					if(j == width){
						break;
					}
					a[i][j] = Integer.parseInt(str2);
					j = j+1;
					k = 0;
				}
				i = i+1;

				if(j!=7){
					System.out.println(i+",ここがまずい");		//テスト用
				}
			//成分の読み込みここまで

			}
			
			//～ここから編集～
			heigth = i;

			for(k=0 ; k<heigth ; k++){
				a[k][width] = 0;				//後で使う時に-1じゃまずいので。
			}
			//～ここまで編集～
			fin.close();						//ファイル・クローズ
		}
		catch(Exception e){					  				//─┐
			System.out.println("File_in_Matで読み込みエラー:" + e);		//　├指定ファイルが開けないときの命令
			System.exit(1);									//　│
		}													//─┘
		return a;
	}
	
	//行列を出力するメソッド
	public static void File_out(String File_Name, int [][] a , double [] b){
		try{
			//ファイル・オープン開始 ***** ここで出力ファイル名を指定する
			PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter(File_Name)));

			/* 行列のファイルへの出力 */
			fout.println("\t平均点,\t　数学　,\t　理科　,\t　社会　,\t　国語　,\t　英語　");
			for(int i=0 ; i<b.length ; i++){
				if(i==0){
					fout.printf("\t\t%.3f ,",b[i]);
				}else if(i==b.length-1){
					fout.printf("\t%.3f",b[i]);
					fout.println("");
					fout.println("");
				}else{
					fout.printf("\t%.3f ,",b[i]);
				}
			}
			fout.println("\t順位,\t番号,\t数学,\t理科,\t社会,\t国語,\t英語,\t総合");
			for(int i=0 ; i<heigth ; i++){
				for(int j=0 ; j<=width ; j++){
					if(j==width){
						if(a[i][j] == -1){
							fout.println(" \t");
						}else{
							fout.printf("\t%s",a[i][j]);
							fout.println("");
						}
					}else{
						if(a[i][j] == -1){
							fout.print("\t  ,");
						}else{
							fout.printf("\t%s ,",a[i][j]);	//行列の成分の出力
						}
					}
				}
			}
			fout.close();							//ファイル・クローズ
		}

		catch (Exception e){								//─┐
			System.out.println("書き込みエラー：" + e);		//　├指定ファイルに
			System.exit(1);									//　│書き込めないときの命令
		}													//─┘
	}
	
}
