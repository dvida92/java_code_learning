package Basics.GUI_Test;

import java.awt.*;

/**
 * GUI
 */
public class Test17  {

    public static void main(String[] args) {
        Frame f = new Frame("My First Test");
        f.setSize(300, 300);
        f.setBackground(Color.BLUE);
        f.setResizable(false);
        f.setLocation(300,300);
        f.setVisible(true);  //必须设置为true否则不可见


    }
}
