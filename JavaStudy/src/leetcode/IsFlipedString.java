package leetcode;

/**
 * @Description TODO
 * @Author: tmj
 * @Data: 2022/9/30 10:25
 */
public class IsFlipedString {
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";
        System.out.println(isFlipedString(s1, s2));
    }

    public static boolean isFlipedString(String s1, String s2) {
        if(s1.length() != s2.length()){
            return false;
        }
        String newS = s1+s1;
        return newS.contains(s2);
    }

}
