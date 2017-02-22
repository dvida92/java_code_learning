package Basics.GUI_Test;

import java.awt.*;

/**
 * Frame with Panel
 */
public class Test19 {
    public static void main(String[] args) {
        Frame f = new Frame("Java Frame with Panel");
        Panel p = new Panel(null);
        f.setLayout(null);
        f.setBounds(300,300,500,500); //相对于屏幕的坐标
        f.setBackground(new Color(0,0,150));
        p.setBounds(50,50,400,400); //相对于frame的坐标
        p.setBackground(new Color(204,204,255));
        f.add(p); //add p to f
        f.setVisible(true);
    }


}
