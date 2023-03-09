package divideAndConquer;

/**
 * @Description TODO
 * @Author: tmj
 * @Data: 2022/10/9 10:26
 */
public class ScoreOfParentheses {

    public static void main(String[] args) {
        int i = scoreOfParentheses("(()(()))");
        System.out.println(i);
    }

    public static int scoreOfParentheses(String s) {
        if(s.length()== 2){
            return 1;
        }
        int bal = 0,len = 0,n=s.length();

        for (int i = 0; i < n; i++) {
            bal += (s.charAt(i)=='('? 1:-1);
            if(bal == 0){
                len = i+1;
                break;
            }
        }
        if (len == n){
            return 2 * scoreOfParentheses(s.substring(1,n-1));
        }else {
            return scoreOfParentheses(s.substring(0,len))+scoreOfParentheses(s.substring(len));
        }
    }
}
