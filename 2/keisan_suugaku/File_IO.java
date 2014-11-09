package keisan_suugaku;

import java.io.*;
import java.util.*;

public class File_IO{	
	public static void main(String args[]) throws IOException
	{

	/* �����ݒ� */
	int i,j;
	int order_row = 0;
	int order_col = 0;
	double a[][] = new double[100][100];	//�����̔z��̐ݒ�
	double x[][] = new double[100][1];
	double b[][] = new double[100][1];
	double c[][] = new double[100][1];
	double d[][] = new double[100][1];
	String str1,str2;
	StringTokenizer el;

	/* �t�@�C���ǂݍ��� */
	try{
	BufferedReader fin = new BufferedReader(new FileReader("data20071011.txt"));	//�t�@�C���E�I�[�v���J�n ***** �����œ��̓t�@�C�������w�肷��
		/* �s��̃t�@�C������̓��� */
		i = 0;
		while((str1=fin.readLine()) != null){			//����
			j = 0;						//�@��
			el = new StringTokenizer(str1,",");		//�@��
			while(el.hasMoreTokens()){			//�@�������̓ǂݍ�
				str2 = el.nextToken();			//�@��
				a[i][j] = Double.parseDouble(str2);	//�@��
				j = j+1;				//�@��
			}						//����
			order_row = j-1;				//�񐔂̌���
			i = i+1;
		}
		fin.close();						//�t�@�C���E�N���[�Y
		order_col = i-1;					//�s���̌���
	}
	
	catch(Exception e){						//����
		System.out.println("�ǂݍ��݃G���[:" + e);		//�@���w��t�@�C�����J���Ȃ��Ƃ��̖���
		System.exit(1);						//�@��
	}								//����

	
	/* �t�@�C���ǂݍ��� */
	try{
	BufferedReader fin = new BufferedReader(new FileReader("data20070712vectorx.txt"));	//�t�@�C���E�I�[�v���J�n ***** �����œ��̓t�@�C�������w�肷��
		/* �s��̃t�@�C������̓��� */
		i = 0;
		while((str1=fin.readLine()) != null){			//����
			j = 0;						//�@��
			el = new StringTokenizer(str1,",");		//�@��
			while(el.hasMoreTokens()){			//�@�������̓ǂݍ�
				str2 = el.nextToken();			//�@��
				x[i][j] = Double.parseDouble(str2);	//�@��
				j = j+1;				//�@��
			}						//����
			order_row = j-1;				//�񐔂̌���
			i = i+1;
		}
		fin.close();						//�t�@�C���E�N���[�Y
		order_col = i-1;					//�s���̌���
	}
	
	catch(Exception e){						//����
		System.out.println("�ǂݍ��݃G���[:" + e);		//�@���w��t�@�C�����J���Ȃ��Ƃ��̖���
		System.exit(1);						//�@��
	}								//����
	
	/* �t�@�C���ǂݍ��� */
	try{
	BufferedReader fin = new BufferedReader(new FileReader("keisan_suugaku/data20070712vectorb.txt"));	//�t�@�C���E�I�[�v���J�n ***** �����œ��̓t�@�C�������w�肷��
		/* �s��̃t�@�C������̓��� */
		i = 0;
		while((str1=fin.readLine()) != null){			//����
			j = 0;						//�@��
			el = new StringTokenizer(str1,",");		//�@��
			while(el.hasMoreTokens()){			//�@�������̓ǂݍ�
				str2 = el.nextToken();			//�@��
				b[i][j] = Double.parseDouble(str2);	//�@��
				j = j+1;				//�@��
			}						//����
			order_row = j-1;				//�񐔂̌���
			i = i+1;
		}
		fin.close();						//�t�@�C���E�N���[�Y
		order_col = i-1;					//�s���̌���
	}
	
	catch(Exception e){						//����
		System.out.println("�ǂݍ��݃G���[:" + e);		//�@���w��t�@�C�����J���Ȃ��Ƃ��̖���
		System.exit(1);						//�@��
	}								//����
	
	
	/*-------------------�����ɍ�Ƃ���v���O����������--------------------------------*/

	for(int k=0;k<100;k++){
		for(int l=0;l<100;l++){
			c[k][0]+=a[l][k]*x[l][0];
		}
	}
	
	for(int k=0;k<100;k++){
		d[k][0] = c[k][0] - b[k][0];
	}

	/*-------------------��Ƃ���v���O�����̏I���------------------------------------*/


	try{
	PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("LU200710111406085.txt")));//�t�@�C���E�I�[�v���J�n ***** �����ŏo�̓t�@�C�������w�肷��

	/* �s��̃t�@�C���ւ̏o�� */
	fout.println("=========< �s�� >==========");
	/*fout.println("\t");
	for(i=0 ; i<order_col+1 ; i++){
		for(j=0 ; j<order_row+1 ; j++){
			fout.printf("%10.5f \t",x[i][j]);	//�s��̐����̏o��
		}
		fout.println("\t");					//���s
	}
	fout.close();							//�t�@�C���E�N���[�Y
	}*/
	
	fout.println("\t");
	for(i=0 ; i<order_col+1 ; i++){
			fout.printf("%10.5f \t",d[i][0]);	//�s��̐����̏o��
		fout.println("\t");					//���s
	}
	fout.close();							//�t�@�C���E�N���[�Y
	}

	catch (Exception e){						//����
		System.out.println("�������݃G���[�F" + e);		//�@���w��t�@�C����
		System.exit(1);						//�@���������߂Ȃ��Ƃ��̖���
	}								//����

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