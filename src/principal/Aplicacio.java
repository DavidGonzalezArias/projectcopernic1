package principal;

import components.UsuariRegistrat;
import components.LlistatMusica;
import components.Audio;
import components.Album;
import components.Administrador;
import java.util.Scanner;

/*
 * Classe Aplicacio per interactuar amb l'usuari i cridar a la resta de classes 
 * i mètodes mitjançant uns menús.
 */
/**
 *
 * @author fta
 */
public class Aplicacio {

    private static Administrador[] administradors; //Adminstradors registrats
    private static int posicioActualAdmin = 0;
    public static UsuariRegistrat[] usuarisRegistrats; //Usuaris registrats
    private static int posicioActualUsuariR = 0;
    private static Album[] albums; //Albums creats
    private static int posicioActualAlbum = 0;
    private static Audio[] audios; //Audios creats
    private static int posicioActualAudio = 0;
    public static UsuariRegistrat usuariRegistratActual; //Usuari autenticat
    private static Administrador administradorActual; //Administrador autenticat

    public static void main(String[] args) {
        administradors = new Administrador[20];
        usuarisRegistrats = new UsuariRegistrat[100];
        albums = new Album[500];
        audios = new Audio[10000];
        //Creem el primer administrador necessari per donar d'alta als altres
        administradors[0] = new Administrador("0@0", "0", "0");
        posicioActualAdmin++;
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcio = 0;
        int pos;
        Scanner dades = new Scanner(System.in);
        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Registrar-se");
            System.out.println("\n2. Entrar");
            opcio = dades.nextInt();
            switch (opcio) {
                case 0:
                    // Salir
                    usuariRegistratActual = new UsuariRegistrat();
                    break;
                case 1:
                    usuarisRegistrats[posicioActualUsuariR] = UsuariRegistrat.nouUsuariRegistrat();
                    posicioActualUsuariR++;
                    break;
                case 2:
                    // Log in All
                    System.out.println("\nIntrodueix el teu correu:");
                    String correu = dades.next();
                    pos = seleccionarAdministrador(correu);
                    //Log in Admin
                    if (pos != -1) {
                        System.out.println("\nIntrodueix la teva contrasenya:");
                        if (dades.next().equals(administradors[pos].getContrasenya())) {
                            administradorActual = administradors[pos];
                            menuAdministrador();
                        } else {
                            System.out.println("\nLa teva contrasenya no és correcta.");
                        }
                        // Log in User    
                    } else {
                        pos = seleccionarUsuariRegistrat(correu);
                        if (pos != -1) {
                            System.out.println("\nIntrodueix la teva contrasenya:");
                            if (dades.next().equals(usuarisRegistrats[pos].getContrasenya())) {
                                usuariRegistratActual = usuarisRegistrats[pos];
                                menuUsuariRegistrat();
                            } else {
                                System.out.println("\nLa teva contrasenya no és correcta.");
                            }
                        } else {
                            System.out.println("\nEl correu no existeix");
                        }
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    /*
     Heu de desenvolupar el menú d'usuaris registrats amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, l'atribut usuariRegistratActual no és null
        
     Opció 0. Sortir -> Surt del menú i torna al menú principal. L'usuari ha de
     desautenticar-se.
     Opció 1. Modificar perfil -> Permet modificar l'usuari registrat autenticat
     Opció 2. Llistar usuaris registrats -> Imprimeix les dades dels usuaris registrats.
     Opció 3. Gestionar Llistats -> Accedeix al menú de llistats de música.
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi 
     l'opció 0 de sortida. Si no s'ha introduït cap opció de les de la llista, s'ha 
     de mostrar el missatge "S'ha de seleccionar una opció correcta del menú."
     
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, això ho controlarem
     més endavant.
     */
    public static void menuUsuariRegistrat() {
        Scanner dades = new Scanner(System.in);
        int opcio = -1;

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Modificar perfil");
            System.out.println("\n2. Llistar usuaris registrats");
            System.out.println("\n3. Gestionar Llistats");
            opcio = dades.nextInt();
            switch (opcio) {
                case 0:
                    usuariRegistratActual = new UsuariRegistrat();
                    menuPrincipal();
                    break;
                case 1:
                    //Permet modificar l'usuari registrat autenticat
                    usuariRegistratActual.modificarUsuariRegistrat();
                    break;
                case 2:
                    //Imprimeix les dades dels usuaris registrats.
                    //no hay una funcion que imprima los usuarios registrados,
                    //solo el usuario registrado..
                    usuariRegistratActual.mostrarUsuariRegistrat();
                    break;
                case 3:
                    //Accedeix al menú de llistats de música.
                    menuLListatsMusica();
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);

    }

    /*
     Heu de desenvolupar el menú d'administradors amb les opcions que podeu veure.
     Nota: penseu que quan arribem aquí, l'atribut administradorActual no és null
        
     Opció 0. Sortir -> Surt del menú i torna al menú principal. L'usuari ha de
     desautenticar-se.
     Opció 1. Modificar perfil -> Permet modificar l'administrador autenticat
     Opció 2. Alta d'adminstrador -> Permet crear un nou adminstrador i registrar-lo. 
     Penseu que la classe Administrador sap crear Administradors demanat les dades 
     a l'usuari.
     Opció 3. Llistar Adminstradors -> Imprimeix les dades dels adminstradors registrats.
     Opció 4. Gestionar Àudios -> Accedeix al menú d'àudios
     Opció 2. Gestionar Albums -> Accedeix al menú d'albums.
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi 
     l'opció 0 de sortida. Si no s'ha introduït cap opció de les de la llista, s'ha 
     de mostrar el missatge "S'ha de seleccionar una opció correcta del menú."
     
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, això ho controlarem
     més endavant.
     */
    public static void menuAdministrador() {
        Scanner dades = new Scanner(System.in);
        int opcio = -1;

        do {
            System.out.println("\nSelecciona una opció\n");
            System.out.println("\n0. Sortir - Log out");
            System.out.println("\n1. Modificar perfil");
            System.out.println("\n2. Alta d'adminstrador ");
            System.out.println("\n3. Llistar Adminstradors ");
            System.out.println("\n4. Gestionar Àudios ");
            System.out.println("\n5. Gestionar Albums ");
            opcio = dades.nextInt();
            switch (opcio) {
                case 0:
                    administradorActual = new Administrador();
                    menuPrincipal();
                    break;
                case 1:
                    //Permet modificar l'usuari registrat autenticat
                    administradorActual.modificarAdministrador();
                    break;
                case 2:
                    administradorActual.nouAdministrador();
                    break;
                case 3:

                    administradorActual.mostrarAdministrador();
                    break;
                case 4:
                    menuAudios();
                    break;
                case 5:
                    menuAlbums();
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    /*
     Heu de desenvolupar el menú de llistats de música amb les opcions que podeu veure.
        
     Opció 0. Sortir -> Surt del menú i torna al menú d'usuaris registrats.
     Opció 1. Crear -> Permet crear un nou llistat de música i afegir-lo als
     llistats de música de l'usuari autenticat.
     Opció 2. Modificar -> Permet modificar un dels llistats de l'usuari registrat 
     autenticat. Per seleccionar quin llistat volem modificar teniu un mètode en 
     aquesta classe que us ajudarà.
     Opció 3. Afegir àudio -> Afegeix un audio al llistat de música seleccionat del
     usuari registrat autenticat. Per seleccionar quin àudio volem afegir teniu un mètode en 
     aquesta classe que us ajudarà, igual que per seleccionar el llistat de música.
     Opció 4. Treure àudio -> Treu un audio del llistat de música seleccionat del
     usuari registrat autenticat. Com abans, per seleccionar l'àudio i el llistat
     teniu els  mètodes d'aquesta classe que us ajudaran.
     Opció 5. Llistar llistats -> Imprimeis les dades dels llistats de m´usica de l'usuari
     registrat autenticat.
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi 
     l'opció 0 de sortida. Si no s'ha introduït cap opció de les de la llista, s'ha 
     de mostrar el missatge "S'ha de seleccionar una opció correcta del menú."
     
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, això ho controlarem
     més endavant.
     */
    public static void menuLListatsMusica() {
        Scanner dades = new Scanner(System.in);
        int opcio = -1;
        int opcioLlistat = -1;

        do {
            System.out.println("\nSelecciona una opció\n");
            System.out.println("\n0. Sortir - Log out");
            System.out.println("\n1. Modificar perfil");
            System.out.println("\n2. Alta d'adminstrador ");
            System.out.println("\n3. Llistar Adminstradors ");
            System.out.println("\n4. Gestionar Àudios ");
            System.out.println("\n5. Gestionar Albums ");
            opcio = dades.nextInt();
            switch (opcio) {
                case 0:
                    administradorActual = new Administrador();
                    break;
                case 1:
                    //Permet modificar l'usuari registrat autenticat
                    administradorActual.modificarAdministrador();
                    break;
                case 2:

                    administradorActual.nouAdministrador();
                    break;
                case 3:

                    administradorActual.mostrarAdministrador();
                    break;
                case 4:
                    menuAudios();
                    break;
                case 5:
                    menuAlbums();
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");

            }
        } while (opcio != 0);
    }

    /*
     Heu de desenvolupar el menú d'àudios amb les opcions que podeu veure.
        
     Opció 0. Sortir -> Surt del menú i torna al menú d'administradors.
     Opció 1. Nou àudio -> Permet crear un nou àudio i afegir-lo a la posició actual 
     del vector d'àudios de l'aplicació.
     Opció 2. Modificar -> Permet modificar un àudio de l'aplicació. Per seleccionar 
     quin àudio volem modificar teniu un mètode en aquesta classe que us ajudarà.
     Opció 3. Llistar audios -> Imprimeix les dades dels àudios de l'aplicació.
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi 
     l'opció 0 de sortida. Si no s'ha introduït cap opció de les de la llista, s'ha 
     de mostrar el missatge "S'ha de seleccionar una opció correcta del menú."
     
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, això ho controlarem
     més endavant.
     */
    public static void menuAudios() {
        Scanner dades = new Scanner(System.in);
        int opcio = -1;

        do {

            System.out.println("\n Menu Audios\n");
            System.out.println("\nSelecciona una opció\n");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Nou àudio ");
            System.out.println("\n2. Modificar ");
            System.out.println("\n3. Llistar audios ");

            opcio = dades.nextInt();
            switch (opcio) {
                case 0:
                    menuAdministrador();
                    break;
                case 1:/*Permet crear un nou àudio i afegir-lo a la posició actual 
     del vector d'àudios de l'aplicació.
                     */
                    audios[posicioActualAudio].nouAudio();
                    break;
                case 2:/*Permet modificar un àudio de l'aplicació. Per seleccionar 
     quin àudio volem modificar teniu un mètode en aquesta classe que us ajudarà.*/

                    audios[seleccionarAudio()].modificarAudio();
                    break;
                case 3:
                    for (int i = 0; i < posicioActualAudio; i++) {
                        audios[i].mostrarAudio();
                    }
                    //Imprimir Audios de App
                    break;

                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");

            }
        } while (opcio != 0);

    }

    /*
     Heu de desenvolupar el menú d'àlbums amb les opcions que podeu veure.
        
     Opció 0. Sortir -> Surt del menú i torna al menú d'administradors.
     Opció 1. Nou àlbum -> Permet crear un nou àlbum i afegir-lo a la posició actual 
     del vector d'àlbums de l'aplicació.
     Opció 2. Modificar -> Permet modificar un àlbum de l'aplicació. Per seleccionar 
     quin àlbum volem modificar teniu un mètode en aquesta classe que us ajudarà.
     Opció 3. Llistar albums -> Imprimeix les dades dels àlbums de l'aplicació.
     Opció 4. Afegir pista -> Afegeix un audio al àlbum seleccionat de l'aplicació.
     Per seleccionar quin àudio volem afegir teniu un mètode en aquesta classe que 
     us ajudarà, igual que per seleccionar l'àlbum.
        
     A més, heu de fer un bucle per tornar a mostrar el menú sempre que no es premi 
     l'opció 0 de sortida. Si no s'ha introduït cap opció de les de la llista, s'ha 
     de mostrar el missatge "S'ha de seleccionar una opció correcta del menú."
     
     Nota important: 
     no controlem que l'usuari introdueixi una opció numèrica, això ho controlarem
     més endavant.
     */
    public static void menuAlbums() {
        Scanner dades = new Scanner(System.in);
        int opcio = -1;

        do {

            System.out.println("\n Menu Albums\n");
            System.out.println("\nSelecciona una opció\n");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Nou àlbum ");
            System.out.println("\n2. Modificar àlbum ");
            System.out.println("\n3. Llistar albums ");
            System.out.println("\n4. Afegir pista");

            opcio = dades.nextInt();
            switch (opcio) {
                case 0:
                    menuAdministrador();
                    break;
                case 1:/*Permet crear un nou àlbum i afegir-lo a la posició actual 
     del vector d'àlbums de l'aplicació.
                     */
                    albums[posicioActualAlbum].nouAlbum();
                    break;
                case 2:/*Permet modificar un àlbum de l'aplicació. Per seleccionar 
     quin àlbum volem modificar teniu un mètode en aquesta classe que us ajudarà..*/

                    albums[seleccionarAlbum()].modificarAlbum();
                    break;
                case 3:
                    //Imprimeix les dades dels àlbums de l'aplicació.
                    for (int i = 0; i < posicioActualAlbum; i++) {
                        albums[i].mostrarAlbum();
                    }

                    break;
                case 4:/*Afegeix un audio al àlbum seleccionat de l'aplicació.
     Per seleccionar quin àudio volem afegir teniu un mètode en aquesta classe que 
     us ajudarà, igual que per seleccionar l'àlbum.*/
                    seleccionarAudio();
                    seleccionarAlbum();

                    break;

                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");

            }
        } while (opcio != 0);

    }

    public static int seleccionarAdministrador(String correu) {
        boolean trobat = false;
        int pos = -1;
        for (int i = 0; i < posicioActualAdmin && !trobat; i++) {
            if (administradors[i].getCorreu().equals(correu)) {
                pos = i;
                trobat = true;
            }
        }
        return pos;
    }

    public static int seleccionarUsuariRegistrat(String correu) {
        boolean trobat = false;
        int pos = -1;
        for (int i = 0; i < posicioActualUsuariR && !trobat; i++) {
            if (usuarisRegistrats[i].getCorreu().equals(correu)) {
                pos = i;
                trobat = true;
            }
        }
        return pos;
    }

    public static int seleccionarAlbum() {
        Scanner dades = new Scanner(System.in);
        boolean trobat = false;
        System.out.println("\nIntrodueix el codi de l'àlbum:");
        String codi = dades.next();
        int pos = -1;
        for (int i = 0; i < posicioActualAlbum && !trobat; i++) {
            if (albums[i].getCodi().equals(codi)) {
                pos = i;
                trobat = true;
            }
        }
        return pos;
    }

    public static int seleccionarAudio() {
        Scanner dades = new Scanner(System.in);
        boolean trobat = false;
        System.out.println("\nIntrodueix el codi de l'àudio:");
        String codi = dades.next();
        int pos = -1;
        for (int i = 0; i < posicioActualAudio && !trobat; i++) {
            if (audios[i].getCodi().equals(codi)) {
                pos = i;
                trobat = true;
            }
        }
        return pos;
    }
}
