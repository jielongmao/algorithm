//import javax.naming.Name;
//import java.lang.reflect.Modifier;
//import java.util.Scanner;
//
///**
// * @Description TODO
// * @Author: tmj
// * @Data: 2023/5/17 16:44
// */
//public class Main2 {
//    public static void main(String[] args) throws ClassNotFoundException {
//        Class<?> clazz = Class.forName("Converter");
//        Class<?> clazz2 = Class.forName("LengthConverter");
//        boolean isAbs = Modifier.isAbstract(clazz.getModifiers());
//        System.out.println(clazz.isAssignableFrom(clazz2)+" "+Modifier.isAbstract(clazz.getModifiers()));
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("请输入换算器名称（比如：米/厘米）、原长度和换算系数，中间用空格分开");
//        String name = scanner.next();
//        double original = scanner.nextDouble();
//        double scalingFactor = scanner.nextDouble();
//        LengthConverter converter = new LengthConverter(name,original,scalingFactor);
//        converter.convert();
//        String[] units = name.split("-");
//        System.out.println(converter.getName()+ "换算." + converter.getOriginal() + units[0] + "=" + converter.getResults());
//    }
//
//}
//
//abstract class Converter{
//    String name;
//
//    public String getName() {
//        return name;
//    }
//
//    public Converter(String name){
//        this.name = name;
//    }
//
//    abstract void convert();
//
//}
//class LengthConverter extends Converter{
//    double original;
//    double results;
//    double scalingFactor;
//
//    public double getOriginal() {
//        return original;
//    }
//
//    public double getResults() {
//        return results;
//    }
//
//    public LengthConverter(String name, double original,double scalingFactor){
//        super(name);
//        this.name = name;
//        this.original = original;
//        this.scalingFactor = scalingFactor;
//    }
//
//    @Override
//    public void convert(){
//        this.results = this.original * this.scalingFactor;
//    }
//}
