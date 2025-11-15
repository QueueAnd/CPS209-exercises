import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Scanner;

public class Mondrian extends JPanel {
    // Cutoff size for when a rectangle is not subdivided further.
    private static final int CUTOFF = 40;

    private static final int OFFSET = 15;

    // Percentage of rectangles that are white.
    private static final double WHITE = 0.75;
    // Colours of non-white rectangles.
    private static final Color[] COLORS = {
            Color.YELLOW, Color.RED, Color.BLUE, Color.CYAN
    };
    // RNG instance to make the random decisions with.
    private Random rng = new Random();
    // The Image in which the art is drawn.
    private Image mondrian;
    private Graphics2D g2d;

    public Mondrian(int w, int h) {
        setPreferredSize(new Dimension(w, h));
        mondrian=new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        g2d=(Graphics2D)mondrian.getGraphics();
        subdivide(0, 0, w, h, (Graphics2D)g2d);
    }
    @Override public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(mondrian,0,0, null);
    }
    private void subdivide(int x, int y, int w, int h, Graphics2D g2){
        if(w<CUTOFF || h<CUTOFF){
            drawRect(x, y, w, h, g2);
        } else {
            int offset=rng.nextInt(-OFFSET, OFFSET);
            if(w>h){
                subdivide(x, y, w/2+offset, h, g2);
                subdivide(x+w/2+offset, y, w/2-offset, h, g2);
            } else {
                subdivide(x, y, w, h/2+offset, g2);
                subdivide(x, y+h/2+offset, w, h/2-offset, g2);
            }
        }
    }
    private Color getRandomColor(){
        return new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255));
    }
    private void drawRect(int x, int y, int w, int h, Graphics2D g2){
        g2.setColor(Color.BLACK);
        g2.setStroke(new BasicStroke(3f));
        g2.drawRect(x, y, w, h);

        if(rng.nextFloat()<=WHITE){
            g2.setColor(Color.WHITE);
        } else {
            g2.setColor(COLORS[rng.nextInt(3)]);
        }
        g2.fillRect(x, y, w, h);
    }
}
