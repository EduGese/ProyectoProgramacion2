/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogramacion;

/**
 *
 * @author Edu
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
Clase abstracta Que nos vale para 
* implementar sus metodos en la clase PrgArchivoBinario
 */
public class FBinario {
     static void archivarBin (ArrayList arrayList){
    // Guarda la lista de publicaciones en un archivo binario
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Edu\\"
                    + "Desktop\\DAW\\Programacion\\ProyectosNetBeans\\ProyectoProgramacion\\src\\"
                    + "proyectoprogramacion\\proyectoprogramacion.bin"));
            for (Iterator i = arrayList.iterator(); i.hasNext();) { 
                Publicacion p = (Publicacion) i.next();
                oos.writeObject(p);
            }
            oos.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     static void leerBin (ArrayList arrayList){
    // Recupera las publicaciones archivadas
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("C:\\Users\\Edu\\"
                    + "Desktop\\DAW\\Programacion\\ProyectosNetBeans\\ProyectoProgramacion\\src\\"
                    + "proyectoprogramacion\\proyectoprogramacion.bin"));
            Publicacion p = (Publicacion) ois.readObject();
            while (p!=null) {
                if (p instanceof Libro){
                    arrayList.add(new Libro((Libro)p));
                    
                }
                else
                    arrayList.add(new Revista((Revista)p));
                p = (Publicacion)ois.readObject();
                
            }
            ois.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Archivo no encontrado");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Programa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            // EOF
        }
    }
    
    
    
}

