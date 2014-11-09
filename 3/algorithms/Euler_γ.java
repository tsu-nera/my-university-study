/************************************/
/*                                  */
/* �����������̐��l�v�Z�|�I�C���[�@ */
/*                                  */
/*     1997/10/18 ���ˁ@�P��        */
/*                                  */
/************************************/

import java.awt.*;

public class Euler_�� extends java.applet.Applet {

	Image screen;
	Graphics g_screen;
	TextField af,yf;
	Label al,fl,yl,hl;
	Panel dxP;
	Choice dxC;
	Button go,clb;

	public void init(){

		resize(440,380);
		setBackground(Color.green); /*�A�v���b�g�̔w�i��΂ɂ���*/
		setFont(new Font("TimesRoman",Font.PLAIN,12));

		screen=createImage(348,324); 
		g_screen=screen.getGraphics();
		g_screen.setFont(new Font("TimesRoman",Font.PLAIN,9));

		this.setLayout((LayoutManager)null);

		go=new Button("G o");
		add(go);
		go.reshape(360,160,72,32);

		clb=new Button("Clear");
		add(clb);
		clb.reshape(360,208,72,32);

		al=new Label("dy/dx=",Label.RIGHT);
		add(al);
		al.reshape(8,340,72,32);
		al.setBackground(Color.green);

		af=new TextField(5);
		add(af);
		af.reshape(84,344,64,24);
		af.setBackground(Color.white);
		af.setText("0.6");

		fl=new Label("xy",Label.LEFT);
		add(fl);
		fl.reshape(148,340,32,32);
		fl.setBackground(Color.green);

		yl=new Label("y0=",Label.RIGHT);
		add(yl);
		yl.reshape(168,340,64,32);
		yl.setBackground(Color.green);

		yf=new TextField(5);
		add(yf);
		yf.reshape(240,344,64,24);
		yf.setBackground(Color.white);
		yf.setText("0.2");

		hl=new Label("h=",Label.RIGHT);
		add(hl);
		hl.reshape(316,340,32,32);
		hl.setBackground(Color.green);


		dxP=new Panel();
		add(dxP);
		dxP.reshape(348,340,80,32);

		dxC=new Choice();
		dxC.addItem("0.02");
		dxC.addItem("0.04");
		dxC.addItem("0.1");
		dxC.addItem("0.4");
		dxP.add(dxC);
		dxC.select(0);

		screenInit();

	}

	public void screenInit() { /*��ʏ�����*/

		g_screen.setColor(Color.white);
		g_screen.fillRect(0,0,348,324);

		g_screen.setColor(Color.black);
		g_screen.drawRect(38,3,302,302);

		g_screen.drawString("0",32,321);

		g_screen.drawString("3.0",180,321);
		g_screen.drawString("6.0",330,321);

		g_screen.drawString("0",8,300);
		g_screen.drawString("150",8,158);
		g_screen.drawString("300",8,12);

		g_screen.setColor(Color.cyan);
		g_screen.drawRect(39,153,300,0);

		repaint();

	}

	public boolean action(Event evt,Object What) {

		double a,c,dx,dy,h,i,x,y,y0;
		int px,py,oldX,oldY;

		if (evt.target==go) { /*Go �{�^��*/

			try { /* a �̐ݒ� */

				a=Double.valueOf(af.getText()).doubleValue();

				if (a<0) {

					a=0.6;
					af.setText(String.valueOf(a));

				}

			} catch (Exception e) { /* ���̓G���[ */

				a=0.6;
				af.setText(String.valueOf(a));

			}

			try { /* x=0 �ł�y �̒l�iy0�j�̐ݒ� */

				y0=Double.valueOf(yf.getText()).doubleValue();

				if (y0<0) {

					y0=0.2;
					yf.setText(String.valueOf(y0));

				}

			} catch (Exception e) { /* ���̓G���[ */

				y0=0.2;
				yf.setText(String.valueOf(y0));

			}

			h=0.02;

			switch (dxC.getSelectedIndex()) { /* h�i���j�̐ݒ� */

				case 0:
					h=0.02;
					break;

				case 1:
					h=0.04;
					break;

				case 2:
					h=0.1;
					break;

				case 3:
					h=0.4;
					break;
					
				case 4:
					h=0.00001;
					break;	

			}

			oldX=39;
			oldY=304-(int)y0;
			g_screen.setColor(Color.green);

			c=Math.log(y0); /* ��͓I�ɉ�������C ���v�Z */

			for (i=0;i<300;i++) { /* ��͓I�ɉ����ĕ\�� */

				x=0.02*i;
				y=Math.exp(a*x*x*0.5+c); /* �v�Z */

				px=39+(int)i; /* �\���p�̍��W�ɕϊ� */
				py=304-(int)y;

				g_screen.drawLine(oldX,oldY,px,py);

				oldX=px; /* ���̐��̋N�_�ɂ��� */
				oldY=py;

				if (py<4) /* �`��͈͂𒴂����璆�~ */
					break;

			}

			oldX=39; /* �`��J�n�_ */
			oldY=304-(int)y0;

			px=39;

			y=y0;

			g_screen.setColor(Color.red);

			for (x=0;x<6.0;x+=h) { /* �I�C���[�@�ŉ����ĕ\�� */

				dy=y+1.0; /* ���l�����y �̑����ʂ��v�Z */
				y+=dy*h;

				px+=(int)(h/0.02); /* �\���p�̍��W�ɕϊ� */
				py=304-(int)y;

				g_screen.drawLine(oldX,oldY,px,py);

				oldX=px;
				oldY=py;

				if (py<4) /* �`��͈͂𒴂����璆�~ */
					break;

			}

			repaint();

			return true;

		}

		if (evt.target==clb) /* �N���A�{�^�� */
			screenInit();

		return false;

	}

	public void paint(Graphics g){

		g.drawImage(screen,8,8,this); /*�\���p�C���[�W��\��*/

	}

	public void update(Graphics g){

		paint(g);

	}

}
