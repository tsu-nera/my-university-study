// ------------------------------
// *     オイラー法による微分方程式の初期値問題(Java appli & applet)   *
// ------------------------------
//   application and applet program  2002.2.18 KPC SPIT sekiya
//(参考）河西朝雄、Javaによるはじめてのアルゴリズム入門、技術評論社、2001.7、pp.64-66
//   
import java.applet.Applet;  //　Javaの言語ﾊﾟｯｹｰｼﾞ類
import java.awt.*;
import java.awt.event.*;
import java.lang.*;    		//
import java.lang.Math;		//  数学サブクラス
import java.lang.String;	//  ストリングクラス

public class Euler_δ extends Applet implements ActionListener {
	private TextArea  ta2;
	private TextField tf1,tf2, tf3, tf4, tf5;
	double c;
	Button bt;
	int int7;

	double f(double x, double y) {    // 微分方程式の導関数
		return y /(2.0*x);
	}
	double ft(double x, double y) {    // 微分方程式の一般解の関数
		return c * Math.sqrt(x);
	}

	double rd(double x) {	//  丸め関数
		double rdec;
		int7 = (int) (x * 1.0e5);
		rdec = (double)( int7 / 1.e5);
		return rdec;
	}
	public void init() {	//
		setSize(400,350);

		add(tf5 = new TextField("例５．４"));
		add(new Label("初期値(x,y):"));
		add(tf1=new TextField("1",6));
		add(tf2=new TextField("1",6));
		add(new Label("分割数:"));
		add(tf3=new TextField("10",6));
		add(new Label("xx:"));
		add(tf4=new TextField("2",6));
		add(bt=new Button("計算"));
		add(ta2=new TextArea(20,50));
		bt.addActionListener(this); 

		String result= " 微分方程式f(x, y)= y /(2.0*x) \n 一般解ft(x, y)=c * Math.sqrt(x)\n"; 
		ta2.setText(result);
	}
	public void actionPerformed(ActionEvent e) {
		int n, k;
		double x, y, xx, h, yt, gosa;

		if (e.getSource() == bt) { 
			x = Double.valueOf(tf1.getText()).doubleValue();
			y = Double.valueOf(tf2.getText()).doubleValue();
			n = Integer.valueOf(tf3.getText()).intValue();
			xx = Double.valueOf(tf4.getText()).doubleValue();
			
			h=(xx-x)/n;    // 刻み
			c = 1.0;
			c = y / ft(x, y);
			String result= "\nx　" + "\t数値解y" + "\t解析解yt"  + "\t誤差 \n" ;
			ta2.appendText(result);

			for (k=1; k<=n; k++) {
				y = y + h * f(x,y);
				x=x+h;
				yt = ft(x, y);
				gosa = yt- y;
				result = rd(x) + "\t" + rd(y) + "\t \t" + rd(yt) + "\t \t" + rd(gosa) + "\n"; 
				ta2.appendText(result);
			}
		}
	}
	public static void main(String[] args) {
		Frame f = new Frame();
		Euler_δ w = new Euler_δ();
		w.init();
		f.add(w,"Center");
		f.pack();
		f.show();
	} 
}

