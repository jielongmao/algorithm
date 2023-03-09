package msb_2022_7_6;

/**
 * leetcode 2327. 知道秘密的人数
 */
public class PeopleAwareOfSecret {
    public static void main(String[] args) {
        // 结束天
        int n= 6;
        // 知道秘密的第几天散播
        int delay = 2;
        // 知道秘密的第几天遗忘
        int forget = 4;
        System.out.println(peopleAwareOfSecret(n, delay, forget));
    }


    public static int peopleAwareOfSecret(int n, int delay, int forget){
        // 记录第n天知道的人数
        long[] knows = new long[n+1];
        // 记录第n天新知道的人数
        long[] news = new long[n+1];
        // 记录第n天要忘记的人数
        long[] forgets = new long[n+1];

        int mod = 1000000007;

        // 设置默认值，第一天一个人知道
        knows[1] = 1;

        if(1+delay<n+1){
            news[1+delay] = 1;
        }

        if(1+forget<n+1){
            forgets[1+forget] = 1;
        }
        for (int i = 2; i < n+1; i++) {
            knows[i] = (mod+knows[i-1]+news[i]-forgets[i])%mod;
            if(i+forget<n+1) {
                forgets[i + forget] = news[i];
            }
            if(i+delay<n+1) {
                // i+delay天新增 第i天新增的人数+ （第i+delay-1天被分享的人数 - 第i+delay天忘记了不能传播的那部分人）
                news[i+delay] =(mod+ news[i] + news[i+delay-1] - forgets[i+delay])%mod;
            }
        }
        return (int)knows[n];

    }

}
