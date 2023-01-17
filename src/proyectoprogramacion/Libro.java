/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogramacion;

/**
 *
 * @author Edu
 */


    import java.util.ArrayList;
import java.util.Iterator;

public class Libro extends Publicacion implements Prestable {
    /* clase Libro
        hereda de la clase Publicación
        implementa la interfaz Prestable
    extends Publicacion implements Prestable */

    // ATRIBUTOS AÑADIDOS A LOS DE Publicacion
    private boolean prestado;
    
    // CONSTRUCTORES
    // Los libros no están prestados cuando se crean
    Libro(){
        super();
        prestado=false;
    }

    Libro(String codigo, String titulo, int aaPubl){
        super(codigo,titulo,aaPubl);
        prestado=false;
    }

    Libro(Libro l) {
        super(l.codigo,l.titulo,l.aaPubl);
        prestado=l.prestado;
    }

    // RESTO DE METODOS
    @Override
    public String toString(){
    // Devuelve una cadena formada por el contenido de todos los atributos
    return super.toString() + " Prestado: "+prestado;
    }

    // Implementacion de los metodos de la interface Prestable
    @Override
    public boolean prestar(){
        if(prestado){
            return false;
        }
        else { // prestado es false
            prestado=true;
            return true;
        }        
    }
    
    @Override
    public boolean devolver(){
        if(prestado){
            prestado=false;
            return true;
        }
        else { // prestado es false
            return false;
        }
        
    }

    @Override
    public boolean prestado(){
        return prestado;
    }   
    public static int cuentaPrestados (ArrayList arrayList){
    // Devuelve el número de libros  prestados
        int prestados=0;
        for (Iterator i = arrayList.iterator(); i.hasNext();) {
            Publicacion elemento = (Publicacion) i.next();
            if (elemento instanceof Libro)
                if (((Libro) elemento).prestado())
                    prestados++;
        }
        return prestados;
    }
    
    
}

