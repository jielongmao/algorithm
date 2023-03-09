package unclassified;

import java.util.Stack;

/**
 * @author DIO的面包店
 * @since 2022/3/13 19:11
 */
public class StackTest {
    public static void main(String[] args) {
        int n = 4;

        System.out.println(find(n));

    }

    static int  find(int n) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        boolean flag = true;
        for (int i = 1; i <= n; i++) {
            if (!flag)  {
                stack1.add(i);
            }
            flag = !flag;
        }
        flag = true;
        while (stack1.size() > 1) {

            n = stack1.size();
            for (int i = 1; i <= n; i++) {
                int temp = stack1.pop();
                if (!flag) {
                    stack2.add(temp);
                }
                flag = !flag;

            }
            stack1 = (Stack<Integer>) stack2.clone();

            stack2.clear();

        }

        return stack1.pop();

    }
}
