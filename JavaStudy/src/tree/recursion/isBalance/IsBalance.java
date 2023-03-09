package tree.recursion.isBalance;

import tree.TreeNode;

/**
 * @Description 判断二叉树是否是平衡二叉树
 * @Author: tmj
 * @Data: 2022/12/6 21:26
 */
public class IsBalance {

    // 定义Info内置类（存储二叉树是否为平衡二叉树和树的高度）
    public static class Info{
        public boolean isBalanced;
        public int height;

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }

    public static boolean isBalance(TreeNode node){
        Info ans = process(node);
        return ans.isBalanced;
    }

    // 递归函数
    public static Info process(TreeNode node){
        // 设置base case:当节点为空默认高度为0，是平衡的
        if (node == null){
            return new Info(true,0);
        }
        // 获取左右子树信息
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);
        // 计算出此节点信息
        // 如果左右树都为平衡且，两树高度相差不大于1，则平衡
        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced &&
                Math.abs(leftInfo.height - rightInfo.height) <= 1 ;
        // 最大树高度+1
        int height = Math.max(leftInfo.height,rightInfo.height)+1;
        return new Info(isBalanced,height);
    }
}
