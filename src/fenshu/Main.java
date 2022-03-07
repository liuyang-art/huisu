package fenshu;

public class Main {
    public static void main(String arg[]) {
        int i, k, g, s;
        int m1, m2, m3, a[];
        a=new int[10];
        a[1] = 1;
        i = 1;
        g = 1;
        s = 0;
        while (true) {
            g = 1;
            for (k = i - 1; k > 0; k--)
                if (a[k] == a[i]) {
                    g = 0;
                    break;
                }

            if (i == 9 && g == 1 && a[1] < a[4]) {
                m1 = a[2] * 10 + a[3];
                m2 = a[5] * 10 + a[6];
                m3 = a[8] * 10 + a[9];
                if (a[1] * m2 * m3 + a[4] * m1 * m3 == a[7] * m1 * m2) {
                    s++;
                }
            }

            if (i < 9 && g == 1) {
                i++;
                a[i] = 1;
                continue;
            }
            while (a[i] == 9 && i > 1) i--;
            if (a[i] == 9 && i == 1) break;
            else a[i]++;
        }
        System.out.println(s);
    }
}
