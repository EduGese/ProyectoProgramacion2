package proyectoprogramacion;

/**
 *
 * @author Edu
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Programa {


    public static void main(String[] args) throws IOException {
       
        ArrayList listaDePublicaciones = new ArrayList<>();

        Scanner leer = new Scanner(System.in);
        FBinario.leerBin(listaDePublicaciones);

        /*//////////////////////////////////////////////////////////////////////////////////////////////////////////////////*/
        int entrada = 0;
        System.out.println("");
        System.out.println("Bienvenido a Edu's Virtual Library");
        System.out.println("");
        do {

            System.out.println("-----------------MENU PRINCIPAL------------------");
            System.out.println("");
            System.out.println("[1] Dar de alta una publicacion\n"
                    + "[2] Dar de baja una publicacion\n"
                    + "[3] Modificar una publicacion\n" + "[4] Consultar publicaciones\n"
                    + "[5] Salir del programa");

           
            int ultimaopcion = 5;
            int menu = Bibliotecario.recogerOP(ultimaopcion);
            switch (menu) {
                case 1:
                    int n = 0;
                   
                    System.out.println("");
                    System.out.println("          ->MENU ALTA PUBLICACIÓN<-");
                    System.out.println("");
                    System.out.println("[1] Introducir un libro \n"
                            + "[2] Introducir una revista\n"
                            + "[3] Volver al menú principal");
                    ultimaopcion = 3;
                    int submenu1 = Bibliotecario.recogerOP(ultimaopcion);
                    switch (submenu1) {
                        case 1:
                            System.out.println("");
                            System.out.println("Introduzca un libro a la base de datos");
                            Bibliotecario.altaLibro(listaDePublicaciones);//METODO QUE INTRODUCE UN LIBRO                              
                           
                            break;
                        case 2:

                            System.out.println("Introduzca una revista a la base de datos");
                            Bibliotecario.altaRevista(listaDePublicaciones);//METODO QUE INTRODUCE UNA REVISTA
                         
                            break;
                        case 3:
                            break;
                    }                  
                    break;
                case 2:
                    System.out.println("          ->MENU BAJA PUBLICACIÓN<-");
                    System.out.println("");
                    System.out.println("Introduzca un codigo");
                    
                    String codigo = leer.nextLine();
                    Bibliotecario.bajaPublicacion(listaDePublicaciones, codigo);

                    break;
                case 3:
                    System.out.println("          ->MENU MODIFICACIÓN PUBLICACIÓN<-");
                    System.out.println("");

                    System.out.println("Introduzca el codigo de la publicacion que desea modificar");
                   
                    String codigo1 = leer.nextLine();
                    Bibliotecario.editarPublicacion(listaDePublicaciones, codigo1);

                    break;
                case 4:
                    System.out.println("          ->MENU CONSULTA PUBLICACIONES<-");
                    System.out.println("");
                    System.out.println("[1] Consultar todas las publicaciones\n"
                            + "[2] Relación de publicaciones por título\n"
                            + "[3] Volver al menú principal");
                    System.out.println("");
                    ultimaopcion = 3;
                    int submenu2 = Bibliotecario.recogerOP(ultimaopcion);
                    switch (submenu2) {
                        case 1:
                            System.out.println("          --Todas las publicaciones (ordenadas por código)--");
                            System.out.println("");
                            Publicacion.imprimirPublicaciones(listaDePublicaciones);
                            System.out.println("");
                            break;
                        case 2:
                            System.out.println("");
                          
                            Bibliotecario.publicacionesPorTitulo(listaDePublicaciones);
                            System.out.println("");
                            break;
                        case 3:
                            break;
                    }
                    break;
                case 5:
                    System.out.println("");
                    System.out.println("Saliendo...");
                    entrada = 5;
                    break;
            }

        } while (entrada != 5);
        FBinario.archivarBin(listaDePublicaciones);//SE sobreescribe al salir del programa
    }
}
