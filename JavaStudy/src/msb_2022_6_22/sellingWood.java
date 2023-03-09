package msb_2022_6_22;


//2312. 卖木头块
public class sellingWood {
    public static void main(String[] args) {

        int[][] prices = new int[][]{{1,4,2},{2,2,7},{2,1,3}};
        System.out.println(sellingWood(3, 5, prices));
    }

    public static long sellingWood(int m, int n, int[][] prices) {
        long[][] dp = new long[m+1][n+1];
        for (int[] p : prices ){
            dp[p[0]][p[1]] = Math.max(p[2],dp[p[0]][p[1]]);
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= i>>1; k++) {
                    dp[i][j] = Math.max(dp[i][j],dp[k][j]+dp[i-k][j]);
                }
                for (int k = 1; k <= j>>1; k++) {
                    dp[i][j] = Math.max(dp[i][j],dp[i][k]+dp[i][j-k]);
                }
            }
        }

        return dp[m][n];
    }




    public static long dfs(int m,int n,long[][] values,long[][] dp){
        if(m==0||n==0){
            return 0;
        }
//        if(dp[m][n] != -1){
//            return dp[m][n];
//        }
        long ans = values[m][n];
        for (int i = 1; i < m; i++) {
            ans = Math.max(ans,dfs(i,n,values,dp)+dfs(m-i,n,values,dp));
        }
        for (int i = 1; i < n; i++) {
            ans = Math.max(ans,dfs(m,i,values,dp)+dfs(m,n-i,values,dp));
        }
        dp[m][n] = ans;
        return ans;
    }
}
