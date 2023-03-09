package string;

/**
 * @author DIO的面包店
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        int[] arr = new int[3];
        int x = arr.length;
        String s = " rtyui tyuio tyuio ii";
        int i = lengthOfLastWord(" rtyui tyuio tyuio ii ");
        System.out.println(i);

//        System.out.print("_");
//        System.out.print(s.charAt(0));
//        System.out.print("_");
    }

    public static int lengthOfLastWord(String s) {
        int n = s.length();
        int j;
        for (j = n-1 ; j >=0 ; j--){
            if(s.charAt(j) != ' '){
                break;
            }
        }
        System.out.println(j);
        int i;
        for (i = j-1 ; i >=0 ; i--) {
            if(s.charAt(i) == ' '){
                break;
            }
        }
        System.out.println(i);
        return j-i;
    }

    public static int[] plusOne(int[] digits) {
        int n = digits.length;
        for (int i = n-1; i >= 0 ; i--) {
            if(digits[i] != 9 ){
                for (int j = i+1; j < n; j++) {
                    digits[j] = 0;
                }
                digits[i] += 1;
                return digits;
            }
        }
        int[] ans = new int[n + 1];
        ans[0] = 1;
        return ans;
    }
}
