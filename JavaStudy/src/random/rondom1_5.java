package random;

//求1-5的随机数
public class rondom1_5 {
    public static void main(String[] args) {
        int m1 = 0;
        int m2 = 0;
        for (int i = 0; i < 10000; i++) {
            if(y()==0){
                m1++;
            }else m2++;
        }
        System.out.println(m1);
        System.out.println(m2);
    }

    // 计算1-5随机数
    public static int f1(){
        return (int)(Math.random()*5+1);
    }

    // 试得到0，1的概率各位百分之五十
    public static int f2(){
        int ans = 0;
        do{
            ans = f1();
        }while (ans == 3);
        return ans < 3 ? 0 : 1 ;
    }

    public static int f3(){
        int ans = 0;
        do{
            ans = (f2()<<2) +(f2()<< 1) + f2();
        }while (ans == 7);
        return ans;
    }

    public static int x(){
        return Math.random()>0.32 ? 0:1;
    }

    public static int y(){
        int ans = 0;
        do{
            ans = x();
        }while (ans == x());
        return ans;
    }


}

