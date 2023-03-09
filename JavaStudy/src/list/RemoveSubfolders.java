package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description 1233. 删除子文件夹
 * @Author: tmj
 * @Data: 2023/2/8 13:56
 */
public class RemoveSubfolders {

    public List<String> removeSubfolders(String[] folder) {
        List<String> ans = new ArrayList<>();
        // 先排序
        Arrays.sort(folder);
        ans.add(folder[0]);
        for (int i = 1; i < folder.length; i++) {
            // 前一个的长度
            int pre = ans.get(ans.size() - 1).length();
            // 判断是不是子文件夹，如果不是子文件夹就加入答案列表
            // 子文件夹的条件：1.当前字符串长度大于前者，2.上一个字符串可以作为当前字符串前缀，3.满足前两个条件的同时，以上一个字符串作为前缀后下一位为'/'(避免/a /ab这种情况)
            if ( !(pre<folder[i].length() && ans.get(ans.size()-1).equals(folder[i].substring(0,pre)) && folder[i].charAt(pre) == '/') ){
                ans.add(folder[i]);
            }
        }
        return ans;
    }

}
