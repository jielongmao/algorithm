package unclassified;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author DIO的面包店
 * @since 2022/5/22 15:37
 */
public class combinationSum {
    public static void main(String[] args) {
        int[] candidates ={2,3,6,7};
        int[] candidates1 ={7,6,3,2};
        int target = 7;
        System.out.println(combinationSum(candidates, target));

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        //结果list
        List<List<Integer>> res = new ArrayList<>();
        //
        //栈存放选取数字与回溯
        Stack<Integer> stack = new Stack<>();
        com(candidates,stack,target,0,res);

        return res;
    }

    public static void com(int[] candidates,Stack stack,int target,int i,List<List<Integer>> res){
        if (target < 0) {
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(stack));
            return ;
        }

        for ( int j = i ; j < candidates.length; j++) {
            stack.push(candidates[j]);
            com(candidates,stack,target - candidates[j],i,res);
            stack.pop();
        }
    }
}
