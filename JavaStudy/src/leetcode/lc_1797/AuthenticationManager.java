package leetcode.lc_1797;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @Description 1797. 设计一个验证系统
 * @Author: jielongmao
 * @Data: 2023/2/9 14:04
 */
public class AuthenticationManager {

    // 生存时间
    private int timeToLive;

    private HashMap<String, Integer> map;

    // 使用两个列表分别储存所有记录的id和time
    private List<String> idList;
    private List<Integer> timeList;

    int index = 0;


    public AuthenticationManager(int timeToLive) {
        this.timeToLive = timeToLive;
        map = new HashMap<>();
        idList = new ArrayList<>();
        timeList = new ArrayList<>();
    }

    public void generate(String tokenId, int currentTime) {
        map.put(tokenId, currentTime + timeToLive);
        idList.add(tokenId);
        timeList.add(currentTime + timeToLive);
    }

    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId)) {
            if (map.get(tokenId) > currentTime) {
                map.put(tokenId, currentTime + timeToLive);
                idList.add(tokenId);
                timeList.add(currentTime + timeToLive);
            }
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        int i = index;
        for (; i < idList.size(); i++) {
            String id = idList.get(i);
            Integer time = timeList.get(i);
            // 没有过期的了就停止遍历
            if (time > currentTime) {
                break;
            }
            // 必须在当前这个time = map里面最后更新的过期时间才删除，因为timeList没有删除操作，
            // 存在多个更新过期时间的操作可能存在上一个更新的过期时间是在当前时间之前的，但map中存的最新一次过期时间大于当前时间此时就不进行删除
            if (map.get(id).equals(time)) {
                map.remove(id);
            }
        }
        index = i;
        return map.size();
    }


    public static void main(String[] args) {
//        ["AuthenticationManager","renew","generate","countUnexpiredTokens","generate","renew","renew","countUnexpiredTokens"]
//        [[5],["aaa",1],["aaa",2],[6],["bbb",7],["aaa",8],["bbb",10],[15]]
        AuthenticationManager authenticationManager = new AuthenticationManager(5);
        authenticationManager.renew("aaa", 1);
        authenticationManager.generate("aaa", 2);
        int count1 = authenticationManager.countUnexpiredTokens(6);
        authenticationManager.generate("bbb", 7);
        authenticationManager.renew("aaa", 8);
        authenticationManager.renew("bbb", 10);
        int count2 = authenticationManager.countUnexpiredTokens(15);
        System.out.println("count1:" + count1);
        System.out.println("count2:" + count2);
    }
}
