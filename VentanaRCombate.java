import javax.swing.*;
import java.awt.*;

public class VentanaRCombate extends JFrame{

    public VentanaRCombate(boolean victoria){

        /** Mensaje si victoria es true o false */
        setTitle(victoria ? "Victoria" : "Derrota");
        setSize(400, 230);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        /** Definicion de colores a usar */

        Color fondo = new Color(23, 25, 35);
        Color dorado = new Color(217, 182, 111);
        Color rojo = new Color(220, 100, 100);

        /** panel del mensaje */

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.setBackground(fondo);

        JLabel titulo = new JLabel(victoria ? "Victoria" : "Derrota");

        titulo.setFont(new Font("Serif", Font.BOLD, 30));
        titulo.setForeground(victoria ? dorado : rojo);
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel mensaje = new JLabel(victoria ? "Felicidades \n Has derrotado a todos los enemigos" : "  El heroe a muerto en combate");

        mensaje.setForeground(Color.WHITE);
        mensaje.setFont(new Font("Arial", Font.PLAIN, 13));
        mensaje.setAlignmentX(Component.CENTER_ALIGNMENT);

        /** Botones mensaje */

        JButton Bmenu = new JButton("Volver al menú");
        JButton Bsalir = new JButton("Salir");

        estiloBoton(Bmenu);
        estiloBoton(Bsalir);

        Bmenu.setAlignmentX(Component.CENTER_ALIGNMENT);
        Bsalir.setAlignmentX(Component.CENTER_ALIGNMENT);

        /** Accion al oprimir cada boton */

        Bmenu.addActionListener(e -> {
            dispose();
            new PantallaInicio().setVisible(true);
        });

        Bsalir.addActionListener(e -> System.exit(0));

        /** Agregar toda la información */

        panel.add(Box.createVerticalStrut(25));
        panel.add(titulo);
        panel.add(Box.createVerticalStrut(10));
        panel.add(mensaje);
        panel.add(Box.createVerticalStrut(20));
        panel.add(Bmenu);
        panel.add(Box.createVerticalStrut(10));
        panel.add(Bsalir);

        add(panel);
    }

    /** Estilo botones */

    private void estiloBoton(JButton boton){
        boton.setBackground(new Color(85,66,43));
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 13));
        boton.setFocusPainted(false);
        boton.setOpaque(true);
        boton.setBorderPainted(false);
    }

}
