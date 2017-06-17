package CS112.test.testy;
import java.util.*;
/**
 * Created by davidzhou on 5/5/17.
 */
public class Animal {

    public static final double FAVNUMBER = 1.222;

    private String name;
    private int weight;
    private boolean hasOwner = false;
    private byte age;
    private long uniqueID;
    private char favoriteChar;
    private double speed;
    private float height;

    protected static int numberOfAnimals = 0;

    static Scanner userInput = new Scanner(System.in);

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public boolean isHasOwner() {
        return hasOwner;
    }

    public byte getAge() {
        return age;
    }

    public long getUniqueID() {
        return uniqueID;
    }

    public char getFavoriteChar() {
        return favoriteChar;
    }

    public double getSpeed() {
        return speed;
    }

    public float getHeight() {
        return height;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setHasOwner(boolean hasOwner) {
        this.hasOwner = hasOwner;
    }

    public void setAge(byte age) {
        this.age = age;
    }

    public void setUniqueID(long uniqueID) {
        this.uniqueID = uniqueID;
    }

    public void setFavoriteChar(char favoriteChar) {
        this.favoriteChar = favoriteChar;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public Animal() {
        numberOfAnimals++;

        System.out.println("Enter the name: ");

        if (userInput.hasNextLine()) {
            this.setName(userInput.nextLine());

        }
    }

    public void setUniqueID() {
        long minNumber = 1;
        long maxNumber = 1000000;

        uniqueID = minNumber + (long) (Math.random() * (maxNumber - minNumber));
        String stringNumber = Long.toString(maxNumber);
        int number = Integer.parseInt(stringNumber);

    }

    public String makeSound() {
        return "Grrr";
    }

    public static void speakAnimal(Animal randAnimal) {
        System.out.println("Animal says: " + randAnimal.makeSound());
    }


    public static void main(String[] args) {

        Animal theAnimal = new Animal();
        System.out.println(theAnimal.getName());

    }
}
