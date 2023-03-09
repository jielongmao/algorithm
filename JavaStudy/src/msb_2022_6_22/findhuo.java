package msb_2022_6_22;

public class findhuo {

    public static void main(String[] args) {
        String s = "**|***|**|*|*|***";
        System.out.println(findhuo(s,1,12));
    }

    private static int findhuo(String s,int start,int end){
        int len = s.length();
        //每个位置左边最近的墙
        int[] left = new int[len];
        //每个位置右边最近的墙
        int[] right = new int[len];

        //前缀和
        int[] sum = new int[len];


        right[0] = s.charAt(0)=='|' ? 0:-1;
        for (int i = 1; i < len; i++) {
            if(s.charAt(i)=='|'){
                right[i]=i;
            }else {
                right[i]=right[i-1];
            }
        }
        left[len-1] = s.charAt(len-1)=='|' ? len-1:-1;
        for (int i = len-2; i >= 0; i--) {
            if(s.charAt(i)=='|'){
                left[i]=i;
            }else {
                left[i]=left[i+1];
            }
        }

        sum[0] = s.charAt(0)=='*' ? 1:0;
        for (int i = 1; i < len; i++) {
            if(s.charAt(i)=='*'){
                sum[i]=sum[i-1]+1;
            }else {
                sum[i]=sum[i-1];
            }
        }

        return left[start]!=-1&&right[end]!=-1 ? sum[right[end]]-sum[left[start]]:0;
    }
}
