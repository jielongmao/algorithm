package sort.merge;

public class SortArray {

    public static void main(String[] args) {
        int[] arr = {5,1,1,2,0,0};
        mergeSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    // 迭代非递归的归并排序，通过调节步长来把控
    public static int[] mergeSort(int[] arr){
        int N = arr.length;
        int mergeSize = 1;
        while (mergeSize < N){
            int L = 0; // 每次轮更新归并的大小都重置起始位置
            while (L < N){
                int M = L + mergeSize - 1;//两个的待归并序列的中间
                if(M > N){ // 如果归并的中心的大于数组的长度了，显然排序已经完成了
                    break;
                }
                int R = Math.min(M+mergeSize,N-1);// 可能出现最后一个达不到步长
                merge(arr,L,M,R);// 将L~M-1和M~R进行合并排序
                L = R +1;//设置下一个归并的开始位置
            }
            if(mergeSize > N/2){
                break;
            }
            mergeSize <<= 1;
        }

        return arr;
    }

    private static void merge(int[] arr , int L,int M, int R){
        int[] help = new int[R - L + 1];
        int i = L;
        int j = M+1;
        int index = 0;
        while ( i<M+1 && j<R+1){
            if(arr[i] <= arr[j]){
                help[index++] = arr[i++];
            }else {
                help[index++] = arr[j++];
            }
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
    }
}
