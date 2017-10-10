package components;


import components.LlistatMusica;
import java.util.Scanner;




/*
 * Classe que representa un usuari registrat. Un usuari registrat s'identifica 
 * pel seu correu electrònic, la seva contrasenya i el llistats de música que ha
 * creat.
 */
/**
 *
 * @author fta
 */
public class UsuariRegistrat {

    private String correu;
    private String contrasenya;
    private LlistatMusica[] elsMeusLlistats;
    private int llistatActual;
    

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres
     - elsMeusLlistats s'ha d'inicialtizar buit i amb una capacitat per 20 àudios.
     - el llistatActual a la primera posició del vector elsMeusLlistats
     */
    
    
    public UsuariRegistrat() {
        this.correu = "buit";
        this.contrasenya = "buit";
        this.elsMeusLlistats = new LlistatMusica[20];
        this.llistatActual = 0;
    }

    public UsuariRegistrat(String correu, String contrasenya) {
        this.correu = correu;
        this.contrasenya = contrasenya;
        this.elsMeusLlistats = new LlistatMusica[20];
        this.llistatActual = 0;
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

    public LlistatMusica[] getElsMeusLlistats() {   
        return elsMeusLlistats;
    }

    public int getLlistatActual() {    
        return llistatActual;
    }

    public void setCorreu(String correu) {
        this.correu = correu;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public void setElsMeusLlistats(LlistatMusica[] elsMeusLlistats) {
        this.elsMeusLlistats = elsMeusLlistats;
    }

    public void setLlistatActual(int llistatActual) {
        this.llistatActual = llistatActual;
    }

    /*
    Paràmetres: cap
    Accions:
    - Demanar a l'usuari les dades per consola per crear un nou usuari. Les dades
    a demanar són les que necessita el constructor.
    Retorn: El nou usuari registrat creat.
     */
    public static UsuariRegistrat nouUsuariRegistrat() {
        
        String correu, contrasenya;
        Scanner in = new Scanner(System.in);
        
        System.out.print("Introdueix nou correu "); /*Introduir i desar dades*/
         correu = in.nextLine();
        System.out.print("Introdueix nova contrasenya ");
         contrasenya = in.nextLine();
        
         return new UsuariRegistrat(correu,contrasenya);
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
     i si aquesta coincideix amb la de l'usuari registrat actual, se li demana
     que introdueixi la nova i es modifica. Si no coincideix, s'avisa a l'usurai
     amb el missatge "La contrasenya no és correcta.".     
     Retorn: cap
     */
    public void modificarUsuariRegistrat() {
        String correu = "-";
        int opcio = -1;

        Scanner in = new Scanner (System.in);

           // mostrar atributs actualas
         //////¿ MODIFICAR ELS MEUS LLISTAT Y LLISTAT ACTUAL? Y se ha de mostrar?
        do
        {
        System.out.println("El seu correu...\n" + this.correu);

        System.out.println("Que voleu modificar...");

        System.out.println("n0 - Sortir...");
        System.out.println("n1 - Correu...");
        System.out.println("n2 - Contrasenya...");
        opcio = in.nextInt();
        in.nextLine();// limpiar buffer

        switch (opcio)
                {
                    case 0:
                        break;
                    case 1:
                        System.out.print("Nou correu?");
                        this.correu = in.next();
                        System.out.println("Dada modificada");
                        break;
                    case 2:
                        System.out.print("Introduiex contrasenya actual...");
                        if(in.next().equals(this.contrasenya))
                        {
                            System.out.print("Nova contrasenya... ");
                            this.contrasenya = in.next();
                            System.out.println("Dada modificada.");
                        }else
                        {
                            System.out.println("La contrasenya no és correcta.");
                        }
                        break;
                    default:
                         System.out.print("Selecciona un numero correcte");
                }
        }while(opcio!=0);
    }
    
    public void mostrarUsuariRegistrat() {
        // EXEMPLE?
        System.out.println("\n Els llistats de música de l'usuari registrat " + correu + " són:");
        for (int i = 0; i < llistatActual; i++) {
                elsMeusLlistats[i].mostrarLlistatMusica();
        }
        
        System.out.println("\nEl nom de l'administrador " + correu + " és:");
        
    }

    /*
     Paràmetres: llistat de música
     Accions:
     - afegeix el llistat de música passat per paràmetre al vector de llistats 
     de l'usuari registrat actual.
     - actaualitza la posició del vector de llistats de música.
     Retorn: cap
     */
    public void afegirLlistat(LlistatMusica[] ElsMeusLlistats) {
        
        this.elsMeusLlistats = ElsMeusLlistats;
        this.llistatActual++;
   
    }

    /*
     Paràmetres: nom del llistat de música
     Accions:
     - Cerca en el llistat de llistats de música de l'usuari registrat actual, el
       llistat amb el nom passat per paràmetre.
     - Si el nom passat per paràmetre és null (no li passem cap nom), li demanarem
       a l'usuari el nom del llistat que vol cercar.
     Retorn: -1 si no troba el llistat i la posició que ocupa dins el vector si el
              troba.
     */
    public int seleccionarLlistat(String nomLlistatMusica) {
        
        for(int i=0; i < elsMeusLlistats.length; i++)
        {
            if(nomLlistatMusica.equals(this.elsMeusLlistats[i].getNom()))

                return i;
        }
        return -1;
    }
}
