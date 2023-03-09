package unclassified;

import javax.swing.text.html.HTMLDocument;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author DIO的面包店
 * @since 2022/6/1 10:53
 */
public class zj1 {
    public static void main(String[] args) {
        int[] x = new int[]{191,172,596,304};
        int[] ans1 = answer(x);
        int ans2 = find(ans1);
        System.out.println(ans2);


    }

    public static int[] answer(int[] x) {

        int len = x.length;
        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i < len; i++) {
            if(!map.containsKey(x[i])){
                map.put(x[i],1);
            }
        }
        int[] x1 = new int[map.size()*3];
        int ceng = 0;
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            for (int i = 0; i < 3; i++) {
                x1[ceng*3+i]=entry.getKey();

            }
            ceng+=1;
        }



        for (int i = 0; i < map.size()*3-1; i++) {
            for (int j = 0; j < map.size()*3 - i - 1; j++) {
                if(x1[j]>x1[j+1]){
                    int tmp = x1[j];
                    x1[j] = x1[j+1];
                    x1[j+1] = tmp;
                }
            }
        }
        Integer integer;
        return x1;
    }
    public static int find(int[] x){
        if(x==null){
            return 0;
        }
        int len = x.length;
        if(len == 1){
            return x[0];
        }
        if(len>=8){
            return x[7];
        }
        for (int i = 1; i<3;i++){
            if(len>=8/(i*2)){
                return x[8/(i*2)];
            }
        }
        return 0;
    }
}
