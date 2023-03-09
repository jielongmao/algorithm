package tree.recursion.isFull;

import tree.TreeNode;

/**
 * @Description 判断二叉树是否满二叉树
 * @Author: jielongmao
 * @Data: 2022/12/7 23:56
 */
public class IsFull {

    public static class Info{
        int nodeCount;
        int height;

        public Info(int nodeCount, int height) {
            this.nodeCount = nodeCount;
            this.height = height;
        }
    }

    public static boolean isFUll(TreeNode root) {
        Info info =  process(root);
        return ( 1 << info.height) - 1 == info.nodeCount;
    }

    public static Info process(TreeNode node) {
        if (node == null) {
            return new Info(0,0);
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);
        int nodeCount = Math.max(leftInfo.height,rightInfo.height) + 1;
        int height = leftInfo.nodeCount + rightInfo.nodeCount + 1;
        return new Info(nodeCount,height);
    }
}
