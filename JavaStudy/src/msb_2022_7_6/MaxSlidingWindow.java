package msb_2022_7_6;

import java.util.LinkedList;
import java.util.List;

// 239. 滑动窗口最大值
public class MaxSlidingWindow {

    public static void main(String[] args) {

//        [1,3,-1,-3,5,3,6,7]
//        3
        // 经过的数组
        int[] nums = {1,3,1,2,0,5};
        // 窗口大小
        int k = 3;
        int[] ans=maxSlidingWindow(nums, k);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }

    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        // 先做特判
        if(nums==null||k<1||len<k){
            return null;
        }
        int i = 0;
        int ans[] = new int[len - k + 1];
        // 由于需要检查过期此处放置（nums中下标）
        LinkedList<Integer> maxWindow = new LinkedList<>();
        for (int r = 0; r < len; r++) {
            while (!maxWindow.isEmpty() && nums[maxWindow.peekLast()]<=nums[r]){
                maxWindow.pollLast();
            }
            maxWindow.addLast(r);
            if(r-maxWindow.peekFirst() == k){
                maxWindow.pollFirst();
            }
            // 当窗口满足大小开始记录结果
            if(r>=k-1){
                ans[i++] = nums[maxWindow.peekFirst()];
            }
        }
        return ans;
    }
}
