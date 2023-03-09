package linkedList.reverseKGroup;

import linkedList.ListNode;

/**
 * @Description 25. K 个一组翻转链表
 * @Author: tmj
 * @Data: 2022/11/3 22:22
 */
public class ReverseKGroup {

    public static void main(String[] args) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        for (int i = 1; i <= 4; i++) {
            node.next = new ListNode(i);
            node = node.next;
        }
        ListNode node1 = reverseKGroup(head, 2);
        System.out.println(node1.val);
//        reverse(head,3);
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(k == 0 || k ==1 || head == null|| head.next==null){
            return head;
        }
        ListNode n1 = head;
        ListNode beforHeead = new ListNode();
        ListNode ans = beforHeead;
        beforHeead.next = head;

        while (true){
            ListNode h = n1;
            int i;
            for (i = 0; i < k; i++) {
                if(n1 == null){
                    break;
                }
                n1 = n1.next;
            }
            if(i==k){
                beforHeead.next = reverse(h,k);
                beforHeead = h;
            }else {
                beforHeead.next = h;
                break;
            }
        }
        return ans.next;
    }

    /**
     * 将熊head开始的k个节点颠倒
     * @param head
     * @param k
     * @return 返回当前这一块的头节点
     */
    public static ListNode reverse(ListNode head , int k){
        ListNode n1 = head; //记录头节点
        ListNode n2 = head.next; //下个节点
        ListNode n3 ;//备用
//        n1.next = null;
        for (int i = 0; i < k - 1; i++) {
            n3 = n2.next; // 下个节点的next
            n2.next = n1;
            n1 = n2;
            n2 = n3;
        }
        head.next = n2;
        return n1;

    }



}
