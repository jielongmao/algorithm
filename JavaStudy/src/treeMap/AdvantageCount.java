package treeMap;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @Description 田忌赛马
 * @Author: tmj
 * @Data: 2022/10/8 9:15
 */
public class AdvantageCount {
//    nums1 = [2,7,11,15], nums2 = [1,10,4,11]
//    输出：[2,11,7,15]

    public static void main(String[] args) {
//        [2,0,4,1,2]
//[1,3,0,0,2]
        int[] nums1 = {2,7,11,15}, nums2 = {2,11,7,15};
        int[] ansNums = advantageCount2(nums1, nums2);
        for (int i = 0; i < ansNums.length; i++) {
            System.out.println(ansNums[i]);
        }
    }
    public static int[] advantageCount(int[] nums1,int[] nums2){
        int len = nums1.length;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            Integer higher = map.higherKey(nums2[i]);

            if (higher == null) {
                higher = map.firstKey();
            }

            res[i] = higher;

            if (map.get(higher) == 1) {
                map.remove(higher);
            } else {
                map.put(higher, map.get(higher) - 1);
            }
        }
        return res;
    }
    public static int[] advantageCount2(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Integer[] idx1 = new Integer[n];
        Integer[] idx2 = new Integer[n];
        for (int i = 0; i < n; ++i) {
            idx1[i] = i;
            idx2[i] = i;
        }
        Arrays.sort(idx1, (i, j) -> nums1[i] - nums1[j]);
        Arrays.sort(idx2, (i, j) -> nums2[i] - nums2[j]);

        int[] ans = new int[n];
        int left = 0, right = n - 1;
        for (int i = 0; i < n; ++i) {
            if (nums1[idx1[i]] > nums2[idx2[left]]) {
                ans[idx2[left]] = nums1[idx1[i]];
                ++left;
            } else {
                ans[idx2[right]] = nums1[idx1[i]];
                --right;
            }
        }
        return ans;
    }

}
