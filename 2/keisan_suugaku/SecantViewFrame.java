//
//Newton法による方程式の解への収束状況を描画するプログラム
//ファイル名	：NewtonViewFrame.java
//
package keisan_suugaku;

import java.awt.*;
import java.awt.event.*;

class MyFrame2 extends Frame{

/* Window，座標に対する初期設定 */
static int width = 800;				//画面の横幅
static int height = 800;				//画面の縦幅
final int k = 1;				//軸の偏り
final double xmax = 10.0;			//x座標の最大値
final double ymax = 20.0;			//y座標の最大値

/* Newton法に対する初期設定 */
final double eps =1.0e-10;			//収束判定条件
final double x0 =2.0;	
final double x1 =1.0;				//初期値x0
final int N=200;				//最大反復数

/* Windowの設定 */
MyFrame2(String title){
	setTitle(title);				//タイトル設定
	addWindowListener(new WindowAdapter(){	//閉じるボタン対応
		public void windowClosing(WindowEvent e){
			System.exit(0);
		}
	});
}

/* 描画 */
public void paint(Graphics g){

	double x[] = newton(N);			//Newton法の点列設定
	int max = (int) x[N+2]-1;			//反復回数
	
	/* 軸の描画 */
	g.setColor(Color.black);		//軸の色設定（黒）
	g.drawLine(xaxis(-xmax),yaxis(0.0),xaxis(xmax),yaxis(0.0));	//x軸
	g.drawLine(xaxis(0.0),yaxis(ymax),xaxis(0.0),yaxis(-ymax));	//y軸

	/* 関数f(x)の描画 */
	int b = 5;				//関数の刻み幅
	g.setColor(Color.blue);			//関数の色設定（青）
	int Xmax = (int) xmax*b;
	for(int i=-Xmax ; i<Xmax+1 ;i++){
		g.drawLine(xaxis((double) i/b),yaxis(ff((double) i/b)),xaxis((double) (1.0+i)/b),yaxis(ff((double) (1.0+i)/b)));
						//関数の描画
	}

	/* Secant法による収束状況の描画 */
	g.setColor(Color.red);			//？の色設定（赤）
	for(int i=0 ; i<max ; i++){
		g.drawLine(xaxis(x[i]),yaxis(0.0),xaxis(x[i]),yaxis(ff(x[i])));
		g.drawLine(xaxis(x[i]),yaxis(ff(x[i])),xaxis(x[i+1]),yaxis(0.0));
	}
	g.drawString("反復回数"+max,100,100);
	g.drawString("解"+x[max],100,120);
	
}

/* X座標の設定 */
int xaxis(double x){
	double X = (double) width*(k*x/xmax+1.0)/(k+1.0);	//x→Xの変換
	return (int) X;
}

/* Y座標の設定 */
int yaxis(double y){
	double Y = height*k*(1.0-y/ymax)/(k+1.0);		//y→Yの変換
	return (int) Y;
}

/* Secant法の計算 */
double newton(int N)[]{

	/* 初期設定 */
	int i;
	double d;
	double p[] = new double[N+3];		//配列の設定
	p[0] = x0;
	p[1] = x1;

	/* Newton法 */
	for(i=1 ; i<=N+1 ; i++){
		d = Math.abs(ff(p[i]));		//残差の計算
		if(d<eps){
			break;
		}
		p[i+1] = p[i]-ff(p[i])/gg(p[i],p[i-1]);//反復公式
	}
	p[N+2] = i;				//反復回数
	return p;
}

/* 関数の定義 */
static double ff(double x){
	double p =0.0;
	//double[] a={1.0,-3.0,1.0,3.0};
	double[] a={1.0,-1.0,-5.0,-2.0};
	for(int i=0;i<=a.length-1;i++){
		p = p*x +a[i];
	}
	return p;
}

/* 導関数の定義 */
static double gg(double x, double y){
	double p =( ff(y) - ff(x))/(y-x);
	return p;
}
}

public class SecantViewFrame {
public static void main(String args[]){
	MyFrame2 f = new MyFrame2("Secant法の収束状況");	//Frame objectの生成
	f.setSize(MyFrame2.width,MyFrame2.height);				//Windowサイズの設定
	f.setVisible(true);					//Frameの表示
}
}