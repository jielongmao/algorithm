package dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class SubsetXORSum {

    public static void main(String[] args) {
        int[] nums = new int[]{5,1,6};
        int ans = subsetXORSum(nums);
        System.out.println(ans);
    }

    public static int subsetXORSum(int[] nums) {
        int n = nums.length;
        List<Integer> sonsXor = new ArrayList<>();// 子集异或结果集合
        sonsXor.add(0);// 初始化,相当于先设置个空集合
        int ans = 0; // 接受结果
        for (int i = 0; i < n; i++) {// 每轮都在上一轮基础上做新增操作故，循环次数固定
            List<Integer> addList = new ArrayList<>();// 存放新增部分子集，最后与老自己相加
            
            for (int cur:sonsXor){
                addList.add(cur^nums[i]);// 将新增异或结果存入
                ans += cur^nums[i]; // 将新子集异或结果与结果相加
            }
            sonsXor.addAll(addList);
        }
        return ans;
    }
}
