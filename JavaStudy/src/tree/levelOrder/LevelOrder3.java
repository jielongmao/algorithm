package tree.levelOrder;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 锯齿形层序遍历 就是一排从左往右遍历，一排从右往左遍历
 * @Author: tmj
 * @Data: 2023/1/11 10:18
 */
public class LevelOrder3 {


    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        int count = 1;
        int nextLevelCount = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            tmp.add(node.val);
            count--;

            if (node.left != null) {
                queue.add(node.left);
                nextLevelCount++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLevelCount++;
            }

            if (count == 0) {
                if (level % 2 == 0) {
                    res.add(tmp);
                } else {
                    res.add(reverse(tmp));
                }
                level++;
                count = nextLevelCount;
                nextLevelCount = 0;
                tmp = new ArrayList<>();
            }
        }
        return res;
    }

    public static List<Integer> reverse(List<Integer> list) {
        List<Integer> reverseList = new ArrayList<>();
        for (int i = list.size() - 1; i >= 0; i--) {
            reverseList.add(list.get(i));
        }
        return reverseList;
    }
}
