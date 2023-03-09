package unclassified;

import java.util.Scanner;


/**
 * @author DIO的面包店
 * @since 2022/3/3 13:23
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz1 = Class.forName("unclassified.Filter");
        Class<?> clazz2 = Class.forName("unclassified.UpperCaseFilter");
        System.out.println(clazz1.isInterface()+" "+clazz1.isAssignableFrom(clazz2));
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        UpperCaseFilter filter = new UpperCaseFilter(input);
        System.out.println("原文是："+filter.getValue());
        filter.doFilter();
        System.out.println("过滤处理后："+filter.getValue());
    }
}
interface Filter{
    public void doFilter();
}

class UpperCaseFilter implements Filter {
    String value;
    UpperCaseFilter(String value){
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void doFilter() {
        this.value = value.toLowerCase();
    }

}
