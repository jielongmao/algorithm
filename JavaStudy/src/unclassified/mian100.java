package unclassified;

/**
 * @author DIO的面包店
 * @since 2022/4/16 19:26
 */
public class mian100 {
    public static void main(String[] args) {
//        int[] a = {6, 9, 3, 6};
//        System.out.println();
        Integer a = new Integer(287189);
        int b = 287189;
        Integer c = new Integer(128);
        System.out.println(a == b);
        System.out.println(a == c);

    }

    // k:测试用例个数 n:n行 m：m列 bt:数据 Str:字符串
    public static int step(int k, int m, int n, String bt, String str) {
        char[][] bts = new char[n][m];
        int m1 = 0, n1 = 0;
        for (int i = 0; i < bt.length(); i++) {
            bts[m1][n1] = bt.charAt(i);
            m1++;
            n1++;
            if (m1 >= m) {
                m1 = 0;
            }
            if (n1 >= n) {
                n1 = 0;
            }
        }
        int ans = 0;
        int m2 = 0;
        int n2 = 0;
        for (int i = 0; i < str.length(); i++) {
            for (int o = 0; o < m; o++) {
                for (int p = 0; p < n; p++) {
                    if (bts[o][p] == str.charAt(i)) {
                        ans += Math.abs(o - m2) + Math.abs(p - n2);
                        m2 = o;
                        n2 = p;
                    }
                }
            }
        }
        return ans;


    }

}
