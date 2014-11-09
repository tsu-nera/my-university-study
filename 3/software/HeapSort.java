
	//***ヒープソート***

	public static int num;		    // 現在の要素数
	
	public static void insert(int searcher,int[][] x){
		num++;
		int k=num,l=k/2;

		while(k>1 && x[k-1][searcher]<x[l-1][searcher]){					//change
			swap(k-1,l-1,x);	
			k=l;
			l=k/2;	
		}
	}
	
	//ヒープソートメインメソッド
	public static void HeapSort(int search,int[][] x){
		num=0;
		// 並び替える
		for(int i=0;i<heigth;i++){
			insert(search,x);
		}
		// 一番上の要素を最後にする
		while(num>0){
			--num;
			swap(0,num,x);
			
			int k=1,l=k*2;
			while(l<=num){	
				if(l+1<=num && x[l-1][search]>x[l][search]) 			//change
					l++;

				if(x[k-1][search]>x[l-1][search]){					//change
					swap(k-1,l-1,x);
				}
				k=l;
				l=k*2;
			}
		}
	}

	