package N2;
import java.util.Scanner;
public class Main {
    static int n,sum;
    static int a[][];
    public static void main(String arg[]){
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        sum=0;
        a=new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++){
                a[i][j]=scanner.nextInt();
            }
        queen(0,2);
        System.out.println(sum);
    }
    public static void queen(int i,int m){
        for(int j=0;j<n;j++){
            if(a[i][j]!=1)
                continue;
            int x=j-1,y=j+1,z=1,k;
            for(k=i-1;k>=0;k--){
                if(a[k][j]==m || x>=0&&a[k][x]==m || y<n&&a[k][y]==m){
                    z=0;
                    break;
                }
                x--;
                y++;
            }
            if(z!=0){
                a[i][j]=m;
                if(i!=n-1){
                    queen(i+1,m);
                }
                else
                {
                    if(m==2)
                        queen(0,3);
                    else
                        sum++;
                }
                a[i][j]=1;
            }
        }
    }
}
