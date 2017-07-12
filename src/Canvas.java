
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JPanel;


public class Canvas extends JPanel {

    /* intentionally "package" access mode is used */
        ArrayList<Rectangle2D.Double> boxes;
        int active = -1;

        public Canvas() {
            boxes = new ArrayList<>();
            boxes.add(new Rectangle2D.Double(10, 10, Drag.RWIDTH, Drag.RHEIGHT));
            boxes.add(new Rectangle2D.Double(40, 40, Drag.RWIDTH, Drag.RHEIGHT));
            boxes.add(new Rectangle2D.Double(90, 90, Drag.RWIDTH, Drag.RHEIGHT));
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            for (int i = 0; i < boxes.size(); i++) {
                Rectangle2D.Double r = boxes.get(i);
                g2.draw(r);
            }
        }
    }