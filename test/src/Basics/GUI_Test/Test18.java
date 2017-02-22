package Basics.GUI_Test;

import java.awt.*;

/**
 * Customize Frame Class
 */
public class Test18 {
    public static void main(String[] args) {
        MyFrame f1 =
                new MyFrame(100,100,200,200,Color.BLACK);
        MyFrame f2 =
                new MyFrame(300,100,200,200,Color.BLUE);
        MyFrame f3 =
                new MyFrame(100,300,200,200,Color.red);
        MyFrame f4 =
                new MyFrame(300,300,200,200,Color.yellow);
    }
}

class MyFrame extends Frame {

    static int id = 0;
    MyFrame(int x, int y, int w, int h, Color color) {
        super("MyFrame" + (++id));
        setBackground(color);
        setLayout(null);
        setBounds(x,y,w,h);
        setVisible(true);
    }
}
