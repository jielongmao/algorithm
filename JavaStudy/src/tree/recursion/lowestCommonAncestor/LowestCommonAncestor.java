package tree.recursion.lowestCommonAncestor;

import tree.TreeNode;

/**
 * @Description 二叉树的最近公共祖先
 * @Author: tmj
 * @Data: 2023/6/13 22:54
 */
public class LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Info process = process(root, p, q);
        return process.an;
    }

    public static Info process(TreeNode root,TreeNode a,TreeNode b){
        if(root == null){
            return new Info(false,false,null);
        }
        Info now = new Info(false,false,null);
        Info left = process(root.left, a, b);
        Info right = process(root.right, a,b);
        now.findA = left.findA || right.findA || root == a;
        now.findB = left.findB || right.findB || root == b;
        now.an = left.an != null ? left.an: right.an != null ? right.an
                : now.findA && now.findB ? root : null;
        return now;
    }



}

class Info{
    boolean findA;
    boolean findB;
    TreeNode an;

    public Info(boolean findA, boolean findB, TreeNode an) {
        this.findA = findA;
        this.findB = findB;
        this.an = an;
    }
}
