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

public class Revista extends Publicacion {
    /* clase Revista
        hereda de la clase Publicación
        implementa la interfaz Prestable
    extends Publicacion implements Prestable */

    // ATRIBUTOS AÑADIDOS A LOS DE Publicacion)
    private int numero;
    
    // CONSTRUCTORES
    // En el momento de crear las revistas se pasa el numero por parametro
    // (el atributo numero se inicializa en el constructor)
    Revista(String codigo, String titulo, int aaPubl, int numero){
        super(codigo,titulo,aaPubl);
        this.numero=numero;
    }

    Revista(Revista r) {
        super(r.codigo,r.titulo,r.aaPubl);
        numero=r.numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
    // RESTO DE METODOS
    @Override
    public String toString(){
    // Devuelve una cadena formada por el contenido de todos los atributos
    return super.toString() + " Número: "+numero;
    }
    
    public static int cuentaRevistas(ArrayList arrayList) {
    // Devuelve el número de  revistas registradas
        int contador=0;
        for (Iterator i = arrayList.iterator(); i.hasNext();)
            if ((Publicacion) i.next() instanceof Revista)
                contador++;
        return contador;
    }
}
