//
//Newton�@�ɂ��������̉��ւ̎����󋵂�`�悷��v���O����
//�t�@�C����	�FNewtonViewFrame.java
//
package keisan_suugaku;

import java.awt.*;
import java.awt.event.*;

class MyFrame2 extends Frame{

/* Window�C���W�ɑ΂��鏉���ݒ� */
static int width = 800;				//��ʂ̉���
static int height = 800;				//��ʂ̏c��
final int k = 1;				//���̕΂�
final double xmax = 10.0;			//x���W�̍ő�l
final double ymax = 20.0;			//y���W�̍ő�l

/* Newton�@�ɑ΂��鏉���ݒ� */
final double eps =1.0e-10;			//�����������
final double x0 =2.0;	
final double x1 =1.0;				//�����lx0
final int N=200;				//�ő唽����

/* Window�̐ݒ� */
MyFrame2(String title){
	setTitle(title);				//�^�C�g���ݒ�
	addWindowListener(new WindowAdapter(){	//����{�^���Ή�
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	});
}

/* �`�� */
public void paint(Graphics g){

	double x[] = newton(N);			//Newton�@�̓_��ݒ�
	int max = (int) x[N+2]-1;			//������
	
	/* ���̕`�� */
	g.setColor(Color.black);		//���̐F�ݒ�i���j
	g.drawLine(xaxis(-xmax),yaxis(0.0),xaxis(xmax),yaxis(0.0));	//x��
	g.drawLine(xaxis(0.0),yaxis(ymax),xaxis(0.0),yaxis(-ymax));	//y��

	/* �֐�f(x)�̕`�� */
	int b = 5;				//�֐��̍��ݕ�
	g.setColor(Color.blue);			//�֐��̐F�ݒ�i�j
	int Xmax = (int) xmax*b;
	for(int i=-Xmax ; i<Xmax+1 ;i++){
		g.drawLine(xaxis((double) i/b),yaxis(ff((double) i/b)),xaxis((double) (1.0+i)/b),yaxis(ff((double) (1.0+i)/b)));
						//�֐��̕`��
	}

	/* Secant�@�ɂ������󋵂̕`�� */
	g.setColor(Color.red);			//�H�̐F�ݒ�i�ԁj
	for(int i=0 ; i<max ; i++){
		g.drawLine(xaxis(x[i]),yaxis(0.0),xaxis(x[i]),yaxis(ff(x[i])));
		g.drawLine(xaxis(x[i]),yaxis(ff(x[i])),xaxis(x[i+1]),yaxis(0.0));
	}
	g.drawString("������"+max,100,100);
	g.drawString("��"+x[max],100,120);
	
}

/* X���W�̐ݒ� */
int xaxis(double x){
	double X = (double) width*(k*x/xmax+1.0)/(k+1.0);	//x��X�̕ϊ�
	return (int) X;
}

/* Y���W�̐ݒ� */
int yaxis(double y){
	double Y = height*k*(1.0-y/ymax)/(k+1.0);		//y��Y�̕ϊ�
	return (int) Y;
}

/* Secant�@�̌v�Z */
double newton(int N)[]{

	/* �����ݒ� */
	int i;
	double d;
	double p[] = new double[N+3];		//�z��̐ݒ�
	p[0] = x0;
	p[1] = x1;

	/* Newton�@ */
	for(i=1 ; i<=N+1 ; i++){
		d = Math.abs(ff(p[i]));		//�c���̌v�Z
		if(d<eps){
			break;
		}
		p[i+1] = p[i]-ff(p[i])/gg(p[i],p[i-1]);//��������
	}
	p[N+2] = i;				//������
	return p;
}

/* �֐��̒�` */
static double ff(double x){
	double p =0.0;
	//double[] a={1.0,-3.0,1.0,3.0};
	double[] a={1.0,-1.0,-5.0,-2.0};
	for(int i=0;i<=a.length-1;i++){
		p = p*x +a[i];
	}
	return p;
}

/* ���֐��̒�` */
static double gg(double x, double y){
	double p =( ff(y) - ff(x))/(y-x);
	return p;
}
}

public class SecantViewFrame {
public static void main(String args[]){
	MyFrame2 f = new MyFrame2("Secant�@�̎�����");	//Frame object�̐���
	f.setSize(MyFrame2.width,MyFrame2.height);				//Window�T�C�Y�̐ݒ�
	f.setVisible(true);					//Frame�̕\��
}
}