package CS112.test.CS112_Summer_I.Iterator;

/**
 * Created by davidzhou on 6/23/17.
 */
public class MenuItem {
    private String name;
    private String description;
    private boolean isVegetarian;
    private double price;

    public MenuItem(String name, String description,
                    boolean veg, double price) {
        this.name = name;
        this.description = description;
        this.isVegetarian = veg;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public double getPrice() {
        return price;
    }


}
