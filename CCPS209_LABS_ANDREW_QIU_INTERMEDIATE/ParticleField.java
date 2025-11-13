import java.awt.*;

import static java.lang.Thread.sleep;

public class ParticleField extends javax.swing.JPanel{
    private boolean running=true;
    private java.util.List<Particle> particles=new java.util.ArrayList<Particle>();
    public ParticleField(int n, int width, int height) {
        setPreferredSize(new Dimension(width, height));
        for(int i=0; i<n; i++){
            particles.add(new Particle(width, height));
        }
        Runnable r= new Runnable() {
            @Override
            public void run() {
                while(running){
                    try {
                        sleep(20);
                        for(Particle p:particles){
                            p.move();
                        }
                        repaint();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        };
        new Thread(r).start();
    }
    @Override public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(Particle p:particles){
            g.setColor(Color.RED);
            g.fillRect((int)p.getX(), (int)p.getY(), 3, 3);
        }
    }
    public void terminate(){
        running=false;
    }
}
