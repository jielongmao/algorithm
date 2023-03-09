package zeroSet;

/**
 * @Description 二维数组中与0相同的行或列设置为0
 * @Author: tmj
 * @Data: 2022/9/30 9:27
 */
public class SetZeroes {

    public static void main(String[] args) {
//          [0,1,2,0],
//          [3,4,5,2],
//          [1,3,1,5]
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static void setZeroes(int[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] record = new boolean[m+n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 0){
                    record[i] = true;
                    record[m+j] = true;
                }
            }
        }

        for (int i = 0; i < m+n; i++) {
            if(record[i]){
                if(i<m){
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = 0;
                    }
                }else {
                    for (int j = 0; j < m; j++) {
                        matrix[j][i-m] = 0;
                    }
                }
            }
        }
    }

}
