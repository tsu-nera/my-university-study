// ------------------------------
// *     �I�C���[�@�ɂ������������̏����l���(Java appli & applet)   *
// ------------------------------
//   application and applet program  2002.2.18 KPC SPIT sekiya
//(�Q�l�j�͐����Y�AJava�ɂ��͂��߂ẴA���S���Y������A�Z�p�]�_�ЁA2001.7�App.64-66
//   
import java.applet.Applet;  //�@Java�̌����߯���ޗ�
import java.awt.*;
import java.awt.event.*;
import java.lang.*;    		//
import java.lang.Math;		//  ���w�T�u�N���X
import java.lang.String;	//  �X�g�����O�N���X

public class Euler_�� extends Applet implements ActionListener {
	private TextArea  ta2;
	private TextField tf1,tf2, tf3, tf4, tf5;
	double c;
	Button bt;
	int int7;

	double f(double x, double y) {    // �����������̓��֐�
		return y /(2.0*x);
	}
	double ft(double x, double y) {    // �����������̈�ʉ��̊֐�
		return c * Math.sqrt(x);
	}

	double rd(double x) {	//  �ۂߊ֐�
		double rdec;
		int7 = (int) (x * 1.0e5);
		rdec = (double)( int7 / 1.e5);
		return rdec;
	}
	public void init() {	//
		setSize(400,350);

		add(tf5 = new TextField("��T�D�S"));
		add(new Label("�����l(x,y):"));
		add(tf1=new TextField("1",6));
		add(tf2=new TextField("1",6));
		add(new Label("������:"));
		add(tf3=new TextField("10",6));
		add(new Label("xx:"));
		add(tf4=new TextField("2",6));
		add(bt=new Button("�v�Z"));
		add(ta2=new TextArea(20,50));
		bt.addActionListener(this); 

		String result= " ����������f(x, y)= y /(2.0*x) \n ��ʉ�ft(x, y)=c * Math.sqrt(x)\n"; 
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
			
			h=(xx-x)/n;    // ����
			c = 1.0;
			c = y / ft(x, y);
			String result= "\nx�@" + "\t���l��y" + "\t��͉�yt"  + "\t�덷 \n" ;
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
		Euler_�� w = new Euler_��();
		w.init();
		f.add(w,"Center");
		f.pack();
		f.show();
	} 
}

