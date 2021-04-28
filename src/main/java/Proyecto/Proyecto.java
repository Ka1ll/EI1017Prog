package Proyecto;


import Persona.Persona;
import Tarea.Tarea;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.List;

public class Proyecto implements Serializable {
    private String nombreProyecto;
    private List<Persona> personasProyecto;
    private List<Tarea> tareas;

    public Proyecto(String nombreProyecto, List<Persona> personasProyecto, List<Tarea> tareas) {
        this.nombreProyecto = nombreProyecto;
        this.personasProyecto = personasProyecto;
        this.tareas = tareas;
    }

    public String getNombreProyecto() {
        return nombreProyecto;
    }

    public void setNombreProyecto(String nombreProyecto) {
        this.nombreProyecto = nombreProyecto;
    }

    public List<Persona> getPersonasProyecto() {
        return personasProyecto;
    }

    public void setPersonasProyecto(List<Persona> personasProyecto) {
        this.personasProyecto = personasProyecto;
    }

    public List<Tarea> getTareas() {
        return tareas;
    }

    public void setTareas(List<Tarea> tareas) {
        this.tareas = tareas;
    }

    public boolean añadirPersonaProyecto(Persona persona){
        if (personasProyecto.size() == 0){
            personasProyecto.add(persona);
            return true;
        }

        for(Persona p : personasProyecto){
            if(p.getCorreo().equals(persona.getCorreo())) return false;
        }

        personasProyecto.add(persona);
        return true;
    }

    public boolean añadirTareaProyecto(Tarea tarea) {
        if (tareas.size() == 0) {
            tareas.add(tarea);
            return true;
        }

        for (Tarea t : tareas) {
            if (t.getTitulo().equals(tarea.getTitulo())) return false;
        }

        tareas.add(tarea);
        return true;
    }

    public void escribirDatos() throws IOException {
        FileOutputStream fos = new FileOutputStream( nombreProyecto + ".bin");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(this);
        oos.close();
    }
}