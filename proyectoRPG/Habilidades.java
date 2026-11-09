import javax.swing.JOptionPane;

public class Habilidades implements MostrarI{

    String nombre;
    String tipo;
    int dano;
    int costomana;

    /** Constructor habilidades */

    public Habilidades(String nombre, String tipo, int dano, int costomana){
        this.nombre = nombre;
        this.tipo = tipo;
        this.dano = dano;
        this.costomana = costomana;
    }

    /** Mostrar información de cada habilidad */

    @Override
    public void minfo(){
        String informacion = "Nombre: " + nombre + "\n" + 
                            "Tipo: " + tipo + "\n" + 
                            "Daño: " + dano + "\n" +
                            "Valor: " + costomana;
        JOptionPane.showMessageDialog(null, informacion, "Informacion de objeto", JOptionPane.INFORMATION_MESSAGE);
    }


}
