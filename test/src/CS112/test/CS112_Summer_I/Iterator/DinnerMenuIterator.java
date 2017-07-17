package CS112.test.CS112_Summer_I.Iterator;

import java.util.Iterator;

/**
 * Created by davidzhou on 6/23/17.
 */
public class DinnerMenuIterator implements Iterator{
    private MenuItem[] items;
    int counter;


    public DinnerMenuIterator(MenuItem[] items) {
        this.items = items;
        counter = 0;
    }

    public Object next() {
        MenuItem item = items[counter++];
        return item;
    }

    public boolean hasNext() {
        return counter < items.length;
    }
}
