package tree.serializeAndDeserialize;

import tree.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;
import java.util.jar.JarEntry;

/**
 * @Description 层序遍历
 * @Author: tmj
 * @Data: 2022/11/22 22:54
 */
public class LevelSerialize {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);
        String serialize = serialize(root);
        System.out.println("1");

    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            return null;
        } else {
            sb.append(root.val+",");
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    sb.append(poll.left.val + ",");
                    queue.add(poll.left);
                } else {
                    sb.append("#,");
                }
                if (poll.right != null) {
                    sb.append(poll.right.val + ",");
                    queue.add(poll.right);
                } else {
                    sb.append("#,");
                }
            }
        }
        return sb.substring(0, sb.length() - 2);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null){
            return null;
        }
        String[] split = data.split(",");
        if(split.length == 0){
            return null;
        }
        Queue<String> levelList = new LinkedList<>();
        for (String s : split) {
            if (s != null && !"".equals(s)) {
                if ("#".equals(s)) {
                    levelList.add(null);
                } else {
                    levelList.add(s);
                }
            }
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode head = generateNode(levelList.poll());
        if(head != null){
            queue.add(head);
        }
        TreeNode node = null;
        while (!queue.isEmpty()){
            node = queue.poll();
            node.left = generateNode(levelList.poll());
            node.right = generateNode(levelList.poll());
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }

        }
        return head;

    }

    public static TreeNode generateNode(String s){
        if(s == null){
            return null;
        }
        return new TreeNode(Integer.parseInt(s));
    }
}
