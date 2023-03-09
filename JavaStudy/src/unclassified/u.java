package unclassified;

import java.util.*;
public class u {
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);

        int[] a = {1,2,3,4,5};
        int[] b = {2,4,3,4,5};
        System.out.println(find(a,b));
        System.out.println("Hello World!");
    }

    static int find(int[] a,int[] b){
        int n = a.length;
        int m = b.length;
        int max = 0;
        int tmp = 0;
        for(int x= 0;x<n;x++){
            int i = x,j=0;
            while(i<n&&j<m){
                if(a[i]==b[j]){
                    tmp++;
                    i++;
                    j++;
                }else{
                    max = Math.max(tmp,max);
                    tmp=0;
                    j++;
                    continue;
                }
            }
        }
        return max;
    }
}
