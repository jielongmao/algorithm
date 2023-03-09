package unclassified;

import java.util.Arrays;

/**
 * 寻找第k大数组的返回距离
 *
 * @author DIO的面包店
 * @since 2022/6/16 16:14
 */
public class NumberPair {
    public static void main(String[] args) {
        //传入数组
        int[] nums = new int[]{1,6,1};
        int k = 3;
        System.out.println(smallestDistancePair(nums, k));
    }

    public static int smallestDistancePair(int[] nums, int k) {
        //数组长度
        int len = nums.length;

        //排序
        sort(nums);

        //第k小数对所在区间[0,max(nums) - min(nums)]
        int left = 0;
        int right = nums[len-1] - nums[0];
        while(left<right){
            int mid = (right + left) / 2;
            //此处应计算所所有距离小于
            int count = countLess(nums,mid);
            if(k>count){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    //排序
    public static void sort(int[] nums){
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < len-i+1; j++) {
                if(nums[j]<nums[j-1]){
                    int tmp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = tmp;
                }
            }
        }
    }

    //计算有多少距离小于mid的数对
    public static int countLess(int[] nums,int mid){
        int count = 0;
        for(int left = 0,right = 0;right< nums.length;right ++){
            while (nums[right] - nums[left] > mid){
                left++;
            }
            count += right-left;
        }
        return count;
    }


}
