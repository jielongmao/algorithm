package tree.ergodic;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description 中序遍历
 * @Author: jielongmao
 * @Data: 2022/11/7 23:46
 */
public class InorderTraversal {

    /**
     * 中序遍历（不使用递归）
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root != null){
            Stack<TreeNode> s1 = new Stack<>();
            while (!s1.isEmpty() || root!=null){
                if(root != null){
                    s1.push(root);
                    root = root.left;
                }else {
                    root = s1.pop();
                    ans.add(root.val);
                    root = root.right;
                }
            }
        }
        return ans;
    }

    /**
     * 中序遍历（递归）
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        process(root, ans);
        return ans;
    }

    public void process(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        process(root.left, list);
        list.add(root.val);
        process(root.right, list);
    }
}
