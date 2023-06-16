import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author: tmj
 * @Data: 2023/5/18 15:54
 */
public class Mian4 {
    public static void main(String[] args) throws ClassNotFoundException {
        //验证两个类的定义是否符合要求
        //**如果你的这两个类是定义在特定包下的，在下面的类名前加上包路径**
        Class<?> clazz = Class.forName("Converter");
        Class<?> clazz2 = Class.forName("CurrencyConverter");
        boolean isAbs = Modifier.isAbstract(clazz.getModifiers()) ;
        System.out.println(clazz.isAssignableFrom(clazz2)+" "+Modifier.isAbstract(clazz.getModifiers()));
        //输入开始
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入换算器名称、本币金额和汇率，中间用空格分开：");
        String name = scanner.next();
        double localCurrency = scanner.nextDouble();
        double exchangeRate = scanner.nextDouble();
        CurrencyConverter converter = new CurrencyConverter(name,localCurrency,exchangeRate);
        converter.convert();
        System.out.println(converter.getName()+"：本币："+converter.getLocalCurrency()+"，汇率："+converter.getExchangeRate()+"，外币："+converter.getForeignCurrency());
        converter.setExchangeRate(0.7);
        converter.convert();
        System.out.println(converter.getName()+"：本币："+converter.getLocalCurrency()+"，汇率："+converter.getExchangeRate()+"，外币："+converter.getForeignCurrency());
    }
}

abstract class Converter{
    String name;

    public String getName() {
        return name;
    }

    abstract void convert();
}

class CurrencyConverter extends Converter{

    double localCurrency;
    double foreignCurrency;
    double exchangeRate;

    public double getLocalCurrency() {
        return localCurrency;
    }

    public double getForeignCurrency() {
        return foreignCurrency;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public CurrencyConverter(String name, double localCurrency, double exchangeRate) {
        this.name = name;
        this.localCurrency = localCurrency;
        this.exchangeRate = exchangeRate;
    }

    @Override
    void convert() {
        this.foreignCurrency = this.localCurrency* this.exchangeRate;
    }
}
