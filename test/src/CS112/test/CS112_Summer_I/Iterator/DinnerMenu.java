package CS112.test.CS112_Summer_I.Iterator;

import java.util.Iterator;

/**
 * Created by davidzhou on 6/23/17.
 */
public class DinnerMenu implements Menu {

    private static final int NUMBER_OF_ITEMS = 6;
    int counter = 0;
    private MenuItem[] dinnerItems;

    public DinnerMenu() {
        dinnerItems = new MenuItem[NUMBER_OF_ITEMS];
    }

    public void addItem(String name, String description,
                        boolean veg, double price) {
        MenuItem item = new MenuItem(name, description, veg, price);

        if (counter >= NUMBER_OF_ITEMS) {
            System.err.println("Error, array is full!");
        } else {
            dinnerItems[counter++] = item;
        }
    }

    public MenuItem[] getDinnerItems() {
        return dinnerItems;
    }

    public Iterator createIterator() {
        return new DinnerMenuIterator(dinnerItems);
    }

    public static void main(String[] args) {
        DinnerMenu dinnerMenu = new DinnerMenu();
        dinnerMenu.addItem("Turkey Dinner", "Big", false, 15);
        Iterator iterator = dinnerMenu.createIterator();
        while (iterator.hasNext()) {
            MenuItem menuItem = (MenuItem) iterator.next();
            System.out.println(menuItem.getDescription());
        }
    }
}
