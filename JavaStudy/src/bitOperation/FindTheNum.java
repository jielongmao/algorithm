package bitOperation;

import java.util.HashMap;
import java.util.HashSet;

public class FindTheNum {

    // 在nums中一个数出现了k次，其他数都出现了m次，且k>0,m>k，要求空间复杂度为常数,O(1)
    public static int findTheNum(int[] nums ,int k,int m){
        int[] tmp = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                if(((1<<j)&nums[i]) != 0){
                    tmp[j]++;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if(tmp[i]%m/k==1){
                ans += (1<<i);
            }
        }
        return ans;
    }

    public static int test(int[] nums ,int k,int m){
        HashMap<Integer,Integer> map = new HashMap();
        for (int num : nums) {
            if(!map.containsKey(num)){
                map.put(num,1);
            }else {
                int v = map.get(num);
                map.put(num,++v);
            }
        }
        for (int key:map.keySet()){
            if(map.get(key) == k){
                return key;
            }
        }
        return 0;
    }

    public static int[] randomArray(int maxKinds,int range,int k,int m) {
        int ktimeNum = rangeNumber(range);
        // 2
        int numkinds = (int) (Math.random() * maxKinds) + 2;
        // k * 1 + (numKinds - 1) *m
        int[] arr = new int[k + (numkinds - 1) * m];
        int index = 0;
        for (; index < k; index++) {
            arr[index] = ktimeNum;
        }
        numkinds--;
        HashSet<Integer> set = new HashSet<>();
        set.add(ktimeNum);
        while (numkinds != 0) {
            int curNum = 0;
            do {
                curNum = rangeNumber(range);
            } while (set.contains(curNum));
            set.add(curNum);
            numkinds--;
            for (int i = 0; i < m; i++) {
                arr[index++] = curNum;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            int j = (int)(Math.random() * arr.length);
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }

        return arr;
    }

    public static int rangeNumber(int range){
        return ((int)(Math.random() *range)+1) - ((int)(Math.random()*range) +1);
    }

    public static void main(String[] args) {

//        int[] nums = new int[]{1,1,1,2,3,2,2,3,3,9,9,1,9,2,9};
//        int ans = test(nums,3,4);
//        System.out.println("ans:"+ans);

        // 做个对数器
        int kinds = 100;
        int range = 200;
        int max = 9;
        int testTime = 10000;
        for (int i = 0; i < testTime; i++) {
            int a = (int)(Math.random() * max)+1;
            int b = (int)(Math.random() * max)+1;
            int k = Math.min(a,b);
            int m = Math.max(a,b);
            if(k == m){
                m++;
            }
            int[] nums = randomArray(kinds,range,k,m);
            int ans1 = test(nums,k,m);
            int ans2 = findTheNum(nums,k,m );
            if(ans1 != ans2){
                System.out.println("错误用例：");
                System.out.print("[");
                for (int j = 0; j < nums.length; j++) {
                    System.out.print(nums[j]);
                    if(j != nums.length-1){
                        System.out.print(",");
                    }
                }
                System.out.println("]");
                System.out.println("k="+k);
                System.out.println("m="+m);
            }
        }
        System.out.println("测试结束");

    }
}
