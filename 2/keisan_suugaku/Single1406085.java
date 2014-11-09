//単精度の計算機イプシロンを求めるプログラム　２００７年５月１０日（木）
//単精度は２３ビットで表せばいい
package keisan_suugaku;

public class Single1406085 {

	
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		float e=1;
		
			for (int i = 0; i <= 10000; i++) {
				e /= 2.0;
		     
				if (1.0 + e == 1.0) {
					System.out.printf("ε=%7.23f\n",e);
		    	 break;
		     }

	}

}
	
}
