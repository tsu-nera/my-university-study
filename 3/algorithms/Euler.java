
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
/*     �o�̓t�H�[�}�b�g�̐ݒ�     */
/* ------------------------------ 
    DecimalFormat df1 = new DecimalFormat(" 0.00");
    DecimalFormat df2 = new DecimalFormat(" 0.00000");*/

/* ------------------------ */
/*     �����f�[�^�̓���     */
/* ------------------------ */
    x0 =1.0;//floatDataRead("�����l(x) ---> ");
    y0 =6.085;//floatDataRead("�����l(y) ---> ");
    xe =19.0;//floatDataRead("�ŏI�l(x) ---> ");
    h  =0.0001;//floatDataRead("���ݕ�    ---> ");

    n=(long) ((xe-x0)/h+0.05); // �������̌v�Z
    System.out.println(n);
    m=(n/10);                      // �o�͊Ԋu�̌v�Z
    x=x0;
    y=y0;
    double p=(-1)+2.6064258406996688*Math.exp(19.0);
    System.out.println(" ************************");
    System.out.println("    �v�Z����(Euler�@)    ");
    System.out.println(" ************************");
    System.out.printf(" x = %6.6f",x);//df1.format(x)
    System.out.printf(" y = %6.6f",y);//df2.format(y));
    System.out.println();
    double c;

/* -------------------- */
/*     �J��Ԃ����Z     */
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
    System.out.printf("��������%8.6f",p);
    System.out.println();
    System.out.printf("�c����%8.6f",c);
  }
}






