package keisan_suugaku;

public class Nisinsu03 {

	public static void main(String[] args){
		
		double z=1406085;
		int x= (int)z;
		double y= z - x;
		
		
		//�܂��́A������������l����
		int x1 = x;
		int[] a = new int[sub(x1)+1];
		int tmp = 0;
		
		
			
		//�z��ɐ����i�[����
		for(int j = 0; j<=sub(x1);j++){
			a[j] = x%2;
			tmp =(int) x/2;
			x = tmp;
		}
		
		
		
		System.out.print(z+"���i���\�������");
		
		//�z����Ōォ��\������
		for(int i = sub(x1);i>=0;i--){
			System.out.print(a[i]);
		}
		
		
		System.out.print(".");
			
		int j=0;
		double tmp2 = 0;
			
		while(y !=0.0){
			tmp2 = y*2;
			System.out.print((int)tmp2);
			y = tmp2 - (int)tmp2;
			j++;
			
			if(j==10) break;
		}
			
			System.out.println("�ł��B");
			
	}
		
		
		
		

	
	
	
	
	//�z��̐������߂郁�]�b�g������
	public static int sub(int x){
		int tmp;
		int b = 0;
		
		do{
			tmp = (int)x/2;
			x = tmp;
			b++;
		}while((int)x/2>=1);
		
		return b;
	}

}