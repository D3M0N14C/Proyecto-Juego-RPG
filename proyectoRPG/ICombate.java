import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class ICombate {
    Jugador jugador;
    Enemigo enemigo;
    VentanaCombate ventanap;
    ArrayList<Enemigo> enemigos;
    int enemigoa;

    boolean TurnoJugador = true;

    /** Constructor inicio combate */

    public ICombate(Jugador jugador, ArrayList<Enemigo> enemigos) {
        this.jugador = jugador;
        this.enemigos = enemigos;
        this.enemigoa = 0;
        this.enemigo = enemigos.get(enemigoa);
        TurnoJugador = true;
        ventanap = new VentanaCombate(jugador, enemigo);
        ventanap.setVisible(true);
        ventanap.setCombate(this);
    }

    /** Metodo turno del jugador */

    public void TJugador() {
        if (!TurnoJugador) {
            return;
        }

        ventanap.CEnemigo();
        int danio = jugador.atacar();
        enemigo.recibirdanio(danio);
        jugador.quitarataquetem();
        ventanap.ainfo();
        ventanap.DesactivarB();
        if (Fcombate()) {
            return;
        }
        TurnoJugador = false;
        TEnemigo();
    }

    /** Función seleccion de habilidades en el turno del jugador */

    public Habilidades SelecHabilidad() throws SinHabilidadException {
        String[] opciones = new String[jugador.habilidades.inventariohab.size()];

        if (jugador.habilidades.inventariohab.isEmpty()) {
            throw new SinHabilidadException("El jugador no tiene ninguna habilidad actualmente");
        }

        for (int i = 0; i < jugador.habilidades.inventariohab.size(); i++) {
            opciones[i] = jugador.habilidades.inventariohab.get(i).nombre;
        }

        int Seleccionar = JOptionPane.showOptionDialog(null, "Selecciona una habilidad", "Habilidaddes",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        if (Seleccionar == -1) {
            return null;
        }

        return jugador.habilidades.inventariohab.get(Seleccionar);
    }

    /** Función seleccion de objetos en el turno del jugador */

    public Objeto SelecObjeto() throws SinObjetoException {
        String[] opciones = new String[jugador.inventario.inventario.size()];

        if (jugador.inventario.inventario.isEmpty()) {
            throw new SinObjetoException("El jugador no posee ningún objeto actualmente");
        }

        for (int i = 0; i < jugador.inventario.inventario.size(); i++) {
            opciones[i] = jugador.inventario.inventario.get(i).nombre;
        }

        int Seleccionar = JOptionPane.showOptionDialog(null, "Seleccione un Objeto", "Objetos",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        if (Seleccionar == -1) {
            return null;
        }

        return jugador.inventario.inventario.get(Seleccionar);
    }

    /** Utilizacion de objeto en el turno del jugador */

    public void TObjeto() {
        try {
            Objeto objeto = SelecObjeto();

            if (objeto == null) {
                return;
            }

            jugador.UObjeto(objeto);
            ventanap.ainfo();

            if (Fcombate()) {
                return;
            }

            TurnoJugador = false;
            TEnemigo();
        } catch (SinObjetoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /** Utilizacion de habilidades en el turno del jugador */

    public void THabilidad() {
        try {

            int danio = 0;
            Habilidades habilidad = SelecHabilidad();

            if (habilidad == null) {
                return;
            }

            danio = jugador.UHabilidades(habilidad);

            

            if (habilidad.tipo.equals("Ataque")) {
                enemigo.recibirdanio(danio);
                jugador.quitarmagia();
            }

            ventanap.ainfo();
            if (Fcombate()) {
                return;
            }
            TurnoJugador = false;
            TEnemigo();

        } catch (SinHabilidadException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch(ManaInsuficienteException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    /** Metodo turno del enemigo */

    public void TEnemigo() {
        Timer tiempoE = new Timer(750, e -> {

            if (TurnoJugador) {
                return;
            }
            ventanap.CJugador();
            int danio = enemigo.atacar();
            jugador.recibirdanio(danio);
            jugador.quitardefensatem();
            ventanap.ainfo();
            if (Fcombate()) {
                return;
            }
            ventanap.ActivarB();
            jugador.quitarmagia();
            TurnoJugador = true;

        });

        tiempoE.setRepeats(false);
        tiempoE.start();

    }

    private void mResultado(boolean victoria) {
        ventanap.dispose();

        new VentanaRCombate(victoria).setVisible(true);
    }

    /** Funcion terminar combate */

    public boolean Fcombate() {

        /** Condicion si vida del enemigo o el jugador es igual a 0 o se terminan todos los combates */

        if (!jugador.vivoono(jugador.vida) || !enemigo.vivoono(enemigo.vida)) {

            int nivela = jugador.nivel;

            if (!enemigo.vivoono(enemigo.vida)) {

                JOptionPane.showMessageDialog(null, "Felicidades has derrotado a " + enemigo.nombre);

                jugador.Gexp(enemigo.Darexp());
                Objeto recompensa = enemigo.darRecompensa();

                if(recompensa != null){
                    jugador.AggObjeto(recompensa);
                    JOptionPane.showMessageDialog(null, "Obtuviste " + recompensa.nombre);
                }
                
                jugador.subirnivel();

                enemigoa++;
                if (enemigoa < enemigos.size()) {

                    enemigo = enemigos.get(enemigoa);
                    jugador.Pcombate();
                    ventanap.nEnemigo(enemigo);
                    ventanap.ainfo();
                    TurnoJugador = true;
                    ventanap.CJugador();
                    ventanap.ActivarB();

                    if (jugador.nivel > nivela) {
                        JOptionPane.showMessageDialog(null, "Felicidades has subido al nivel " + jugador.toString());
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Has derrotado a todos los enemigos \n Batalla completada");
                    mResultado(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Has sido derrotado");
                mResultado(false);
            }
            return true;
        }

        return false;
    }

}
