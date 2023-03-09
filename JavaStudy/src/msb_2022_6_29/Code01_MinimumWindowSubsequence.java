package msb_2022_6_29;


// 给定字符串 S and T，找出 S 中最短的（连续）子串 W ，使得 T 是 W 的 子序列 。
// 如果 S 中没有窗口可以包含 T 中的所有字符，返回空字符串 ""。
// 如果有不止一个最短长度的窗口，返回开始位置最靠左的那个。
// 示例 1：
// 输入：
// S = "abcdebdde", T = "bde"
// 输出："bcde"
// 解释：
// "bcde" 是答案，因为它在相同长度的字符串 "bdde" 出现之前。
// "deb" 不是一个更短的答案，因为在窗口中必须按顺序出现 T 中的元素。
// 测试链接 : https://leetcode.cn/problems/minimum-window-subsequence/
public class Code01_MinimumWindowSubsequence {

    public static void main(String[] args) {
        String str = "xxxaxbxasscxca*b*c****HHHHHHHHHESSFFFFFFFFFabcFFFFFASD";
        String target = "abc";
//        System.out.println(minLen(str,target));
//        System.out.println(minLen1(str,target));
        System.out.println(minLen2(str,target));

    }

    public static int minLen(String str, String target) {
        char[] s = str.toCharArray();
        char[] t = target.toCharArray();
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < s.length; i++) {
            // 调用方法消化参数返回最小长度
            int end = tian(s,t,i,0);
            if(end != Integer.MAX_VALUE ){
                len = Math.min(end-i ,len);
            }
        }
        return len;

    }
    // 消化t中参数
    // s主数组，t目标数组，sIndex s中目前位置，tIndex t中当前位置
    public static int tian(char[] s, char[] t,int sIndex,int tIndex) {
        if (tIndex == t.length){
            return sIndex;
        }
        if (sIndex == s.length){
            return Integer.MAX_VALUE;
        }
        // s[si]不消化t[ti]
        int p1 = tian(s,t,sIndex +1 , tIndex);
        // s[si]消化t[ti]
        int p2 = Integer.MAX_VALUE;
        if (s[sIndex] == t[tIndex]){
            p2 = tian(s,t,sIndex+1,tIndex+1);
        }
        return Math.min(p1,p2);
    }


    // 优化1
    public static int minLen1(String str, String target) {
        char[] s = str.toCharArray();
        char[] t = target.toCharArray();
        int len = Integer.MAX_VALUE;
        int[][] dp = new int[s.length+1][t.length+1];
        for (int i = 0; i < s.length+1; i++) {
            for (int j = 0; j < t.length+1; j++) {
                dp[i][j] = -1;
            }
        }
        for (int i = 0; i < s.length; i++) {
            // 调用方法消化参数返回最小长度
            int end = tian1(s,t,i,0,dp);
            if(end != Integer.MAX_VALUE ){
                len = Math.min(end-i ,len);
            }
        }
        return len;

    }
    // 消化t中参数
    // s主数组，t目标数组，sIndex s中目前位置，tIndex t中当前位置 ,dp记录缓存
    public static int tian1(char[] s, char[] t,int sIndex,int tIndex,int[][] dp) {
        if(dp[sIndex][tIndex] != -1){
            return dp[sIndex][tIndex];
        }
        if (tIndex == t.length){
            return sIndex;
        }
        if (sIndex == s.length){
            return Integer.MAX_VALUE;
        }
        // s[si]不消化t[ti]
        int p1 = tian1(s,t,sIndex +1 , tIndex,dp);
        // s[si]消化t[ti]
        int p2 = Integer.MAX_VALUE;
        if (s[sIndex] == t[tIndex]){
            p2 = tian1(s,t,sIndex+1,tIndex+1,dp);
        }
        int result = Math.min(p1,p2);
        dp[sIndex][tIndex] = result;
        return result;

    }

    public static String minLen2(String str, String target) {
        char[] s = str.toCharArray();
        char[] t = target.toCharArray();
        int m = s.length;
        int n = t.length;
        int[][] dp = new int[m+1][n+1];

        for (int si = 0; si <= m; si++) {
            dp[si][n] = si;
        }
        for (int ti = 0; ti < n; ti++) {
            dp[m][ti] = Integer.MAX_VALUE;
        }

        for (int si = m-1; si >= 0; si--) {
            for (int ti = n-1; ti >= 0; ti--) {
                int r1 = dp[si+1][ti];
                int r2 = s[si]==t[ti] ? dp[si+1][ti+1]:Integer.MAX_VALUE ;
                dp[si][ti] = Math.min(r1,r2);
            }
        }
        int len = Integer.MAX_VALUE;
        int l = -1;
        int r = -1;
        for (int si = 0; si < m; si++) {
            int end = dp[si][0] ;
            if (end != Integer.MAX_VALUE && end - si < len) {
                len = dp[si][0] - si;
                l = si;
                r = end;
            }

        }
        return l==-1 ? "":str.substring(l,r);

    }



}
