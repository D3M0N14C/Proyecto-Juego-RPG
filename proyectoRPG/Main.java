import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        /** Inicio seguro de la interfaz grafica (evita posibles errores en el apartado visual) */
        SwingUtilities.invokeLater(() -> {
            PantallaInicio inicio = new PantallaInicio();
            inicio.setVisible(true);
        });
        
    }

    

}
