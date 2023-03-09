package unclassified;

import java.util.Scanner;

/**
 * @author DIO的面包店
 * @since 2022/3/3 13:48
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double input = scanner.nextDouble();
        double ans = (input-32)*5/9.0;
        System.out.printf("%.1f%n",ans);
    }


}
