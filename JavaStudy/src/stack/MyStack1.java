package stack;

import java.util.LinkedList;
import java.util.Queue;

// 225. 用队列实现栈
public class MyStack1 {


    Queue<Integer> pushQueue, popQueue; // 交替使用，但交替完都会将pop赋值给push

    public MyStack1() {
        pushQueue = new LinkedList();
        popQueue = new LinkedList();

    }

    public void push(int x) {
        pushQueue.offer(x);
    }

//    123 321


    public int pop() {
        while (pushQueue.size() > 1) {
            popQueue.offer(pushQueue.poll());
        }
        int ans = pushQueue.poll();
        Queue<Integer> tmp = popQueue;
        popQueue = pushQueue;
        pushQueue = tmp;
        return ans;
    }

    public int top() {
        while (pushQueue.size() > 1) {
            popQueue.offer(pushQueue.poll());
        }
        int ans = pushQueue.poll();
        popQueue.offer(ans);
        Queue<Integer> tmp = popQueue;
        popQueue = pushQueue;
        pushQueue = tmp;
        return ans;
    }

    public boolean empty() {
        if (popQueue.isEmpty() && pushQueue.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyStack1 stack = null;
//        ["MyStack","push","push","top","pop","pop","empty"]
//        [[],[1],[2],[],[],[],[]]
        String[] strs = new String[]{"MyStack", "push", "push", "top", "pop", "pop", "empty"};
        int[][] nums = new int[][]{{}, {1}, {2}, {}, {}, {}, {}};
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            if (strs[i].equals("MyStack")) {
                stack = new MyStack1();
                System.out.println("null");
            } else if (strs[i].equals("push")) {
                stack.push(nums[i][0]);
                System.out.println("null");
            } else if (strs[i].equals("pop")) {
                System.out.println(stack.pop());
            } else if (strs[i].equals("top")) {
                System.out.println(stack.top());
            } else if (strs[i].equals("empty")) {
                System.out.println(stack.empty());
            }
        }
    }
}
