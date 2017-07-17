package CS112.test.CS112_Summer_I.Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by davidzhou on 6/23/17.
 */
public class BreakfastMenu implements Menu{

    private List menuItems;

    public BreakfastMenu() {
        menuItems = new ArrayList();
    }


    public void addItem(String name, String description,
                        boolean veg, double price) {

        MenuItem item = new MenuItem(name, description, veg, price);
        menuItems.add(item);
    }

    public List getMenuItems() {
        return menuItems;
    }


    public Iterator createIterator() {
        return menuItems.iterator();
    }

    public static void main(String[] args) {
        BreakfastMenu breakfastMenu = new BreakfastMenu();
        breakfastMenu.addItem("burger", "small", false, 8.5);

        Iterator iterator = breakfastMenu.createIterator();
        while (iterator.hasNext()) {
            MenuItem item = (MenuItem)iterator.next();
            System.out.println(item.getDescription());
            System.out.println(item.getName());
            System.out.println(item.getPrice());
        }
    }
}
