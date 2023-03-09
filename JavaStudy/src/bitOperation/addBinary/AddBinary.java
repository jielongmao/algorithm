package bitOperation.addBinary;

/**
 * @Description 二进制求和
 * @Author: tmj
 * @Data: 2022/12/30 12:24
 */
public class AddBinary {

    public static void main(String[] args) {
        int a = '1' - '0';
        char b = '0';
        int c = a + b;
        System.out.println((int) a);
        System.out.println(c);

    }

    public String addBinary(String a, String b) {
        int lena = a.length()-1;
        int lenb = b.length()-1;
        int carry = 0;
        String res = "";
        while (lena >= 0 && lenb >= 0) {
            int now = (a.charAt(lena) - '0') + (b.charAt(lenb) - '0') + carry;

            res = (now == 3 || now == 1 ? "1" : "0") + res;
            carry = now == 3 || now == 2 ? 1 : 0;
            lena--;
            lenb--;
        }
        while (lena < 0 && lenb >= 0) {
            int now = b.charAt(lenb) - '0' + carry;
            res = (now == 1 ? "1" : "0") + res;
            carry = now == 2 ? 1 : 0;
            lenb --;
        }

        while (lenb < 0 && lena >= 0) {
            int now = a.charAt(lena) - '0' + carry;
            res = (now == 1 ? "1" : "0") + res;
            carry = now == 2 ? 1 : 0;
            lena --;
        }

        return carry == 1?"1"+res:res;
    }
}

