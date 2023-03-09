package msb_2022_6_22;
//769. 最多能完成排序的块
public class maxChunksToSorted {
    public static void main(String[] args) {
        int[] arr =new int[]{0,2,1} ;
        maxChunksToSorted1(arr);
    }

    private static int maxChunksToSorted1(int[] arr){

        int len = arr.length;
        int[] min = new int[len];
        int ans = 1;
        min[len-1] = arr[len-1];
        for (int i = len-2; i > 0; i--) {
            min[i] = Math.min(arr[i],min[i+1]);
        }
        int max = arr[0];
        for (int i = 1; i < len; i++) {
            if(max<=min[i]){
                ans++;
            }
            max = Math.max(max,arr[i]);
        }
        return ans;
    }
}
