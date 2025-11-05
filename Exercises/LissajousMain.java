import javax.swing.*;

public class LissajousMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Lissajous lissajous=new Lissajous(800);
        frame.add(lissajous);
        frame.pack();
        frame.setVisible(true);
    }
}
