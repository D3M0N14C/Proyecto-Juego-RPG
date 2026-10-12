import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Inventario {
    ArrayList<Objeto> inventario;

    /** Constructor inventario */

    public Inventario(){
        inventario = new ArrayList<>();
    }

    /** Añadir, usar y eliminar objeto del inventario */

    public void aggobjeto(Objeto objeto){
        inventario.add(objeto);
    }

    public Objeto obtenerObjeto(int pos){
        return inventario.get(pos);
    }

    public void borrarobjeto(Objeto objeto){
        inventario.remove(objeto);
    }

    /** Mostrar información del objeto */

    public void minfo(){
        String informacion = "";
        for(Objeto objeto : inventario){
            informacion = informacion + "Nombre: " + objeto.nombre + "\n" + 
            "Tipo: " + objeto.tipo + "\n" + 
            "Valor: " + objeto.valor + "\n" + 
            "---------------------------------- \n"; 
        }

        JOptionPane.showMessageDialog(null, informacion, "Inventario", JOptionPane.INFORMATION_MESSAGE);
        
    }
}
