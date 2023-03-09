package tree.recursion.pathSum;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 从根节点到叶子节点是否存在等于路径和target
 * @Author: tmj
 * @Data: 2022/12/9 13:55
 */
public class pathSum1 {
    public static boolean hasPathSum(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return target == root.val;
        }
        return hasPathSum(root.left, target - root.val) || hasPathSum(root.right, target - root.val);
    }


    public static boolean hasPathSum1(TreeNode root, int target) {
        List<Integer> process = process(root, target);
        for (int i : process) {
            if (i == target) {
                return true;
            }
        }
        return false;
    }

    public static List<Integer> process(TreeNode x, int target) {
        if (x == null) {
            return null;
        }
        List<Integer> leftPathSumList = process(x.left, target);
        List<Integer> rightPathSumList = process(x.right, target);
        List<Integer> thisList = new ArrayList<>();
        // 如果没有左右节点就把自己的val装入list返回
        if (leftPathSumList == null && rightPathSumList == null) {
            thisList.add(x.val);
            return thisList;
        }
        if (leftPathSumList != null) {
            for (int val : leftPathSumList) {
                thisList.add(val + x.val);
            }
        }
        if (rightPathSumList != null) {
            for (int val : rightPathSumList) {
                thisList.add(val + x.val);
            }
        }
        return thisList;
    }
}
