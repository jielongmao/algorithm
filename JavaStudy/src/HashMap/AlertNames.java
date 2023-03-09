package HashMap;

import java.util.*;

/**
 * @Description 警告一小时内使用相同员工卡大于等于三次的人
 * @Author: tmj
 * @Data: 2023/2/8 15:10
 */
public class AlertNames {

    public static void main(String[] args) {
        String[] keyName = {"daniel","daniel","daniel","luis","luis","luis","luis"};
        String[] keyTime = {"10:00","10:40","11:00","09:00","11:00","13:00","15:00"};
        alertNames(keyName,keyTime);
    }


    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        HashMap<String, List<Integer>> timeMap = new HashMap<>();
        // 当前步骤，将时间对于人名分配至map
        for (int i = 0; i < keyName.length; i++) {
            timeMap.putIfAbsent(keyName[i], new ArrayList<>());
            int time = Integer.parseInt(keyTime[i].substring(0, 2)) * 60 + Integer.parseInt(keyTime[i].substring(3));
            timeMap.get(keyName[i]).add(time);
        }
        List<String> res = new ArrayList();
        Set<String> keySet = timeMap.keySet();
        // 判断每个人的时间是否存在一个小时打卡超过三次的情况
        for(String key: keySet){
            List<Integer> list = timeMap.get(key);
            Collections.sort(list);
            int size = list.size();
            // 一共打卡都没三次的直接跳过
            if (size < 3){
                continue;
            }
            // 判断有没有一个小时内三次打卡时间
            for (int i = 2; i < size ; i ++){
                if (list.get(i) - list.get(i-2) <= 60 ){
                   res.add(key);
                   break;
                }
            }
        }
        Collections.sort(res);
        return res;
    }

}
