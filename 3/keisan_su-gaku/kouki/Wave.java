 package kouki;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Wave {

	
	public static void main(String[] args) {
		int n=21;
		double[] y0=new double[n];
		double[] y1=new double[n];
		double[] y=new double[n];
		double dt=0.1;
		double dx=0.05;
		double a =(dt*dt)/(dx*dx);
		y0[0]=0;
		y0[10]=0;
		y1[0]=0;
		y1[10]=0;
		for(int i=1;i<10;i++){ //初期条件
			y0[i]=0.1*i;
		}
		for(int i=10;i<n-1;i++){
			y0[i]=2-0.1*i;
		}
		/*for(int i=1;i<n-1;i++){ //初期条件
			y0[i]=0.2*i*(1-i*0.1);
		}*/
		
		for(int i=1;i<n-1;i++){ //初期条件
			y1[i]=y0[i]+dt*y0[i]+a*(y0[i+1]-2*y0[i]+y0[i-1])*0.5;
		}
		
		
		
		
		try{
			PrintWriter fout = new PrintWriter(new BufferedWriter(new FileWriter("kouki/output.txt")));//ファイル・オープン開始 ***** ここで出力ファイル名を指定する

			for(int t=0;t<10;t++){
				for(int i=1;i<n-1;i++){ //n+1の計算
					y[i]=2*y1[i]-y0[i]+a*(y1[i+1]-2*y1[i]+y1[i-1]);
					/*if((t==(Math.round(t/10)*10)))*/fout.printf("%10.5f \t",y[i]);
				}
				/*if(t==(Math.round(t/10)*10))*/fout.println();
				for(int i=1;i<n-1;i++){ //n+1の計算
					y0[i]=y1[i];
					y1[i]=y[i];
				}
			}
		fout.close();							//ファイル・クローズ
		}catch (Exception e){						//─┐
			System.out.println("書き込みエラー：" + e);		//　├指定ファイルに
			System.exit(1);						//　│書き込めないときの命令
		}								//─
		

	}

}
