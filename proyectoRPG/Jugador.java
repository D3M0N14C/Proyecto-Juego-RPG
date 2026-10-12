import javax.swing.JOptionPane;

public class Jugador extends Personaje{

    Inventario inventario;
    IHabilidades habilidades;

    /** Constructor Jugador */

    public Jugador(String nombre, int vida, int vidamax, int mana, int manamax, int ataque, int ataquemag, int defensa, int nivel, int experiencia){
        super(nombre, vida, vidamax, mana, manamax, ataque, ataquemag, defensa, nivel, experiencia);

        inventario = new Inventario();
        habilidades = new IHabilidades();

    }

    /** Incluir objetos a inventario del personaje */

    public void AggObjeto(Objeto objeto){
        inventario.aggobjeto(objeto);
    }

    /** Uso de objetos segun el tipo especificado */

    public void UObjeto(Objeto objeto){
        switch(objeto.tipo){
            case "Ataque":
                ataquetem =  objeto.valor;
                break;
            case "Defensa":
                defensatem =  objeto.valor;
                break;
            case "Vida":
                vida = vida + objeto.valor;

                if(vida > vidamax){
                vida = vidamax;
                }
                break;
            case "Mana":
                mana = mana + objeto.valor;

                if(mana > manamax){
                    mana = manamax;
                }
                break;
        }
        inventario.borrarobjeto(objeto);
    }

    /** Incluir habilidades a inventario de habilidades del personaje */

    public void AggHabilidad(Habilidades newhabilidad){
        habilidades.agghabilidad(newhabilidad);
    }

    /** Uso de habilidades segun el tipo especificado y retorno de daño o curacion*/

    public int UHabilidades(Habilidades habilidad){
        int danio = 0;
        if(mana < habilidad.costomana){
            JOptionPane.showMessageDialog(null, "Maná insuficiente");
            return -1;
        }else if(mana >= habilidad.costomana){
            switch(habilidad.tipo){
            case "Ataque":
                ataquemagtem = habilidad.dano;
                danio = atacarmag();
                mana -= habilidad.costomana;
                break;
            case "Defensa":
                defensatem = habilidad.dano;
                mana -= habilidad.costomana;
                break;
            case "Vida":
                vida += habilidad.dano;
                if(vida > vidamax){
                    vida = vidamax;
                }
                mana -= habilidad.costomana;
                break;
            }
        }

        return danio;
        
    }

    /** Inventario de objetos */

    public void MInventario(){
        inventario.minfo();
    }

    /** Inventario de habilidades */

    public void MInventarioHab(){
        habilidades.minfo();
    }

    /** Metodo optencion de experienca personaje */

    public void Gexp(int exp){
        experiencia = experiencia + exp;
    }

    /** Reinicio de estadisticas temporales y vidas proximo turno de combate */

    public void Pcombate(){
        vida = vidamax;
        ataquetem = 0;
        ataquemagtem = 0;
        defensatem = 0;
    }

    
}
