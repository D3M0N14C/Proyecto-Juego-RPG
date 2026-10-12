public class Enemigo extends Personaje{

    int Darexp;

    /** Constructor enemigo*/

    public Enemigo(String nombre, int vida, int vidamax, int mana, int manamax, int ataque, int ataquemag, int defensa, int nivel, int experiencia, int Darexp){
        super(nombre, vida, vidamax, mana, manamax, ataque, ataquemag, defensa, nivel, experiencia);

        this.Darexp = Darexp;
        
    }

    /** Funcion dar experiencia */

    public int Darexp(){
        return Darexp;
    }

}
