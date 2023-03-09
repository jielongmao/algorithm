package NumberOfPrefixes;

/**
 * @Description TODO
 * @Author: tmj
 * @Data: 2022/10/24 22:25
 */
public class PartitionDisjoint {

    public static void main(String[] args) {
        String str = "23,43,22";
        String[] split = str.split(",");

//        int[] nums = {5,0,3,8};
//        int i = partitionDisjoint(nums);
//        System.out.println(i);

    }

    public static int partitionDisjoint(int[] nums) {
        int len = nums.length;
        int[] maxs = new int[len];
        int[] mins = new int[len];
        maxs[0] = nums[0];
        mins[len-1] = nums[len-1];
        for (int i = 1; i < len; i++) {
            maxs[i] = Math.max(maxs[i-1],nums[i]);
        }
        for (int i = len-2 ; i >= 0 ; i--) {
            mins[i] = Math.min(mins[i+1],nums[i]);
        }
        int num = -1;
        for (int i = 0; i <= len-2; i++) {
            if(maxs[i] <= mins[i+1]){
                num = i+1;
                break;
            }
        }
        return num;
    }

}
