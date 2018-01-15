
import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        Drag d = new Drag();

        d.setTitle("Drag something with mouse");
        d.setSize(700, 500);
        d.setLocation(100, 100);
        d.initialize();
        
        d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        d.setVisible(true);
    }
}
