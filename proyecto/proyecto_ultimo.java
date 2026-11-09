package proyecto;
import java.util.ArrayList;
import javax.swing.*;
import java.awt.*;

public class proyecto_ultimo extends JFrame {
    
    private JTextField x1, y1, x2, y2;
    private JLabel resultado;

    public proyecto_ultimo() {
        setTitle("calculadora de costos");
        setSize(450,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(235, 242, 250));
        panel.setLayout(null);

        JLabel titulo = new JLabel("calculadora de costos");
        titulo.setFont(new Font("Arial", Font.BOLD, 23));
        titulo.setForeground(new Color(25, 45, 75));
        titulo.setBounds(55, 25, 350, 35);
        panel.add(titulo);

        JLabel subtitulo = new JLabel("Ingresa las coordenadas de dos puntos");
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 13));
        subtitulo.setForeground(Color.GRAY);
        subtitulo.setBounds(75, 65, 300, 25);
        panel.add(subtitulo);

        JLabel punto1 = new JLabel("Primer punto");
        punto1.setFont(new Font("Arial", Font.BOLD, 16));
        punto1.setBounds(55, 115, 150, 25);
        panel.add(punto1);

        JLabel punto2 = new JLabel("Segundo punto");
        punto2.setFont(new Font("Arial", Font.BOLD, 16));
        punto2.setBounds(55, 220, 150, 25);
        panel.add(punto2);

        x1 = crearCampo(panel, "X1:", 55, 150);
        y1 = crearCampo(panel, "Y1:", 240, 150);


        x2 = crearCampo(panel, "X2:", 55, 255);
        y2 = crearCampo(panel, "Y2:", 240, 255);

                JButton boton = new JButton("CALCULAR DISTANCIA");
        boton.setBounds(75, 325, 280, 45);
        boton.setBackground(new Color(35, 100, 200));
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        boton.addActionListener(e -> calcular());

        panel.add(boton);

        resultado = new JLabel("Resultado: --", SwingConstants.CENTER);
        resultado.setFont(new Font("Arial", Font.BOLD, 17));
        resultado.setForeground(new Color(25, 100, 70));
        resultado.setBounds(50, 390, 340, 35);
        panel.add(resultado);

        add(panel);

    }

    private JTextField crearCampo(JPanel panel, String label, int x, int y) {
        JLabel etiqueta = new JLabel(label);
        etiqueta.setFont(new Font("Arial", Font.BOLD, 14));
        etiqueta.setBounds(x, y, 35, 30);
        panel.add(etiqueta);

        JTextField campo = new JTextField();
        campo.setBounds(x + 35, y, 150, 25);
        campo.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(campo);

        return campo;
    }

     public void calcular() {

        try {
            double px1 = Double.parseDouble(x1.getText());
            double py1 = Double.parseDouble(y1.getText());
            double px2 = Double.parseDouble(x2.getText());
            double py2 = Double.parseDouble(y2.getText());

            double distancia = Math.sqrt(Math.pow(px2 - px1, 2) +Math.pow(py2 - py1, 2));

            resultado.setText(String.format("Distancia: %.2f ", distancia));

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Por favor, ingresa valores numéricos válidos.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            proyecto_ultimo ventana = new proyecto_ultimo();
            ventana.setVisible(true);
        });
    }
}