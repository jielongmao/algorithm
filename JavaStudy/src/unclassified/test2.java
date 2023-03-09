package unclassified;

import java.util.*;

public class test2 {


    public static void main(String[] args) {
//        int[] a = {1,2,3,5,6,6,7};

        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);

        list1.addAll(list2);
        System.out.println(list1);

//        System.out.println(ans(a));
    }

    static int ans(int[] a){
        int n = a.length;
        Map map = new HashMap();
        int f=1;
        int res = 0;
        for (int i = n-1; i >= 0; i--) {
            if (!map.containsKey(a[i])) {
                map.put(a[i],1);
                res+=a[i]*f;
                if(i!=0 ){
                    res*=10;
                }

            }
        }

        return res;
    }

}

