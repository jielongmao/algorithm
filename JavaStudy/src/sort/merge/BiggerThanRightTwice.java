package sort.merge;

import treeMap.Merge;

/**
 * num大于2倍右边数 的 右边数的数量
 */
public class BiggerThanRightTwice {

    public static void main(String[] args) {
        int[] arr={9,1,3,4,9,1,2};
        System.out.println(biggerThanRightTwice(arr));
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    private static int biggerThanRightTwice(int[] arr){

        int l = 0;
        int r = arr.length-1;

        int ans = process(arr,l,r);


        return ans;
    }

    private static int process(int[] arr,int l,int r){
        if(l==r){
            return 0;
        }
        int m = l+ ((r-l) >> 1);
        return process(arr,l,m) + process(arr,m+1,r) + merge(arr,l,m,r);
    }

    private static int merge(int[] arr,int l,int m,int r){
        int ans = 0;
        int windowR = m+1;
        for (int i = l; i < m+1; i++) {
            while (windowR<=r && arr[i] > (arr[windowR]<<1)){
                windowR ++;
            }
            ans += windowR - m - 1;
        }
        int help[] = new int[r-l+1];
        int i = 0;
        int p1 = l;
        int p2 = m+1;
        while(p2 <= r && p1<=m){
            help[i++] = arr[p1] > arr[p2] ? arr[p2++]:arr[p1++];
        }
        while (p2<= r){
            help[i++] = arr[p2++];
        }
        while (p1<= m){
            help[i++] = arr[p1++];
        }
        for (i = 0; i < r-l+1; i++) {
            arr[i+l] = help[i];
        }
        return ans;
    }
}
