package sort.merge;

public class CountOfRangSum {

    public static void main(String[] args) {

    }

    private static int countOfRangSum(int[] arr,int lower,int upper){

        int n = arr.length;
        long[] sum = new long[n];
        sum[0] = arr[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i-1]+arr[i];
        }

        int ans = process(sum ,0,n-1,lower,upper);
        return ans;
    }

    private static int process(long[] sum ,int l,int r,int lower,int upper){
        if(l==r){
            if (sum[l] >= lower && sum[l] <= upper){
                return 1;
            }
            return 0;
        }

        int m = l+((r-l)>>1);
        return process(sum,l,m,lower,upper)+
                process(sum,m+1,r,lower,upper)+
                merge(sum,l,m,r,lower,upper);
    }

    private static int merge(long[] sum,int l,int m,int r,int lower,int upper){
        int ans = 0;
        int windowL = l;
        int windowR = l;
        for (int i = m+1; i <= r; i++) {
            long min = sum[i] - upper;
            long max = sum[i] - lower;
            while (windowR <= m && sum[windowR] <= max){
                windowR++;
            }
            while (windowL <= m && sum[windowL] < min){
                windowL++;
            }
            ans += Math.max(0,windowR - windowL);
        }
        long[] help = new long[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = m+1;
        while(p2 <= r && p1<=m){
            help[i++] = sum[p1] > sum[p2] ? sum[p2++]:sum[p1++];
        }
        while (p2<= r){
            help[i++] = sum[p2++];
        }
        while (p1<= m){
            help[i++] = sum[p1++];
        }
        for (i = 0; i < r-l+1; i++) {
            sum[i+l] = help[i];
        }
        return ans;

    }
}
