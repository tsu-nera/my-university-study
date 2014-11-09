/* ******************************** */
/*      ‚PŠKí”÷•ª•û’ö®‚Ì‰ğ–@      */
/* ******************************** */
import java.io.*;
import java.util.*;
import java.text.*;
public class EulerƒÀ{

/* ================================== */
/*      ŠÖ” dy/dx=f(x,y) ‚Ìİ’è      */
/* ================================== */
  static double function (double x, double y){
    double f;
    f=y+1.0;
    return(f);
  }

/* **************************** */
/*      Euler Method (‚PŸ)     */
/* **************************** */
  static void Euler
      (double x0,double y0,double xe,double h,int n){

    int m;
    double x,y;

    m=n/10;
    x=x0;
    y=y0;

    for(int i=1 ; i<=n ; i++){
      y+=h*function(x,y);
      x=x0+i*h;
      if(i%m == 0){
        printout(i,x,y);
      }
    }
  }

/* ******************************************* */
/*      ˆê”ÊŒö® Runge Kutta Method (‚QŸ)     */
/* ******************************************* */
  static void Second_Runge_Kutta
      (double alpha,double x0,double y0,double xe,double h,int n){

    double x,y,k1,k2;
    double beta;
    int m;

    beta=1.0/(2.0*alpha);

    m=n/10;
    x=x0;
    y=y0;

    for(int i=1 ; i<=n ; i++){
      k1=h*function(x,y);
      k2=h*function(x+beta*h,y+beta*k1);
      x=x0+i*h;
      y+=(1-alpha)*k1+alpha*k2;
      if(i%m == 0){
        printout(i,x,y);
      }
    }
  }

/* *************************** */
/*      Heun Method (‚QŸ)     */
/* *************************** */
  static void Heun
      (double x0,double y0,double xe,double h,int n){

    double x,y,k1,k2;
    int m;

    m=n/10;
    x=x0;
    y=y0;

    for(int i=1 ; i<=n ; i++){
      k1=h*function(x,y);
      k2=h*function(x+h,y+k1);
      y+=(k1+k2)*0.5;
      x=x0+i*h;
      if(i%m == 0){
        printout(i,x,y);
      }
    }
  }
/* ************************************* */
/*      Modified Euler Method (‚QŸ)     */
/* ************************************* */
  static void Modified_Euler
      (double x0,double y0,double xe,double h,int n){

    double x,y,k1,k2;
    double alpha,beta;
    int m;

    m=n/10;
    x=x0;
    y=y0;

    for(int i=1 ; i<=n ; i++){
      k1=h*function(x,y);
      k2=h*function(x+h*0.5,y+k1*0.5);
      y+=k2;
      x=x0+i*h;
      if(i%m == 0){
        printout(i,x,y);
      }
    }
  }
/* ********************************** */
/*      Runge Kutta Method (‚RŸ)     */
/* ********************************** */
  static void Third_Runge_Kutta
      (double x0,double y0,double xe,double h,int n){

    double x,y,k1,k2,k3;
    double alpha,beta;
    int m;

    m=n/10;
    x=x0;
    y=y0;

    for(int i=1 ; i<=n ; i++){
      k1=h*function(x,y);
      k2=h*function(x+h/2,y+k1/2);
      k3=h*function(x+h,y+2*k2-k1);
      x=x0+i*h;
      y+=(k1+4*k2+k3)/6;
      if(i%m == 0){
        printout(i,x,y);
      }
    }
  }
/* ********************************** */
/*      Runge Kutta Method (‚SŸ)     */
/* ********************************** */
  static void Runge_Kutta
      (double x0,double y0,double xe,double h,int n){
    int m;
    double x,y,f1,f2,f3,f4;

    m=n/10;
    x=x0;
    y=y0;

    for(int i=1 ; i<=n ; i++){
      f1=h*function(x,y);
      f2=h*function(x+h/2,y+f1/2);
      f3=h*function(x+h/2,y+f2/2);
      f4=h*function(x+h,y+f3);
      x=x0+i*h;
      y+=(f1+2*f2+2*f3+f4)/6;
      if(i%m == 0){
        printout(i,x,y);
      }
    }
  }

/* ******************************************* */
/*      Runge_Kutta_Ralston Method (‚SŸ)      */
/* ******************************************* */
  static void Runge_Kutta_Ralston
      (double x0,double y0,double xe,double h,int n){

    double x,y,d0,d1,d2,d3;
    double xa,ya;
    double a1=0.4,a2=0.45573725,a3=1.0;
    double c0=0.17476028,c1=-0.55148066,c2=1.20553560,c3=0.17118478;
    double b10=0.4,b20=0.29697761,b21=0.15875964;
    double b30=0.21810040,b31=-3.05096516,b32=3.83286476;
    int m;

    m=n/10;
    x=x0;
    y=y0;

    for(int i=1 ; i<=n ; i++){
      x=x0+i*h;
      d0=h*function(x,y);
      ya=y0+b10*d0;
      xa=x+a1*h;
      d1=h*function(xa,ya);
      ya=y0+b20*d0+b21*d1;
      xa=x+a2*h;
      d2=h*function(xa,ya);
      ya=y0+b30*d0+b31*d1+b32*d2;

      xa=x+a3*h;
      d3=h*function(xa,ya);
      y0+=c0*d0+c1*d1+c2*d2+c3*d3;
      y=y0;
      if(i%m == 0){
        printout(i,x,y);
      }
    }
  }
/* **************************************** */
/*      Runge_Kutta_Gill Method (‚SŸ)      */
/* **************************************** */
  static void Runge_Kutta_Gill
      (double x0,double y0,double xe,double h,int n){

    double cq[] = {0.0, 2.0, 1.0, 1.0, 2.0};
    double ckq[] = {0.0, 0.5, 0.29289322, 1.7071068, 0.16666666};
    double ck[] = {0.0,0.5,0.29289322,1.7071068,0.5};
    double ch[] = {0.0,0.5,0.0,0.5,0.0};

    double x,y,a,q,r;
    int m;

    m=n/10;
    q=0.0;
    x=x0;
    y=y0;

    for(int j=1 ; j<=n ; j++){
      for(int i=1 ; i<=4 ; i++){
        a=h*function(x,y);
        r=(a-cq[i]*q)*ckq[i];
        y+=r;
        q+=3.0*r-ck[i]*a;
        x+=h*ch[i];
      }
      if(j%m == 0){
        printout(j,x,y);
      }
    }
  }
/* ****************************************** */
/*      Runge_Kutta_Shanks Method (‚SŸ)      */
/* ****************************************** */
  static void Runge_Kutta_Shanks
      (double x0,double y0,double xe, double h, int n){

    double alpha[] = new double [10];
    double beta[][] = new double [10][10];
    double gamma[] = new double [10];
    double d[] = new double [10];

    int bo[]=new int []{1,27,18,12,8,54,4320,20,288,820};
    int si[][]=new int [][]{
         {0,0,0,0,0,0,0,0,0,0},
         {4,0,0,0,0,0,0,0,0,0},
         {1,3,0,0,0,0,0,0,0,0},
         {1,0,3,0,0,0,0,0,0,0},
         {1,0,0,3,0,0,0,0,0,0},
         {13,0,-27,42,8,0,0,0,0,0},
         {389,0,-54,966,-824,243,0,0,0,0},
         {-231,0,81,-1164,656,-122,800,0,0,0},
         {-127,0,18,-678,456,-9,576,4,0,0},
         {1481,0,-81,7104,-3376,72,-5040,-60,720,0}};
    int g[]=new int []{41,0,0,27,272,27,216,0,216,41};

    alpha[0]=0.0;          alpha[1]=4.0/27.0;
    alpha[2]=2.0/9.0;      alpha[3]=1.0/3.0;
    alpha[4]=1.0/2.0;      alpha[5]=2.0/3.0;
    alpha[6]=1.0/6.0;      alpha[7]=1.0;
    alpha[8]=5.0/6.0;      alpha[9]=1.0;
    for(int i=0 ; i<10 ; i++){
      for(int j=0 ; j<10 ; j++){
        beta[i][j]=(double)si[i][j]/(double)bo[i];
      }
      gamma[i]=(double)g[i]/840.0;
    }
    int dansue=10;
    double x,y,s,xa,ya;
    int m;

    m=n/10;

    x=x0;
    y=y0;
 
    for(int i=1 ; i<=n ; i++){
      x=x0+i*h;
      d[0]=h*function(x,y);
      for(int j=1 ; j<dansue ; j++){
        xa=x+h*alpha[j];
        s=0.0;
        for(int k=0 ; k<j ; k++){
          s+=beta[j][k]*d[k];
        }
        ya=y+s;
        d[j]=h*function(xa,ya);
      }
      s=0.0;
      for(int j=0 ; j<dansue ; j++){
        s+=gamma[j]*d[j];
      }
      y+=s;
      if(i%m == 0){
        printout(i,x,y);
      }
    }
  }
/* ======================================== */
/*      ƒL[ƒ{[ƒh‚©‚ç®”’l‚ğ“Ç‚İ‚Ş      */
/* ======================================== */
    static int intDataRead (String str){
       String c = "";
       int x;
       InputStreamReader keyin = new InputStreamReader(System.in);
       BufferedReader buff = new BufferedReader (keyin);
       try{
          System.out.print(str);
          c = buff.readLine();
       }
       catch (IOException e){
          System.out.println (e.getMessage());
       }
       x = Integer.valueOf(c).intValue();
       return (x);
    }
/* ======================================== */
/*      ƒL[ƒ{[ƒh‚©‚çÀ”’l‚ğ“Ç‚İ‚Ş      */
/* ======================================== */
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
/* ================== */
/*      ‰ğ‚Ì•\¦      */
/* ================== */
  static void printout (int k, double x, double y){
    DecimalFormat df1 = new DecimalFormat(" 0.000");
    DecimalFormat df2 = new DecimalFormat(" 0.000000000000");
      System.out.println("    x = "+df1.format(x)
                        +"     y = "+df2.format(y));
  }

/* **************************** */
/*      Runge Kutta Method      */
/* **************************** */
  public static void main(String str[]){

    String chr[] = new String [11];
    int cha[] = new int []{0,29,44,28,38,35,35,43,40,42};


    double x0,y0,xe,h;
    double alpha=0.5;
    int n,fl;

    chr[1]="  (1) Euler Method (‚PŸ)                  ";
    chr[2]="  (2) ˆê”ÊŒö® Runge Kutta Method (‚QŸ)   ";
    chr[3]="  (3) Heun Method (‚QŸ)                   ";
    chr[4]="  (4) Modified Euler Method (‚QŸ)         ";
    chr[5]="  (5) Runge Kutta Method (‚RŸ)            ";
    chr[6]="  (6) Runge Kutta Method (‚SŸ)            ";
    chr[7]="  (7) Runge Kutta Ralston Method (‚SŸ)    ";
    chr[8]="  (8) Runge Kutta Gill Method (‚SŸ)       ";
    chr[9]="  (9) Runge Kutta Shanks Method (‚SŸ)     ";

    System.out.println(
           "\n ****************************"
          +"\n     í”÷•ª•û’ö®‚Ì”’l‰ğ    "
          +"\n ****************************");

/* -------------------- */
/*      ‰ğ–@‚Ì“ü—Í      */
/* -------------------- */
    System.out.println("");
    System.out.println("+-------------- Solved Method --------------+");
    System.out.println("|"+chr[1]+"|");
    System.out.println("|"+chr[2]+"|");
    System.out.println("|"+chr[3]+"|");
    System.out.println("|"+chr[4]+"|");
    System.out.println("|"+chr[5]+"|");
    System.out.println("|"+chr[6]+"|");
    System.out.println("|"+chr[7]+"|");
    System.out.println("|"+chr[8]+"|");
    System.out.println("|"+chr[9]+"|");
    System.out.println("+-------------------------------------------+");
    System.out.println("");
    fl=intDataRead("Input number for method -------> ");

    if(fl == 2){
      System.out.println();
      System.out.println("============================");
      System.out.println("  Heun–@          (ƒ¿=1/2)  ");
      System.out.println("  Modified Euler–@(ƒ¿=1)    ");
      System.out.println("============================");
      alpha=floatDataRead("  Input value of ƒ¿ ---> ");
    }

/* ------------------ */
/*      ‰Šúİ’è      */
/* ------------------ */
    System.out.println();
    System.out.println("====== ‰Šúİ’è =======");
    x0 = floatDataRead("   ‰Šú’l(x) ---> ");
    y0 = floatDataRead("   ‰Šú’l(y) ---> ");
    xe = floatDataRead("   ÅI’l(x) ---> ");
    h  = floatDataRead("   ‚İ•    ---> ");
    n=(int)((xe-x0)/h+0.05);

    System.out.println();
    for(int i=1 ; i<= (13+cha[fl]) ; i++){
      System.out.print("*");
    }
    System.out.println("\n    ” ’l ‰ğ "+chr[fl]);
    for(int i=1 ; i<= (13+cha[fl]) ; i++){
      System.out.print("*");
    }
    System.out.println();
    if(fl == 2){
      System.out.println(" ƒ¿ = "+alpha);
    }


    switch(fl){
      case 1:
        Euler(x0,y0,xe,h,n);
        break;
      case 2:
        Second_Runge_Kutta(alpha,x0,y0,xe,h,n);
        break;
      case 3:
        Heun(x0,y0,xe,h,n);
        break;
      case 4:
        Modified_Euler(x0,y0,xe,h,n);
        break;
      case 5:
        Third_Runge_Kutta(x0,y0,xe,h,n);
        break;
      case 6:
        Runge_Kutta(x0,y0,xe,h,n);
        break;
      case 7:
        Runge_Kutta_Ralston(x0,y0,xe,h,n);
        break;
      case 8:
        Runge_Kutta_Gill(x0,y0,xe,h,n);
        break;
      case 9:
        Runge_Kutta_Shanks(x0,y0,xe,h,n);
        break;
      default :
        break;
    }
  }

}

