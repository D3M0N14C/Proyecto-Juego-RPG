import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class VentanaInformacion extends JFrame{

    private final Color fondo = new Color(23, 25, 35);
    private final Color panel = new Color(35, 38, 51);
    private final Color dorado = new Color(217, 182,111);

    /** Constructor paneles y pestañas */

    public VentanaInformacion(Jugador jugador){
        setTitle("Información del jugador");
        setSize(550, 450);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        /** Panel principal */

        JPanel principal = new JPanel(new BorderLayout(10, 10));
        principal.setBackground(fondo);
        principal.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        /** Titulo */

        JLabel titulo = new JLabel("Información del heroe");
        titulo.setFont(new Font("Serif", Font.BOLD, 24));
        titulo.setForeground(dorado);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        principal.add(titulo, BorderLayout.NORTH);

        /** Pestañas de personaje, inventario y inventario de habilidades */

        JTabbedPane pestana = new JTabbedPane();
        pestana.setBackground(panel);
        pestana.setForeground(Color.WHITE);
        pestana.setFont(new Font("Arial", Font.BOLD, 12));

        pestana.addTab("Personaje", Ppersonaje(jugador));
        pestana.addTab("Inventario", Pinventario(jugador));
        pestana.addTab("Habilidades", Phabilidades(jugador));

        principal.add(pestana, BorderLayout.CENTER);

        /** Boton cerrar  */

        JButton cerrar = new JButton("Cerrar");
        cerrar.setBackground(new Color(130, 101, 47));
        cerrar.setForeground(Color.WHITE);
        cerrar.setFocusPainted(false);
        cerrar.setOpaque(true);
        cerrar.setBorderPainted(false);

        cerrar.addActionListener(e -> dispose());

        JPanel abajo = new JPanel();
        abajo.setBackground(fondo);
        abajo.add(cerrar);

        principal.add(abajo, BorderLayout.SOUTH);

        add(principal);
    }

    /** Agregar información */

    private void aggInfo(JPanel Panel, String nombre, String valor){
        JLabel etiqueta = new JLabel(nombre);
        etiqueta.setForeground(dorado);
        etiqueta.setFont(new Font("Arial", Font.BOLD, 13));

        JLabel info = new JLabel(valor);
        info.setForeground(Color.WHITE);
        info.setFont(new Font("Arial", Font.BOLD, 13));

        Panel.add(etiqueta);
        Panel.add(info);
    }

    /** diseño tablas */

    private void estilotabla(JTable tabla2){
        tabla2.setBackground(panel);
        tabla2.setForeground(Color.WHITE);
        tabla2.setGridColor(new Color(65, 68, 80));
        tabla2.setRowHeight(28);
        tabla2.setFont(new Font("Arial", Font.PLAIN, 12));
        tabla2.setFillsViewportHeight(true);

        tabla2.getTableHeader().setBackground(dorado);
        tabla2.getTableHeader().setForeground(Color.BLACK);
        tabla2.getTableHeader().setFont(new Font("Arial", Font.BOLD, 12));

        tabla2.setSelectionBackground(new Color(85, 66, 43));
        tabla2.setSelectionForeground(Color.WHITE);
    }

    /** Informacion de jugador */
    
    private JPanel Ppersonaje(Jugador jugador){
        JPanel Panel = new JPanel(new GridLayout(0, 2, 10, 12));
        Panel.setBackground(panel);
        Panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        aggInfo(Panel, "Nombre:", jugador.nombre);
        aggInfo(Panel, "Vida", jugador.vida + "/" + jugador.vidamax);
        aggInfo(Panel, "Maná", jugador.mana + "/" + jugador.manamax);
        aggInfo(Panel, "Nivel", String.valueOf(jugador.nivel));
        aggInfo(Panel, "Experiencia", String.valueOf(jugador.experiencia));
        aggInfo(Panel, "Ataque", String.valueOf(jugador.ataque));
        aggInfo(Panel, "Ataque Mágico", String.valueOf(jugador.ataquemag));
        aggInfo(Panel, "Defensa", String.valueOf(jugador.defensa));

        return Panel;
    }

    /** Información del inventario */

    private JPanel Pinventario(Jugador jugador){
        String[] col ={"Nombre", "Tipo", "Valor"};

        DefaultTableModel tabla = new DefaultTableModel(col, 0){
            @Override 
            public boolean isCellEditable(int fila, int columna){
                return false;
            }
        };

        for(int i = 0; i < jugador.inventario.inventario.size(); i++){
            Objeto objeto = jugador.inventario.obtenerObjeto(i);

            tabla.addRow(new Object[]{objeto.nombre, objeto.tipo, objeto.valor});
        }

        if(tabla.getRowCount() == 0){
            tabla.addRow(new Object[]{"No hay objetos", "-", "-"});
        }

        JTable tabla2 = new JTable(tabla);
        estilotabla(tabla2);

        JPanel Panel = new JPanel(new BorderLayout());
        Panel.setBackground(panel);
        Panel.add(new JScrollPane(tabla2), BorderLayout.CENTER);

        return Panel;
    }

    /** Información inventario de habilidades  */
    private JPanel Phabilidades(Jugador jugador){
        String[] col = {"Nombre", "Tipo", "Daño", "Costo de maná"};

        DefaultTableModel tabla = new DefaultTableModel(col, 0){
            @Override 
            public boolean isCellEditable(int fila, int columna){
                return false;
            }
        };

        for(int i = 0; i < jugador.habilidades.inventariohab.size(); i++){
            Habilidades habilidad = jugador.habilidades.obtenerhab(i);
            tabla.addRow(new Object[]{ habilidad.nombre, habilidad.tipo, habilidad.dano, habilidad.costomana});
        }

        if(tabla.getRowCount() == 0){
            tabla.addRow(new Object[]{"Sin habilidades", "-", "-", "-"});
        }

        JTable tabla2 = new JTable(tabla);
        estilotabla(tabla2);

        JPanel Panel = new JPanel(new BorderLayout());
        Panel.setBackground(panel);
        Panel.add(new JScrollPane(tabla2), BorderLayout.CENTER);

        return Panel;
    }
}
