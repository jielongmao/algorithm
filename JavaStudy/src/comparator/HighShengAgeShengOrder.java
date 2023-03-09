package comparator;

import java.util.Comparator;

public class HighShengAgeShengOrder implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.high != o2.high ? (o1.high-o2.high):(o1.age-o2.age) ;
    }
}
