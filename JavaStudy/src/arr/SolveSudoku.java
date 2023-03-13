package arr;


/**
 * 编写一个程序，通过填充空格来解决数独问题。
 *
 * 数独的解法需 遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 解决数独问题
 * @Author: tmj
 * @Data: 2023/3/12 17:28
 */
public class SolveSudoku {

    // 初始化 行
    private boolean[][] line = new boolean[9][9];
    // 初始化 列
    private boolean[][] column = new boolean[9][9];
    // 初始化 单元块
    private boolean[][][] block = new boolean[3][3][9];
    // 校验符号
    private boolean valid = false;
    // 待填位置 即空格位
    private List<int[]> spaces = new ArrayList<>();

    /**
     * 初始化三个数组记录相应模块中对应数字是否出现过
     * 但有没有可能我先给每行设置成一个set保证数字不重复
     * @param board
     */
    public void solveSudoku(char[][] board) {
        // init 初始化
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if(board[i][j] == '.'){
                   spaces.add(new int[]{i , j});
                }else {
                    int digit = board[i][j] - '0' - 1;
                    line[i][digit] = column[j][digit] = block[i/3][j/3][digit] = true;
                }
            }
        }
        dfs(board , 0);
    }

    public void dfs(char[][] board , int pos){
        if(pos == spaces.size()){
            valid = true;
            return;
        }

        int[] space = spaces.get(pos);
        int i = space[0];
        int j = space[1];
        for(int digit = 0; digit <9 && !valid ; ++digit){
            if(!line[i][digit] && !column[j][digit] && !block[i/3][j/3][digit]){
                line[i][digit] = column[j][digit] = block[i/3][j/3][digit] = true;
                board[i][j] = (char)(digit + '0' + 1);
                dfs(board,pos+1);
                // 不成立则还原回去
                line[i][digit] = column[j][digit] = block[i/3][j/3][digit] = false;
            }
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
    }

}
