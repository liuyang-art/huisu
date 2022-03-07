package four;
import java.util.Scanner;
public class Main {
    private static int res;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = scan.nextInt();
        }
        for (int i = 0; i < c.length; i++) {
            res = c[i];
            int t = c[i];
            c[i] = c[0];
            c[0] = t;
            calculate(c, 0);
            if (res == 0) {
                System.out.println("yes");
                return;
            }
        }
        System.out.println("no");
    }

    private static void calculate(int[] c, int n) {
        if (n < c.length - 1) {
            for (int j = 0; j < 4; j++) {
                if (j == 0) {
                    res += c[n + 1];
                    calculate(c, n + 1);
                    if (res == 0)
                        return;
                    res -= c[n + 1];
                } else if (j == 1) {
                    res -= c[n + 1];
                    calculate(c, n + 1);
                    if (res == 0)
                        return;
                    res += c[n + 1];
                } else if (j == 2){
                    res *= c[n + 1];
                    calculate(c, n + 1);
                    if (res == 0)
                        return;
                    res /= c[n + 1];
                }else {
                    if (res % c[n+1] == 0){
                        res /= c[n + 1];
                        calculate(c, n + 1);
                        if (res == 0)
                            return;
                        res *= c[n + 1];
                    }
                }
            }
        }
    }
}