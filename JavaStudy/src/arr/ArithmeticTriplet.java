package arr;

import java.lang.invoke.MutableCallSite;
import java.util.*;

/**
 * @Description 2367. 算术三元组的数目
 * 给你一个下标从 0 开始、严格递增 的整数数组 nums 和一个正整数 diff 。如果满足下述全部条件，则三元组 (i, j, k) 就是一个 算术三元组 ：
 *
 * i < j < k ，
 * nums[j] - nums[i] == diff 且
 * nums[k] - nums[j] == diff
 * 返回不同 算术三元组 的数目。
 * @Author: tmj
 * @Data: 2023/3/31 10:06
 */
public class ArithmeticTriplet {
    public static void main(String[] args) {
        for (int index = 0; index < 1000; index++) {
            int len = new Random().nextInt(198)+3;
            int[] nums = new int[len];
            for (int i = 0; i < len; i++) {
                nums[0] = new Random().nextInt(201);
            }
            int diff = new Random().nextInt(50)+1;
            if (arithmeticTriplets(nums, diff) != arithmeticTriplets1(nums, diff)){
                System.out.println("noPass!!!");
            }else {
                System.out.println("pass");
            }
        }

    }

    public static int arithmeticTriplets(int[] nums, int diff) {
        int len = nums.length;
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            set.add(nums[i]);
        }
        for (int litIndex = 0; litIndex < len-2; litIndex++) {
            for (int midIndex = litIndex+1; midIndex < len-1; midIndex++) {
                if (nums[midIndex] - nums[litIndex] == diff){
                    int big = nums[midIndex] + diff;
                    if (set.contains(big)){
                        res += 1;
                    }
                }
            }
        }
        return res;
    }

    // 不用set
    public static int arithmeticTriplets1(int[] nums, int diff) {
        int len = nums.length;
        int res = 0;
        for (int litIndex = 0; litIndex < len-2; litIndex++) {
            for (int midIndex = litIndex+1; midIndex < len-1; midIndex++) {
                if (nums[midIndex] - nums[litIndex] == diff){
                    int big = nums[midIndex] + diff;
                    if (valid(nums,midIndex,big)){
                        res += 1;
                    }
                }
            }
        }
        return res;
    }

    public static boolean valid(int[] nums, int midIndex ,int big) {
        for (int i = midIndex+1; i < nums.length; i++) {
            if (nums[i] == big){
                return true;
            }
        }
        return false;
    }
}
