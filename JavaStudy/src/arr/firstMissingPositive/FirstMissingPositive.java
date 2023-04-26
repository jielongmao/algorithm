package arr.firstMissingPositive;

import java.util.HashSet;

/**
 * @Description 缺失的第一个正数
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <p>
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * @Author: tmj
 * @Data: 2023/4/26 16:02
 */
public class FirstMissingPositive {

    // 直接装到set里进行判断
    public int firstMissingPositive(int[] nums) {
        // 先给数据装到hashset里
        HashSet<Integer> set = new HashSet();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        // 再做一次循环判断是否存在于hashset中
        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            if(!set.contains(i)){
                return i;
            }
        }
        return -1;
    }

    // 手动创建hashmap进行判断
    public int firstMissingPositive1(int[] nums) {
        // 手动创建hashmap
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i]<= nums.length && nums[nums[i]-1] != nums[i]){
                swap(nums,nums[i]-1, i);
            }
        }
        // 再做一次循环判断是否存在于hashset中
        for (int i = 1; i <= Integer.MAX_VALUE; i++) {
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return -1;
    }

    void swap(int[] nums , int a, int b){
        int c = nums[a];
        nums[a] = nums[b];
        nums[b] = c;
    }
}
