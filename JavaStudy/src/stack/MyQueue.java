package stack;

import java.util.Stack;

// 232. 用栈实现队列
public class MyQueue {
    Stack<Integer> pushStack, popStack;

    public MyQueue() {
        pushStack = new Stack<>();
        popStack = new Stack<>();
    }

    public void push(int x) {
        pushStack.push(x);

    }

    public int pop() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.pop();
    }

    public int peek() {
        if (popStack.isEmpty()) {
            while (!pushStack.isEmpty()) {
                popStack.push(pushStack.pop());
            }
        }
        return popStack.peek();
    }

    public boolean empty() {
        if (pushStack.isEmpty() && popStack.isEmpty()) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyQueue queue = null;
        String[] strs = new String[]{"MyQueue", "push", "push", "peek", "pop", "empty"};
        int[][] nums = new int[][]{{}, {1}, {2}, {}, {}, {}};
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            if (strs[i].equals("MyQueue")) {
                queue = new MyQueue();
                System.out.println("null");
            } else if (strs[i].equals("push")) {
                queue.push(nums[i][0]);
                System.out.println("null");
            } else if (strs[i].equals("pop")) {
                queue.pop();
                System.out.println("null");
            } else if (strs[i].equals("peek")) {
                System.out.println(queue.peek());
            } else if (strs[i].equals("empty")) {
                System.out.println(queue.empty());
            }
        }
    }
}
