package unclassified;

/**
 * @author DIO的面包店
 * @since 2022/5/29 16:21
 */
public class LR {
    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        searchRange(nums,target);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }
    public static int[] searchRange(int[] nums, int target) {
        int len = nums.length;
        if(len == 0){
            return new int[]{-1,-1};
        }

        int first = findFirst(nums,target);
        if(first == -1){
            return new int[]{-1,-1};
        }
        int last = findLast(nums,target);
        return new int[]{first,last};
    }

    static int findFirst(int[] nums, int target){
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid]>target){
                r = mid -1;
            }else if(nums[mid] == target){
                r = mid;
            }else{
                l = mid+1;
            }
        }
        if(nums[l]==target){
            return l;
        }
        return -1;
    }

    static int findLast(int[] nums, int target){
        int l = 0;
        int r = nums.length-1;
        while(l<r){
            int mid = (l+r+1)/2;
            if(nums[mid]>target){
                r = mid -1;
            }else if(nums[mid] == target){
                l = mid;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
}
