
public class Experiment {
		
		public static void insert(int i,int num,int[] x){
				int k=i,l=2*k;
				if(l<num && x[l-1]>x[l])l++;//�q�����m�̌����B�q���ЂƂȂ�Ή������Ȃ�
				if(x[k-1]>x[l-1]){
					swap(k-1,l-1,x);
				}
				if(2*l<=num) insert(l,num,x);
				
			}
		
		//�q�[�v�\�[�g���C�����\�b�h
		public static void main(String args[]){
			int[] x= {1,6,1,0,0,7};
			int num = x.length;
			// ���ёւ���
				insert(1,num,x);
				
			for(int k=0;k<x.length;k++){
				System.out.println(x[k]);
			}
			System.out.println();
			while(num>0){
				num--;
				swap(0,num,x);
				insert(1,num,x);
			}
			
			for(int k=0;k<x.length;k++){
				System.out.println(x[k]);
			}
		}
	
	

	
//	���ёւ��p�̃��\�b�h
	public static void swap(int i,int j,int[] x){
		int a=0;
			a=x[j];
			x[j]=x[i];
			x[i]=a;
	}

}
