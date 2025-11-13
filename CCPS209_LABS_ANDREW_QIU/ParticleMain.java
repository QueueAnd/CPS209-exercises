import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ParticleMain
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Particle Main");
        ParticleField particleField=new ParticleField(2000, 800, 800);
        particleField.setSize(800, 800);
        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent we){
                particleField.terminate();
                frame.dispose();
            }
        });
        frame.add(particleField);
        frame.pack();
        frame.setVisible(true);
    }
}
