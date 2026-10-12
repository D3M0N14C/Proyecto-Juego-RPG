import javax.swing.JOptionPane;

public class Objeto {

    String nombre;
    String tipo;
    int valor;

    /** Constructor objeto */

    public Objeto(String nombre, String tipo, int valor){
        this.nombre = nombre;
        this.tipo = tipo;
        this.valor = valor;
    }

    /** Información objetos */

    public void minfo(){
        String informacion = "Nombre: " + nombre + "\n" + 
                            "Tipo: " + tipo + "\n" + 
                            "Valor: " + valor;
        JOptionPane.showMessageDialog(null, informacion, "Informacion de objeto", JOptionPane.INFORMATION_MESSAGE);
    }

}
