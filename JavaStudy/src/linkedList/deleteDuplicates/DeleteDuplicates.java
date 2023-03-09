package linkedList.deleteDuplicates;

import linkedList.ListNode;

/**
 * @Description
 * @Author: tmj
 * @Data: 2022/11/4 14:17
 */
public class DeleteDuplicates {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(3);
//        head.next.next.next.next = new ListNode(3);
//        head.next.next.next.next.next = new ListNode(3);
//        head.next.next.next.next.next.next = new ListNode(4);
//        head.next.next.next.next.next.next.next = new ListNode(4);
        deleteDuplicates(head);
    }

    /** 1->2->2->3->4->4->5 => 1->3->5**/
    public static ListNode deleteDuplicates1(ListNode head) {
        ListNode h = new ListNode();
        h.next = head;
        ListNode ans = h;
        ListNode n1;
        while (h.next != null&&h.next.next != null){
            n1 = h.next;
            if(n1.val == n1.next.val){
                while (n1.next != null && n1.val == n1.next.val){
                    n1 = n1.next;
                }
                h.next = n1.next;
            }else {
                h = h.next;
            }
        }
        return ans.next;
    }
    /** 1->2->2->3->4->4->5 => 1->2->3->4->5**/

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode ans = head;
        ListNode n1 = head;
        ListNode n2;
        while (n1 != null && n1.next!=null) {
            n2 = n1.next;
            while (n2!=null && n1.val == n2.val){
                n2 = n2.next;
            }
            n1.next = n2;
            n1 = n1.next;
        }
        return ans;
    }

}
