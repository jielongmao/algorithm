package arr.solveNQueens;

import java.util.*;

/**
 * @Description 解决n皇后问题
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 * @Author: tmj
 * @Data: 2023/5/5 9:43
 */
public class SolveNQueens {
    public static void main(String[] args) {
        char[][] arr = new char[3][3];
        System.out.println((int) arr[0][0]);
//        System.out.println();

        List<List<String>> lists = solveNQueens2(7);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println("[");
            for (int j = 0; j < lists.get(0).size(); j++) {
                System.out.println(lists.get(i).get(j) + ",");
            }
            System.out.println("]");
        }
    }

    /**
     * 解答1
     *
     * @param n
     * @return
     */
    public static List<List<String>> solveNQueens(int n) {
        char[][] ans = new char[n][n];
        List<List<String>> resList = new ArrayList<>();
        process(ans, 0, n, resList);
        return resList;
    }

    /**
     * 做递归调用
     *
     * @param ans
     * @param row
     * @param n
     * @param resList
     */
    private static void process(char[][] ans, int row, int n, List<List<String>> resList) {
        if (row == n) {
            List<String> ansList = format(ans);
            resList.add(ansList);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (ans[row][i] == 0) {
                ans[row][i] = 'Q';
                char[][] tmp = new char[n][n];
                for (int j = 0; j < n; j++) {
                    tmp[j] = ans[j].clone();
                }
                setPoint(tmp, row, i, n);
                process(tmp, row + 1, n, resList);
            }
        }
    }

    /**
     * 给相应位置置'.'
     *
     * @param ans
     * @param i
     * @param j
     * @param n
     */
    private static void setPoint(char[][] ans, int i, int j, int n) {
        for (int k = 0; k < n; k++) {
            if (k != j && ans[i][k] == 0) {
                ans[i][k] = '.';
            }
        }

        for (int k = 0; k < n; k++) {
            if (k != i && ans[k][j] == 0) {
                ans[k][j] = '.';
            }
        }
        int x = 1;
        while (i + x < n && j + x < n) {
            ans[i + x][j + x] = '.';
            x++;
        }
        // 左上右上没有设置必要，优化掉
//        x = 1;
//        while (i-x>=0&&j-x>=0){
//            ans[i-x][j-x] = '.';
//            x++;
//        }
//        x = 1;
//        while (i-x>=0&&j+x<n){
//            ans[i-x][j+x] = '.';
//            x++;
//        }
        x = 1;
        while (i + x < n && j - x >= 0) {
            ans[i + x][j - x] = '.';
            x++;
        }
    }

    /**
     * 格式化合法结果
     *
     * @param ans
     * @return
     */
    private static List<String> format(char[][] ans) {
        List<String> ansList = new ArrayList<>();
        for (int i = 0; i < ans.length; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int j = 0; j < ans.length; j++) {
                stringBuilder.append(ans[i][j]);
            }
            ansList.add(stringBuilder.toString());
        }
        return ansList;
    }

/*    -------------------------------------------------  */

    /**
     * 算法2
     * @param n
     * @return
     */
    public static List<List<String>> solveNQueens2(int n) {
        List<List<String>> solutions = new ArrayList<List<String>>();
        // 存储每行皇后位置
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        // 出现过的列
        Set<Integer> columns = new HashSet<Integer>();
        // 横纵坐标的差值 判断是否在左上到右下
        Set<Integer> diagonals1 = new HashSet<Integer>();
        // 横纵坐标之和 判断是否在右上到左下
        Set<Integer> diagonals2 = new HashSet<Integer>();
        backtrack(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    /**
     * 回溯算法
     * @param solutions
     * @param queens
     * @param n
     * @param row
     * @param columns
     * @param diagonals1
     * @param diagonals2
     */
    public static void backtrack(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
        } else {
            for (int i = 0; i < n; i++) {
                // 合法性校验
                // 列校验
                if (columns.contains(i)) {
                    continue;
                }
                // 左上到右下斜线 横纵坐标差值相等 相减判断差值是否存在
                int diagonal1 = row - i;
                if (diagonals1.contains(diagonal1)) {
                    continue;
                }
                // 右上到左下斜线 横纵坐标和相等 相加判断和是否存在
                int diagonal2 = row + i;
                if (diagonals2.contains(diagonal2)) {
                    continue;
                }

                queens[row] = i;
                columns.add(i);
                diagonals1.add(diagonal1);
                diagonals2.add(diagonal2);
                backtrack(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
                // 进行回溯，进行其他可能尝试
                queens[row] = -1;
                columns.remove(i);
                diagonals1.remove(diagonal1);
                diagonals2.remove(diagonal2);
            }
        }
    }

    /**
     * 初始化棋盘
     * @param queens
     * @param n
     * @return
     */
    public static List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

}
