package unclassified;

/**
 * @author DIO的面包店
 * @since 2022/6/16 21:28
 */
public class FindPairs {
    public static void main(String[] args) {
        int[] nums = new int[]{-1,-2,-3};
        int k = 0;
        System.out.println(findPairs(nums, k));
    }

    //先排序，双指针
    public static int findPairs(int[] nums, int k) {
        int len = nums.length;
        if(len<2){
            return 0;
        }
        sort(nums);

        int res = 0;
        for(int start = 0, port = 1;start<len-1;start++){
            while(nums[port]-nums[start]<k && port<len-1){
                port++;
            }
            if(nums[port]-nums[start]==k){
                res++;
            }
            if(start!=0&&nums[start]==nums[start-1]){
                start++;
            }
            port = start;
        }
        return res;

    }

    public static void sort(int[] nums){
        int len = nums.length;
        for(int i = 1; i<len;i++){
            for(int j = 1;j<len -i+1; j++){
                if(nums[j]<nums[j-1]){
                    int tmp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = tmp;
                }
            }
        }
    }
}
