package stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

// 735. 行星碰撞
public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = new int[]{-2, -2, 1, -2};
        int[] ans = asteroidCollision(asteroids);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    public static int[] asteroidCollision(int[] asteroids) {

        int n = asteroids.length;
        // 栈是jdk1的东西，底层实现并非链表而是数组，会设计到扩容等操作
        // 其实际效率远不如Deque
        Stack<Integer> ansStack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (ansStack.isEmpty() || asteroids[i] > 0 || ansStack.peek() < 0) {
                ansStack.push(asteroids[i]);
            } else if (asteroids[i] < 0) {
                int cur = 0;
                while (!ansStack.isEmpty() && ansStack.peek() > 0) {
                    if (-asteroids[i] == ansStack.peek()) {
                        ansStack.pop();
                        cur = 0;
                        break;
                    } else if (-asteroids[i] > ansStack.peek()) {
                        ansStack.pop();
                        cur = asteroids[i];
                    } else {
                        cur = 0;
                        break;
                    }
                }
                if (cur != 0) {
                    ansStack.push(cur);
                }
            }
        }
        int m = ansStack.size();
        int[] ans = new int[m];
        for (int i = m - 1; i >= 0; i--) {
            ans[i] = ansStack.pop();
        }

        return ans;
    }


    public static int[] asteroidCollision1(int[] asteroids) {
//        Stack<Integer> ansStack = new Stack<>();
        Deque<Integer> ansStack = new ArrayDeque<Integer>();
        for (int astero : asteroids){
            // 记录行星死活
            boolean alive = true;
            while (alive && astero < 0 && !ansStack.isEmpty() && ansStack.peek() > 0){
                alive = ansStack.peek() < -astero; //如果栈顶大于左方向移动的行星，当前行星死亡
                if(ansStack.peek() <= -astero){
                    ansStack.pop();
                }
            }
            if(alive){
                ansStack.push(astero);
            }
        }
        int m = ansStack.size();
        int[] ans = new int[m];
        for (int i = m - 1; i >= 0; i--) {
            ans[i] = ansStack.pop();
        }
        return ans;
    }

}
