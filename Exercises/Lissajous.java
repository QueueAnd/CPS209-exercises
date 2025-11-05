import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

public class Lissajous extends JPanel {
    JTextField text1=new JTextField();
    JTextField text2=new JTextField();
    JTextField text3=new JTextField();
    MyActionListener listener=new MyActionListener();
    int size;
    public Lissajous(int size){
        setPreferredSize(new Dimension(size, size));
        this.size=size;

    }
    private void createComponents(){
        text1.setText("6");
        text2.setText("5");
        text3.setText("0.5");

        text1.addActionListener(listener);
        text2.addActionListener(listener);
        text3.addActionListener(listener);

        add(text1);
        add(text2);
        add(text3);
    }
    @Override public void paintComponent(Graphics g){
        double a=Integer.parseInt(text1.getText());
        double b=Integer.parseInt(text2.getText());
        double delta=Integer.parseInt(text3.getText());

        double x=0;
        double y=0;
        double x2=0;
        double y2=0;

        for(double t = 0; t<((double) a /gcd(a, b))*b; t++){
            x2=x;
            y2=y;
            x= (double) size /2+ (double) (2 * size) /5*Math.sin(a*t*Math.PI+delta);
            y=(double)size/2+ (double) (2 * size) /5*Math.sin(b*t*Math.PI);
            if(x!=0 && y!=0){
                g.drawLine((int)x, (int)y, (int)x, (int)y);
            }

        }
    }
    public double gcd(double a, double b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
    private class MyActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }
    }

}
