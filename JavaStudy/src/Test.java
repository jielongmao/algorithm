import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;

public class Test {
    public static void stringReplace(String text) {
        text = text + "c";
    }

    public static void bufferReplace(StringBuffer text) {
        text = text.append("c");
    }

    public static void main(String args[]) {
        String textString = new String("ab");
        StringBuffer textBuffer = new StringBuffer("ab");
        stringReplace(textString);
        bufferReplace(textBuffer);
        System.out.println(textString + textBuffer);
        Vector<Integer> v = new Vector<>();
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        Iterator iterator= set.iterator();
        System.out.println("+++++++++++++++++++++");
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
