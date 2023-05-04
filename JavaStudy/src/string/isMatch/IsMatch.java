package string.isMatch;

/**
 * @Description 给你一个输入字符串 (s) 和一个字符模式 (p) ，请你实现一个支持 '?' 和 '*' 匹配规则的通配符匹配：
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符序列（包括空字符序列）。
 * 判定匹配成功的充要条件是：字符模式必须能够 完全匹配 输入字符串（而不是部分匹配）。
 * @Author: tmj
 * @Data: 2023/5/4 10:35
 */
public class IsMatch {
    public static void main(String[] args) {
        String s = "adceb";
        String p = "*a*b";
        System.out.println(isMatch(s, p));
    }
    /**
     * 逻辑: 先将p处理成*u1*u2*形式
     */

    /**
     * 贪心算法(老实说我直接理解起来，还是有点绕hhh)
     * @param s
     * @param p
     * @return
     */
    public static boolean isMatch(String s, String p) {
        int sRight = s.length();
        int pRight = p.length();
        // 将p最后处理成*，如果没有*，则直接匹配完
        while (sRight > 0 && pRight > 0 && p.charAt(pRight-1) != '*'){
            if(match(s.charAt(sRight-1),p.charAt(pRight-1))){
                sRight --;
                pRight --;
            }else {
                return false;
            }
        }
        //判断是否匹配完了，匹配完的话则可以直接结束
        if(pRight == 0){
            return sRight == 0;
        }

        int sIndex = 0 , pIndex = 0;
        // 这两个位置用于记录*，匹配开始位置，后续匹配失败，则从此s记录的下一位置开始匹配
        int sRecord = -1, pRecord = -1;

        while (sIndex < sRight && pIndex < pRight){
            if(p.charAt(pIndex) == '*' ){
                pIndex ++ ;
                sRecord = sIndex;
                pRecord = pIndex;
            }else if (match(s.charAt(sIndex),p.charAt(pIndex))){
                sIndex ++;
                pIndex ++;
            }else if(sRecord != -1 && sRecord+1 < sRight){
                sRecord ++;
                sIndex = sRecord;
                pIndex = pRecord;
            }else {
                return false;
            }
        }

        // 最后剩下部分没匹配完,p最后剩下的部分必须全部都是*
        return allStar(p,pIndex,pRight);

    }

    private static boolean match(char sChar,char pChar){
        if(sChar == pChar || pChar == '?'){
            return true;
        }
        return false;
    }

    private static boolean allStar(String p , int pIndex ,int pRight){
        for (int i = pIndex; i < pRight; i++) {
            if (p.charAt(i)!='*'){
                return false;
            }
        }
        return true;
    }
}
