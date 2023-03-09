package kthGrammar;

import sun.awt.util.IdentityArrayList;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author: tmj
 * @Data: 2022/10/20 10:01
 */
public class KthGrammar {

    public static void main(String[] args) {
        int n = 30; // 行数
        int k = 434991989; // 列数
        int i = kthGrammar(n, k);
        System.out.println(i);

    }

    public static int kthGrammar(int n, int k) {
        if(k>Math.pow(2,n)){
            return -1;
        }
        if(n==1){
            return 0;
        }if (n==2){
            return k==1? 0:1;
        }
        Map<String,String> dp = new HashMap<>();
        dp.put("0","01");
        dp.put("1","10");
//        dp.put("01","0110");
        String pre = "01";
        String now = "";
        int m = 2; //pre的长度
        for (int i = 3; i <= n; i++) {
            String tmp;
            if(m/2==1){
                tmp = dp.get(pre.substring(m/2));
                now = pre + tmp;
            }else {
                tmp = dp.get(pre.substring(m/2,m/2+m/4)) + dp.get(pre.substring(m/2+m/4));
                now = pre + tmp;
            }
            if(i==n){
                return now.charAt(k-1)-'0';
            }
            dp.put(pre,now);
            dp.put(pre.substring(m/2),tmp);
            m*=2;
            pre = now;
        }
        return -1;
    }

}
