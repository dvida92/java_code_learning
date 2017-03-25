package Basics.Fundamentals.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * iterator提供了统一便捷的遍历元素的方法。
 * Created by davidzhou on 3/25/17.
 */
public class TestIterator {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("I");
        list.add("am");
        list.add("sad!");
        Iterator<String> iter = list.iterator();
        while (iter.hasNext()) {
            String str = iter.next();
            System.out.println(str);
        }
    }
}
