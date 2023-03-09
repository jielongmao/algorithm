package arr;

/**
 * @Description TODO
 * @Author: tmj
 * @Data: 2022/10/9 15:44
 */
public class MaxAscendingSum {

    public static void main(String[] args) {
        int[] nums = {10,20,30,5,10,50};
        int i = maxAscendingSum(nums);
        System.out.println(i);
    }

    public static int maxAscendingSum(int[] nums) {
        int n = nums.length;
        if(n==1){
            return nums[0];
        }
        int ans = 0;
        int tmp = nums[0];
        for (int i = 1; i < n; i++) {
            if(nums[i]>nums[i-1]){
                tmp += nums[i];
                if(i==n-1){
                    ans = Math.max(ans,tmp);
                }
            }else {
                ans = Math.max(ans,tmp);
                tmp = nums[i];
            }
        }
        return ans;
    }

}
