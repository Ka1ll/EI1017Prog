package Tarea;

import java.util.List;
import Tarea.Fecha;

public class Tarea  {

    String titulo;
    String descripcion;
    List<String> personaAsignada;
    int prioridad;
    Fecha fechaInicio;
    Fecha fechaFinal;
    boolean finalizada;
    //Resultado
    List<String> listaEtiquetas;


    public Tarea(String titulo, String descripcion, List<String> personaAsignada, int prioridad, Fecha fechaInicio, Fecha fechaFinal, boolean finalizada, List<String> listaEtiquetas) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.personaAsignada = personaAsignada;
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

