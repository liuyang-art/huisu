package Home;
import java.util.Scanner;
public class Main {
    static int n;
    static int v[];
    static int cp,bestp;
    static boolean x[],bestx[];
    public static void main(String arg[]){
        Scanner scanner=new Scanner(System.in);
        n=scanner.nextInt();
        v=new int[n+2];
        v[n+1]=0;
        cp=0;
        bestp=0;
        x=new boolean[n+1];
        bestx=new boolean[n+1];
        for(int i=1;i<=n;i++){
            v[i]=scanner.nextInt();
        }
        Back(1);
        System.out.println(bestp);
    }
    public static void Back(int t){
        if(t>n){
            for(int j=1;j<=n;j++){
                bestx[j]=x[j];
            }
            bestp=cp;
            return;
        }
        x[t]=true;
        cp+=v[t];
        Back(t+1);
        cp-=v[t];
        if(t-2>=1){
            if(x[t-1]==false&&x[t-2]==false){
                x[t]=true;
                cp+=v[t];
                Back(t+1);
                cp-=v[t];
            }

        }
        if(Bound(t+1)<bestp){
            x[t]=false;
            Back(t+1);
        }
    }
    public static int Bound(int i){
        int rp=0;
        int temp[]=new int[n+2];
        if(i+2<=n) {
            temp[i]=v[i];
            temp[i + 1] = v[i + 1];
            temp[i + 2] = v[i + 2];
            for (int j = i + 3; j <= n+1; j++) {
                int sum = 0;
                int sum1 = temp[j - 1] + v[j];
                int sum2 = temp[j - 2] + v[j];
                int sum3 = temp[j - 3] + v[j];
                sum = sum1;
                if (sum2 < sum)
                    sum = sum2;
                if (sum3 < sum)
                    sum = sum3;
                temp[i] = sum;
            }
        }else
            temp[n+1]=v[i];
        rp=temp[n+1];
        return rp+cp;
    }
}
