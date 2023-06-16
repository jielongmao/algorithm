import java.util.Scanner;

/**
 * @Description TODO
 * @Author: tmj
 * @Data: 2023/5/18 16:09
 */
public class Main5 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz1 = Class.forName("Filter");
        Class<?> clazz2 = Class.forName("UnicodeFilter");
        System.out.println(clazz1.isInterface()+" "+clazz1.isAssignableFrom(clazz2));
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        UnicodeFilter filter = new UnicodeFilter(input);
        System.out.println("原字符串是："+filter.getValue());
        filter.doFilter();
        System.out.println("字符串的Unicode码是："+filter.getValue());
    }
}

interface Filter {
    public void doFilter();
}

class UnicodeFilter implements Filter{

    String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public UnicodeFilter(String value) {
        this.value = value;
    }

    @Override
    public void doFilter(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<this.value.length();i++){
            char c = this.value.charAt(i);
            String str = Integer.toHexString( c);
            sb.append("\\u").append(str);
        }
        this.value = sb.toString();
    }
}


