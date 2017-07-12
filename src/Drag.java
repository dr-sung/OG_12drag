
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.JFrame;

public class Drag extends JFrame {

    private Canvas canvas;
    private double dx; // relative mouse click location inside the box
    private double dy;
    protected final static int RWIDTH = 30;
    protected final static int RHEIGHT = 30;

    public void initialize() {

        canvas = new Canvas();
        
        MouseObserver mouseObserver = new MouseObserver();
        canvas.addMouseListener(mouseObserver);
        canvas.addMouseMotionListener(mouseObserver);

        Container cp = getContentPane();
        cp.add(canvas, "Center");
    }

    /* Facade design pattern
        facade: MouseAdapter
    subsystems: each method for each mouse event
    
    */
    private class MouseObserver extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();

            canvas.active = -1; // 'active' package access mode
            // canvas.boxes : package access mode
            for (int i = 0; i < canvas.boxes.size(); i++) {
                Rectangle2D.Double r = canvas.boxes.get(i);
                if (r.contains(x, y)) {
                    canvas.active = i;
                    dx = x - r.x; // relative click location inside the box
                    dy = y - r.y;
                    return;
                }
            }
        }
        
        @Override
        public void mouseDragged(MouseEvent e) {
            if (canvas.active < 0) {
                return;
            }

            Rectangle2D.Double r = canvas.boxes.get(canvas.active);
            int x = e.getX();
            int y = e.getY();
            r.setRect(x-dx, y-dy, RWIDTH, RHEIGHT);
            repaint();
        }
    }

}
