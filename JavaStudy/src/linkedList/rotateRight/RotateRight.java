package linkedList.rotateRight;

import linkedList.ListNode;

/**
 * @Description 链表右转k步
 * @Author: tmj
 * @Data: 2022/11/3 21:32
 */
public class RotateRight {
    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        for (int i = 1; i <= 1; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        rotateRight(head, 2);

    }
    public static ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null||k==0){
            return head;
        }
        ListNode n1 = head;
        int len = 1;
        while (n1.next!=null){
            n1 = n1.next;
            len ++;
        }
        if(k%len == 0){
            return head;
        }
        n1.next = head;
        n1 = head;
        for (int i = 0; i < len - k%len; i++) {
            n1 = n1.next;
        }
        ListNode n2 = n1;
        while (n1.next != n2){
            n1 = n1.next;
        }
        n1.next = null;
        return n2;
    }

}
