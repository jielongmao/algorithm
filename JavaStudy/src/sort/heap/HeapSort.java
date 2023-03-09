package sort.heap;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.PriorityQueue;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = {5,1,1,2,0,0};
        PriorityQueue<Integer> heap = new PriorityQueue<>(); //(a,b) -> b-a
        for (int i = 0; i < arr.length; i++) {
            heap.add(arr[i]);
        }
        while (!heap.isEmpty()){
            System.out.print(heap.poll()+" ");
        }
        System.out.println();
        System.out.println("=============================");


        heapSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    private static void heapSort(int[] arr){
        if(arr == null || arr.length == 0){
            return;
        }

//        for (int i = 0; i < arr.length; i++) {
//            heapinsert(arr ,i);
//        }

        for (int i = arr.length-1; i >= 0; i--) {
            heapify(arr ,i,arr.length);
        }

        int heapSize = arr.length;
        swap(arr , 0 , --heapSize);
        int index = 0; // 堆顶
        while (heapSize > 0){
            heapify(arr,index,heapSize);
            swap(arr , 0 ,--heapSize);
        }
    }

    private static void heapinsert(int[] arr ,int i){
        while (arr[i] > arr[(i-1)/2] ){
            swap(arr , i,(i-1)/2);
            i = (i-1)/2;
        }
    }

    private static void heapify(int[] arr ,int index ,int heapSize){
        int left  = index*2+1;
        while (left < heapSize){
            int largest = left+1 < heapSize && arr[left+1]>arr[left] ? left+1 : left;
            largest = arr[largest] >arr[index]? largest : index;
            if(largest == index){
                break;
            }
            swap(arr ,largest,index);
            index = largest;
            left = index * 2 + 1;
        }

    }

    private static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
