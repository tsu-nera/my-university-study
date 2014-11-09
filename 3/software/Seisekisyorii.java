
import java.io.*;
import java.util.*;
public class Seisekisyorii{

	static int heigth = 0,width = 7;			//�ǂݍ��񂾃f�[�^�̍s/�񐔁Bheight�͍s��ǂݍ��ݎ��Ɍ���
	static int num = 0;							//�q�[�v�\�[�g�p

	public static void main(String args[]) throws IOException{
		
		int fl;
		String chr[] = new String [7];
		chr[1]="  (1) BubbleSort                           ";
		chr[2]="  (2) SelectionSort                        ";
		chr[3]="  (3) ��{�}���@                           ";
		chr[4]="  (4) ShellSort                            ";
		chr[5]="  (5) HeapSort                             ";
		chr[6]="  (6) QuickSort                            ";
		System.out.println("");
		System.out.println("+-------------- Solved Method --------------+");
		System.out.println("|"+chr[1]+"|");
		System.out.println("|"+chr[2]+"|");
		System.out.println("|"+chr[3]+"|");
		System.out.println("|"+chr[4]+"|");
		System.out.println("|"+chr[5]+"|");
		System.out.println("|"+chr[6]+"|");
		System.out.println("+-------------------------------------------+");
		System.out.println("");
		fl=intDataRead("Input number for method -------> ");
		
		int data[][]=File_in("seiseki.dat");		//�f�[�^��ǂݍ��ށB
		int right = heigth-1;						//�N�C�b�N�\�[�g�p�ϐ�
		int left = 0;
		
		for(int i=0 ; i < heigth ; i++){
			for(int j=2 ; j < width ; j++){
				if(data[i][j]!=-1){
					data[i][width] += data[i][j];			//���v���_���o���B�u-1�v��������󔒂Ȃ̂ŉ������Ȃ��B
				}
			}
		}
		int search = width;		//�ꉞ�A���т̍��v�ȊO�ł��\�[�g�ł��������֗����Ǝv���̂ŁA��t�����y�Ȃ悤�ɕʕϐ��B
		
		long tbegin,tend;			//���ԑ���p�B
		tbegin=System.currentTimeMillis();
		
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
		}else{
			System.out.println("���m�Ȑ��l����͂��ĉ�����");
			System.exit(1);
		}
		
		tend=System.currentTimeMillis();
		long diff_ms=tend-tbegin;						//�I�����ԂƊJ�n���Ԃ��ׂď��v���Ԃ����߂�B
		double diff_s=diff_ms/1000.0;
		System.out.println("�\�[�g���v���ԁF"+diff_s+"�b");			//���v���Ԃ̕\��

		System.out.println();
		
		//��������A�搶�̔閧��\���v���W�F�N�g
		int[][] test=new int[102][5];
		for(int i=0 ; i<test.length ; i++){
			for(int j=0 ; j<5 ; j++){
				test[i][j]=0;				//������
			}
		}
		for(int i=0 ; i<heigth ; i++){
			for(int j=0 ; j<5 ; j++){
				for(int k=-1 ; k<=100 ; k++){
					if(data[i][j+2]==k){		//j=0��-1,j=1�͊w�Дԍ��������Ă���
						test[k+1][j]++;
					}
				}
			}
		}
		System.out.println("\t���w\t����\t�Љ�\t����\t�p��");
		for(int i=0 ; i<test.length ; i++){
			System.out.print((i-1)+"�_"+"\t");
			for(int j=0 ; j<5 ; j++){
				System.out.print(test[i][j]+"\t");
			}
			System.out.println();
		}
		File_out_Mat("outdata.txt",test);
		
		Scorerank(search,data);							//���ʂ�t����B
		double[] Ave = ScoreAve(data);					//���ϓ_�����߂�B
		
		File_out("seiseikekka.dat",data,Ave);			//�o��
		
	}
	
	//�s����o�͂��郁�\�b�h
	public static void File_out_Mat(String File_Name, int [][] a){
	try{
		//�t�@�C���E�I�[�v���J�n ***** �����ŏo�̓t�@�C�������w�肷��
		PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter(File_Name)));

		/* �s��̃t�@�C���ւ̏o�� */
		fout.println("=========< �s�� >==========");
		fout.println("\t");
		for(int i=0 ; i<a.length ; i++){
			for(int j=0 ; j<a[0].length ; j++){
				fout.print(a[i][j]+",");	//�s��̐����̏o��
			}
			fout.println("\t");					//���s
		}
		fout.close();							//�t�@�C���E�N���[�Y
		}

		catch (Exception e){								//����
			System.out.println("�������݃G���[�F" + e);		//�@���w��t�@�C����
			System.exit(1);									//�@���������߂Ȃ��Ƃ��̖���
		}													//����
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
		for(int i=0 ; i<=heigth-2 ; i++){
			for(int j=i+1 ; j<=heigth-1 ; j++){
				if(x[i][search] < x[j][search]){
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
		for(int gap=heigth/2; gap>0; gap/=2){
			for(int h=0; h<gap; h++){
				for(int i=h+gap; i<heigth; i+=gap){
					double tmp = x[i][search];
					for(int j=i-gap; j>=h; j-=gap){
						if(x[j][search] > tmp){
							break;
						}
						swap(j+gap,j,x);
					}
				}
			}
		}
	}
	
	//�q�[�v�\�[�g���C�����\�b�h
	public static void HeapSort(int search,int[][] x){
		num=0;
		// ���ёւ���
		for(int i=0;i<heigth;i++){
			insert(search,x);
		}
		// ��ԏ�̗v�f���Ō�ɂ���
		while(num>0){
			--num;
			swap(0,num,x);
			
			int k=1,l=k*2;
			while(l<=num){	
				if(l+1<=num && x[l-1][search]>x[l][search]){ 			//change
					l++;
				}
				if(x[k-1][search]>x[l-1][search]){					//change
					swap(k-1,l-1,x);
				}
				k=l;
				l=k*2;
			}
		}
	}
	
	//�q�[�v�\�[�g�p���\�b�h
	public static void insert(int search,int[][] x){
		num++;
		int k=num,l=k/2;

		while(k>1 && x[k-1][search]<x[l-1][search]){					//change
			swap(k-1,l-1,x);	
			k=l;
			l=k/2;	
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
		return x;
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
		
		int a[][]=new int[row][col];				//row�~col�̍s��̒�`
		
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
			
			//�`�`�����̓ǂݍ��݂�������`�`
			while((str1=fin.readLine()) != null){
				j = 1;
				el = new StringTokenizer(str1," ",true);
				str2 = el.nextToken();
				while(str2 . equals(" ")){		//��ԍŏ��̃f�[�^�܂œǂݐi�߂�
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
			//�`�`�����̓ǂݍ��݂����܂Ł`�`
			}
			
			heigth = i;
			for(k=0 ; k<heigth ; k++){
				a[k][width] = 0;				//��Ŏg������-1����܂����̂ŁB
			}
			fin.close();						//�t�@�C���E�N���[�Y
		}
		catch(Exception e){					  							//����
			System.out.println("File_in_Mat�œǂݍ��݃G���[:" + e);		//�@���w��t�@�C�����J���Ȃ��Ƃ��̖���
			System.exit(1);												//�@��
		}																//����
		return a;
	}
	
	//�s����o�͂��郁�\�b�h
	public static void File_out(String File_Name, int [][] a , double [] b){
		try{
			//�t�@�C���E�I�[�v���J�n ***** �����ŏo�̓t�@�C�������w�肷��
			PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter(File_Name)));

			/* �s��̃t�@�C���ւ̏o�� */
			fout.println("���ϓ_,\t�@���w�@,\t�@���ȁ@,\t�@�Љ�@,\t�@����@,\t�@�p��@");
			for(int i=0 ; i<b.length ; i++){
				if(i==b.length-1){
					fout.printf("\t%.3f",b[i]);
					fout.println("");
					fout.println("");
				}else{
					fout.printf("\t%.3f ,",b[i]);
				}
			}
			fout.println("\t����,\t����,\t�ԍ�,\t���w,\t����,\t�Љ�,\t����,\t�p��");
			for(int i=0 ; i<heigth ; i++){
				for(int j=0 ; j<=width ; j++){
					if(j==width){							//�������Ō�ɂ��Ă������߁A�\�������ւ���B
						if(a[i][j-1] == -1){
//						if(a[i][j] == -1){
							fout.println(" \t");
						}else{
							fout.printf("\t%s",a[i][j-1]);
//							fout.printf("\t%s",a[i][j]);
							fout.println("");
						}
					}else if(j==0){
						if(a[i][j] == -1){
							fout.print("\t  ,");
						}else{
							fout.printf("\t%s ,",a[i][j]);	//�s��̐����̏o��
						}
					}else if(j==1){
						if(a[i][width] == -1){
							fout.print("\t  ,");
						}else{
							fout.printf("\t%s ,",a[i][width]);	//�s��̐����̏o��
						}
					}else{
						if(a[i][j-1] == -1){
//						if(a[i][j] == -1){
							fout.print("\t  ,");
						}else{
							fout.printf("\t%s ,",a[i][j-1]);	//�s��̐����̏o��
//							fout.printf("\t%s ,",a[i][j]);	//�s��̐����̏o��
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
