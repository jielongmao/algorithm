public class generateTheString {

    public static void main(String[] args) {
        float m1 = 1.0029F;
        float m2 = 1.0029F;

        System.out.println();

        int n = 8;
        String ans = generateTheString(n);
        System.out.println(ans);
    }
    private static String generateTheString(int n){
        StringBuilder ans = new StringBuilder();
        if (n%2 == 1){
            return ans.append(repeat("a", n)).toString();
        }
        return ans.append(repeat("a",n-1)).append("b").toString();
    }

    private static String repeat(String s, int n){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(s);
        }
        return sb.toString();
    }
}

