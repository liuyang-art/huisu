package oula;
import java.util.Scanner;
public class Main {
    static int map[][];
    static int v[];
    public static void main(String arg[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int p[] = new int[n + 1];
        int flag = 1;
        map = new int[n + 1][n + 1];
        v=new int[n+1];
        for (int i = 1; i <= m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            map[a][b] = map[b][a] = 1;
            p[a]++;
            p[b]++;
        }
        dfs(1, n);
        for (int i = 1; i <= n; i++) {
            if (v[i]==0 || (p[i] % 2)!=0)
            {
                flag = 0;
                break;
            }
        }
        if(flag==1)
            System.out.println(1);
        else System.out.println(0);
    }
    public static void dfs(int t, int n)
    {
        v[t] = 1;
        for(int i = 1; i <= n; i++)
        {
            if(v[i]==0 && map[t][i]!=0)
            {
                dfs(i, n);
            }
        }
    }
}
