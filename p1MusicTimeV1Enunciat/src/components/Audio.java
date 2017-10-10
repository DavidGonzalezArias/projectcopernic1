package components;


import java.time.LocalTime;
import principal.Durada;
import java.util.Scanner;

/*
 * Classe que representa un àudio. Un àudio es defineix pel seu codi, nom, temps
 * de durada i el nom de l'arxiu que conté l'audio.
 */

/**
 *
 * @author fta
 */
public class Audio {

    private String codi;
    private String nom;
    private Durada durada;
    private String arxiu;

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres
    
     NOTA: Heu de tenir en compte quins paràmetres heu de passar al constructor per
     inicialitzar el paràmetre durada.
     */

    public Audio() {
    }

    public Audio(String codi, String nom, Durada durada, String arxiu) {
        this.codi = codi;
        this.nom = nom;
        this.durada = durada;
        this.arxiu = arxiu;
    }

    public String getCodi() {
        return codi;
        
    }

    public String getNom() {
        return nom;
    }

    public Durada getDurada() {
        return durada;
    }

    /*
    Mètodes accessors    
     */
    public String getArxiu() {
        return arxiu;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDurada(Durada durada) {
        this.durada = durada;
    }

    public void setArxiu(String arxiu) {
        this.arxiu = arxiu;
    }

    /*
    Paràmetres: cap
    Accions:
    - Demanar a l'usuari les dades per consola per crear un nou àudio. Les dades
    a demanar són les que necessita el constructor.
    - També heu de tenir en compte que el nom pot ser una frase, per exemple,
    "Escuela de calor".
    Retorn: El nou àudio creat.
     */
    public static Audio nouAudio() {
        
        Scanner in = new Scanner (System.in);
        Audio makeAudio = new Audio(); 
        System.out.println("Codi");
            makeAudio.setCodi(in.next());
        System.out.println("Nom");
            makeAudio.setNom(in.nextLine());
        System.out.println("Arxiu");
            makeAudio.setArxiu(in.nextLine());
        
        System.out.println("Durada");
        makeAudio.setDurada(new Durada("//"));
        
        
        //LocalT = in.nextInt();
        //Durada nuevo = new Durada(Durada.toString());        
        //LocalTime time = LocalTime.of(5, 30, 45, 35); //05:30:45:35
                
        //INTRODUCIR DURADA por consola    
            //makeAudio.setDurada(newDurada));

        return  makeAudio;
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
    
    public void modificarAudio(){
        
        Scanner in = new Scanner (System.in);
        //Mostrar atributs actuals
        mostrarAudio();
        int opcio ;
        System.out.println("Modificar Audio:");
        do
        {
            // MODIFICAR TODO??
            System.out.println("n0 - Sortir");
            System.out.println("n1 - Codi");
            System.out.println("n2 - Nom");
            System.out.println("n3 - Durada");
                //FALTA DURADA//////////
            System.out.println("n4 - Arxiu");
                
            opcio = in.nextInt();
            switch(opcio)
            {
                case 0:
                    break;
                case 1:
                    System.out.print("Nou Codi...");
                    this.codi = in.next();
                    break;
                case 2:
                    System.out.print("Nou nom...");
                    this.nom = in.nextLine();
                    break;
                case 3:
                    break;
                case 4:
                    System.out.print("Nou arxiu...");
                    this.arxiu = in.next();
                    break;
                default:
                    System.out.println("Escull una opcio correcta");
            }
            
        }while(opcio!=0);
        
    }
    
    public void mostrarAudio() {
        System.out.println("\nLes dades de l'àudio amb codi " + codi + " són:");
        System.out.println("\nNom:" + nom);
        System.out.println("\nArxiu:" + arxiu);
        System.out.println("\nDurada:" + durada);
    }
    

    public boolean equals(String pCodi){
        if(codi.equals(pCodi)){
            return true;
        }
        return false;
    }
}
