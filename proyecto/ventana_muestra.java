package proyecto;
import java.awt.Dimension;

import javax.swing.*;



public class ventana_muestra extends JFrame {



    public ventana_muestra(double[] xPoints, double[] yPoints) {
        setTitle("ventana de muestra");
        setSize(450,500);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        figurapanel Panel = new figurapanel(xPoints, yPoints);

        add(Panel);

    
    }
    
}
