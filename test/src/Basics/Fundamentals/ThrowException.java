package Basics.Fundamentals;

/**
 * Created by davidzhou on 4/6/17.
 * http://beginnersbook.com/2013/04/java-exception-handling/
 */
public class ThrowException {

    private int data;
    public ThrowException(int data) {
        this.data = data;
    }

    //If a method throw exceptions, either handle them inside the method or "throws" them in the definition
    public int testing() throws IllegalAccessException, ClassNotFoundException{
        if (data < 0) {
            throw new IllegalAccessException();
        } else if (data > 0) {
            throw new ClassNotFoundException();
        } else {
            return data;
        }
    }

    //No need to handel runtime exception in java.
    public int testing2() {
        if (data == 0) throw new RuntimeException();
        else return data;
    }


    //Try-catch blocks
    public static void main (String[] args) {
        ThrowException t1 = new ThrowException(1);
        try {
            t1.testing();

        } catch (IllegalAccessException e1) {
            System.out.println(e1);
        } catch (ClassNotFoundException e2) {
            System.out.println(e2);
        } finally {
            System.out.println("Finished!" );
        }
    }

}
