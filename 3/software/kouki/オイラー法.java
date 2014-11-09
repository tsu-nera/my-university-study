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
  public static void main(String str[]){

    double x0,xe,y0,h;
    double x,y;
    int n,m;

/* ------------------------------ */
/*     出力フォーマットの設定     */
/* ------------------------------ */
    DecimalFormat df1 = new DecimalFormat(" 0.000");
    DecimalFormat df2 = new DecimalFormat(" 0.000000000000");

/* ------------------------ */
/*     初期データの入力     */
/* ------------------------ */
    x0 =floatDataRead("初期値(x) ---> ");
    y0 =floatDataRead("初期値(y) ---> ");
    xe =floatDataRead("最終値(x) ---> ");
    h  =floatDataRead("刻み幅    ---> ");

    n=(int)((xe-x0)/h+0.05);     // 分割数の計算
    m=n/10;                      // 出力間隔の計算
    x=x0;
    y=y0;

    System.out.println();
    System.out.println(" ************************");
    System.out.println("    計算結果(Euler法)    ");
    System.out.println(" ************************");
    System.out.println(" x = "+df1.format(x)
                      +"     y = "+df2.format(y));

/* -------------------- */
/*     繰り返し演算     */
/* -------------------- */
    for(int i=1 ; i<=n ; i++){
      y+=h*function(x,y);
      x=x0+i*h;
      if(i%m == 0){
        System.out.println(" x = "+df1.format(x)
                          +"     y = "+df2.format(y));
      }
    }    
  }
}
