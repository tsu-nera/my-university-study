package kouki;

public class Heat_Conduction {
	public static void main(String[] args) {
		int n=0;
		double L=5;//棒の長さ
		//鉄（Fe)
		double ρ=21450;//密度
		double cp=130;//比熱
		double λ=71.6 ; //熱伝導率*/
		int l=20;
		double dx=L/l;
		double dt=0.001;
		double Gamma=λ*dt*3600/(ρ*cp*dx*dx);
		
		/*double[][] h=new double[l][100000];
		h[0][0]=1300;
		for(int i=1;i<l;i++){
			h[i][0]=300;
		}*/
		
	/*	while(h[l-1][n]<340){
			for(int i=1;i<l-1;i++){
				h[i][n+1]=Gamma*h[i-1][n]+(1-2*Gamma)*h[i][n]+Gamma*h[i+1][n];
			}
			h[l-1][n+1]=h[l-2][n+1];
			System.out.println(h[l-1][n+1]);
			n++;
		}
*/
		double[] T=new double[l];
		double[] TT=new double[l];
		
		for(int i=0;i<l;i++){
			T[i]=300;
		}
		T[0]=1300;
		
		while(true){
			n++;
			for(int i=1;i<l-1;i++){
				TT[i]=Gamma*T[i-1]+(1-2*Gamma)*T[i]+Gamma*T[i+1];
			}
			TT[0]=1300;
			TT[l-1]=TT[l-2];		//境界条件
			
			for(int j=0;j<l;j++){
	if(n==(Math.round(n/10)*10)){
			System.out.print(TT[j]+"	 ");
		}
		
			}
		if(n==(Math.round(n/10)*10)){
				System.out.println();
			}
		//収束判定
		if(TT[l-1]>=340) break;
		for(int i=0;i<l;i++){
			T[i]=TT[i];
		}
	}
		System.out.println("やけどする時間は"+n*dt+"です！");
		System.out.println(Gamma*dt/(dx*dx));
	}

}
