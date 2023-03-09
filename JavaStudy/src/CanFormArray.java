import java.util.HashMap;
import java.util.Map;

/**
 * @Description TODO
 * @Author: tmj
 * @Data: 2022/9/22 19:00
 */
public class CanFormArray {
    public static void main(String[] args) {
//        [91,4,64,78]
//[[78],[4,64],[91]]
        int arr[] = {91,4,64,78};
        int pieces[][] = {{78},{4,64},{91}};
        canFormArray(arr,pieces);
    }

    public static boolean canFormArray(int[] arr, int[][] pieces) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < pieces.length;i ++){
            map.put(pieces[i][0],i);
        }

        for (int i = 0; i < arr.length; i++) {
            if(!map.containsKey(arr[i])){
                return false;
            }
            int j;
            for (j = 0; j < pieces[map.get(arr[i])].length; j++) {
                if(arr[i+j]!=pieces[map.get(arr[i])][j]){
                    return false;
                }
            }
            i += j-1;
        }
        System.out.println(true);
        return true;
    }
}
