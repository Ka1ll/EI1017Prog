package Persona;

import java.util.List;

public class Persona {
       String nombre;
       String correo;
       List<String> ListaTareas;


    public Persona(String nombre, String correo, List<String> listaTareas) {
        this.nombre = nombre;
        this.correo = correo;
        ListaTareas = listaTareas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public List<String> getListaTareas() {
        return ListaTareas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setListaTareas(List<String> listaTareas) {
        ListaTareas = listaTareas;
    }
}
