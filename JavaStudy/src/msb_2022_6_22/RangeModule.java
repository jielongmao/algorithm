package msb_2022_6_22;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
//715. Range 模块
public class RangeModule {


    TreeMap<Integer,Integer> map;
    public static void main(String[] args) {

    }

    public RangeModule() {
        map = new TreeMap<>();
    }

    public void addRange(int left, int right) {
        if(left>=right){
            return;
        }
        Integer start = map.floorKey(left);
        Integer end = map.floorKey(right);
        if(start==null && end == null){
            map.put(left,right);
        }else if(start != null && map.get(start)>=left){
            map.put(start,Math.max(right,map.get(end)));
        }else{
            map.put(left,Math.max(right,map.get(end)));
        }
        Map<Integer,Integer> subMap = map.subMap(left,false,right,true);
        Set<Integer> set = new HashSet<>(subMap.keySet());
        map.keySet().removeAll(set);
    }

    public boolean queryRange(int left, int right) {
        if(map.floorKey(left) != null && map.get(map.floorKey(left)) >= right){
            return true;
        }
        return false;
    }

    public void removeRange(int left, int right) {
        if(left>=right){
            return;
        }
        Integer start = map.floorKey(left);
        Integer end = map.floorKey(right);
        if(end!=null&&map.get(end)>right){
            map.put(right, map.get(end));
        }
        if (start!=null&&map.get(start)>left){
            map.put(start, left);
        }

        Map<Integer,Integer> subMap = map.subMap(left,true,right,false);
        Set<Integer> set = new HashSet<>(subMap.keySet());
        map.keySet().removeAll(set);
    }

}
