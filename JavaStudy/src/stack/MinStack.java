package stack;

import java.util.Deque;
import java.util.LinkedList;

// 155. 最小栈
public class MinStack {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack() {
        xStack = new LinkedList<>();
        minStack = new LinkedList<>();


    }

    public void push(int val) {
        if (xStack.isEmpty() || minStack.peek() >= val) {
            minStack.push(val);
        } else {
            int top = minStack.peek();
            minStack.push(top);
        }
        xStack.push(val);
    }

    public void pop() {
        xStack.pop();
        minStack.pop();
    }

    public int top() {
        return xStack.peek();

    }

    public int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        MinStack stack = null;
        String[] strs = new String[]{"MinStack", "push", "push", "push", "getMin", "top", "pop", "getMin"};
        int[][] nums = new int[][]{{}, {-2}, {0}, {-1}, {}, {}, {}, {}};
        int n = strs.length;
        for (int i = 0; i < n; i++) {
            if (strs[i].equals("MinStack")) {
                stack = new MinStack();
                System.out.println("null");
            } else if (strs[i].equals("push")) {
                stack.push(nums[i][0]);
                System.out.println("null");
            } else if (strs[i].equals("pop")) {
                stack.pop();
                System.out.println("null");
            } else if (strs[i].equals("top")) {
                System.out.println(stack.top());
            } else if (strs[i].equals("getMin")) {
                System.out.println(stack.getMin());
            }
        }
    }
}
