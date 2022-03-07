package zidian;

import java.util.Scanner;

public class Main {
    static int n;
    static int a[];
    static int t,count;
    static boolean x[];
    public static void main(String arg[]){
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        a=new int[n+1];
        x=new boolean[n+1];
        t=scanner.nextInt();
        count=0;
        Back(1);
        System.out.println(count);
    }
    public static void Back(int i){
        if(i>t){
            for(int j=1;j<=t-1;j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println(a[t]);
            count++;
            return;
        }
         for(int j=i;j<=n;j++){
             if(x[j]==false){
                 if(a[i-1]<j) {
                     a[i] = j;
                 }else
                     continue;
                 x[j]=true;
                 Back(i+1);
                 x[j]=false;
             }
         }
    }
}
