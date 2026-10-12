import javax.swing.*;
import java.awt.*;

public class PantallaInicio extends JFrame{
    public PantallaInicio(){

        /** configuracion incio de pantalla */
        setTitle("Juego RPG");
        setSize(400,350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        /** informacion inicio de pantalla */

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JLabel titulo = new JLabel("Aventura RPG");
        titulo.setFont(new Font("Serif", Font.BOLD, 32));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        /** Estilo inicio de pantalla */

        Color fondo = new Color(23, 25, 35);
        Color dorado = new Color(217, 182, 111);

        panel.setBackground(fondo);
        titulo.setBackground(dorado);

        /** Configuracion botones inicio de pantalla */

        JButton jugar = new JButton("Jugar");
        JButton salir = new JButton("Salir");

        jugar.setAlignmentX(Component.CENTER_ALIGNMENT);
        salir.setAlignmentX(Component.CENTER_ALIGNMENT);

        /** Estilo botones inicio de pantalla */

        jugar.setBackground(new Color(130, 101, 47));
        jugar.setForeground(Color.WHITE);
        jugar.setFont(new Font("Arial", Font.BOLD, 16));
        jugar.setFocusPainted(false);
        jugar.setOpaque(true);
        jugar.setBorderPainted(false);

        salir.setBackground(new Color(52, 53, 65));
        salir.setForeground(Color.WHITE);
        salir.setFont(new Font("Arial", Font.BOLD, 14));
        salir.setFocusPainted(false);
        salir.setOpaque(true);
        salir.setBorderPainted(false);

        /** Especificacion tamaño botones inicio de pantalla */

        Dimension tamano = new Dimension(160,35);
        
        jugar.setPreferredSize(tamano);
        jugar.setMaximumSize(tamano);

        salir.setPreferredSize(tamano);
        salir.setMaximumSize(tamano);

        /** Interaccion botones inicio de pantalla */

        jugar.addActionListener(e -> {
            dispose();
            new Main().iniciarjuego();
        });

        salir.addActionListener(e -> System.exit(0));

        panel.add(Box.createVerticalStrut(45));
        panel.add(titulo);
        panel.add(Box.createVerticalStrut(35));
        panel.add(jugar);
        panel.add(Box.createVerticalStrut(15));
        panel.add(salir);

        /** incluir panel al iniciar programa */

        add(panel);
    }
}
