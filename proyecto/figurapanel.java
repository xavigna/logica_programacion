package proyecto;
import javax.swing.*;
import java.awt.*;


public class figurapanel extends JPanel {
    private final double[] xPoints;
    private final double[] yPoints;

    public figurapanel(double[] xPoints, double[] yPoints) {
        this.xPoints = xPoints;
        this.yPoints = yPoints;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.GRAY);
        int[] x = java.util.Arrays.stream(xPoints).mapToInt(point -> (int) Math.round(point)).toArray();
        int[] y = java.util.Arrays.stream(yPoints).mapToInt(point -> (int) Math.round(point)).toArray();
        
    

        g2d.setColor(Color.GREEN);
        g2d.fillPolygon(x, y, x.length);

    }
}