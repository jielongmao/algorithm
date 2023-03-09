package unclassified;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @author DIO的面包店
 * @since 2022/3/5 14:42
 */
public class IteratorTest {
    public static void main(String[] args) {
        Set<Man> set = new HashSet();
        set.add(new Man(2,"lili"));
        Man man1 = new Man(2,"lili");
        set.add(man1);
        Man man2 = man1;
        set.add(man2);
        Iterator iterator =set.iterator();
        while (iterator.hasNext()){
            Man man = (Man) iterator.next();
            System.out.println(man.getName()+"::"+man.getYear());
        }
    }
}

class Man extends Object{
    private Integer year;
    private String name;

    public Man(Integer year,String name){
        this.year = year;
        this.name = name;
    }

    public Integer getYear() {
        return year;
    }

    public String getName(){
        return name;
    }
}
