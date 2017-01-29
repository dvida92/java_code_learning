package Basics;

/**
 * Analysis of RAM PART I
 * Video: https://www.youtube.com/watch?v=WIIVa2JWCuo&list=PLEdG6ih2rJtG5xRuKpzgRnqfZPR6EDbGu&index=41
 */
class BirthDate {
    public int day;
    public int month;
    public int year;
    BirthDate(int d, int m, int y) {
        day = d; month = m; year = y;
    }

    public void setDay(int d) {
        day = d;
    }

}

public class Test4 {

    public static void main(String[] args) {
        Test4 test = new Test4(); // Test4 is a reference type, test is in stack seg and it points to an area in heap seg.
        int date = 9; //date is a basic type(int), date is in stack seg.
        BirthDate d1 = new BirthDate(7, 7, 1970); //d1 and d2 is in stack seg and
        BirthDate d2 = new BirthDate(1, 1, 2000); //it points to an area in heap seg.
        test.change1(date); //Create i in stack seg and i = date = 9. When finish this method i is removed from stack seg.


        /**
         * Reference type as parameter
         */
        test.change2(d1);
        test.change3(d2);

        System.out.println(d1.day + "," + d1.month + ", " + d1.year);
        System.out.println(d2.day + "," + d2.month + ", " + d2.year);

    }

    public void change1(int i) {
        i = 1234;
    }

    public void change2 (BirthDate b) { // b is removed after the method ends
        b = new BirthDate(22, 2, 2004);
    }

    public void change3(BirthDate b) {
        b.setDay(22);
    }


}
