package stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

// 225. 用队列实现栈
public class MyStack {

    Queue<Integer> pushQueue,popQueue; // 交替使用，但交替完都会将pop赋值给push

    public MyStack() {
        pushQueue = new LinkedList();
        popQueue = new LinkedList();

    }

    public void push(int x) {
        pushQueue.offer(x);
        // 这一步过后新进来的元素就成了push队列的头，pop队列就为空了
        while (!popQueue.isEmpty()){
            pushQueue.offer(popQueue.poll());
        }
        // 交换push队列和pop队列
        // 事实上，这步过后，push为空，pop为倒序的队列
        Queue tmp = popQueue;
        popQueue = pushQueue;
        pushQueue = tmp;

    }

//    123 321


    public int pop() {
        return popQueue.poll();
    }

    public int top() {
        return popQueue.element();
    }

    public boolean empty() {
        if (popQueue.isEmpty()){
            return true;
        }
        return false;
    }
}
