import javax.swing.*;
import java.awt.*;

public class VentanaCombate extends JFrame{

    Jugador jugador;
    Enemigo enemigo;
    ICombate combate;

    JLabel nombreJ;
    JLabel vidaJ;
    JLabel manaJ;
    JLabel nivelJ;

    JLabel nombreE;
    JLabel vidaE;
    JLabel manaE;
    JLabel nivelE;

    JButton BAtacar;
    JButton BHabilidad;
    JButton BObjeto;
    JButton BInfo;

    JLabel Turno;

    /** Colore de panel */

    private final Color fondo = new Color(23, 25, 35);
    private final Color dorado = new Color(217, 182, 111);
    private final Color panel = new Color(35, 38, 51);
    private final Color rojo = new Color(220, 120, 110);
    private final Color botones = new Color(85, 66, 43);

    /** Constructor de paneles y botones */

    public VentanaCombate (Jugador jugador, Enemigo enemigo){
        this.jugador = jugador;
        this.enemigo = enemigo;

        /** Inicio */

        setTitle("Combate");
        setSize(500,300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        getContentPane().setBackground(fondo);

        /**ventana principal */

        JPanel vprincipal = new JPanel(new GridLayout(1,2));
        vprincipal.setBackground(fondo);
        vprincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 5, 10));

        /** Turnos */

        Turno = new JLabel("Turno del Jugador");
        Turno.setHorizontalAlignment(SwingConstants.CENTER);
        Turno.setFont(new Font("Arial", Font.BOLD, 16));
        Turno.setForeground(dorado);
        Turno.setBackground(panel);
        Turno.setOpaque(false);
        Turno.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));

        add(Turno, BorderLayout.NORTH);

        /** Informacion jugador */

        JPanel Pjugador = new JPanel();
        Pjugador.setLayout(new BoxLayout(Pjugador, BoxLayout.Y_AXIS));
        Pjugador.setBackground(panel);
        Pjugador.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(dorado), BorderFactory.createEmptyBorder(10, 8, 10, 8)));

        nombreJ = new JLabel();
        vidaJ = new JLabel();
        manaJ = new JLabel();
        nivelJ = new JLabel();

        /** Estilo de información jugador */

        estiloEtiqueta(nombreJ, dorado, 15);
        estiloEtiqueta(vidaJ, Color.WHITE, 13);
        estiloEtiqueta(manaJ, Color.WHITE, 13);
        estiloEtiqueta(nivelJ, Color.WHITE, 13);

        /** Centrar texto jugador */

        nombreJ.setAlignmentX(Component.CENTER_ALIGNMENT);
        vidaJ.setAlignmentX(Component.CENTER_ALIGNMENT);
        manaJ.setAlignmentX(Component.CENTER_ALIGNMENT);
        nivelJ.setAlignmentX(Component.CENTER_ALIGNMENT);

        /** Mostrar informacion en panel jugador */

        Pjugador.add(nombreJ);
        Pjugador.add(Box.createVerticalStrut(10));
        Pjugador.add(vidaJ);
        Pjugador.add(manaJ);
        Pjugador.add(nivelJ);

        /** Informacion enemigo */

        JPanel Penemigo = new JPanel();
        Penemigo.setLayout(new BoxLayout(Penemigo, BoxLayout.Y_AXIS));
        Penemigo.setBackground(panel);
        Penemigo.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(rojo), BorderFactory.createEmptyBorder(10, 8, 10, 8)));

        nombreE = new JLabel();
        vidaE = new JLabel();
        manaE = new JLabel();
        nivelE = new JLabel();

        /** Estilo informacion en panel enemigo */

        estiloEtiqueta(nombreE, rojo, 15);
        estiloEtiqueta(vidaE, Color.WHITE, 13);
        estiloEtiqueta(manaE, Color.WHITE, 13);
        estiloEtiqueta(nivelE, Color.WHITE, 13);

        /** centrar texto enemigo */

        nombreE.setAlignmentX(Component.CENTER_ALIGNMENT);
        vidaE.setAlignmentX(Component.CENTER_ALIGNMENT);
        manaE.setAlignmentX(Component.CENTER_ALIGNMENT);
        nivelE.setAlignmentX(Component.CENTER_ALIGNMENT);

        /** Mostrar informacion en panel enemigo */

        Penemigo.add(nombreE);
        Penemigo.add(Box.createVerticalStrut(10));
        Penemigo.add(vidaE);
        Penemigo.add(manaE);
        Penemigo.add(nivelE);

        /** Incuir informacion de enemigo y jugador al iniciar programa */

        vprincipal.add(Pjugador);
        vprincipal.add(Penemigo);

        add(vprincipal, BorderLayout.CENTER);
        ainfo();

        /** botones */

        JPanel Botones = new JPanel(new GridLayout(2, 2));
        Botones.setBackground(fondo);
        Botones.setBorder(BorderFactory.createEmptyBorder(5, 10, 10, 10));

        /** Creacion de los cuatro tipos de botones */

        BAtacar = new JButton("Atacar");
        BHabilidad = new JButton("Habilidades");
        BObjeto = new JButton("Objetos");
        BInfo = new JButton("Ver información");

        /** Estilo botones */

        estiloBoton(BAtacar);
        estiloBoton(BHabilidad);
        estiloBoton(BObjeto);
        estiloBoton(BInfo);

        /** Interaccion botones */

        BAtacar.addActionListener(e ->{
            if(combate.TurnoJugador){
                combate.TJugador();
            }
        });

        BHabilidad.addActionListener(e ->{
            if(combate.TurnoJugador){
                combate.THabilidad();
            }

        });

        BObjeto.addActionListener(e->{
            if(combate.TurnoJugador){
                combate.TObjeto();
            }
        });

        BInfo.addActionListener(e->{
            jugador.minfo();
        });

        /** Incluir botones al iniciar programa */

        Botones.add(BAtacar);
        Botones.add(BHabilidad);
        Botones.add(BObjeto);
        Botones.add(BInfo);

        add(Botones, BorderLayout.SOUTH);
    }

    /** Metodo estilo de informacion */

    public void estiloEtiqueta(JLabel etiqueta, Color color, int tamano){
        etiqueta.setForeground(color);
        etiqueta.setFont(new Font("Arial",Font.BOLD, 13));
        etiqueta.setAlignmentX(Component.CENTER_ALIGNMENT);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
    }

    /** Metodo estilo de botones */

    public void estiloBoton(JButton boton){
        boton.setBackground(botones);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 13));
        boton.setFocusPainted(false);
        boton.setOpaque(true);
        boton.setBorderPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    /** Llamado e iniciado de combate */

    public void setCombate(ICombate combate){
        this.combate = combate;
    }

    /** Actualizar informacion general */

    public void ainfo(){
        nombreJ.setText("Héroe: " + jugador.nombre);
        vidaJ.setText("Vida: " + jugador.vida + " / " + jugador.vidamax);
        manaJ.setText("Maná: " + jugador.mana + " / " + jugador.manamax);
        nivelJ.setText("Nivel: " + jugador.nivel);

        nombreE.setText("Enemigo: " + enemigo.nombre);
        vidaE.setText("Vida: " + enemigo.vida + " / " + enemigo.vidamax);
        manaE.setText("Maná: " + enemigo.mana + " / " + enemigo.manamax);
        nivelE.setText("Nivel: " + enemigo.nivel);
    }

    /** Activar y desactivar botones */

    public void ActivarB(){
        BAtacar.setEnabled(true);
        BHabilidad.setEnabled(true);
        BObjeto.setEnabled(true);
        BInfo.setEnabled(true);
    }

    public void DesactivarB(){
        BAtacar.setEnabled(false);
        BHabilidad.setEnabled(false);
        BObjeto.setEnabled(false);
        BInfo.setEnabled(false);
    }

    /** Cambiar turnos */

    public void CJugador(){
        Turno.setText("Turno del Jugador");
        Turno.setForeground(dorado);
    }

    public void CEnemigo(){
        Turno.setText("Turno del Enemigo");
        Turno.setForeground(rojo);
    }

    /** Actualizar información proximo combate */

    public void nEnemigo(Enemigo enemigo){
        this.enemigo = enemigo;
        ainfo();
    }

}
