package keisan_suugaku;

public class Jyushinsu {

	
	public static void main(String[] args) {
		
		int integer[] = {1,0,1,0};
		int decimal[] ={0,1};
		double dec1 =0.0;
		double dec2 =0.0;
		
		for(int i=0;integer.length>i;i++){
			dec1 = dec1*2 + integer[i];
		}
		
		for(int i=decimal.length-1;i>=0;i--){
			dec2=(dec2 + decimal[i])/2;
		}
	
	System.out.println(dec1+dec2);
	}

}
