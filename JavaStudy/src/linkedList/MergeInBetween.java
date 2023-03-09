package linkedList;

import java.util.List;

/**
 * @Description 1669. 合并两个链表
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 *
 * 请你将 list1 中下标从 a 到 b 的全部节点都删除，并将list2 接在被删除节点的位置。
 * @Author: tmj
 * @Data: 2023/1/31 16:00
 */
public class MergeInBetween {

    public static void main(String[] args) {
        ListNode list1 = new ListNode(0);
        ListNode l1 = list1;
        for (int i = 1; i < 6; i++) {
            list1.next = new ListNode(i);
            list1 = list1.next;
        }
        ListNode list2 = new ListNode(1000);
        ListNode l2 = list2;
        for (int i = 10001; i < 10003; i++) {
            list2.next = new ListNode(i);
            list2 = list2.next;
        }
        ListNode node = mergeInBetween(l1, 3, 4, l2);

    }

    /**
     *
     * @param list1
     * @param a
     * @param b
     * @param list2
     * @return
     */
    public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        int i = 1;// 用于计数
        ListNode res = list1;//记录头节点
        ListNode tmp;
        while (list1!=null){
            if (i+1 == a){
                tmp = list1.next;
                list1.next = list2;
                while (list1.next!=null){
                    list1 = list1.next;
                }
                while (i != b){
                    tmp = tmp.next;
                    i++;
                }
                list1.next = tmp;
                return res;
            }
            i++;
            list1 = list1.next;
        }
        return res;
    }
}
