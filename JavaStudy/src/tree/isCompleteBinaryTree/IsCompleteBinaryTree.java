package tree.isCompleteBinaryTree;

import tree.TreeNode;

import java.util.LinkedList;

/**
 * @Description 判断二叉树是否完全二叉树
 * @Author: tmj
 * @Data: 2022/12/5 23:45
 */
public class IsCompleteBinaryTree {

    public boolean isCompleteBinaryTree(TreeNode head) {
        if (head == null) {
            return true;
        }
        // 申请一个队列用于排序
        LinkedList<TreeNode> queue = new LinkedList<>();
        boolean leaf = false;
        TreeNode l = null;
        TreeNode r = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            l = head.left;
            r = head.right;
            if (
                    // 如果遇到不双全的节点后，又发现当前节点不是叶子节点
                    (leaf && (l != null || r != null))
                            ||
                            // 只有右节点
                            (l == null && r != null)) {
                return false;
            }
            if(l != null){
                queue.add(l);
            }
            if(r != null){
                queue.add(r);
            }
            if(l == null || r == null) {
                leaf = true;
            }
        }
        return true;
    }

    public static boolean isCompleteBinaryTree1(TreeNode head) {
        if(head == null){
            return true;
        }
        return process(head).isCBT;

    }

    public static Info process(TreeNode x){
       if(x == null){
           return new Info(true,true,0);
       }
       Info leftInfo = process(x.left);
       Info rightInfo = process(x.right);

       int height = Math.max(leftInfo.height , rightInfo.height) + 1;
       boolean isFull = leftInfo.isFull && rightInfo.isFull && leftInfo.height == rightInfo.height;
       boolean isCBT = false;
       if(leftInfo.height == rightInfo.height){
           if(leftInfo.isFull && rightInfo.isFull || leftInfo.isFull && rightInfo.isCBT){
               isCBT = true;
           }
       }
       if(leftInfo.height == rightInfo.height + 1){
           if(leftInfo.isCBT && rightInfo.isFull || leftInfo.isFull && rightInfo.isFull){
               isCBT = true;
           }
       }
       return new Info(isFull,isCBT,height);
    }

    public static class Info{
        public boolean isFull;
        public boolean isCBT;
        public int height;

        public Info(boolean isFull, boolean isCBT, int height) {
            this.isFull = isFull;
            this.isCBT = isCBT;
            this.height = height;
        }
    }
}
