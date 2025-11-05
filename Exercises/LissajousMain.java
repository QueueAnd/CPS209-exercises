import javax.swing.*;
import java.awt.*;

public class LissajousMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Lissajous lissajous=new Lissajous(800);
        frame.setLayout(new FlowLayout());
        frame.add(lissajous);
        frame.pack();
        frame.setVisible(true);
    }
}
