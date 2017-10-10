package components;

import java.util.Scanner;

/*
 * Classe que representa un administrador. Un usuari administrador s'identifica 
 * pel seu correu electrònic i la seva contrasenya.
 */
/**
 *
 * @author fta
 */
public class Administrador {

    private String correu;
    private String contrasenya;
    private String nom;

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats
     - Assignar als com a paràmetres
     */
    public Administrador() {/*constructor sobrecarregat*/
    }

    public Administrador(String correu, String contrasenya, String nom) {
        /*constructor sobrecarregat*/
        this.correu = correu;
        this.contrasenya = contrasenya;
        this.nom = nom;
    }

    /*
     Mètodes accessors    
     */
    public String getCorreu() {
        return correu;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public String getNom() {
        return nom;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou administrador. 
       Les dades a demanar són les que necessita el constructor.
     - Heu de tenir en compte que el nom pot ser una frase, per exemple,
       "Josep García".
    
     Retorn: El nou administrador creat.
     */
    public static Administrador nouAdministrador() {

        String correu, contrasenya, nom;
        Scanner in = new Scanner(System.in);

        System.out.print("Introdueix nou correu ");
        /*Introduir datos
                                                      como pone en el enunciado de arriba hay que utilizar el next line
                                                        ya que el next unicamente lee hasta el proximo espacio*/
        correu = in.nextLine();
        System.out.print("Introdueix nova contrasenya ");
        contrasenya = in.nextLine();
        System.out.print("Introdueix nou nom ");
        nom = in.nextLine();

        return new Administrador(correu, contrasenya, nom);
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari que introdueixi les noves dades de l'objecte actual
     i modificar els atributs corresponents d'aquest objecte.
    - Li heu de mostrar a l'usuari el valor actual dels atributs de l'objecte
     actual, abans de modificar-los
     - En el cas de la contrasenya, per qüestions de seguretat, se li ha de demanar
     a l'usuari que introdueixi l'antiga contrasenya, és a dir, la que vol modificar,
     i si aquesta coincideix amb la de l'administrador actual, se li demana
     que introdueixi la nova i es modifica. Si no coincideix, s'avisa a l'usurai
     amb el missatge "La contrasenya no és correcta.".     
     Retorn: cap
     */
    public void modificarAdministrador() {
        String correu = "0", nom = "0";
        String verContrasenya = "0";
        Scanner in = new Scanner(System.in);

        System.out.println("En cas de no voler modificar un valor apretar 'ENTER'");
        System.out.println("El nom  actual es " + this.nom);
        System.out.print("Introdueix nou nom ");
        nom = in.nextLine();
        if (!nom.equals("0")) {
            this.nom = nom;
        }

        System.out.println("El nom  actual es " + this.correu);
        System.out.print("Introdueix nou nom");
        nom = in.nextLine();
        if (!nom.equals("0")) {
            this.nom = nom;
        }

        System.out.print("Introdueix la contrasenya actual ");
        verContrasenya = in.nextLine();
        if (!verContrasenya.equals("0")) {
            if (this.contrasenya.equals(verContrasenya)) {
                System.out.print("Introdueix la nova contrasenya ");
                this.contrasenya = in.nextLine();
            } else {
                System.out.print("La contrasenya no és correcta.");
            }
        }

    }

    public void mostrarAdministrador() {
        System.out.println("\nEl nom de l'administrador " + correu + " és:");
        System.out.println("\nNom:" + nom);
    }

}
