package keisan_suugaku;

public class Nisinsu04 {

	public static void main(String[] args) {
			double z = 1406085.0;
			int x =(int)z; 		//®”•”
			double y = z - x;		//¬”•”
			
			int[] a= new int[100];
			int[] b= new int[100];
			int i = 0,j = 0;
			
			while(x>0){			//‚˜„‚O‚Å‚È‚¢‚±‚Æ‚É’ˆÓB
				a[i] = x%2;
				x = x/2;
				i++;
			}
			
			while(y>0){
				b[j] = (int)(2*y);
				y = 2*y- b[j];
				if(j==99)break;
				j++;
			}
		
			
			for(int k=i-1;k>=0;k--){
				System.out.print(a[k]);
			}
			
				//System.out.println(".");
				
			for(int k=0;k<j;k++){
				System.out.print(b[k]);
			}
	}
}
