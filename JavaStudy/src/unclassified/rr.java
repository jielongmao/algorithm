package unclassified;

import java.util.HashMap;
import java.util.Map;

public class rr {
    public static void main(String[] args) {
//        int[] x1 = fun1(x);
        int[] arr = {1,2,3,4};
        int x2 = fun2(arr);
        System.out.println(x2);
//        int[] x3 = fun3(x2);
    }

    static int[] fun1(int[] arr){
        Map map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],1);
        }
        int[] ans = new int[arr.length*3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if(arr[j]>arr[j+1]){
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                }
            }
        }
        for (int i = 0; i < arr.length; i++){
            ans[i*3]=arr[i];
            ans[i*3+1]=arr[i];
            ans[i*3+2]=arr[i];
        }
        return ans;
    }

    static int fun2(int[] arr){
        int n = arr.length;
        if( n == 0){
            return 4;
        }
        if( n> 6){
            if(n%2==1){
                return arr[n/2]+arr[n/2+1]+arr[n/2+2]+arr[n/2-1]+arr[n/2-2];
            }else {
                return arr[n/2]+arr[n/2-1]+arr[n/2-2]+arr[n/2-3]+arr[n/2+1]+arr[n/2+2];
            }
        }else{
            int ans = 0;
            for (int i = 0; i < n; i++) {
                ans += arr[i];
            }
            return ans;
        }

    }


}
