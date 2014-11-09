package keisan_suugaku;

public class Vector {

	
	public static void main(String[] args) {
	double[][] A= {{1.1,7,3},{	-3,5,11},{3,4,-5}};
	double[] x={7,2,9};
	double[] b = new double[3];
	
	for(int i=0;i<3;i++){
		for(int j=0;j<3;j++){
			b[i]+=A[i][j]*x[j];
		}
	}
	
	for(int k=0;k<3;k++){
	System.out.println(b[k]);
	}
	
	}
}
