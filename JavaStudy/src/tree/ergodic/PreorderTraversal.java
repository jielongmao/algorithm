package tree.ergodic;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description 前序遍历
 * @Author: tmj
 * @Data: 2022/11/7 22:57
 */
public class PreorderTraversal {
    public static void main(String[] args) {

    }

    /**
     * 非递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            root = s1.pop();
            ans.add(root.val);
            if (root.right != null) {
                s1.push(root.right);
            }
            if (root.left != null) {
                s1.push(root.left);
            }
        }

        return ans;

    }


    /**
     * 递归
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        nn(root, ans);
        return ans;

    }

    public void nn(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        nn(root.left, list);
        nn(root.right, list);
    }


}
