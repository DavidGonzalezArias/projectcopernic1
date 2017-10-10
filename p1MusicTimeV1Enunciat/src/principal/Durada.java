package principal;


import java.time.LocalTime;

/*
 * Classe que representa la durada d'un àudio. Una durada és un objecte de la
 * classe LocalTime que repesenta les hores, minuts i segons que dura l'àudio.
 */

/**
 *
 * @author fta
 */
public class Durada {
    private LocalTime durada;
    
     /*
     CONSTRUCTOR
     Paràmetres: valors per l'atribut de la classe.
     Accions:
     - Assignar a l'atribut el valor passats com a paràmetre
     */

    public Durada(LocalTime durada) {
        this.durada = durada;
    }

    /*
    Mètodes accessors    
     */
    
    public LocalTime getDurada(){
       return durada;
    }
        
    public void setDurada(LocalTime durada) {
        this.durada = durada;
    }

    /*
    Paràmetres: cap
    Accions: cap
    Retorn: les hores de l'atribut durada.
     */
    public int getHores() {
        return durada.getHour();
    }
    
    /*
     Paràmetres: cap
     Accions: cap
     Retorn: els minuts de l'atribut durada.
     */
    public int getMinuts(){
        return durada.getMinute();
    }
    
    /*
     Paràmetres: cap
     Accions: cap
     Retorn: els segons de l'atribut durada.
     */
    public int getSegons(){
        return durada.getSecond();
    }
    
    public String toString(){
        return getHores()+":"+getMinuts()+":"+getSegons();
    }
}
