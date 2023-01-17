package proyectoprogramacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Edu
 */
public class Bibliotecario {
    
     static void altaLibro(ArrayList listaDePublicaciones) {
        Scanner leer = new Scanner(System.in);
        int repetir=0;
         do {             
            System.out.println("Codigo:");
        String codigo = leer.nextLine();
        boolean check = false;

        for (Object listaDePublicacione : listaDePublicaciones) {
            Publicacion p = (Publicacion) listaDePublicacione;

            if (p.getCodigo().equalsIgnoreCase(codigo)) {//Compara los dos strings
                check = true;
            }
            
        }
        if (check == false) {
                        
            System.out.println("Título:");
            String titulo = leer.nextLine();
            
            System.out.println("Año de publicación:");
            int anno;
            do {//Funcion del bucle-->No sale mientras no se introduzca un valor numerico                
                  anno=recogerNumero();//METODO QUE MANEJA EXCEPCION EN EL CASO DE INTRODUCIR STRING (Devuelve -1 si se mete en el Catch;Asi se mantiene en el bucle do While hasta se introduzca un numero)                            
            } while (anno==-1);
         
            
            String codigo2=codigo;
            
            listaDePublicaciones.add(new Libro(codigo2, titulo, anno));
            System.out.println("## Libro añadido ##");
            System.out.println("");
            repetir=-1;

        } else {
            System.out.println("");
            System.out.println("## Una publicación ya tiene este código ## \n"
                    + "## Tiene que introducir un código no existente en la base de datos ##");
            System.out.println("");
        } 
         } while (repetir!=-1);
        

    }
     static void altaRevista(ArrayList listaDePublicaciones) {
        Scanner leer = new Scanner(System.in);
        int repetir=0;
        do {            
           System.out.println("Codigo:");
        String codigo = leer.nextLine();
        boolean check = false;

        for (Object listaDePublicacione : listaDePublicaciones) {
            Publicacion p = (Publicacion) listaDePublicacione;

            if (p.getCodigo().equalsIgnoreCase(codigo)) {//Compara los dos strings(Ignorando mayusculas)
                check = true;
            }
            
        }
            if (check == false) {

                System.out.println("Título:");
                String titulo = leer.nextLine();

                System.out.println("Año de publicación:");
                int anno;
                do {//Funcion del bucle-->No sale mientras no se introduzca un valor numerico
                    anno = recogerNumero();//METODO QUE MANEJA EXCEPCION EN EL CASO DE INTRODUCIR STRING (Devuelve -1 si se mete en el Catch;Asi se mantiene en el bucle do While hasta se introduzca un numero)                                   
                } while (anno == -1);

                System.out.println("Numero");
                 int numero;
                do {//Funcion del bucle-->No sale mientras no se introduzca un valor numerico
                    numero = recogerNumero();//METODO QUE MANEJA EXCEPCION EN EL CASO DE INTRODUCIR STRING (Devuelve -1 si se mete en el Catch;Asi se mantiene en el bucle do While hasta se introduzca un numero)                 
                } while (numero == -1);

                listaDePublicaciones.add(new Revista(codigo, titulo, anno, numero));
                System.out.println("## Revista añadida ##");
                System.out.println("");
                repetir = -1;

        } else {
             System.out.println("");
            System.out.println("## Una publicación ya tiene este código ## \n"
                    + "## Tiene que introducir un código no existente en la base de datos ##");
            System.out.println("");
        }  
        } while (repetir!=-1);
       

    }
     static void bajaPublicacion(ArrayList listaDePublicaciones, String codigo) {
        boolean check=true;
        
        for (int i = 0; i < listaDePublicaciones.size(); i++) {//FOR ORDINARIO, con el for mejorado salta la excepcion-->"java.util.ConcurrentModificationException" porque no deja borrar elementos mientras se recorre 
            Publicacion p=(Publicacion)listaDePublicaciones.get( i );
            if (p.getCodigo().equalsIgnoreCase(codigo)) { //Compara el el parametro codigo con el atributo codigo de la clase Publicacion
               listaDePublicaciones.remove(p);
                System.out.println("## Publicación encontrada y eliminada ## --> " + p.toString());
                System.out.println("");
                check=true;
                break;
            }else
                check=false;
                
        }if (check==false) {
            System.out.println("");
            System.out.println("## Publicación no encontrada ##");
        }
        
    }
     static void editarPublicacion(ArrayList listaDePublicaciones, String codigo){
        Scanner leer = new Scanner(System.in);
        boolean check=false;
        boolean check2=false;
        for (Object listaDePublicacione : listaDePublicaciones) {
            Publicacion p = (Publicacion) listaDePublicacione;
            if (p.getCodigo().equalsIgnoreCase(codigo)) { //Compara el el parametro codigo con el atributo codigo de la clase Publicacion
                check=true;
                if (p instanceof Libro) {
                    System.out.println("Publicacion--->" + p.toString());
                    System.out.println("");
                    
                    System.out.println("Que quiere modificar?\n"
                            + "[1] Codigo\n" + "[2] Titulo\n" + "[3] Año de publicación\n"
                            + "[4] Todos los datos\n" +"[5] Ninguno");
                
                    int ultimaopcion = 5;
                    int modificar = recogerOP(ultimaopcion);
                    switch (modificar) {
                        case 1:
                            System.out.println("Codigo nuevo:");// Se edita solo el codigo
                            
                            String codigo1 = leer.nextLine();
                            for (Iterator iterator = listaDePublicaciones.iterator(); iterator.hasNext();) {//1ºBusca una publicacion
                                Object next = iterator.next();
                                Publicacion w=(Publicacion)next;
                                if (w.getCodigo().equalsIgnoreCase(codigo1)) {//2ºCompara el codigo nuevo con todos los codigos existentes, si hay coincidencia-->check2==true y salta a 3º , sino salta a 4º y termina la modificación
                                    check2=true;
                                    
                                }                                                                                            
                            }if (check2==true) {//3º 
                                 System.out.println("## Ya existe una publicación con este codigo ##");
                                    System.out.println("");
                                
                                 
                            }else{//4º
                               p.setCodigo(codigo1);
                                    System.out.println("Publicacion editada--> " + p.toString());
                                    System.out.println("");
                            }                                                                              
                            break;
                        case 2:
                            System.out.println("Título nuevo:");
                            
                            String titulo2 = leer.nextLine();
                            p.setTitulo(titulo2);
                            System.out.println("Publicacion editada--> " + p.toString()); 
                            System.out.println("");
                            break;
                        case 3:
                            System.out.println("Año de publicación nuevo:");
                            
                            
                            int anno;
                            do {
                                anno = recogerNumero();//METODO QUE MANEJA EXCEPCION EN EL CASO DE INTRODUCIR STRING (Devuelve -1 si se mete en el Catch;Asi se mantiene en el bucle do While hasta se introduzca un numero)                 
                            } while (anno == -1);
                            p.setAaPubl(anno);
                            
                            System.out.println("Publicacion editada--> " + p.toString());
                            System.out.println("");
                            break;
                        case 4:
                            System.out.println("Todos los datos");
                            
                            System.out.println("Codigo nuevo:");
                            
                            String codigoAll = leer.nextLine();
                            for (Iterator iterator = listaDePublicaciones.iterator(); iterator.hasNext();) {
                                Object next = iterator.next();
                                Publicacion w=(Publicacion)next;
                                if (w.getCodigo().equalsIgnoreCase(codigoAll)) {
                                    check2=true;
                                    
                                }                                                                                            
                            }if (check2==true) {
                                 System.out.println("## Ya existe una publicacion con este codigo ##");
                                    System.out.println("");
                                
                                 
                            }else{
                            p.setCodigo(codigoAll);
                            
                            System.out.println("Título nuevo:");
                            String tituloAll = leer.nextLine();
                            p.setTitulo(tituloAll);
                            
                            System.out.println("Año de publicación nuevo:");
                           int annoAll;
                            do {
                                annoAll = recogerNumero();//METODO QUE MANEJA EXCEPCION EN EL CASO DE INTRODUCIR STRING (Devuelve -1 si se mete en el Catch;Asi se mantiene en el bucle do While hasta se introduzca un numero)                 
                            } while (annoAll == -1);
                            p.setAaPubl(annoAll);
                            
                            System.out.println("Publicacion editada--> " + p.toString()); 
                            System.out.println("");
                            }          
                            
                            
                            
                            
                            break;
                        case 5:
                            break;
                        
                    }
                  
                } else{
                   System.out.println("Publicacion--->" + p.toString());
                    System.out.println("Que quiere modificar?\n"
                            + "[1] Codigo\n" + "[2] Titulo\n" + "[3] Año de publicación\n"
                            + "[4] Numero de revista\n" + "[5] Todos los datos\n" + "[6] Ninguno");
                    
                    int ultimaopcion = 6;
                    int modificar = recogerOP(ultimaopcion);
                    switch (modificar) {
                        case 1:
                            System.out.println("Codigo nuevo:");// Se edita solo el codigo
                            
                            String codigo1 = leer.nextLine();
                           for (Iterator iterator = listaDePublicaciones.iterator(); iterator.hasNext();) {
                                Object next = iterator.next();
                                Publicacion w=(Publicacion)next;
                                if (w.getCodigo().equalsIgnoreCase(codigo1)) {
                                    check2=true;
                                    
                                }                                                                                            
                            }if (check2==true) {
                                 System.out.println("## Ya existe una publicacion con este codigo ##");
                                    System.out.println("");
                                
                                 
                            }else{
                               p.setCodigo(codigo1);
                                    System.out.println("Publicacion editada--> " + p.toString());
                                    System.out.println("");
                            }      
                            break;
                        case 2:
                            System.out.println("Título nuevo:");
                            
                            String titulo2 = leer.nextLine();
                            p.setTitulo(titulo2);
                            
                            System.out.println("Publicacion editada--> " + p.toString());
                            System.out.println("");
                            break;
                        case 3:
                            System.out.println("Año de publicación nuevo:");
                            int anno;
                            do {
                                anno = recogerNumero();//METODO QUE MANEJA EXCEPCION EN EL CASO DE INTRODUCIR STRING (Devuelve -1 si se mete en el Catch;Asi se mantiene en el bucle do While hasta se introduzca un numero)                 
                            } while (anno == -1);
                            p.setAaPubl(anno);
                            
                            System.out.println("Publicacion editada--> " + p.toString());
                            System.out.println("");
                            break;
                        case 4:
                            System.out.println("Numero de la revista:");
                            int numero;
                            do {
                                numero = recogerNumero();//METODO QUE MANEJA EXCEPCION EN EL CASO DE INTRODUCIR STRING (Devuelve -1 si se mete en el Catch;Asi se mantiene en el bucle do While hasta se introduzca un numero)                 
                            } while (numero == -1);
                            Revista q=(Revista)p;
                            q.setNumero(numero);
                            
                            System.out.println("Publicacion editada--> " + q.toString());
                            System.out.println("");
                            break;
                        case 5:
                            System.out.println("Todos los datos");
                            q = (Revista) p;

                            System.out.println("Codigo nuevo:");
                            
                            String codigoAll = leer.nextLine();
                            for (Iterator iterator = listaDePublicaciones.iterator(); iterator.hasNext();) {
                                Object next = iterator.next();
                                Publicacion w = (Publicacion) next;
                                if (w.getCodigo().equalsIgnoreCase(codigoAll)) {
                                    check2 = true;

                                }
                            }
                            if (check2 == true) {
                                System.out.println("## Ya existe una publicación con este código ##");
                                System.out.println("");

                            } else {
                                q.setCodigo(codigoAll);

                                System.out.println("Título nuevo:");
                                String tituloAll = leer.nextLine();
                                q.setTitulo(tituloAll);

                                System.out.println("Año de publicación nuevo:");
                                int annoAll;
                                do {
                                    annoAll = recogerNumero();//METODO QUE MANEJA EXCEPCION EN EL CASO DE INTRODUCIR STRING (Devuelve -1 si se mete en el Catch;Asi se mantiene en el bucle do While hasta se introduzca un numero)                 
                                } while (annoAll == -1);
                                p.setAaPubl(annoAll);

                                System.out.println("Numero de la revista:");
                                int numeroAll;
                                do {
                                    numeroAll = recogerNumero();//METODO QUE MANEJA EXCEPCION EN EL CASO DE INTRODUCIR STRING (Devuelve -1 si se mete en el Catch;Asi se mantiene en el bucle do While hasta se introduzca un numero)                 
                                } while (numeroAll == -1);
                                q.setNumero(numeroAll);

                                System.out.println("Publicacion editada--> " + q.toString());
                                System.out.println("");
                            }

                            break;
                        case 6:
                            break;
                    }
                }
                
            }
        }if (check==false) {
            
            System.out.println("## Código no encontrado ##");
            System.out.println("");
        }
        

    }
     static void publicacionesPorTitulo(ArrayList listaDePublicaciones){
        boolean check=false;
        Scanner leer=new Scanner(System.in);
        System.out.println("Introduzca parte del título");
       String titulo=leer.nextLine();
        System.out.println("");
        System.out.println("          --Relación de publicaciones por título :"+ "'"+titulo + "..'" + " --");
        
        System.out.println("");
        
        Collections.sort(listaDePublicaciones, new Comparator<Publicacion>() {
            @Override
            public int compare(Publicacion p1, Publicacion p2) {               
                return new String(p1.getCodigo()).compareTo(new String(p2.getCodigo()));
            }
        });
        
        for (Object listaDePublicacione : listaDePublicaciones) {
           Publicacion p=(Publicacion)listaDePublicacione;
            if (p.getTitulo().contains(titulo)) {
                check=true;
               if(p instanceof Libro)
                System.out.print("*** LIBRO ***   ");
            else
                System.out.print("*** REVISTA *** ");
            System.out.println(p.toString());              
            }
        }if (check==false) {
            System.out.println("## No se encuentran publicaciones coincidentes ##");
        }
      
    }   
     static int recogerOP(int ultimaOpcion){
       Scanner leer=new Scanner(System.in);
        int op=0;
       
        try {
            op=leer.nextInt();
            if (op<0 || op>ultimaOpcion) {
                throw new InputMismatchException();
                
            }
            
        } catch (InputMismatchException e) {
            System.out.println("");
            System.out.println("## Debe introducir un número dentro del rango ##");
            System.out.println("");
        }
        return op;
    }//MANEJA EXCEPCION EN CASO DE INTRODUCIR STRING(SOLO PARA lOS SWITCH)
     static int recogerNumero(){
        Scanner leer=new Scanner(System.in);
        
        int temp=0;
        
        try {
            int op=leer.nextInt();
            if (op>0) {
                temp=op;
            }
            
        } catch (InputMismatchException e) {
            System.out.println("");
            System.out.println("## Debe introducir un número ##");
            System.out.println("");
            return -1;
        }
        return temp;
    }//MANEJA EXCEPCION EN EL CASO DE INTRODUCIR STRING (Devuelve -1 si se mete en el Catch-->Asi se mantiene en el bucle do While hasta se introduzca un numero) 
    
     
}
