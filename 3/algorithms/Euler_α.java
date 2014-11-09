
/*      常微分方程式の解法(修正オイラー法)      */
/* **************************************** */
import java.io.*;
import java.util.*;
import java.text.*;
public class Euler_α{
/* --------------------------------------- */
/*      Input Float data from Keybord      */
/* --------------------------------------- */
  static float floatDataRead (String str){
     String c = "";
     float x;
     InputStreamReader keyin = new InputStreamReader(System.in);
     BufferedReader buff = new BufferedReader (keyin);
     try{
        System.out.print(str);
        c = buff.readLine();
     }
     catch (IOException e){
        System.out.println (e.getMessage());
     }
     x = Float.valueOf(c).floatValue();
     return (x);
  }
/* ================================== */
/*      関数 dy/dx=f(x,y) の設定      */
/* ================================== */
  static double function (double x, double y){
    double f;
    f=y+1.0;
    return(f);
  }

/* ********************** */
/*      Euler Method      */
/* ********************** */
  /**
 * @param str
 */
/**
 * @param str
 */
/**
 * @param str
 */
public static void main(String str[]){

    double x0,xe,y0,h;
    double x,y;
    int m,n;
    double a1,a2;
    double b1,b2;
    double k1,k2;
    

/* ------------------------------ */
/*     出力フォーマットの設定     */
/* ------------------------------ 
    DecimalFormat df1 = new DecimalFormat(" 0.00");
    DecimalFormat df2 = new DecimalFormat(" 0.00000");*/

/* ------------------------ */
/*     初期データの入力     */
/* ------------------------ */
    x0 =1.0;//floatDataRead("初期値(x) ---> ");
    y0 =6.085;//floatDataRead("初期値(y) ---> ");
    xe =19.0;//floatDataRead("最終値(x) ---> ");
    h  =0.0001;//floatDataRead("刻み幅    ---> ");
    a1 =1.0/3;//floatDataRead("a1の値    ---> ");
    
   /*for(int j=0;j<10;j++){
    	
    a1=a1+0.01;
    System.out.println();
    System.out.println("a1="+a1);*/
    
    a2=1.0-a1;
    b1=0.5*1.0/a1;
    b2=0.5*1.0/a1;
    
    

    n=(int) ((xe-x0)/h+0.05); // 分割数の計算
    x=x0;
    y=y0;
    System.out.println(n);
    m=(n/10);                      // 出力間隔の計算
    
    double p=(-1)+2.6064258406996688*Math.exp(19.0);
    System.out.println(" ************************");
    System.out.println("    計算結果(SEH法)    ");
    System.out.println(" ************************");
    double c;

/* -------------------- */
/*     繰り返し演算     */
/* -------------------- */
    for(int i=1 ; i<=n ;i++){
      k1=h*function(x,y);
      k2=h*function(x+b1*h,y+b2*k1);
      y=y+(a1*k1+a2*k2);
      x=x0+i*h;
      
      if(i%m == 0){
    	  System.out.printf(" x = %6.6f",x);//df1.format(x)
    	    System.out.printf(" y = %6.6f",y);//df2.format(y));
    	    System.out.println();
      }
     if(x==19.0)break;
    }
    c = Math.abs(p-y);
    System.out.println();
    System.out.printf("厳密解＝%8.6f",p);
    System.out.println();
    System.out.printf("残差＝%8.6f",c);
  
  }
}
