package bitOperation;

/**
 * 位运算测试
 */
public class BitOperation {
    private static void print(int num){
        for(int i = 31 ; i>=0 ; i--){
            System.out.print((num & (1<<i))==0 ? "0": "1");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        print(Integer.MAX_VALUE);
        print(Integer.MIN_VALUE);

    }
}
