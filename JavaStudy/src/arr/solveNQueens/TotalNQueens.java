package arr.solveNQueens;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 *
 * 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。
 * @Author: tmj
 * @Data: 2023/6/5 9:56
 */
public class TotalNQueens {
    public static void main(String[] args) {
        int i = totalNQueens(4);
        System.out.println(i);
    }

    // 最终方法数
    static int total = 0;

    public static int totalNQueens(int n) {

        // 行数
        int row = 0;
        // 列数
        Set<Integer> colums = new HashSet<>();
        // 左上到右下 斜线 row+i
        Set<Integer> diagonals1 = new HashSet<>();
        // 左下到右上 斜线 row-i
        Set<Integer> diagonals2 = new HashSet<>();
        backtrack(n ,row ,colums ,diagonals1 ,diagonals2);
        return total;
    }

    private static void backtrack(int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if(row == n){
            total += 1;
        }else {
            for (int i = 0; i < n; i++) {
                // 列
                if(columns.contains(i)){
                    continue;
                }
                // 左上到右下 斜线 row+i
                if(diagonals1.contains(row+i)){
                    continue;
                }
                // 左下到右上 斜线 row-i
                if(diagonals2.contains(row-i)){
                    continue;
                }
                // 全部满足则可以存
                columns.add(i);
                diagonals1.add(row+i);
                diagonals2.add(row-i);
                backtrack(n,row+1,columns,diagonals1,diagonals2);
                columns.remove(i);
                diagonals1.remove(row+i);
                diagonals2.remove(row-i);
            }

        }
    }
}
