package sort.fast;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.HashMap;

public class sort {

    public static void main(String[] args) {
        int[] arr = {-4,0,7,4,9,-5,-1,0,-7,-1};
        int[] ans = sortArray1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(ans[i]);
        }
    }

    private static int[] sortArray(int[] arr){
        quickSort(arr,0,arr.length-1);
        return arr;
    }

    private static void quickSort(int[] arr,int l,int r){
        if (l >= r){
            return;
        }
        int index = half(arr,l,r);
        quickSort(arr,l,index-1);
        quickSort(arr,index+1,r);

    }

    private static int half(int[] arr,int l,int r){
        if (l >= r){
            return l;
        }
        int index = l+1;
        int more = r;
        int m = arr[l];
        while (index <= more){
            if (arr[index] >= m){
                swap(arr,index,more--);
            }else {
                swap(arr,index,index-1);
                index ++;
            }
        }
        return index-1;
    }

    private static int[] sortArray1(int[] arr){
        fastsort(arr,0,arr.length-1);
        return arr;
    }

    private static void fastsort(int[] arr,int l,int r){
        if (l>=r){
            return;
        }
        swap(arr, (int) (l + Math.random()*(r-l+1)),r);
        int[] equalRange =  netherlandsFlag(arr,l,r);
        fastsort(arr,l,equalRange[0]-1);
        fastsort(arr,equalRange[1]+1,r);
    }

    private static int[] netherlandsFlag(int[] arr,int l,int r){
        if (l > r){
            return new int[]{-1,-1};
        }
        if (l == r){
            return new int[]{l,r};
        }
        // r位置就是基准，最后换到more位置，more是右边界
        int less = l-1; // <区 左边界
        int more = r; // >区 右边界
        int index = l;
        while(index < more){ // 当前位置，不能和>区的左边界接上
            if (arr[index] == arr[r]){
                index++;
            } else if (arr[index] < arr[r]){
                swap(arr, index++, ++less);
            } else {
                swap(arr, index ,--more);
            }
        }
        swap(arr,more,r);
        return new int[]{less+1,more};
    }

    private static void swap(int[] arr, int l,int r){
        int tmp = arr[l];
        arr[l] = arr[r];
        arr[r] = tmp;
    }


}
