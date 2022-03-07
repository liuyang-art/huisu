package Package;
import java.util.Scanner;
public class Main {
    static int n,m;
    static int w[],v[];
    static boolean x[];
    static int cw,cp,bestp;
    static boolean bestx[];
    public static void main(String arg[]){
        Scanner scanner=new Scanner(System.in);
        int sumv=0,sumw=0;
        m=scanner.nextInt();
        n=scanner.nextInt();
        w=new int[n+1];
        v=new int[n+1];
        x=new boolean[n+1];
        bestx=new boolean[n+1];
        for(int i=1;i<=n;i++){
            w[i]=scanner.nextInt();
            sumw+=w[i];
        }
        for(int i=1;i<=n;i++){
            v[i]=scanner.nextInt();
            sumv+=v[i];
        }
        cw=0;
        cp=0;
        bestp=0;
        if(sumw<=m) {
            bestp = sumv;
            return;
        }
        Back(1);
        System.out.println(bestp);
    }
    public static int Bound(int i){
        int rp=0;
        while (i<=n){
            rp+=v[i];
            i++;
        }
        return rp+cp;
    }
    public static void Back(int t){
        if(t>n){
            for(int j=1;j<=n;j++){
                bestx[j]=x[j];
            }
            bestp=cp;
            return;
        }
        if((cw+w[t])<=m){
            x[t]=true;
            cw+=w[t];
            cp+=v[t];
            Back(t+1);
            cw-=w[t];
            cp-=v[t];
        }
        if(Bound(t+1)>bestp){
            x[t]=false;
            Back(t+1);
        }
    }
}
