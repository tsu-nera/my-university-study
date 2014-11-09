package keisan_suugaku;
import java.io.*;
import java.util.*;

public class Jyushinsu2 {

	public static void main(String[] args) throws IOException{
		String ss;
		double dec1 =0.0;
		double dec2 =0.0;
		
		BufferedReader kdb=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("2進数：");
		ss = kdb.readLine();
		
		int dot =ss.indexOf(".");
		int len =ss.length();
		
		if(dot==-1){
			dot=len;
		}
		
		for(int i=0;i<dot;i++){
			dec1 = dec1*2 + Double.parseDouble(ss.substring(i,i+1));
		}
		
		for(int i=len-1;i>dot;i--){
			dec2=(dec2 + Double.parseDouble(ss.substring(i,i+1)))/2.0;
		}
	System.out.print("十進数：");
	System.out.println(dec1+dec2);
	}

}
