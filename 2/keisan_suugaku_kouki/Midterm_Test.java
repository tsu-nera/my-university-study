package keisan_suugaku_kouki;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Midterm_Test {
	static int n = 2;
	public static void main(String[] args) {
		String str1,str2;
		StringTokenizer el;

		double[][] a ={ {3,1},{2,4}};//new double[n][n];
		//�����_�́A�P�D�O�܂œ���
		
		double[] b = new double[n];
		int s,t;
		/*try{
		BufferedReader fin = new BufferedReader(new FileReader("keisan_suugaku_kouki/data20071129_4A2.txt"));
			s = 0;
			while((str1=fin.readLine()) != null){			//����
				t = 0;						//�@��
				el = new StringTokenizer(str1,",");		//�@��
				while(el.hasMoreTokens()){			//�@�������̓ǂݍ�
					str2 = el.nextToken();			//�@��
					a[s][t] = Double.parseDouble(str2);	//�@��
					t = t+1;				//�@��
				}						//����
				s= s+1;
			}
			fin.close();	//�t�@�C���E�N���[�Y
		}catch(Exception e){						//����
			System.out.println("�ǂݍ��݃G���[:" + e);		//�@���w��t�@�C�����J���Ȃ��Ƃ��̖���
			System.exit(1);						//�@��
		}
		try{
			BufferedReader fin = new BufferedReader(new FileReader("keisan_suugaku_kouki/data20071129_4b2.txt"));
				s = 0;
				while((str1=fin.readLine()) != null){			//����
					t = 0;						//�@��
					el = new StringTokenizer(str1,",");		//�@��
					while(el.hasMoreTokens()){			//�@�������̓ǂݍ�
						str2 = el.nextToken();			//�@��
						b[s] = Double.parseDouble(str2);	//�@��
						t = t+1;				//�@��
					}						//����
					s= s+1;
				}
				fin.close();	//�t�@�C���E�N���[�Y
			}catch(Exception e){						//����
				System.out.println("�ǂݍ��݃G���[:" + e);		//�@���w��t�@�C�����J���Ȃ��Ƃ��̖���
				System.exit(1);						//�@��
			}	
		
		*/
		
		
		
		double[] x = new double[n];
		double[][] l = new double[n][n];
		double[][] u = new double[n][n];
		double[][] anti_a = new double[n][n];
		Midterm_Test f = new Midterm_Test();
		System.out.println("�s��́��[�m������"+f.norm_max2(a));
		System.out.println();
		System.out.println("*************�k�t����**********");
		f.lu_solution(a, u, l);
		System.out.println("L = ");
		f.show2(l);
		System.out.println("U = ");
		f.show2(u);
		System.out.println();
		System.out.println("***************�k�t�����𗘗p����Ax=b������*************");
		f.lu_used_solution(l, u, x, b);
		System.out.println("�� = ");
		f.show1(x);
		System.out.println();
		System.out.println("**************�t�s������߂�**************");
		f.anti_matrix(l, u, anti_a);
		f.show2(anti_a);
		System.out.println();
		System.out.println("**************�t�s��̍s��m������***********");
		System.out.println(f.norm_max2(anti_a));
		System.out.println();
		System.out.println("**************�������i���j****************");
		System.out.println("cond(A)="+f.norm_max2(a)*f.norm_max2(anti_a));
		
		
		System.out.println("*********�K�E�X�̏����@�ŉ���**********");
		f.gauss(a,b,x);
		f.show1(x);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//LU����
	void lu_solution(double a[][],double u[][],double l[][]){
		double[][] aa = new double[n][n];
	for(int k=0;k<n;k++){
		for(int p=k+1;p<n;p++){
			aa[p][k] = a[p][k]/a[k][k];
			
			for(int q=k;q<a.length;q++){
				a[p][q] = a[p][q] - aa[p][k]*a[k][q];
			}
			
		}
	}
	
	for(int i=0;i<n;i++){
		for(int j=0;j<n;j++){
			u[i][j] = a[i][j];
		}
	}
	
	for(int i=0;i<aa.length;i++){
		for(int j=0;j<aa.length;j++){
			if(j>i){
				l[i][j]=0;
			}else if(i==j){
				l[i][j]=1;
			}else{
				l[i][j]=aa[i][j];
			}
		}
	}
	}
//�k�t�����𗘗p�����������̉�@���]�b�g
	void lu_used_solution(double l[][],double u[][],double x[],double b[]){
		double[] y = new double[n];
		//�O�i���
		double sum =0;
		for(int k=0;k<n;k++){
			sum =0;
			for(int i=0;i<k+1;i++){
				sum+=l[k][i]*y[i];
			}
			y[k]=(b[k]- sum);
		}
		//��ޑ��
		sum =0;
		for(int k=n-1;k>=0;k--){
			sum =0;
			for(int j=k+1;j<n;j++){
				sum+=u[k][j]*x[j];
			}
			x[k]=(y[k]- sum)/u[k][k];
		}
	}
	
//	�K�E�X�̏����@�̃��]�b�g
	void gauss(double a[][],double b[],double x[]){
		double[] aa = new double[n];
		double temp;
		
		for(int k=0;k<n;k++){
			//�s�{�b�g�I��
			for(int p=k;p<n;p++){
				if(Math.abs(a[k][k])<Math.abs(a[p][k])){
					for(int q=k;q<n;q++){
					temp = a[k][q];
					a[k][q]=a[p][q];
					a[p][q]=temp;
					}
					temp = b[k];
					b[k]= b[p];
					b[p]= temp;
				}
			}
			//�O�i����
			for(int i=k+1;i<n;i++){
					aa[i]=a[i][k]/a[k][k];
					b[i]=b[i]-aa[i]*b[k];
					for(int j=k;j<n;j++){
						a[i][j] =a[i][j] - aa[i]*a[k][j];
					}
			}	
		}
		//��ޑ��
		double sum =0;
		for(int k=n-1;k>=0;k--){
			sum =0;
			for(int l=k+1;l<n;l++){
				sum+=a[k][l]*x[l];
			}
			x[k]=(b[k]- sum)/a[k][k];
		}
	}
	
	
	
//	�t�s������߂郁�]�b�g
	void anti_matrix(double l[][],double u[][],double x[][]){
		double[][]e =new double[n][n];
		double[] z = new double[n];
		
		for(int i=0;i<n;i++){			//�P�ʍs��𐶐�
			for(int j=0;j<n;j++	){
				if(i==j) e[i][j]=1;
				else e[i][j]=0;
			}
		}
		
		for(int i=0;i<n;i++){
			double[] bb=new double[n];
			for(int j=0;j<n;j++){
				bb[j]=e[j][i];
			}
			lu_used_solution(l,u,z,bb);
			for(int j=0;j<n;j++){
				x[j][i] = z[j];
			}
			
		}	
	}
	
	
	
	//���m�����i�ϐ��P�j
	double norm_max1(double x[]){
		double p=0;
		for(int i=0;i<n;i++){
			p=Math.max(p, Math.abs(x[i]));
		}
		return p;
	}
	
//	���m�����i�ϐ��Q�j
	double norm_max2(double x[][]){
		double p=0;
		double sum=0;
		for(int i=0;i<x.length;i++){
			sum=0;
			for(int j=0;j<x[0].length;j++){
				sum= sum+Math.abs(x[i][j]);
				if(sum>p)  p=sum;
			}
		}
		return p;
	}
//	�P�m�����i�ϐ��Q�j
	double norm_1_2(double x[][]){
		double p=0;
		double sum=0;
		for(int i=0;i<x[0].length;i++){
			sum=0;
			for(int j=0;j<x.length;j++){
				sum= sum+Math.abs(x[j][i]);
				if(sum>p)  p=sum;
			}
		}
		return p;
	}

	//�s��̕\��
	void show1(double x[]){
		for(int i=0;i<x.length;i++){
		System.out.println("["+x[i]+"]");
		}
	}
	void show2(double x[][]){
		for(int i=0;i<x.length;i++){
			System.out.print("[");
			for(int j=0;j<x[0].length;j++){
				System.out.printf("%3.3f",x[i][j]);
			}
		System.out.println("]");
		}
	}
}

