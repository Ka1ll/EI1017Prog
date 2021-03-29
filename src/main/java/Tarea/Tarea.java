package Tarea;

import java.util.List;

import Persona.Persona;
import Tarea.Fecha;

public class Tarea  {

    String titulo;
    String descripcion;
    List<Persona> personaAsignadas;
    Persona responsable;
    int prioridad;
    Fecha fechaInicio;
    Fecha fechaFinal;
    boolean finalizada;
    //Resultado
    List<String> listaEtiquetas;

    public Tarea(String titulo, String descripcion, List<Persona> personaAsignadas, Persona responsable, int prioridad, Fecha fechaInicio, Fecha fechaFinal, boolean finalizada,Resultado resultado, List<String> listaEtiquetas) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.personaAsignadas = personaAsignadas;
        this.responsable = responsable;
        this.prioridad = prioridad;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.finalizada = finalizada;
        this.listaEtiquetas = listaEtiquetas;
    }


    public void actualizarFecha(){
        fechaInicio.setDia(5);
        fechaInicio.setMes(4);
        fechaInicio.setAño(3);
    }
}