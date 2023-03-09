package dynamicProgramming;

public class isMatch {

    public static void main(String[] args) {
        String s = "aa";
        String p = "a*";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        boolean[][] dps = new boolean[n+1][m+1];
        dps[0][0] = true;
        for (int i = 0; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if(p.charAt(j-1) == '*'){//注意下标对应
                    dps[i][j] = dps[i][j-2];
                    if(matche(s,p,i,j-1)){
                        dps[i][j] = dps[i][j-2] || dps[i-1][j];
                    }
                }else {
                    dps[i][j] =matche(s,p,i,j) && dps[i-1][j-1];
                }
            }
        }
        return dps[n][m];
    }

    private static boolean matche(String s,String p,int i,int j){
        if(i==0){
            return false;
        }
        if(p.charAt(j-1) == '.'){
            return true;
        }
        return s.charAt(i-1) == p.charAt(j-1);
    }
}
