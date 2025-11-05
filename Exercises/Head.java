import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Head {
    private boolean mouseInside;
    private MyMouseListener mouseListener= new MyMouseListener();
    public Head(){
        createComponents();
        addMouseListener(mouseListener);
    }
    private void createComponents(){
        setSize(500,500);
        setBorder(BorderFactory.createBevelBorder(1, Color.BLACK, Color.BLACK));
    }

    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {
            mouseInside=true;
            repaint();
        }
        @Override
        public void mouseExited(MouseEvent e) {
            mouseInside=false;
            repaint();
        }
    }
    public void drawSleepFace(Graphics page){
        page.setColor(Color.BLACK);
        page.fillOval(30, 30, 150, 150);
        page.setColor(Color.WHITE);
        page.fillRect(50, 60, 20, 10);
        page.fillRect(150, 60, 20, 10);
    }
    public void drawAwakeFace(Graphics page){
        page.setColor(Color.RED);
        page.fillOval(30, 30, 150, 150);
        page.setColor(Color.BLACK);
        page.fillOval(50, 60, 20, 20);
        page.fillOval(150, 60, 20, 20);
    }
    @Override
    protected void paintComponent(Graphics g) {
        if(!mouseInside){
            drawSleepFace(g);
        } else {
            drawAwakeFace(g);
        }
    }

}
