package linkedList.mergeKLists;

import linkedList.ListNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Description TODO
 * @Author: tmj
 * @Data: 2022/11/1 22:58
 */
public class MergeKLists {
    public static void main(String[] args) {
        ListNode[] listNodes = {new ListNode(2),new ListNode(1),new ListNode(3)};
        mergeKLists(listNodes);
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        List<ListNode> list = new ArrayList<>();
        for (ListNode node:lists) {
            if(node != null){
                list.add(node);
            }
        }
        if(list == null || list.size() == 0){
            return null;
        }
        sort(list);
        ListNode head = list.get(0);
        ListNode node = list.get(0);
        ListNode tmp;
        tmp = list.get(0);
        if(tmp.next!=null){
            list.add(tmp.next);
        }
        list.remove(tmp);
        sort(list);
        while (list.size()!=0){
            tmp = list.get(0);
            node.next = tmp;
            if(tmp.next != null){
                list.add(tmp.next);
            }
            list.remove(tmp);
            node.next = node;
            sort(list);
        }
        return head;



    }

    public static void sort(List<ListNode> list){
        list.sort(Comparator.comparingInt(a -> a.val));
    }

}
