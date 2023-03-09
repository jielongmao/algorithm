package unclassified;

import java.util.Stack;

/**
 * @author DIO的面包店
 * @since 2022/5/16 17:36
 */
public class rotate {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        int n = 3;
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j <n ;j++){
                System.out.println(matrix[i][j]);
            }
        }
    }
    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        //左右翻转图像
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j <n/2 ;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n-j-1];
                matrix[i][n-j-1] = tmp;
            }
        }

        //斜线翻转
        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j <n-i ;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][n-i-1];
            }
        }

    }

}
