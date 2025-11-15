import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class HTree extends JPanel {
    // Once line segment length is shorter than cutoff, stop subdividing.
    private static final double CUTOFF = 10;
    // Radius of the little dot drawn on each intersection.
    private static final double R = 10;

    private static final int MINIR = 4;
    // The image inside which the H-Tree fractal is rendered.
    private Image htree;
    // Four possible direction vectors that a line segment can have.
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    // A random number generator for choosing the end piece colours.
    private static final Random rng = new Random();

    public HTree(int width, int height) {
        htree = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = (Graphics2D) htree.getGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(Color.BLACK);
        render((double) width/2, (double) height/2, 2, 350, g2d);
        setPreferredSize(new Dimension(width, height));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(htree, 0, 0, this);
        Graphics2D g2d= (Graphics2D)g;
        g2d.setStroke(new BasicStroke(1));
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    }

    private static void render(double x, double y, int i, double len, Graphics2D g2) {
        if (len < CUTOFF) {
            drawNode(x, y, rng.nextBoolean(), g2);
            drawNode(x, y-R, rng.nextBoolean(), g2);
        } else {
            g2.fillOval((int)(x-MINIR/2), (int)(y-MINIR/2), MINIR, MINIR);
            int next= (((i+1)%DIRS.length)+DIRS.length)%DIRS.length;
            int prev= (((i-1)%DIRS.length)+DIRS.length)%DIRS.length;
            int nx1= (int)(DIRS[prev][0]*len)+(int)x, ny1= (int)(DIRS[prev][1]*len)+(int)y;
            int nx2= (int)(DIRS[next][0]*len)+(int)x, ny2= (int)(DIRS[next][1]*len)+(int)y;

            g2.drawLine((int)x, (int)y, nx1, ny1);
            g2.drawLine((int)x, (int)y, nx2, ny2);

            double newLen=len/Math.sqrt(2);
            render(nx1, ny1, (((i+1)%DIRS.length)+DIRS.length)%DIRS.length, newLen, g2);
            render(nx2, ny2, (((i-1)%DIRS.length)+DIRS.length)%DIRS.length, newLen, g2);
        }
    }

    private static void drawNode(double x, double y, boolean fill, Graphics2D g2) {
        if(fill){
            g2.fillOval((int) (x-R/2), (int) (y), (int) R, (int) R);
        } else {
            g2.drawOval((int) (x-R/2), (int) (y), (int) R, (int) R);
        }
    }
}
