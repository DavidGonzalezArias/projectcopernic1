package components;

import principal.Aplicacio;
import components.Audio;
import java.util.Scanner;
import components.UsuariRegistrat;
/*
 * Classe que representa un llistat de música. Un llistat de música és una conjunt
 * d'àudios seleccionats per un usuari registrat i que s'identifiquen per un nom.
 */
/**
 *
 * @author fta
 */
public class LlistatMusica {
    private String nom;
    private Audio[] llistat;

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres. En el cas del
       nom, si ja existeix, li mostrem a l'usuari el missatge "El nom ja existeix"
       i no crearem el llistat d'àudio
     - El llistat s'ha d'inicialtizar buit i amb una capacitat per 100 àudios.
     */
    public LlistatMusica(String nom) {//se supone que hay que llamar a Usuariregistrat para saber de las demás listas?
     //   for (int i = 0; i < ; i++) {
     //   }
    
        // QUE LE DIGA QUE EL NOMBRE YA EXISTE?
        //COMO LISTO?
        this.nom = nom;
        this.llistat = new Audio[100];
    }
    /*
    Mètodes accessors    
     */
    public String getNom() {
        return nom;

    }

    public Audio[] getLlistat() {
        return llistat;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setLlistat(Audio[] llistat) {
        this.llistat = llistat;
    }

    /*
    Paràmetres: cap
    Accions:
    - Demanar a l'usuari les dades per consola per crear un nou llistat de música.
    Les dades a demanar són les que necessita el constructor.
    - Heu de tenir en compte que el nom pot ser una frase, per exemple,
    "Música per dormir".
    Retorn: El nou llistat creat.
     */
    public static LlistatMusica nouLlistatMusica() {

        Scanner in = new Scanner(System.in);
        String nom;
        System.out.print("Introdueix nom per al nou llistat: ");
        nom = in.nextLine();

        return new LlistatMusica(nom);
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte.
     - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte
     actual, abans de modificar-los
     Retorn: cap
     */
    public void modificarLlistatMusica() {
        String nom = "0";
        Scanner in = new Scanner(System.in);

        System.out.println("En cas de no voler modificar un valor apretar 'ENTER'");
        System.out.println("El nom  actual es " + this.nom);
        System.out.print("Introdueix nou nom ");
        nom = in.nextLine();
        if (!nom.equals("0")) {
            this.nom = nom;
        }

        
    }

    public void mostrarLlistatMusica() {
        System.out.println("\nEl contingut del llistat de música " + nom + " és: ");
        for (int i = 0; i < llistat.length; i++) {
            if (llistat[i] != null) {
                llistat[i].mostrarAudio();
            }
        }
    }

    /*
     Paràmetres: Audio
     Accions:
     - afegeix l'audio passat per paràmetre al vector llistat del llistat de música
       actual.
     - L'àudio s'ha d'afegir en el primer espai buit que trobeu en el vector de 
       pistes.
     - 
     Retorn: cap
     */
    public void afegirAudio(Audio[] llistat) {
    for (int i = 0; i < llistat.length; i++) {
        if(llistat[i] == null)
        {
        }
    }
    }
    

    /*
     Paràmetres: Audio
     Accions:
     - Treu l'audio passat per paràmetre del vector llistat del llistat de música
       actual.
     - La posició del vector llistat on es troba l'àudio, s'ha de substituir 
       per un null, és la manera com treiem l'àudio del llistat.
     - Si l'àudio no està en la llista, s'ha d'avisar a l'usuari amb el 
       missatge "L'àudio no està en el llistat".
     Retorneu: cap
     */
    public void treureAudio(Audio[] llistat) {

    }
}
