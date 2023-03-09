package tree.serializeAndDeserialize;

import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description 序列化和反序列化
 * @Author: tmj
 * @Data: 2022/11/22 21:32
 */
public class PreSerialize {
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
        pre(root,sb);
        return sb.substring(0,sb.length()-2);
    }

    // 递归进行序列化
    public static void pre(TreeNode root , StringBuilder sb){
        if(root == null){
            sb.append("#,") ;
        }else {
            sb.append(root.val);
            sb.append(",");
            pre(root.left,sb);
            pre(root.right,sb);
        }
    }



    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if(data == null){
            return null;
        }
        String[] split = data.split(",");
        if(split.length == 0){
            return null;
        }
        Queue<String> queue = new LinkedList();
        for(String s: split){
            if(s!=null&& !s.equals("")){
                if(s.equals("#")){
                    queue.add(null);
                }else {
                    queue.add(s);
                }
            }
        }
        TreeNode preb = preb(queue);
        return preb;
    }
    public static TreeNode preb(Queue<String> queue){
        String poll = queue.poll();
        if(poll == null){
            return null;
        }else {
            TreeNode node = new TreeNode(Integer.parseInt(poll));
            node.left = preb(queue);
            node.right = preb(queue);
            return node;
        }
    }


}
