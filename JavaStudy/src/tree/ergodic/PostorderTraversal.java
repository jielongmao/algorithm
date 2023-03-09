package tree.ergodic;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description 后序遍历
 * @Author: tmj
 * @Data: 2022/11/7 23:24
 */
public class PostorderTraversal {

    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root!=null){
            Stack<TreeNode> s1 = new Stack<>();
            Stack<TreeNode> s2 = new Stack<>();
            s1.push(root);
            while (!s1.isEmpty()){
                root = s1.pop();
                s2.push(root);
                if(root.right != null){
                    s1.push(root.right);
                }
                if(root.left != null){
                    s1.push(root.left);
                }
            }
            while (!s2.isEmpty()){
                ans.add(s2.pop().val);
            }
        }
        return ans;
    }

    /**
     * 递归
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        nn(root, ans);
        return ans;
    }

    public void nn(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        nn(root.left, list);
        nn(root.right, list);
        list.add(root.val);
    }



}
