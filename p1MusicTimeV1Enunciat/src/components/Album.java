package components;

import components.Audio;
import java.util.Scanner;


/*
 * Classe que representa un àlbum. Un àlbum es defineix pel seu codi, nom, autor,
 * el nom de l'arxiu que conté la imatge de la portada de l'album, l'any de publicació, 
 * l'estíl i un conjunt d'àudios.
 */
/**
 *
 * @author fta
 */
public class Album {

    private String codi;
    private String nom;
    private String autor;
    private String imatge;
    private int anyPubli;
    private String estil;
    private Audio[] pistes; //Pistes d'audio que formen un àlbum

    /*
     CONSTRUCTOR
     Paràmetres: valors per tots els atributs de la classe.
     Accions:
     - Assignar als atributs els valors passats com a paràmetres
     - El vector pistes s'ha d'inicialtizar buit i amb una capacitat per 40 àudios.
     */
    //constructor buit
    public Album(String codi, String nom, String autor, String imatge, int anyPubli, String estil) {
        this.codi = codi;
        this.nom = nom;
        this.autor = autor;
        this.imatge = imatge;
        this.anyPubli = anyPubli;
        this.estil = estil;
        this.pistes = new Audio[40];
    }


    /*
     Mètodes accessors    
     */
    public String getCodi() {
        return codi;
    }

    public String getNom() {
        return nom;
    }

    public String getAutor() {
        return autor;
    }

    public String getImatge() {
        return imatge;
    }

    public int getAnyPubli() {
        return anyPubli;
    }

    public String getEstil() {
        return estil;
    }

    public Audio[] getPistes() {
        return pistes;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setImatge(String imatge) {
        this.imatge = imatge;
    }

    public void setAnyPubli(int anyPubli) {
        this.anyPubli = anyPubli;
    }

    public void setEstil(String estil) {
        this.estil = estil;
    }

    public void setPistes(Audio[] pistes) {
        this.pistes = pistes;
    }

    /*
     Paràmetres: cap
     Accions:
     - Demanar a l'usuari les dades per consola per crear un nou àlbum. Les dades
       a demanar són les que necessita el constructor.
     - També heu de tenir en compte que tant el nom com l'autor i l'estil, 
       poden ser frases, per exemple, "La canción de Juan Perro", "Radio Futura"
       i "Pop espanyol".
    
     Retorn: El nou àlbum creat.
     */
    public static Album nouAlbum() {
        Scanner in = new Scanner(System.in);

        System.out.println("Crear nou Album\n");
        String codi, nom, autor, imatge, estil;
        int anyPubli;
        Audio[] pistes;

        System.out.print("Nou codi.........");
        codi = in.next();
        System.out.print("Nou nom..........");
        nom = in.nextLine();
        System.out.print("Nou Autor........");
        autor = in.nextLine();
        System.out.print("Nova imatge......");
        imatge = in.nextLine();
        System.out.print("Nou estil........");
        estil = in.nextLine();
        //System.out.print("Noves pistes.....");//
        System.out.print("Any publicacio...");
        anyPubli = in.nextInt();
        return new Album(codi, nom, autor, imatge, anyPubli, estil);
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
    public void modificarAlbum() {
        mostrarAlbum();

        Scanner in = new Scanner(System.in);
        int opcio;

        do {
            System.out.println("Modificar Album\n");
            System.out.print("n0 - Sortir.........");
            System.out.print("n1 - Nou Codi.........");
            System.out.print("n2 -  Nou Nom..........");
            nom = in.nextLine();
            System.out.print("n3 - Nou Autor........");
            System.out.print("n4 - Nova Imatge......");
            System.out.print("n5 - Nou Estil........");
            //System.out.print("Noves pistes.....");//
            System.out.print("n6 - Any Publicacio...");
            mostrarAlbum();
            opcio = in.nextInt();

            switch (opcio) {
                case 0:

                    break;
                case 1:
                    System.out.print("El codi anterior es " + this.codi + "Nou codi... ");
                    this.codi = in.next();
                    break;
                case 2:
                    System.out.print("El nom anterior es " + this.nom + "Nou nom... ");
                    this.nom = in.nextLine();

                    break;
                case 3:
                    System.out.print("L'autor anterior es " + this.autor + "Nou autor... ");
                    this.autor = in.nextLine();
                    break;
                case 4:
                    System.out.print("L'imatge anterior es " + this.imatge + "Nova imatge... ");
                    this.imatge = in.next();

                    break;
                case 5:
                    System.out.print("L'estil anterior es " + this.estil + "Nou estil... ");
                    this.estil = in.nextLine();

                    break;
                case 6:
                    System.out.print("L'any anterior es" + this.anyPubli + "Nou any... ");
                    this.anyPubli = in.nextInt();
                    break;
                default:
                    System.out.println("Escull una opcio correcta");
            }
        } while (opcio != 0);

    }

    public void mostrarAlbum() {
        System.out.println("\nLes dades de l'àlbum amb codi " + codi + " són:");
        System.out.println("\nNom:" + nom);
        System.out.println("\nAutor:" + autor);
        System.out.println("\nAny publicació:" + anyPubli);
        System.out.println("\nEstil:" + estil);
        System.out.println("\nPistes:");
        for (int i = 0; i < pistes.length; i++) {
            if (pistes[i] != null) {
                pistes[i].mostrarAudio();
            }
        }
    }

    /*
     Paràmetres: Audio
     Accions:
     - afegeix l'audio passat per paràmetre al vector de pistes de l'àlbum actual
     - Heu de modificar el codi de l'àudio abans d'afegir-lo al vector de pistes,
       modificant els tres primers 0 pel codi de l'àlbum on s'ha d'afegir. Heu de
       fer servir els mètodes de JAVA per treballar amb Strings.
     - L'àudio s'ha d'afegir en el primer espai buit que trobeu en el vector de 
       pistes.
     - Si l'audio ja està assignat a un àlbum, s'ha d'avisar a l'usuari amb el 
       missatge "L'àudio ja està assignat a un àlbum" i no assignar-lo.
     Retorneu: cap
     */
    public void afegirAudio(Audio[] pistes) {
        String newCodi = "-";
        for (int i = 0; i < 40; i++) {
            //Str.substring(inicio: int, final : int) 
            if ((pistes[i].getCodi().substring(0, 2).equals("000")) && !(pistes[i].getCodi().substring(0, 2).equals(this.nom.toUpperCase().substring(0, 2)))) {//la comparación hay que hacerla de otra manera, puede que esté todo mal y solo haya que introducir una unica vez y comprar todo para saber si ya existe
                newCodi = this.nom.toUpperCase().substring(0, 2)
                        + pistes[i].getCodi().substring(3);
                pistes[i].setCodi(newCodi);
            } else {
                System.out.println("L'àudio ja està assignat a un àlbum");
            }
        }

        this.pistes = pistes;

    }

    /*
     Paràmetres: Audio
     Accions:
     - Treu l'audio passat per paràmetre del vector de pistes de l'àlbum actual.
     - La posició del vector de pistes on es troba l'àudio, s'ha de substituir 
       per un null, és la manera com treiem l'àudio del vector de pistes.
     - Un cop tret l'àudio, heu de modificar el codi de l'àudio modificant la part
       del codi que fa refèrencia a l'àlbum, per tres 0. Heu de fer servir els 
       mètodes de JAVA per treballar amb Strings.
     - Si l'àudio no està assignat a l'àlbum, s'ha d'avisar a l'usuari amb el 
       missatge "L'àudio no està assignat a aquest àlbum".
     Retorneu: cap
     */
    public void treureAudio(Audio[] llistat) {
        
    }
}
