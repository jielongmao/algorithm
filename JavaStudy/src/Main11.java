import java.util.Scanner;

/**
 * @Description TODO
 * @Author: tmj
 * @Data: 2023/6/3 9:56
 */
public class Main11 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value = scanner.nextInt();
        if(value>100 || value < 0){
            System.out.println("invalid number");
        }else if(value>=60 || value<70){
            System.out.println("D");
        }else if(value>=70 || value<80){
            System.out.println("C");
        }else if(value>=80 || value<90){
            System.out.println("B");
        }else if(value>=90 ){
            System.out.println("A");
        }
    }

}
