package CS112.test.CS112_Summer_I.Iterator;

import java.util.Iterator;

/**
 * Created by davidzhou on 6/23/17.
 */
interface Menu {

    public void addItem(String name, String description,
                        boolean veg, double price);

    public Iterator createIterator();
}
