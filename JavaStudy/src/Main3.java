//import java.util.Scanner;
//
///**
// * @Description TODO
// * @Author: tmj
// * @Data: 2023/5/17 17:11
// */
//public class Main3 {
//    public static void main(String[] args) throws ClassNotFoundException {
//        Class<?> clazz1 = Class.forName("Filter");
//        Class<?> clazz2 = Class.forName("LowerCaseFilter");
//        System.out.println(clazz1.isInterface()+" "+clazz1.isAssignableFrom(clazz2));
//        Scanner scanner = new Scanner(System.in);
//        String input = scanner.nextLine();
//        LowerCaseFilter filter = new LowerCaseFilter(input);
//        System.out.println("原文是" + filter.getValue());
//        filter.doFilter();
//        System.out.println("过滤处理后"+ filter.getValue());
//    }
//}
//
//interface Filter {
//    public void doFilter();
//}
//
//class LowerCaseFilter implements Filter{
//
//    String value;
//
//    public String getValue() {
//        return value;
//    }
//
//    public void setValue(String value) {
//        this.value = value;
//    }
//
//    public LowerCaseFilter(String value) {
//        this.value = value;
//    }
//
//    @Override
//    public void doFilter(){
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0;i<this.value.length();i++){
//            if (this.value.charAt(i)<='z' && this.value.charAt(i) >='a' ){
//                sb.append((char) (this.value.charAt(i)-32));
//            }else {
//                sb.append(this.value.charAt(i));
//            }
//        }
//        this.value = sb.toString();
//    }
//}
