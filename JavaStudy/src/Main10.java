/**
 * @Description TODO
 * @Author: tmj
 * @Data: 2023/6/3 9:34
 */

import java.util.Scanner;

/**
 * 你的答案
 */
public class Main10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNext()) {
            String oneLineString = scanner.nextLine(); // 读取一行
            if (oneLineString.equals("XXX"))
                break;
            String[] fields = oneLineString.split(" "); // 以空格为风格，取得所有数据

            Accumulator accumulator = new Accumulator(fields[0]);

            for (int i = 1; i < fields.length; i++) {
                accumulator.add(Double.parseDouble(fields[i]));
            }

            System.out.println(accumulator.toString());
            System.out.printf("Sum:%.2f\n", accumulator.getSum());

        }
        scanner.close();

        System.out.printf("System has %d accumulators.", Accumulator.accumulatorCount);

    }
}

class Accumulator {
    static int accumulatorCount = 0;

    String name;

    double sum;

    public Accumulator(String name) {
        this.name = name;
    }

    void add(double data) {
        if (data > 10) {
            this.sum += data;
            accumulatorCount++;
        }
    }

    double getSum() {
        return this.sum;
    }


    public String toString(){
        return String.format("%s has %d items, sum:%.2f",this.name , accumulatorCount,this.sum);
    }


}
