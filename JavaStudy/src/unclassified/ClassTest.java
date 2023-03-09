package unclassified;

/**
 * @author DIO的面包店
 * @since 2022/3/3 11:12
 */
public class ClassTest {
    final static Integer i = 0;//类变量
    final Integer n;//成员变量

    public ClassTest(Integer n) {
        this.n = n;
    }

    public static void main(String[] args) {
        System.out.println(ClassTest.i);
        System.out.println(new ClassTest(3).n);
    }
}
