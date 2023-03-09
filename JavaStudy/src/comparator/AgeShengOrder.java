package comparator;

import java.util.Comparator;

public class AgeShengOrder implements Comparator<Student> {


    // 需要交换时为-1
    // 不需要为0或1
    @Override
    public int compare(Student o1, Student o2) {
        return o1.age - o2.age;
    }
}
