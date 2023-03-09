package unclassified;

import java.util.Stack;

public class t2 {
    public static void main(String[] args) {
        int[] a ={346,698,360,151};
        int[] a1 = fun1(a);
        for (int i = 0; i < 3; i++) {
            System.out.println(a1[i]);
        }
//        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25};
//        int x = fun2(arr);
//        System.out.println(x);
//        int[]
    }

    static int[] fun1(int[] arr){

        Stack st = new Stack();
        if(arr.length<7){
            for (int i = 0; i < arr.length; i++) {
                st.add(arr[i]);
            }
            if(st.peek() == null){
                return new int[1];
            }
            st.pop();
            int[] ans = new int[arr.length-1];
            for (int i = 0; i <arr.length-1; i++) {
                ans[i] = (int)st.pop();
            }
            return ans;
        }else{
            for (int i = 0; i < 7; i++) {
                st.add(arr[i]);
            }
            if(st.peek() == null){
                return new int[1];
            }
            st.pop();
            int[] ans = new int[6];
            for (int i = 0; i <6; i++) {
                ans[i] = (int)st.pop();
            }
            return ans;
        }
    }

    static int fun2(int[] arr){
        int n = arr.length;
        if(arr==null){
            return 0;
        }
        if (n == 1) {
            return arr[0];
        }
        if(n >= 44){
            return arr[43];
        }
        int c = 2;
        while (n<(44/c)){
            c *= 2;
        }
        return arr[44/c-1];
    }

    static int[] fun3(int n){
        int[] ans = new int[11];
        for (int i = 0;i<11;i++){
            ans[10-i] = 53 + i*n;
        }
        return ans;
    }
}
