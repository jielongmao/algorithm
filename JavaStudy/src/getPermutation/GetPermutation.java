package getPermutation;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 60. 排列序列
 * @Author: tmj
 * @Data: 2023/6/25 14:09
 */
public class GetPermutation {
    public static void main(String[] args) {
        String permutation = getPermutation(4, 9);
        System.out.println(permutation);

    }

    /**
     *
     * @param n 1到n
     * @param k 第k个
     * @return
     */
    public static String getPermutation(int n, int k) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(String.valueOf(i));
        }
        String ans = "";
        return process(n,k,ans,list);
    }

    private static String process(int n, int k , String ans , List<String> list){
        if(n == 1){
            return ans + list.get(0);
        }
        int levelNum = factorial(n-1);
        for (int i = 1; i<= n; i ++){
            if(k <= i * levelNum){
                String ans1 = ans + list.get(i-1);
                list.remove(i-1);
                return process(n-1,k- (i-1) * levelNum, ans1,list);
            }
        }
        return null;
    }

    private static int factorial(int n){
        if(n == 1){
            return 1;
        }
        int ans = 1;
        for (int i = 2; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }
}
