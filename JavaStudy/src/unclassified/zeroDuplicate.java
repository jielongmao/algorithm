package unclassified;

/**
 * 0复写
 */
public class zeroDuplicate {

    public static void main(String[] args) {
        int[] arr = new int[]{0,4,1,0,0,8,0,0,3};
        duplicateZeros(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
    public static void duplicateZeros(int[] arr) {
        int len = arr.length;
        for(int i = 0 ; i<len-1;i++){
            if(arr[i] == 0){
                if(i+2<len){
                    for(int j = len-1;j>=i+2;j--){
                        arr[j] = arr[j-1];
                    }
                    arr[i+1] = 0;
                }else{
                    arr[i+1] = 0;
                }
                i++;
            }
        }
    }
}
