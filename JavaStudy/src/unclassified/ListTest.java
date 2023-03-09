package unclassified;

import javax.swing.text.html.HTMLDocument;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.*;

/**
 * @author DIO的面包店
 * 集合类学习
 */
public class ListTest{
//    List<String> list = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Vector vector = new Vector();
        Set<Integer> set = new HashSet<>();
        set.stream().toArray();
        Stack stack = new Stack();
        stack.add(1);
        stack.add(2);
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        Hashtable hashtable = new Hashtable();
//        InputStream inputStream = new FileInputStream("");

        Iterator<Integer> iterator = list.listIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
