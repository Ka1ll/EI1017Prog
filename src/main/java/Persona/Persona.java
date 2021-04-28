package Persona;

import Genericos.tieneClave;
import Genericos.tieneLista;
import Tarea.Tarea;

import java.io.Serializable;
import java.util.List;

public class Persona implements tieneClave, tieneLista, Serializable {
    private String nombre;
    private String correo;
    private List<Tarea> listaTareasResponsable;

    public Persona(String nombre, String correo, List<Tarea> listaTareas) {
        this.nombre = nombre;
        this.correo = correo;
        this.listaTareasResponsable = listaTareas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Tarea> getListaTareasResponsable() {
        return listaTareasResponsable;
    }

    public void setListaTareasResponsable(List<Tarea> listaTareas) {
        listaTareasResponsable = listaTareas;
    }


    public boolean añadirResponsable(Tarea tarea){
        listaTareasResponsable.add(tarea);
        return true;
    }

    @Override
    public Object getClave() {
        return correo;
    }

    @Override
    public List getLista() {
        return listaTareasResponsable;
    }

    /*public boolean eliminarResponsable(Tarea tarea){
        for()
        listaTareasResponsable.add(tarea);
        return true;
    }*/
}
