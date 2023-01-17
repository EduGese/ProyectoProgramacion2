/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogramacion;

/**
 *
 * @author Edu
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Publicacion implements Serializable {
    /* Almacena las características comunes para revistas y libros */
    String codigo;
    String titulo;
    int aaPubl;
    
    Publicacion() {
    }
    
    Publicacion(String codigoInicial, String tituloInicial, int aaPubl) {
    /* Estas características se pasan por parámetro en el momento de crear los 
       objetos*/
         codigo=codigoInicial;
         this.titulo=tituloInicial;
         this.aaPubl=aaPubl;
    }

    // Métodos para devolver cada uno de los atributos
    public int getAaPubl() {
        return aaPubl;
    }
    public String getCodigo() {
        return codigo;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setAaPubl(int aaPubl) {
        this.aaPubl = aaPubl;
    }
    
    //Método toString()
    @Override
    public String toString(){
        return "Código: "+codigo+" / Título: "+titulo+" / Año: "+aaPubl+" /";
    }
    public static void imprimirPublicaciones (ArrayList arrayList){
    // Muestra todas las publicaciones
    
     Collections.sort(arrayList, new Comparator<Publicacion>() {
            @Override
            public int compare(Publicacion p1, Publicacion p2) {
                return new String(p1.getCodigo()).compareTo(new String(p2.getCodigo()));
            }
        });
        for (Iterator i = arrayList.iterator(); i.hasNext();) {
            Publicacion elemento = (Publicacion) i.next();
            if(elemento instanceof Libro)
                System.out.print("*** LIBRO ***   ");
            else
                System.out.print("*** REVISTA *** ");
            System.out.println(elemento.toString());
        }
    }

    public static int publicacionesAnterioresA (ArrayList arrayList, int aa){
    // Devuelve el número de  publicaciones anteriores al año aa
        int contador=0;
        for (Iterator i = arrayList.iterator(); i.hasNext();)
            if (((Publicacion) i.next()).getAaPubl()<aa)
                contador++;
        return contador;
    }
}
