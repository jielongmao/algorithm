package arr.spiralOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description TODO
 * @Author: tmj
 * @Data: 2023/6/16 16:52
 */
public class SpiralOrder {
    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder(matrix);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        int len = matrix.length;
        int up = 0;
        int left = 0;
        int down = len-1;
        int right = matrix[0].length -1;

        int row = 0;
        int col = 0;
        List<Integer> ans = new ArrayList<>();
        ans.add(matrix[0][0]);
        System.out.println(matrix[0][0]);
        String turn = "right";
        for (int i = 1; i < len*matrix[0].length; ) {
            if("right".equals(turn)){
                while (col<right){
                    col++;
                    System.out.println(matrix[row][col]);
                    ans.add(matrix[row][col]);
                    i++;
                }
                up++;
                turn = "down";
            }else if("down".equals(turn)){
                while (row < down){
                    row++;
                    System.out.println(matrix[row][col]);
                    ans.add(matrix[row][col]);
                    i++;
                }
                right--;
                turn = "left";
            }else if("left".equals(turn)){
                while (col > left){
                    col--;
                    System.out.println(matrix[row][col]);
                    ans.add(matrix[row][col]);
                    i++;
                }
                down--;
                turn = "up";
            }else if("up".equals(turn)){
                while (row > up){
                    row --;
                    System.out.println(matrix[row][col]);
                    ans.add(matrix[row][col]);
                    i++;
                }
                left++;
                turn = "right";
            }

        }
        return ans;
    }

}
