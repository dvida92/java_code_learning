package CS112.Examples;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by davidzhou on 4/9/17.
 */
public class UsingStringBuilder {

    public static void main(String[] args) {
        LinkedList<StringBuilder> s1 = new LinkedList<>();
        s1.add(new StringBuilder("apple"));
        s1.add(new StringBuilder("banana"));

        //Convert and Print
        String[] s1Array = new String[s1.size()];
        int counter = 0;
        for (StringBuilder s: s1
                ) {
            s1Array[counter++] = s.toString();
        }
        for (int i = 0; i < s1Array.length; i++) {
            System.out.println(s1Array[i]);
        }


        Iterator<StringBuilder> iter = s1.iterator();
        while (iter.hasNext()) {
            iter.next().insert(0, ' ');
        }

        String[] s2Array = new String[s1.size()];
        int counter2 = 0;
        for (StringBuilder s: s1
                ) {
            s2Array[counter2++] = s.toString();
        }
        for (int i = 0; i < s2Array.length; i++) {
            System.out.println(s2Array[i]);
        }





    }
}
