package tree.generate;

import tree.TreeNode;

/**
 * @Description 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * @Author: tmj
 * @Data: 2022/12/23 10:38
 */
public class SortedArrayToBST {

    static int[] nums = {-10, -3, 0, 5, 9};

    public static void main(String[] args) {

        TreeNode process = sortedArrayToBST(nums);
        System.out.println(process);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return process(nums,0, nums.length-1);
    }



    public static TreeNode process(int[] nums, int left , int right) {
        if (left>right) {
            return null;
        }
        int mid = (left+right)<<1;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = process(nums , left ,mid-1);
        node.right = process(nums , mid+1,right);
        return node;
    }
}
