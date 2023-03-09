package linkedList.intersection;

import linkedList.ListNode;

/**
 * @Description TODO
 * @Author: tmj
 * @Data: 2022/10/31 23:37
 */
public class GetIntersectionNode {

    public static void main(String[] args) {

    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null||headB == null){
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        int lenA = 1;
        int lenB = 1;
        while (nodeA.next != null){
            lenA ++;
            nodeA = nodeA.next;
        }
        while (nodeB.next != null){
            lenB ++;
            nodeB = nodeB.next;
        }
        if(nodeA != nodeB){
            return null;
        }
        int dif = Math.abs(lenB - lenA);
        nodeA = headA;
        nodeB = headB;
        if(lenA >= lenB){
            for (int i = 0; i < dif; i++) {
                nodeA = nodeA.next;
            }
        }else {
            for (int i = 0; i < dif; i++) {
                nodeB = nodeB.next;
            }
        }
        if(nodeA==nodeB){
            return nodeA;
        }
        while (nodeA.next!=null && nodeB.next!=null){
            nodeA = nodeA.next;
            nodeB = nodeB.next;
            if(nodeA==nodeB){
                return nodeA;
            }
        }
        return null;

    }
}
