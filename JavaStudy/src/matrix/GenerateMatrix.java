package matrix;

/**
 * @author DIO的面包店
 */
public class GenerateMatrix {

    public static void main(String[] args) {
        int n = 3;
//        int[][] ans = generateMatrix(n);
        int[][] ans = generateMatrix1(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] ansMatrix = new int[n][n];
        int left = 0;
        int right = n-1;
        int top = 0;
        int bottom = n-1;
        int num = 0;
        while (left <= right && top <= bottom && num < n*n ){
            if(left == right){
                ansMatrix[top][left] = ++num;
                break;
            }
            for(int i = left ; i < right ; i ++){
                ansMatrix[top][i] = ++num;
            }
            for (int j = top; j < bottom; j++) {
                ansMatrix[j][right] = ++num;
            }
            for(int k = right; k > left; k--){
                ansMatrix[bottom][k] = ++ num;
            }
            for (int h = bottom; h > top; h--) {
                ansMatrix[h][left] = ++num;
            }
            left ++;
            right --;
            top ++;
            bottom --;

        }
        return ansMatrix;
    }

    public static int[][] generateMatrix1(int n) {
        int[][] ansMatrix = new int[n][n];
        int start = 0;
        int end = n-1;
        int num = 0;
        while (start <= end && num < n*n ){
            if(start == end){
                ansMatrix[start][start] = ++num;
                break;
            }
            for(int i = start ; i < end ; i ++){
                ansMatrix[start][i] = ++num;
            }
            for (int j = start; j < end; j++) {
                ansMatrix[j][end] = ++num;
            }
            for(int k = end; k > start; k--){
                ansMatrix[end][k] = ++ num;
            }
            for (int h = end; h > start; h--) {
                ansMatrix[h][start] = ++num;
            }
            start ++;
            end --;
        }
        return ansMatrix;
    }
}
