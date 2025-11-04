import javax.swing.*;
import java.awt.*;

public class HeadMain {
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        frame.setSize(1000, 1000);
        GridLayout layout = new GridLayout(2,2);
        frame.setLayout(layout);
        frame.add(new Head());
        frame.add(new Head());
        frame.add(new Head());
        frame.add(new Head());
        frame.setVisible(true);

    }
}
