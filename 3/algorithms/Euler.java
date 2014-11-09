
/* **************************************** */
/*      常微分方程式の解法(オイラー法)      */
/* **************************************** */
import java.io.*;
import java.util.*;
import java.text.*;
public class Euler{
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
    long m,n;
    

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

    n=(long) ((xe-x0)/h+0.05); // 分割数の計算
    System.out.println(n);
    m=(n/10);                      // 出力間隔の計算
    x=x0;
    y=y0;
    double p=(-1)+2.6064258406996688*Math.exp(19.0);
    System.out.println(" ************************");
    System.out.println("    計算結果(Euler法)    ");
    System.out.println(" ************************");
    System.out.printf(" x = %6.6f",x);//df1.format(x)
    System.out.printf(" y = %6.6f",y);//df2.format(y));
    System.out.println();
    double c;

/* -------------------- */
/*     繰り返し演算     */
/* -------------------- */
    for(long i=1 ; i<=n ;i++){
      y+=h*function(x,y);
      x=x0+i*h;
     if(i%m == 0){
    	  System.out.printf(" x = %6.6f",x);//df1.format(x)
    	    System.out.printf(" y = %6.6f",y);//df2.format(y));
    	    System.out.println();
      }
     if(x==19.0)break;
    }
    c = Math.abs(p-y);
    System.out.println(p-y);
    System.out.printf("厳密解＝%8.6f",p);
    System.out.println();
    System.out.printf("残差＝%8.6f",c);
  }
}






