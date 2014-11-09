package kouki;

public class Dim2_heat_condition {
	public static void main(String[] args) {
		int n=0;
		double L=0.5;//–_‚Ì’·‚³
		double ƒ¿=0.01;
		double dx=0.05;
		double Gamma=0.2;//ƒÉ/ƒÏ*cp;
		double dt =Gamma*dx*dx/ƒ¿;
		int l=11;
		int m=11;
		
		double[][] T=new double[l][m];
		double[][] TT=new double[l][m];
		
		for(int i=0;i<l;i++){
			T[i]=300;
		}
		T[0]=1300;
		
		while(true){
			n++;
			for(int i=1;i<l-1;i++){
				for(int j=1;j<m-1;j++){
				TT[i][j]=Gamma*(T[i-1][j]+T[i+1][j])+(1-4*Gamma)*T[i][j]+Gamma*(T[i][j-1]+T[i][i+1]);
			}
			TT[0]=1300;
			TT[l-1]=TT[l-2];		//‹«ŠEðŒ
			
			for(int j=0;j<l;j++){
		if(n*10/10==n){
			System.out.print(TT[j]+"	 ");
		}
			}
		System.out.println();
		//Žû‘©”»’è
		if(TT[l-1]>=340) break;
		for(int i=0;i<l;i++){
			T[i]=TT[i];
		}
	}
		System.out.println("‚â‚¯‚Ç‚·‚éŽžŠÔ‚Í"+n*dt+"‚Å‚·I");
	}

}