package unclassified;

/**
 * 判断S3是否是由S1和S2交错穿插组合而成
 *
 * @author DIO的面包店
 * @since 2022/4/4 15:18
 */
public class Interlace {


    static int s = 0 ;

    public static void main(String[] args) {


//        "aabcc"
//        "dbbca"
//        "aadbbbaccc"

        //定义s1,s2,s3
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbbaccc";
//        System.out.println(s1);
        isInterleave(s1,s2,s3);
        System.out.println(s);

    }


    public static void isInterleave(String s1, String s2, String s3) {
        if((s1==null||s1.length()==0) &&(s2==null||s2.length()==0)&&(s3==null||s3.length()==0)){
            s+=1;
        }
        if(s3 != null && s1.length()!=0 ){
            if(s1!= null&&s1.length()!=0 && s3.charAt(0) == s1.charAt(0)){
                isInterleave(s1.length() == 1 ? "":s1.substring(1),s2,s3.length() == 1 ? "":s3.substring(1));

            }
            if(s2!= null &&s2.length()!=0 &&s3.charAt(0) == s2.charAt(0)){
                isInterleave( s1 , s2.length() == 1 ? "":s2.substring(1),s3.length() == 1 ? "":s3.substring(1));
            }
        }


    }

    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int n = s1.length(), m = s2.length(), t = s3.length();

            if (n + m != t) {
                return false;
            }

            boolean[][] f = new boolean[n + 1][m + 1];

            f[0][0] = true;
            for (int i = 0; i <= n; ++i) {
                for (int j = 0; j <= m; ++j) {
                    int p = i + j - 1;
                    if (i > 0) {
                        f[i][j] = f[i][j] || (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(p));
                    }
                    if (j > 0) {
                        f[i][j] = f[i][j] || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(p));
                    }
                }
            }

            return f[n][m];
        }
    }

}
