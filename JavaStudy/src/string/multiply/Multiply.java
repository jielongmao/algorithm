package string.multiply;


/**
 * @Description 字符串相乘
 * @Author: tmj
 * @Data: 2023/4/28 16:29
 */
public class Multiply {
    public static void main(String[] args) {
        System.out.println(multiply("987654321", "529694991"));
    }

    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        // 最多就进是和两个乘数位数相加一样长
        int[] ansArr = new int[m + n];
        for (int i = m - 1; i >= 0; i--) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int y = num2.charAt(j) - '0';
                ansArr[i + j + 1] += x * y;
            }
        }
        // 以此计算进位，多的直接一股脑给更高位
        for (int i = m + n - 1; i > 0; i--) {
            ansArr[i - 1] += ansArr[i] / 10;
            ansArr[i] %= 10;
        }
        //判断是m+n位还是m+n-1位，决定拼不拼第一位
        int index = ansArr[0] == 0 ? 1 : 0;
        StringBuffer ans = new StringBuffer();
        while (index < m + n) {
            ans.append(ansArr[index]);
            index++;
        }
        return ans.toString();
    }

}
