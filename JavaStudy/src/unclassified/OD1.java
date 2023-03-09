package unclassified;

import java.util.Scanner;

/**
 * @author DIO的面包店
 * @since 2022/5/25 11:10
 */
public class OD1 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.nextLine();
        String tmp = in.next();
        String[] arr = s.split("[ |,|'|.]");
        StringBuilder res = new StringBuilder("");
        int tmpLen = tmp.length();
        int one = 0;
        for (int i = 0;i<arr.length;i++){

            if(arr[i].length()>=tmpLen && tmp.equals(arr[i].substring(0,tmpLen))){
                if(one!=0){
                    res.append(" ");

                }
                res.append(arr[i]);
                one ++;
            }
        }

        if ("".equals(res.toString())){
            System.out.println(tmp);
            return;
        }
        System.out.println(res);
    }
}
