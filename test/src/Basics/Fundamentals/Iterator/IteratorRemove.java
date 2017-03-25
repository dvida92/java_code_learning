package Basics.Fundamentals.Iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 如何正确使用iterator的remove方法在遍历过程中移除某些元素。
 * Created by davidzhou on 3/25/17.
 */
public class IteratorRemove {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("ate");
        stringList.add("an");
        stringList.add("apple!");

        System.out.println(Arrays.toString(stringList.toArray()));

        Iterator<String> iter = stringList.iterator();
        while (iter.hasNext()) {
            String word = iter.next();
            if (word.startsWith("a")) iter.remove();
        }

        System.out.println(Arrays.toString(stringList.toArray()));


    }
}
