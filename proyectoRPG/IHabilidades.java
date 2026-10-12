import java.util.ArrayList;
import javax.swing.JOptionPane;

public class IHabilidades {

    ArrayList<Habilidades> inventariohab;

    /** Constructor inventario de habilidades */

    public IHabilidades(){
        inventariohab = new ArrayList<>();
    }

    /** Añadir y usar habilidades asignadas */

    public void agghabilidad(Habilidades habilidad){
        inventariohab.add(habilidad);
    }

    public Habilidades obtenerhab(int pos){
        return inventariohab.get(pos);
    }

    /** Mostrar información de las habilidades */

    public void minfo(){
        String informacion = "";
        for(Habilidades habilidad : inventariohab){
            informacion = informacion + "Nombre: " + habilidad.nombre + "\n" +
            "Tipo: " + habilidad.tipo + "\n" +
            "Daño: " + habilidad.dano + "\n" +
            "Costo de mana:" + habilidad.costomana + "\n" +
            "---------------------------------- \n";
        }

        JOptionPane.showMessageDialog(null, informacion, "Habilidades", JOptionPane.INFORMATION_MESSAGE);
    }

}
