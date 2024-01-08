package dynamicProgramming;

/**
 * @Description 最小路径问题
 * @Author: tmj
 * @Data: 2023/9/7 0:06
 */
public class MinPathSum {
    public int minPathSum(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        // 思路，这题可以用经典的动态规划的方式来做
        // 1.设置一个二维数组存储到达每个点的路径和
        // 默认值设置为该点大小
        int[][] minPathSum = grid;
        // 然后我们只能从上面的点和左边的点来到当前位置
        // 两层循环计算到每个点的和
        // 行
        for (int row = 0; row < rowLen; row++) {
            // 列
            for (int col = 0; col < colLen; col++) {
                if (row != 0 && col != 0) {
                    grid[row][col] = Math.min(grid[row - 1][col], grid[row][col - 1]) + grid[row][col];
                } else if (row == 0 && col != 0) {
                    grid[row][col] = grid[row][col - 1] + grid[row][col];
                } else if (row != 0 && col == 0) {
                    grid[row][col] = grid[row - 1][col] + grid[row][col];
                }
            }
        }
        return grid[rowLen - 1][colLen - 1];
    }
}
