import javax.lang.model.element.VariableElement;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author: tmj
 * @Data: 2022/12/11 9:07
 */
public class Main {

    public static void main(String[] args) {
//        Scanner p = new Scanner(System.in);
//        String str = p.next();
//        String s = str.trim();
//        System.out.println(s.charAt(2));

        Fish fish = new Fish(2,14);
        int totolPrice = fish.getTotolPrice();
        System.out.println(totolPrice);

    }

}

abstract class Animal{
    private int weight;
    private int price;

    public int getWeight() {
        return weight;
    }

    public int getPrice() {
        return price;
    }

    public Animal(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }

    public abstract int getTotolPrice();
}

class Fish extends Animal{

    public Fish(int weight, int price) {
        super(weight, price);
    }

    @Override
    public int getTotolPrice() {
        int total = getWeight() * getPrice();
        return total <= 0? 0: total;
    }
}

class Control{
    // 温度
    private float temperature;
    // 压力
    private float pressure;
    // 警报状态
    private boolean alram;
    // 统计对象数量
    private static int quantity;


    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        if(pressure <=0){
            pressure = 0;
        }
        this.pressure = pressure;
    }

    public Control(float temperature, float pressure) {
        this.temperature = temperature;
        this.pressure = pressure;
        quantity ++;
    }

    public void alarm(boolean alram){
        this.alram = alram;
    }

    public boolean isAlram() {
        return alram;
    }

    public String toString(){
        return "{temperature:"+this.temperature
                +";pressure:"+this.pressure
                +";alram:"+this.alram
                +";quantity:"+quantity+"}";
    }
}
