package treeMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 插入区间
 *
 * @author DIO的面包店
 */
public class Insert {

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{6,9}};
        int[] newInterval = {4,5};

        int[][] insert = insert(intervals, newInterval);

        for (int i = 0; i < insert.length; i++) {
            System.out.print("("+insert[i][0]+","+insert[i][1]+"),");
        }

    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        TreeMap<Integer,Integer> treeMap = new TreeMap();

        for (int i = 0; i < intervals.length; i++) {
            treeMap.put(intervals[i][0],intervals[i][1]);
        }
        // 新区间的左右边界
        int left;
        int right;

        // 比待合并区间小的最大左边界
        int lowerLeft = treeMap.floorKey(newInterval[0])!=null? treeMap.floorKey(newInterval[0]):-1;

        int upperLeft = treeMap.floorKey(newInterval[1])!=null? treeMap.floorKey(newInterval[1]):-1;


        if(lowerLeft!=-1){
            int lowerRight = treeMap.get(lowerLeft);
            if (lowerRight<newInterval[0]){
                left = newInterval[0];
            }else{
                left = lowerLeft;
            }
        }else {
            left = newInterval[0];
        }
        if(upperLeft!= -1){
            int upperRight = treeMap.get(upperLeft);
            if(upperRight<newInterval[1]){
                right = newInterval[1];
            }else {
                right = upperRight;
            }
        }else {
            right = newInterval[1];
        }



        Map<Integer,Integer> subMap = treeMap.subMap(left,true,right,false);
        Set<Integer> set = new HashSet<>(subMap.keySet());
        treeMap.keySet().removeAll(set);

        treeMap.put(left,right);

        int[][] ans = new int[treeMap.size()][2];
        int n = 0;
        for (int key :treeMap.keySet()) {
            ans[n][0] = key;
            ans[n++][1] = treeMap.get(key);
        }

        return ans;
    }
}
