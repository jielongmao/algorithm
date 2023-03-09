package linkedList;

/**
 * @Description TODO
 * @Author: tmj
 * @Data: 2022/10/26 22:26
 */
public class Copy {

    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.val = 1;
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.more = node.next; // 5->2
        node.next.more = node; // 2->1
        node.more = node.next.next; // 1->3
        node.next.next.more = node; // 3->1
//        1->3 2->1 5->2 3->1
        copy(node);

    }


    public static ListNode copy(ListNode node){
        ListNode n1 = node;
        ListNode n2 = new ListNode();
        ListNode n3 = new ListNode();
        while (n1 != null){
            n2 = n1.next;
            n1.next = new ListNode(n1.val);
            n1.next.next = n2;
            n1 = n2;
        }
        n1 = node;
        while (n1 != null){
            n2 = n1.next;
            if(n1.more!=null){
                n2.more = n1.more.next;
            }
            n1 = n2.next;
        }
        n1 = node;
        n3 = node.next; // 记录克隆的头
        while (n1.next != null && n1.next.next != null){
            n2 = n1.next;
            n1.next = n1.next.next;
            n2.next = n2.next.next;
            n1 = n1.next;
        }
        return n3;
    }

}


