package bitOperation;

public class FindTwo {

    // 找到两个（只有）出现次数为奇数的数
    public static int[] findTwo(int[] nums) {
        // 全体异或取得a^b结果
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            tmp ^= nums[i];
        }
        // 找到最右侧1
        int r = -tmp & tmp;
        int[] ans = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & r) != 0) {
                ans[0] ^= nums[i];
            }
        }
        ans[1] = tmp ^ ans[0];
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 3, 2, 6, 2, 3, 3, 1, 2};
        int[] ans = findTwo(nums);
        System.out.println("a:" + ans[0]);
        System.out.println("b:" + ans[1]);
    }
}
