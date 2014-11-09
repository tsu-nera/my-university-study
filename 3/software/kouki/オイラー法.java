/* **************************************** */
/*      ������������̉�@(�I�C���[�@)      */
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
/*      �֐� dy/dx=f(x,y) �̐ݒ�      */
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
/*     �o�̓t�H�[�}�b�g�̐ݒ�     */
/* ------------------------------ */
    DecimalFormat df1 = new DecimalFormat(" 0.000");
    DecimalFormat df2 = new DecimalFormat(" 0.000000000000");

/* ------------------------ */
/*     �����f�[�^�̓���     */
/* ------------------------ */
    x0 =floatDataRead("�����l(x) ---> ");
    y0 =floatDataRead("�����l(y) ---> ");
    xe =floatDataRead("�ŏI�l(x) ---> ");
    h  =floatDataRead("���ݕ�    ---> ");

    n=(int)((xe-x0)/h+0.05);     // �������̌v�Z
    m=n/10;                      // �o�͊Ԋu�̌v�Z
    x=x0;
    y=y0;

    System.out.println();
    System.out.println(" ************************");
    System.out.println("    �v�Z����(Euler�@)    ");
    System.out.println(" ************************");
    System.out.println(" x = "+df1.format(x)
                      +"     y = "+df2.format(y));

/* -------------------- */
/*     �J��Ԃ����Z     */
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
