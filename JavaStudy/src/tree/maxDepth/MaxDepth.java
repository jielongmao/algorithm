package tree.maxDepth;

import tree.TreeNode;

/**
 * @Description 二叉树最大深度
 * @Author: tmj
 * @Data: 2022/11/23 0:02
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return Math.max(maxDepth(root.left)+1,maxDepth(root.right) + 1);
    }

}
