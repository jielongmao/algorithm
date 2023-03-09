package unclassified;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author DIO的面包店
 * @since 2022/5/25 20:12
 */
public class combinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        //从小到大排序
        for (int i = 0; i < candidates.length-1; i++) {
            for (int j = 0; j < candidates.length-1-i; j++) {
                if(candidates[j]>candidates[j+1]){
                    int tmp = candidates[j];
                    candidates[j] =candidates[j+1];
                    candidates[j+1] = tmp;
                }
            }

        }

//        for (int i = 0; i < candidates.length; i++) {
//            System.out.println(candidates[i]);
//        }


        System.out.println(combinationSum(candidates, target));

    }

    public static List<List<Integer>> combinationSum(int[] candidates,int target){
        List<List<Integer>> res = new ArrayList<>();
        if(candidates.length == 0){
            return res;
        }
        //栈存放选取数学与回溯
        Stack<Integer> stack = new Stack<>();
        com(candidates,stack,target,0,res);
        return res;
    }

    public static void com(int[] candidates,Stack stack,int target,int begin,List<List<Integer>> res){
        if(target<0){
            return;
        }
        if(target == 0){
            res.add(new ArrayList<>(stack));
            return;
        }
        for (int i = begin; i < candidates.length; i++) {
            if(i > begin && candidates[i] == candidates[i-1]) continue;
            stack.push(candidates[i]);
            com(candidates,stack,target-candidates[i],i+1,res);
            stack.pop();
        }
    }
}
