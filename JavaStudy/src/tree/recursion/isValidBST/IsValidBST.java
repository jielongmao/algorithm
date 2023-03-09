package tree.recursion.isValidBST;

import tree.TreeNode;

/**
 * @Description 判断是否搜索二叉树
 * @Author: jielongmao
 * @Data: 2022/12/6 22:47
 */
public class IsValidBST {

    /**
     * 递归
     * @param root
     * @return
     */
    public static boolean isValidBST(TreeNode root) {
        return process(root).isBST;
    }

    public static Info process(TreeNode node){
        if(node == null){
            return null;
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);
        int max = node.val;
        if (leftInfo != null){
            max = Math.max(max,leftInfo.max);
        }
        if (rightInfo != null){
            max = Math.max(max,rightInfo.max);
        }
        int min = node.val;
        if (leftInfo != null){
            min = Math.min(min,leftInfo.min);
        }
        if (rightInfo != null){
            min = Math.min(min,rightInfo.min);
        }
        boolean isBST = true;
        if(leftInfo != null && !leftInfo.isBST){
            isBST = false;
        }
        if(rightInfo != null && !rightInfo.isBST){
            isBST = false;
        }
        if(leftInfo != null && leftInfo.max >= node.val){
            isBST = false;
        }
        if(rightInfo != null && rightInfo.min <= node.val){
            isBST = false;
        }

        return new Info(isBST,max,min);
    }

    // 用于装载左右子树信息
    public static class Info{
        // 是否是搜索二叉树
        boolean isBST;
        // 当前树最大值
        int max;
        // 当前树最小值
        int min;

        public Info(boolean isBST, int max, int min) {
            this.isBST = isBST;
            this.max = max;
            this.min = min;
        }
    }
}
