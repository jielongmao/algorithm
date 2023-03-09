import java.sql.SQLOutput;

/**
 * @Description TODO
 * @Author: tmj
 * @Data: 2023/2/28 21:28
 */
public class Test_2023_2_28 {

    public static void main(String[] args) {
        Integer i = Integer.parseInt("12312");
//        Double.parseDouble();
        String s = i.toString();


        Integer.parseInt("12312");



    }



}

abstract class F{

    public abstract void b();
    void a(){
        System.out.println(2);
    }
}

class S extends F{

    @Override
    public void b() {

    }

    void a(){
        System.out.println(1);
    }
}
