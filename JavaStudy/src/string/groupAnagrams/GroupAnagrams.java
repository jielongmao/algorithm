package string.groupAnagrams;

import java.util.*;

/**
 * @Description 字母异位分组（tm这题目怎么误导人啊，我还以为没有重复字符）(我的)
 * @Author: tmj
 * @Data: 2023/1/11 14:14
 */
public class GroupAnagrams {
    public static void main(String[] args) {
//        String[] strs = {"eat","tea","tan","ate","nat","bat"};
        String[] strs = {"hhhhu", "tttti", "tttit", "hhhuh", "hhuhh", "tittt"};
        List<List<String>> lists = groupAnagrams3(strs);
        System.out.println(lists);
    }

    /**
     * 暴力（超时）
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        List<Map<Character, Integer>> mapList = new ArrayList<>();
        for (String s : strs) {
            if (mapList.isEmpty()) {
                Map<Character, Integer> mapTmp = new HashMap<>();
                for (int i = 0; i < s.length(); i++) {
                    mapTmp.put(s.charAt(i), mapTmp.getOrDefault(s.charAt(i), 0) + 1);
                }
                mapList.add(mapTmp);
                List<String> listTmp = new ArrayList<>();
                listTmp.add(s);
                res.add(listTmp);
                continue;
            }
            // 标志位标识 有没有匹配的map
            boolean flag = false;
            for (Map<Character, Integer> map : mapList) {
                Map<Character, Integer> mapT = new HashMap<>(map);
                // 标志位
                for (int i = 0; i < s.length(); i++) {
                    mapT.put(s.charAt(i), mapT.getOrDefault(s.charAt(i), 0) - 1);
                    if (mapT.get(s.charAt(i)) == 0) {
                        mapT.remove(s.charAt(i));
                    }

                }
                // 如果mapT为空说明完全符合了
                if (mapT.isEmpty()) {
                    // 符合则在相应的list里插入
                    res.get(mapList.indexOf(map)).add(s);
                    // flag值true找到了
                    flag = true;
                }
            }
            if (!flag) {
                Map<Character, Integer> mapTmp = new HashMap<>();
                for (int i = 0; i < s.length(); i++) {
                    mapTmp.put(s.charAt(i), mapTmp.getOrDefault(s.charAt(i), 0) + 1);
                }
                mapList.add(mapTmp);
                List<String> listTmp = new ArrayList<>();
                listTmp.add(s);
                res.add(listTmp);
            }
        }
        return res;
    }

    /**
     * 排序+hashmap
     */
    public List<List<String>> groupAnagrams2(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }
        return new ArrayList(map.values());
    }

    /**
     * 利用质数乘积+hashmap
     */
    public static List<List<String>> groupAnagrams3(String[] strs) {
        HashMap<Double,List<String>> resMap = new HashMap<>();
        // 生成26个质数（素数）并通过map和26个字母关联，字母做主键，质数做value
        HashMap<Character,Integer> map = new HashMap<>();
        //用于计算质数
        int num = 3;
        //用于计算26个英文字母
        int index = 1;
        map.put('a', 2 );
        while (index < 26) {
            // 标识是否质数
            boolean flag = true;
            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                map.put((char) ('a'+index),num);
                index++;
            }
            num += 2;
        }
        for (String s:strs) {
            char[] chars = s.toCharArray();
            Double key = 1d;
            for (char ch : chars){
                key *= map.get(ch);
            }
            if(!resMap.containsKey(key)){
                resMap.put(key,new ArrayList<>());
            }
            resMap.get(key).add(s);
        }
        return new ArrayList<>(resMap.values());
    }
}
