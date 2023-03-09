package sort.merge;

import java.util.ArrayList;
import java.util.List;

public class CountSmaller {

    public List<Integer> countSmaller(int[] arr) {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] arr = {5,1,1,2,0,0};
        int res = process(arr,0,arr.length-1);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        System.out.println(res);
    }

    public static int process(int[] arr ,int l ,int r){
        if(l == r){
            return 0;
        }
        // l < r
        int mid = l+( (r-l) >> 1);
        return process(arr,l,mid)
                +
                process(arr,mid+1,r)
                +
                merge(arr,l,mid,r);
    }


    private static int merge(int[] arr , int L, int M, int R){
        int[] help = new int[R - L + 1];
        int i = L;
        int j = M+1;
        int index = 0;
        int res = 0;
        while ( i<M+1 && j<R+1){
            res += arr[i] < arr[j] ? (R -j + 1) * arr[i] : 0;
            help[index++] = arr[i] < arr[j] ? arr[i++]:arr[j++];
        }
        while (i<M+1){
            help[index++] = arr[i++];
        }
        while (j<R+1){
            help[index++] = arr[j++];
        }
        for (int k = L, index1 =0; k <= R;index1++, k++) {
            arr[k] = help[index1];
        }
        return res;
    }
}
