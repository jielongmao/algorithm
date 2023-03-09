package tree.levelOrder;

import tree.TreeNode;

import java.util.*;

/**
 * @Description 层序遍历从最后一层，遍历结果从最后一层开始遍历
 * @Author: tmj
 * @Data: 2022/12/9 21:40
 */
public class LevelOrder2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        levelOrderBottom(root);
    }

    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> tmp = new ArrayList<>();
        Stack<List<Integer>> stack = new Stack<>();
        int count = 1;
        int nextCount = 0;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            count --;
            tmp.add(node.val);
            if(node.left!=null){
                queue.add(node.left);
                nextCount ++;
            }
            if(node.right!=null){
                queue.add(node.right);
                nextCount ++;
            }
            if(count == 0){
                stack.push(tmp);
                tmp = new ArrayList<>();
                count = nextCount;
                nextCount = 0;
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        while (!stack.isEmpty()){
            ans.add(stack.pop());
        }
        return ans;
    }

}
