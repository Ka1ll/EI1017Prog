package Metodos;

import Persona.Persona;
import Proyecto.Proyecto;
import Tarea.Tarea;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Mostrar {
    public static Proyecto iniciarProyecto(String nombre) throws IOException, ClassNotFoundException {
        try {
            FileInputStream fis = new FileInputStream(nombre + ".bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Proyecto proyecto = (Proyecto) ois.readObject();
            ois.close();
        return proyecto;
        }catch(IOException noExiste) {
            return new Proyecto(nombre, new ArrayList<Persona>(), new ArrayList<Tarea>());
        }
    }
}
