package unclassified;

import javax.naming.InsufficientResourcesException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author DIO的面包店
 * @since 2022/6/9 13:15
 */
public class Y1 {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        if( n < 1){
            return null;
        }
        if(n==1){
            return "1";
        }
        String str= countAndSay(n-1);

        int start = 0;
        int post = 0;
        StringBuilder result = new StringBuilder();
        while(post<str.length()){
            while(post<str.length()&&str.charAt(post)==str.charAt(start)){
                post++;
            }
            result.append(post-start).append(str.charAt(start));
            start = post;
        }
        return result.toString();
    }

}
