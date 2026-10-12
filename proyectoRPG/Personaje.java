import javax.swing.JOptionPane;
public abstract class Personaje {
    protected String nombre;
    protected int vida;
    protected int vidamax;
    protected int mana;
    protected int manamax;
    protected int ataque;
    protected int ataquetem;
    protected int ataquemag;
    protected int ataquemagtem;
    protected int defensa;
    protected int defensatem;
    protected int nivel;
    protected int experiencia;

    /** Contructor abstract personaje */

    public Personaje(String nombre, int vida, int vidamax, int mana, int manamax, int ataque, int ataquemag, int defensa, int nivel, int experiencia){
        this.nombre = nombre;
        this.vida = vida;
        this.vidamax = vidamax;
        this.mana = mana;
        this.manamax = manamax;
        this.ataque = ataque;
        this.ataquemag = ataquemag;
        this.defensa = defensa;
        this.nivel = nivel;
        this.experiencia = experiencia;
    }

    /** estadisticas temporales y funciones de daño*/

    public void quitardefensatem(){
        defensatem = 0;
    }

    public void quitarataquetem(){
        ataquetem = 0;
    }

    public int atacar(){
        return ataque + ataquetem;
    }

    public int atacarmag(){
        return ataquemag + ataquemagtem;
    }

    public void quitarmagia(){
        ataquemagtem = 0;
    }

    /** Funcion daño final con respecto a la cantidad de defensa definida */

    public int recibirdanio(int damage){
        int fdefensa = defensa + defensatem;
        int fdamage = damage - fdefensa;

        if(fdamage < 0){
            fdamage = 0;
        }

        vida = vida - fdamage;

        if(vida <= 0){
            vida = 0;
        }

        return vida;
    }

    /** Función subir de nivel */

    public int subirnivel(){
        while(experiencia >= 100){
            experiencia = experiencia - 100;
            nivel = nivel + 1; 
            vidamax += 10;
            manamax += 15;
            ataque += 5;
            ataquemag += 15;
            defensa += 5;
        }

        return nivel;
    }

    /** Mensaje al subir de nivel */

    @Override
    public String toString(){
        return "Nombre:" + nombre + "\n" +
                "Vida: " + vida + " / " + vidamax + "\n" +
                "Mana: " + mana + " / " + manamax + "\n" +
                "Ataque: " + ataque + "\n" +
                "Ataque magico: " + ataquemag + "\n" +
                "Defensa: " + defensa + "\n" +
                "Nivel: " + nivel + "\n" + 
                "Experiencia: " + experiencia;

    }

    /** Funcion si vida es igual a 0 del enemigo o el jugador */

    public boolean vivoono(int vida){

        if(vida > 0){
            return true;
        } else{
            return false;
        }

    }

    /** Información de los personajes */
    
    public void minfo(){        
        JOptionPane.showMessageDialog(null, this.toString(), "Información del personaje", JOptionPane.INFORMATION_MESSAGE);

    }

}
