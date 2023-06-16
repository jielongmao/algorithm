import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * @Description TODO
 * @Author: tmj
 * @Data: 2023/5/17 15:45
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float length = scanner.nextFloat();
        float width = scanner.nextFloat();
        Rectangle rectangle = new Rectangle(width,length);
        System.out.print("Output:");
        System.out.print(rectangle.getArea()+" "+rectangle.getPerimeter());
    }
}

class Rectangle{
    private float length;
    private float width;

    public Rectangle() {
    }

    public Rectangle(float length, float width) {
        this.length = length;
        this.width = width;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    float getArea(){
        return this.length*this.width;
    }

    float getPerimeter(){
        return (this.length+ this.width) *2;
    }
}





class Square{
    float side;

    public Square() {
        this.side = 10;
    }

    public Square(float side) {
        this.side = side;
    }

    public float getSide() {
        return side;
    }

    public void setSide(float side) {
        this.side = side;
    }

    float getArea(){
        return this.side*this.side;
    }

    float getPerimeter(){
        return this.side*4;
    }
}
