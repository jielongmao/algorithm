package tree.recursion.maxSubBTSsize;

import tree.TreeNode;

/**
 * @Description 找到最大二叉搜索子树，返回head
 * @Author: tmj
 * @Data: 2023/3/13 22:09
 */
public class MaxSubBTSHead {
    /**
     * 返回最大搜索二叉子树head
     * @param root
     * @return
     */
    public static TreeNode maxSubBTSHead(TreeNode root){
        if(root == null){
            return null;
        }
        return process(root).maxSubBSTHead;
    }

    public static Info process(TreeNode x){
        if( x == null ){
            return null;
        }
        Info leftInfo = process(x.left);
        Info rightInfo = process(x.right);
        int max = x.val;
        int min = x.val;
        TreeNode maxSubBSTHead = null;
        int maxBSTSubtreeSize = 0;
        if(leftInfo != null){
            max = Math.max(leftInfo.max , max);
            min = Math.min(leftInfo.min , min);
            maxSubBSTHead = leftInfo.maxSubBSTHead;
            maxBSTSubtreeSize = leftInfo.maxBSTSubtreeSize;
        }
        if(rightInfo != null){
            max = Math.max(rightInfo.max , max);
            min = Math.min(rightInfo.min , min);
            if(rightInfo.maxBSTSubtreeSize > maxBSTSubtreeSize){
                maxSubBSTHead = rightInfo.maxSubBSTHead;
                maxBSTSubtreeSize = rightInfo.maxBSTSubtreeSize;
            }
        }
        // 判断左右子树是否未空或者就是搜索二叉树
        if ((leftInfo == null ? true : (leftInfo.maxSubBSTHead == x.left && leftInfo.max < x.val))
                && (rightInfo == null ? true : (rightInfo.maxSubBSTHead == x.right && rightInfo.min > x.val))) {
            maxSubBSTHead = x;
            maxBSTSubtreeSize = (leftInfo == null ? 0 : leftInfo.maxBSTSubtreeSize)
                + (rightInfo == null ? 0 : rightInfo.maxBSTSubtreeSize) + 1;
        }
        return new Info(maxSubBSTHead,maxBSTSubtreeSize,max,min);
    }


    /**
     * 信息类
     */
    public static class Info {
        TreeNode maxSubBSTHead;
        // 最大搜索二叉子树size
        int maxBSTSubtreeSize;
        // 最大值
        int max;
        // 最小值
        int min;

        public Info(TreeNode maxSubBSTHead, int maxBSTSubtreeSize, int max, int min) {
            this.maxSubBSTHead = maxSubBSTHead;
            this.maxBSTSubtreeSize = maxBSTSubtreeSize;
            this.max = max;
            this.min = min;
        }
    }

}
