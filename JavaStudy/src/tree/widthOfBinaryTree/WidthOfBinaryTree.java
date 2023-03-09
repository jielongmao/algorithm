package tree.widthOfBinaryTree;

import javafx.util.Pair;
import tree.TreeNode;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 二叉树最大宽度
 * @Author: tmj
 * @Data: 2022/11/23 0:08
 */
public class WidthOfBinaryTree {


    // 不算中间的null
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        int count = 1;
        int max = 1;
        int newCount = 0;
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            count --;
            if(poll.left!=null){
                newCount ++;
                queue.add(poll.left);
            }
            if(poll.right!=null){
                newCount ++;
                queue.add(poll.right);
            }
            if(count == 0){
                max = Math.max(max,newCount);
                count = newCount;
                newCount = 0;
            }
        }
        return max;
    }


    public int widthOfBinaryTree1(TreeNode root) {
        int res = 1;
        List<Pair<TreeNode,Integer>> arr = new ArrayList<>();
        arr.add(new Pair<>(root,1));
        while (!arr.isEmpty()){
            List<Pair<TreeNode,Integer>> tmp = new ArrayList<>();
            for(Pair<TreeNode,Integer> pair : arr){
                TreeNode node = pair.getKey();
                Integer index = pair.getValue();
                if(node.left != null){
                    tmp.add(new Pair<>(node.left,index * 2));
                }
                if(node.right != null){
                    tmp.add(new Pair<>(node.right,index * 2 + 1));
                }
            }
            res = Math.max(res,arr.get(arr.size()-1).getValue() - arr.get(0).getValue() + 1);
            arr = tmp;
        }
        return res;
    }
}
