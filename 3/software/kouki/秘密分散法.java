package kouki;

import java.math.BigInteger;

public class 秘密分散法 {

	
	public static void main(String[] args) {
		int n= 5;
		BigInteger[][] A = new BigInteger[n][n+1];
		BigInteger[] x=new BigInteger[n];
		BigInteger[] w=new BigInteger[n];
		BigInteger[] r=new BigInteger[n];
		
		/*BigInteger p=new BigInteger("7");
		x[0]=new BigInteger("6");
		x[1]=new BigInteger("4");
		x[2]=new BigInteger("5");
		w[0]=new BigInteger("4");
		w[1]=new BigInteger("4");
		w[2]=new BigInteger("2");*/
		BigInteger p =new BigInteger("1167839342470745297480167198337596207592050877");
		x[0] = new BigInteger("182564568183420180361980863984768600840497039");
		w[0] = new BigInteger("552187290150820982266962244087323410277297330");
		x[1] = new BigInteger("124514336287649063107836768900652843887852872");
		w[1] = new BigInteger("1082809958027228241745302264801287515142926810");
		x[2] = new BigInteger("806200345156151113757041368805334530684506974");
		w[2] = new BigInteger("164675443976490938373502722859164381659968505");
		x[3] = new BigInteger("690533290194364617812567521040990618929655502");
		w[3] = new BigInteger("523723406003150108199545052791060297005916099");
		x[4] = new BigInteger("518434776665765679830592251245095135303995712");
		w[4] = new BigInteger("345092259924843151553722486608507617827799930");
		
		BigInteger temp =BigInteger.ZERO;//拡大係数行列の作成
		for(int j=0;j<n;j++	){
			for(int i=0;i<n;i++){
			A[i][j]=x[i].modPow(temp, p);	
			}
			temp=temp.add(BigInteger.ONE);
		}
		for(int i=0;i<n;i++){
			A[i][n]=w[i];
		}
		
		for(int i=0;i<n;i++){//表示
			for(int j=0;j<=n;j++){
				System.out.print(A[i][j]);
				System.out.print("  ");
			}
			System.out.println();
		}
		System.out.println();
//		ガウスの消去法
		BigInteger[] qr=new BigInteger[2];
		BigInteger aa;
		for(int k=0;k<n-1;k++){
			
					for(int i=k+1;i<n;i++){//前進消去
						aa=A[i][k];
						
						for(int j=k;j<n+1;j++){
							A[i][j]=((aa.modInverse(p)).multiply(A[i][j].multiply(A[k][k]).subtract(A[k][j].multiply(aa)))).mod(p);
						}
						
						
						}
						for(int s=0;s<n;s++){//前進過程の表示
							for(int j=0;j<=n;j++){
								System.out.print(A[s][j]);
								System.out.print("  ");
							}
							System.out.println();
						}
						System.out.println();
					}
					/*for(int i=0;i<n;i++){//前進過程の表示
						for(int j=0;j<=n;j++){
							System.out.print(A[i][j]);
							System.out.print("  ");
						}
						System.out.println();
					}
					System.out.println();*/
		
		
		if(A[n-1][n-1].gcd(p).intValue()==1){
		r[n-1]=((A[n-1][n-1].modInverse(p)).multiply(A[n-1][n])).mod(p);
		}else{r[n-1]=BigInteger.ZERO;}
		BigInteger[] c=new BigInteger[n];
		for(int k=n-2;k>=0;k--){//後退代入
			for(int i=0;i<n;i++){//初期化
				c[i]=BigInteger.ZERO;
			}
			for(int l=n-1;l>k;l--){
				c[k]=c[k].add((A[k][l].multiply(r[l])));
			}
			r[k]=((A[k][k].modInverse(p)).multiply(A[k][n].subtract(c[k]))).mod(p);
		}
		
		for(int i=0;i<n;i++){
			System.out.println(r[i]);
		}
		

		System.out.println();
		System.out.println(RSA.RSA_in(r[0]));
		
	}


}
