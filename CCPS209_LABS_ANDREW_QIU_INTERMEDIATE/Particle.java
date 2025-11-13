import java.util.Random;

public class Particle {
    private double x;
    private double y;
    private double heading;
    private static final Random rng=new Random();
    private static final double BUZZY=0.7;
    public Particle(int width, int height){
        x=Math.random()*width;
        y=Math.random()*height;
        heading=Math.PI*2*rng.nextDouble();
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public void move(){
        x+=Math.cos(heading);
        y+=Math.sin(heading);
        heading+=rng.nextGaussian()*BUZZY;
    }

}
