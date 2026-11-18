package proyecto;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class proyecto_ultimo extends JFrame {
    public double perimetro = 0.0;
    public double area = 0.0;
    public double[] xPoins = new double[100];
    public double[] yPoins = new double[100];

    private JTextField coordenadas;
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

        JLabel subtitulo = new JLabel("Ingresa las coordenadas");
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

        coordenadas = crearCampo(panel, "Coordenadas:", 100, 150);
        

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

        resultado = new JLabel("--", SwingConstants.CENTER);
        resultado.setFont(new Font("Arial", Font.BOLD, 17));
        resultado.setForeground(new Color(25, 100, 70));
        resultado.setBounds(50, 390, 340, 35);
        panel.add(resultado);

        add(panel);

    }
        static class Punto {
        double x, y;

        Punto(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return  "(" + x + ", " + y + ")";
        }
    }

    private JTextField crearCampo(JPanel panel, String label, int x, int y) {
        JLabel etiqueta = new JLabel(label);
        etiqueta.setFont(new Font("Arial", Font.BOLD, 14));
        etiqueta.setBounds(x - 65, y, 100, 30);
        panel.add(etiqueta);

        JTextField campo = new JTextField();
        campo.setBounds(x + 35, y, 150, 25);
        campo.setFont(new Font("Arial", Font.PLAIN, 14));
        panel.add(campo);

        return campo;
    }

    public static void ordenarAntihorario(List<Punto> puntos) {
        if (puntos.size() < 3) return;


        double sumaX = 0, sumaY = 0;
        for (Punto p : puntos) {
            sumaX += p.x;
            sumaY += p.y;
        }
        final double centroX = sumaX / puntos.size();
        final double centroY = sumaY / puntos.size();

  
        puntos.sort((p1, p2) -> {
            double angulo1 = Math.atan2(p1.y - centroY, p1.x - centroX);
            double angulo2 = Math.atan2(p2.y - centroY, p2.x - centroX);
            return Double.compare(angulo1, angulo2);
        });
    }

    public void calcular() {
        try {
            List<Punto> puntos = new ArrayList<>();
            String[] valores = coordenadas.getText().replace("(", "").replace(")", "").split(",");
            if (valores.length == 0 || valores.length % 2 != 0 || valores.length < 4) {
                throw new NumberFormatException();
            }

            perimetro = 0.0;
            area = 0.0;
            double distancia = 0.0;
            double s1 = 0.0;
            double s2 = 0.0;
            this.xPoins = new double[valores.length / 2];
            this.yPoins = new double[valores.length / 2];

       for (int i = 0; i < valores.length; i += 2) {
            double x = Double.parseDouble(valores[i].trim());
            double y = Double.parseDouble(valores[i + 1].trim());
            puntos.add(new Punto(x, y));
        }

            ordenarAntihorario(puntos);

            double[] punto = puntos.stream().flatMapToDouble(p -> java.util.stream.DoubleStream.of(p.x, p.y)).toArray();


            for (int i = 0; i < punto.length; i += 2) {
            if (i + 3 >= punto.length) {
                distancia = Math.sqrt(
                Math.pow(punto[i] - punto[i + 1], 2) + Math.pow(punto[0] - punto[1], 2)
                );
                s1 += punto[i] * punto[1];
                s2 += punto[i+1] * punto[0];
            }else {
            distancia = Math.sqrt(
                Math.pow(punto[i] - punto[i + 1], 2) + Math.pow(punto[i + 2] - punto[i + 3], 2)
            );
                s1 += punto[i] * punto[i + 3];
                s2 += punto[i+1] * punto[i + 2];
            }
            perimetro += distancia;
            }
            area = Math.abs(s1 - s2) / 2;

            for (int i = 0; i < punto.length; i += 2) {
                xPoins[i / 2] = punto[i];
                yPoins[i / 2] = punto[i + 1];
            }

            ventana_muestra muestra = new ventana_muestra(xPoins, yPoins);
            muestra.setVisible(true);

resultado.setText(String.format(
    "<html>El perímetro es: %.2f unidades<br>El área es: %.2f unidades²</html>",
    perimetro, area
));


        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                this,
                "Por favor, ingresa valores numéricos validos.",
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