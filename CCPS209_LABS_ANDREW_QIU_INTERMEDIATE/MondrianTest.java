import javax.swing.*;

public class MondrianTest {
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        Mondrian mondrian=new Mondrian(1000, 800);
        frame.add(mondrian);
        frame.pack();
        frame.setVisible(true);
    }
}
