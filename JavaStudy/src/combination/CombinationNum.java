package combination;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

/**
 * @Description 组合数字测试
 * @Author: tmj
 * @Data: 2022/9/19 14:14
 */
public class CombinationNum {

    public static void main(String[] args) {
        /** 数字从1到n **/
        int n = 4;
        /** 每个组合长度为k **/
        int k = 2;
        List<List<Integer>> combineList =
                combine(n, k);
        for (int i = 0 ; i<combineList.size() ; i++){
            for (int j = 0; j < combineList.get(i).size(); j++) {
                System.out.print(combineList.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> combine(int n, int k) {
        //用于存储每次执行完的最终结果
        List<List<Integer>> ansList = new ArrayList<>();
        //用于存储每次执行的中间新增的数组
        List<List<Integer>> testList = new ArrayList<>();



        for (int i = 0; i < k; i++) {
            if (i == 0){
                for (int j = 1; j<=n ; j++){
                    List<Integer> son = new ArrayList();
                    son.add(j);
                    testList.add(son);
                }
            }else{
                for (List<Integer> son : ansList){
                    int last = son.get(i-1);
                    if(last < n){
                        for (int j = son.get(i-1)+1 ; j<=n ; j++){
                            List<Integer> newSon = new ArrayList<>();
                            newSon.addAll(son);
                            newSon.add(j);
                            testList.add(newSon);
                        }
                    }
                }
            }
            ansList.clear();
            ansList.addAll(testList);
            testList.clear();
        }
        return ansList;
    }
}
