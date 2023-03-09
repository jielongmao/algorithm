package tree.recursion.maxDistance;

import tree.TreeNode;

/**
 * @Description 返回整棵树的最大距离
 * @Author: jielongmao
 * @Data: 2022/12/6 23:37
 */
public class MaxDistance {

    /**
     * 返回整棵树的最大距离
     * @param root
     * @return
     */
    public int maxDistance(TreeNode root){
        return process(root).max;
    }

    public static Info process(TreeNode node){
        // base case
        if(node == null){
            return new Info(0,0);
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);
        // 最大距离为，左子树最大距离，右子树最大距离和左右子树深度加上1中最大者
        int max = Math.max(leftInfo.depth + rightInfo.depth +1,
                Math.max(leftInfo.max, rightInfo.max));
        int depth = Math.max(leftInfo.depth, rightInfo.max) + 1;
        return new Info(max,depth);
    }

    public static class Info{
        // 当前子树的最大距离
        int max;
        // 深度
        int depth;

        public Info(int max, int depth) {
            this.max = max;
            this.depth = depth;
        }
    }
}
