
import java.io.*;
import java.util.*;
public class File_IO{

	static int heigth=0,width=7;			//�ǂݍ��񂾃f�[�^�̍s/�񐔁Bheight�͍s��ǂݍ��ݎ��Ɍ���

	public static void main(String args[]) throws IOException{
		
		int fl;
		String chr[] = new String [8];
		
		chr[1]="  (1) BubbleSort                           ";
		chr[2]="  (2) SelectionSort                        ";
		chr[3]="  (3) ��{�}���@                           ";
		chr[4]="  (4) �V�F���\�[�g                         ";
		chr[5]="  (5) �q�[�v�\�[�g        �@                ";
		chr[6]="  (6) QuickSort                            ";
		chr[7]="  (7) ������                               ";
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
		
		int data[][]=File_in("seiseki.dat");		//�f�[�^��ǂݍ��ށB
		int right = heigth-1;				//�N�C�b�N�\�[�g�p�ϐ�
		int left = 0;
		
		for(int i=0 ; i < heigth ; i++){
			for(int j=2 ; j < width ; j++){
				if(data[i][j]==-1){
						//������������\��������̂ō��̂Ƃ���B
				}else{
					data[i][width] += data[i][j];			//���v���_���o���B
				}
			}
		}
		int search = width;		//�ꉞ�A���т̍��v�ȊO�ł��\�[�g�ł��������֗����Ǝv���̂ŁA��t�����y�Ȃ悤�ɕʕϐ��B
		
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
			System.out.println("���m�Ȑ��l����͂��ĉ�����");
			System.exit(1);
		}
		
		System.out.println(fl);
		System.out.println(heigth);
		System.out.println(width);
		
		Scorerank(search,data);			//���ʂ�t����B
		double[] Ave = ScoreAve(data);					//���ϓ_�����߂�B
		
	/*-------------------��Ƃ���v���O�����̏I���------------------------------------*/
		//���o��
		File_out("seiseikekka.dat",data,Ave);
		//���o��
	}
	
	//���ʂ�t���郁�\�b�h
	public static void Scorerank(int search,int[][] x){
		int rank=0;
		for(int i=0 ; i<heigth ; i++){
			x[i][0] = rank+1;
			if(x[i][search]>x[i+1][search]){
				rank = i+1;
			}
		}
	}
	
	//���ς����߂郁�\�b�h
	public static double[] ScoreAve(int[][] x){
		int sum = 0;
		int ninzu = 0;
		double[] Ave = new double[width-2];
		for(int i=0 ; i<Ave.length ; i++){
			sum = 0;
			ninzu = 0;
			for(int j=0 ; j<heigth ; j++){
				if(x[j][i+2]!=-1){				//��������ʂƔԍ��Ȃ���+2�B
					sum += x[j][i+2];			//-1�������ꍇ�͕��ꂩ������q������������B
					ninzu++;
				}
			}
			Ave[i]=(double)sum/(double)ninzu;
		}
		return Ave;
	}
	
	//���ёւ��p�̃��\�b�h
	public static void swap(int i,int j,int[][] x){
		int a=0;
		for(int k = 1 ; k <= width ; k++){
			a=x[j][k];
			x[j][k]=x[i][k];
			x[i][k]=a;
		}
	}
	
	//�o�u���\�[�g
	public static void BubbleSort(int search,int[][] x){
		for(int i=heigth-1 ; i>=1 ; i--){
			for(int j=0 ; j<=i-1 ; j++){
				if(x[j][search] < x[j+1][search]){
					swap(j,j+1,x);
				}
			}
		}
	}
	
	//�Z���N�V�����\�[�g
	public static void SelectionSort(int search,int[][] x){
		for(int i=heigth-1 ; i>=1 ; i--){
			for(int j=0 ; j<=i-1; j++){
				if(x[j][search] < x[i][search]){
					swap(i,j,x);
				}
			}
		}
	}
	
	//��{�}���@
	public static void BasicInsertion(int search,int[][] x){
		for(int i=1 ; i<=heigth-1 ; i++){
			for(int j=i-1 ; j>=0 ; j--){
				if(x[j][search] < x[j+1][search]){
					swap(j,j+1,x);
				}
			}
		}
	}
	
	//�V�F���\�[�g
	public static void ShellSort(int search,int[][] x){
		for(int span=heigth/2; span>0; span/=2){
			for(int grp=0; grp<span; grp++){
				//���������{�}���@
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
	//***���S�񕪖؂����郁�]�b�h ���
	public static void ShiftDown(int search,int last,int[][] x){
		int j=1;
		 for(int i=last-1;i;){
				if(x[i-1][search]>x[i][search]) i--;  //��̎q���m�̔�r
				if(j>1&&x[i-1][search]<x[j-1][search]){
				swap(i-1,j-1,x);	//�e�Ǝq�̌���
				i=j;    //���̊K�w�̔�r��
				j=i/2;	
				}
			}
	}
	
	//�q�[�v�\�[�g���C�����\�b�h
	public static void HeapSort(int search,int[][] x){
		int  last= heigth-1;
		ShiftDown(search,last,x);   //�q�[�v�ɕ��ёւ���
		while(last>=1){
			swap(0,last,x);  //���𐮗�ς݂̔z��ɓ����
			last--;
			ShiftDown(search,last,x);
		}
	}*/
	

/*
	//***�q�[�v�\�[�g***���
	
	public static void insert(int search,int num,int[][] x){
		int k=1,l=2;
		while(l<=num){	
			if(l<num && x[l-1][search]>x[l][search])l++;//�q�����m�̌����B�q���ЂƂȂ�Ή������Ȃ�
			if(x[k-1][search]>x[l-1][search]){
				swap(k-1,l-1,x);
			}
			k=l;
			l=k*2;
		}
	}
	
	//�q�[�v�\�[�g���C�����\�b�h
	public static void HeapSort(int search,int[][] x){
		int num=heigth;
		// ���ёւ���
		for(int i=0;i<heigth;i++){
			insert(search,num,x);
		}
		// ��ԏ�̗v�f���Ō�ɂ���
		while(num>0){
			num--;
			swap(0,num,x);
			insert(search,num,x);
		}
	}*/
	
	/*public static void MakeHeap(int search,int i,int max,int[][] x){�O��
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

	//�l��
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

		 //�q�[�v�\�[�g���C�����]�b�h
		  public static void HeapSort(int search,int[][] x){
		    num=0;

		    for(int i=0;i<heigth;i++){
				Insert(search,x);
			}
		    // �q�[�v������o���Ȃ���z��Ɋi�[���܂��B
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

		 //�q�[�v�\�[�g���C�����]�b�h
		  public static void HeapSort(int search,int[][] x){
		    num=0;
		    
		    while(num<heigth){
		    	num++;
		    	Insert(search,x);
		    }
		    // �q�[�v������o���Ȃ���z��Ɋi�[���܂��B
		    while(num>0){
		    	num--;
		    	swap(0,num,x);
		    	ShiftDown(search,x);
		    }
		  }
		  
		  
		  
	//�N�C�b�N�\�[�g�̃��\�b�h
	public static void QuickSort(int search,int right,int left,int[][] x){
		if(right<=left) return;
		int pivot = x[right][search];
		int sakai =Bunkatu(search,right,left,pivot,x);
		
		QuickSort(search,sakai-1,left,x);
		QuickSort(search,right,sakai+1,x);
	}
	
	//pivot���傫���l�����ցA�������l���E�ֈړ������郁�\�b�h
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
	
	//�ŏ��ɃL�[�{�[�h���琔������͂��邽�߂̃��\�b�h
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
	
	//�s���ǂݍ��ރ��\�b�h
	public static int[][] File_in(String File_Name){
		int i,j,k;
		int col=8;//�s��̍s��
		int row=20001;//�s��̗�
		String str1,str2;
		str2=" ";
		StringTokenizer el;
		/* �t�@�C���ǂݍ��� */

		//row�~col�̍s��̒�`
		int a[][]=new int[row][col];

		for(i=0 ; i<row ; i++){
			for(j=0 ; j<col ; j++){
				a[i][j] = -1;						//�ꉞ�A�u-1�v�𓊓��B
			}
		}
		i = 0;
		j = 0;
		k = 0;

		try{
			//�t�@�C���E�I�[�v���J�n ***** �����œ��̓t�@�C�������w�肷��
			BufferedReader fin = new BufferedReader(new FileReader(File_Name));	
			/* �s��̃t�@�C������̓��� */
			i = 0;
			
			//�����̓ǂݍ��݂�������
			while((str1=fin.readLine()) != null){
				j = 1;
				el = new StringTokenizer(str1," ",true);
				str2 = el.nextToken();
				while(str2.equals(" ")){		//��ԍŏ��̃f�[�^�܂œǂݐi�߂�
					str2 = el.nextToken();
				}
				a[i][j] = Integer.parseInt(str2);
				j = j+1;
				
				while(el.hasMoreTokens()){
					str2 = el.nextToken();
					while(str2 . equals(" ")){
						k = k+1;
						if(k>=4){				//4���p�X�y�[�X����������󔒃f�[�^�Ƃ݂Ȃ���-1����
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
					System.out.println(i+",�������܂���");		//�e�X�g�p
				}
			//�����̓ǂݍ��݂����܂�

			}
			
			//�`��������ҏW�`
			heigth = i;

			for(k=0 ; k<heigth ; k++){
				a[k][width] = 0;				//��Ŏg������-1����܂����̂ŁB
			}
			//�`�����܂ŕҏW�`
			fin.close();						//�t�@�C���E�N���[�Y
		}
		catch(Exception e){					  				//����
			System.out.println("File_in_Mat�œǂݍ��݃G���[:" + e);		//�@���w��t�@�C�����J���Ȃ��Ƃ��̖���
			System.exit(1);									//�@��
		}													//����
		return a;
	}
	
	//�s����o�͂��郁�\�b�h
	public static void File_out(String File_Name, int [][] a , double [] b){
		try{
			//�t�@�C���E�I�[�v���J�n ***** �����ŏo�̓t�@�C�������w�肷��
			PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter(File_Name)));

			/* �s��̃t�@�C���ւ̏o�� */
			fout.println("\t���ϓ_,\t�@���w�@,\t�@���ȁ@,\t�@�Љ�@,\t�@����@,\t�@�p��@");
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
			fout.println("\t����,\t�ԍ�,\t���w,\t����,\t�Љ�,\t����,\t�p��,\t����");
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
							fout.printf("\t%s ,",a[i][j]);	//�s��̐����̏o��
						}
					}
				}
			}
			fout.close();							//�t�@�C���E�N���[�Y
		}

		catch (Exception e){								//����
			System.out.println("�������݃G���[�F" + e);		//�@���w��t�@�C����
			System.exit(1);									//�@���������߂Ȃ��Ƃ��̖���
		}													//����
	}
	
}
