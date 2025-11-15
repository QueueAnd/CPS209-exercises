import javax.swing.*;

public class HTreeMain {
    public static void main(String[] args) {
        JFrame frame=new JFrame();
        HTree hTree=new HTree(1000, 1000);
        frame.add(hTree);
        frame.pack();
        frame.setVisible(true);
    }
}
