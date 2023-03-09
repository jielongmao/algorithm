package linkedList;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Description TODO
 * @Author: tmj
 * @Data: 2022/10/25 22:28
 */
public class IsPalindrome {

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 1;
        node.next = new ListNode(2);
        node.next.next = new ListNode(2);
        node.next.next.next = new ListNode(1);
        boolean palindrome = isPalindrome(node);
        System.out.println(palindrome);


    }

    //
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        // 快慢指针找中点
        ListNode n1 = n1point(head);
        ListNode n2 = n1.next;
        n1.next = null;

        ListNode n3;
        while (n2 != null) {
            n3 = n2.next;
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        n3 = n1; // 尾节点
        n2 = head; // 头节点
        boolean res = true;
        while (n2 != null && n1 != null) {
            if(n2.val != n1.val) {
                res = false;
                break;
            }
            n1 = n1.next;
            n2 = n2.next;
        }
        n1 = n3.next;
        n3.next = null;
        while (n1 != null){
            n2 = n1.next;
            n1.next = n3;
            n3 = n1;
            n1 = n2;
        }

        return res;
    }

    public static ListNode n1point(ListNode node) {
        ListNode fast = node;
        ListNode slow = node;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;
    }

}


