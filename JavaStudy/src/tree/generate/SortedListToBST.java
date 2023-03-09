package tree.generate;

import linkedList.ListNode;
import tree.TreeNode;

/**
 * @Description 有序链表转换二叉搜索树
 * @Author: tmj
 * @Data: 2022/12/23 11:31
 */
public class SortedListToBST {
    public static void main(String[] args) {

    }

    public static TreeNode sortedListToBST(ListNode head){
        return process(head,null);
    }

    public static TreeNode process(ListNode left, ListNode right){
        if(left == right){
            return null;
        }
        ListNode mid = getMid(left, right);
        TreeNode node = new TreeNode(mid.val);
        node.left = process(left,mid);
        node.right = process(mid.next,right);
        return node;
    }

    public static ListNode getMid(ListNode left, ListNode right){
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right){
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
