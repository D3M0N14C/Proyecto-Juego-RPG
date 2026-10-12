import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        /** Inicio seguro de la interfaz grafica (evita posibles errores en el apartado visual) */
        SwingUtilities.invokeLater(() -> {
            PantallaInicio inicio = new PantallaInicio();
            inicio.setVisible(true);
        });
        
    }

    public void iniciarjuego(){

        /** Creacion de Array y enemigos */
        ArrayList<Enemigo> enemigos= new ArrayList<>();
        Jugador jugador1 = new Jugador("Heroe", 100, 100, 100, 100, 10, 10, 7, 1, 0);
        Enemigo enemigo1 = new Enemigo("Slime", 40, 40, 5, 5, 15, 0, 2, 1, 1, 50);
        Enemigo enemigo2 = new Enemigo("Goblin", 50, 50, 10, 10, 20, 0, 5, 3, 0, 50);
        Enemigo enemigo3 = new Enemigo("Orco", 90, 90, 15, 15, 35, 0, 10, 8, 0, 40);
        Enemigo enemigo4 = new Enemigo("Muerte", 105, 105, 5, 5, 40, 0, 20, 15, 0, 100);

        /** incluir enemigos en el Array */

        enemigos.add(enemigo1);
        enemigos.add(enemigo2);
        enemigos.add(enemigo3);
        enemigos.add(enemigo4);

        /** Creacion de objetos y habilidades */
        
        Objeto pocion = new Objeto("Poción", "Vida", 10);
        Objeto espada = new Objeto("Espada desgastada", "Ataque", 5);
        Objeto pocion_mana = new Objeto("Poción de mana", "Mana", 30);
        Habilidades fuego = new Habilidades("Bola de fuego", "Ataque", 20, 20);
        Habilidades curar = new Habilidades("Curar", "Vida", 15, 30);
        
        /** Incluir objetos y habilidades a inventarios */

        jugador1.AggObjeto(pocion);
        jugador1.AggObjeto(pocion);
        jugador1.AggObjeto(espada);
        jugador1.AggObjeto(pocion_mana);
        jugador1.AggHabilidad(fuego);
        jugador1.AggHabilidad(curar);

        /** inicio del programa */
        
        ICombate combate = new ICombate(jugador1, enemigos);
    }

}
