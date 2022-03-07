package famer;
public class Main {
    static int a[];
    static int b[];
    static int sum;
    static int chuan;
    public static void main(String arg[]){
        a=new int[3];//1 2 3分别代表🐺 🐏 菜
        b=new int[3];//0表示还没有过河
        sum=0;
        chuan=0;
        for(int i=0;i<3;i++){
            a[i]=i+1;
            b[i]=0;
        }
        river(0);
        System.out.println(sum);
    }
    public static void river(int t){
        if(t>=3){
            if(b[0]==1&&b[1]==1&&b[2]==1)
                sum++;
            return;
        }
        b[t] = 1;
        chuan=1;
        if(b[2]!=b[1]&&b[0]!=b[1]||(b[2]==b[1]&&b[1]==chuan)||(b[0]==b[1]&&b[1]==chuan)) {
            chuan=0;
            for (int i = 0; i < 3; i++) {
                b[i] = 1;
                chuan=1;
                if(b[2]!=b[1]&&b[0]!=b[1]||(b[2]==b[1]&&b[1]==chuan)||(b[0]==b[1]&&b[1]==chuan)) {
                    river(t + 1);
                }
                else
                    {
                    for(int m=0;m<3;m++){
                        if(b[m]==0){
                            for(int j=0;j<3;j++){
                                if(j!=t&&b[j]==1) {
                                    b[j] = 0;
                                    chuan=0;
                                }
                            }
                        }
                    }
                    river(t + 1);
                }
                b[i] = 0;
            }
        }
        else {
            for(int i=0;i<3;i++){
                if(b[i]==0){
                    for(int j=0;j<3;j++){
                        if(j!=t&&b[j]==1){
                            b[j]=0;
                            chuan=0;
                        }
                        else {
                            chuan=0;
                            b[t] = 0;
                        }
                    }
                }
            }
            river(t + 1);
        }
    }
}
