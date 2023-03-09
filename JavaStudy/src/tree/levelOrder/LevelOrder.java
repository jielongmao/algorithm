package tree.levelOrder;

import tree.TreeNode;

import java.util.*;

/**
 * @Description 二叉树层序遍历
 * @Author: tmj
 * @Data: 2022/11/21 22:33
 */
public class LevelOrder {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        levelOrder(root);
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return  new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 1;
        int newCount = 0;
        while (!queue.isEmpty()){
            TreeNode cur = queue.poll();
            count --;
            tmp.add(cur.val);
            if(cur.left!=null){
                queue.add(cur.left);
                newCount ++;
            }
            if(cur.right!=null){
                queue.add(cur.right);
                newCount ++;
            }
            if(count == 0){
                ans.add(tmp);
                tmp = new ArrayList<>();
                count = newCount;
                newCount = 0;
            }
        }
        return ans;
    }
}
