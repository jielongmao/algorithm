package combination;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 力扣官方解，复刻
 * @Author: tmj
 * @Data: 2022/9/19 15:24
 */
public class Combine1 {

    public static void main(String[] args) {
        /** 数字从1到n **/
        int n = 4;
        /** 每个组合长度为k **/
        int k = 2;
        List<List<Integer>> combineList =
                combine(n, k);
        for (int i = 0 ; i<combineList.size() ; i++){
            for (int j = 0; j < combineList.get(i).size(); j++) {
                System.out.print(combineList.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    /** 结果集合 **/
    static List<List<Integer>> ans = new ArrayList<List<Integer>>();
    /** 子项 **/
    static List<Integer> temp = new ArrayList<>();
    public static List<List<Integer>> combine(int n, int k) {
        dfs(1,n,k);
        return ans;
    }

    public static void dfs(int cur , int n ,int k){
        // 此时说明剩余数字的无法满足组成一个长度为k的数字了
        if (temp.size() +n-cur+1<k){
            return;
        }

        // 当长度满足k，则加入结果集合
        if (temp.size() == k){
            ans.add(new ArrayList<Integer>(temp));
            return;
        }
        //考虑当前位置
        temp.add(cur);
        dfs(cur+1,n,k);
        //不考虑当前位置
        temp.remove(temp.size()-1);
        dfs(cur+1,n,k);
    }

}
