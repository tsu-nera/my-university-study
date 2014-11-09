package kouki;

import java.math.BigInteger;

public class RSA { 
	public static BigInteger RSA_in(BigInteger S){
		 BigInteger e = new BigInteger("65537");
		 BigInteger p=new BigInteger("1345448987677");
		 p=p.nextProbablePrime();
		 BigInteger q = p.nextProbablePrime();
		 BigInteger n =p.multiply(q);
		 
		
		System.out.println("ŒöŠJŒ®ie,n)=("+e+","+n+")");
		
		//ˆÃ†‰»
		BigInteger c = S.modPow(e, n);
		System.out.println("c = "+c);
	
		return c;
	}
}
