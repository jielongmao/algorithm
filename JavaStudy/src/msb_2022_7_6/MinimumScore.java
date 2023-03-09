package msb_2022_7_6;

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MinimumScore {

    public static void main(String[] args) {
        // 数组存储节点
        int[] nums= {};
        // 二位数组存储连线（无向）
        int[][] edges = {};
        int ans = minimumScore(nums,edges);
        System.out.println(ans);
    }

    public static int minimumScore(int[] nums, int[][] edges) {
        // 数组长度
        int n = nums.length;
        // 建立无向图
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        // 构建dfn[]记录新序号、xor[]以该坐标为头的情况下异或的结果、size[]树的大小
        int[] dfn = new int[n];
        int[] xor = new int[n];
        int[] size = new int[n];
        dfs(nums , graph,0,dfn,xor,size);

        // 两层for循环判断所有断连线情况
        int ans = Integer.MAX_VALUE;
        int m = edges.length;
        int cut1,cut2,pre,post,part1,part2,part3,max,min;
        for (int i = 0; i < m; i++) {
            cut1 = dfn[edges[i][0]]>dfn[edges[i][1]] ? edges[i][0]:edges[i][1] ;
            for (int j = i+1; j < m; j++) {
                // 处理每种断法(计算的注意的核心点是切割)
                cut2 = dfn[edges[j][0]]>dfn[edges[j][1]]?edges[j][0]:edges[j][1];
                pre = dfn[cut1]>dfn[cut2]?cut2:cut1;
                post = pre==cut1?cut2:cut1;
                part1 = xor[post];
                if(dfn[post] < dfn[pre]+size[pre]){
                    part2 = xor[pre] ^ xor[post];
                    part3 = xor[0] ^ xor[pre];
                }else {
                    part2 = xor[pre];
                    part3 = xor[0] ^ part1 ^part2;
                }

                // 处理得到这个断法的结果
                max = Math.max(Math.max(part1,part2),part3);
                min = Math.min(Math.min(part1,part2),part3);
                ans = Math.min(max-min,ans);
            }
        }
        return ans;
    }

    static int cut = 1;
    // 用于对dfn,xor,size三个预处理的数组的处理
    public static void dfs(int[] nums, List<List<Integer>> graph,int cur,int[] dfn,int[] xor,int[] size){
        dfn[cur] = cut++;
        xor[cur] = nums[cur];
        size[cur] = 1;
        for (int next : graph.get(cur)){
            if(dfn[next] == 0){
                dfs(nums,graph,next,dfn,xor,size);
                xor[cur] ^= xor[next];
                size[cur] += size[next];
            }
        }

    }
}
