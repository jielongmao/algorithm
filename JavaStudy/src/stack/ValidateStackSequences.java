package stack;

import java.util.Deque;
import java.util.LinkedList;

// 946. 验证栈序列
public class ValidateStackSequences {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        int pushLen = pushed.length;
        int popLen = popped.length;
        int i = 0,j = 0;
        Deque<Integer> stack = new LinkedList<>();
        while (i<pushLen && j<popLen){
            while (stack.isEmpty() || (i<pushLen &&stack.peek() != popped[j])){
                stack.push(pushed[i++]);
            }
            while (!stack.isEmpty() &&stack.peek() == popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
    // [1,2,3,4,5,6,7]
    // [1,2,5,3,6,7,4]
    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5,6,7};
        int[] popped = {1,2,5,3,6,7,4};
        boolean ans = validateStackSequences(pushed, popped);
        System.out.println(ans);;
    }
}
