package unclassified;

import java.util.*;

/**
 * @author DIO的面包店
 * @since 2022/5/25 11:53
 */
public class OD2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        //存放小写
        Map map1 = new HashMap();
        //存放大写
        Map map2 = new HashMap();
        char[] arr = s.toCharArray();


        for (int i = 0; i < arr.length; i++) {
            if (Character.isLowerCase(arr[i])){
                if(map1.containsKey(arr[i])){
                    int tmp = Integer.parseInt(map1.get(arr[i]).toString());
                    map1.put(arr[i],tmp+1);
                }else {
                    map1.put(arr[i],1);
                }
            }else {
                if(map2.containsKey(arr[i])){
                    int tmp = Integer.parseInt(map2.get(arr[i]).toString());
                    map2.put(arr[i],tmp+1);
                }else {
                    map2.put(arr[i],1);
                }
            }
        }
        List<Map.Entry<Character,Integer>> infolds = new ArrayList<>(map1.entrySet());
        Collections.sort(infolds, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return (o2.getValue() - o1.getValue());
            }
        });
        List<Map.Entry<Character,Integer>> infolds1 = new ArrayList<>(map2.entrySet());
        Collections.sort(infolds1, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return (o2.getValue() - o1.getValue());
            }
        });
        for (int i = 0 ; i<infolds.size();i++){
            System.out.print(infolds.get(i).getKey()+":"+infolds.get(i).getValue()+";");
        }
        for (int i = 0 ; i<infolds1.size();i++){
            System.out.print(infolds1.get(i).getKey()+":"+infolds1.get(i).getValue()+";");
        }
    }

}
