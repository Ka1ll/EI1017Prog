package Tarea;


import Genericos.tieneClave;
import Genericos.tieneLista;
import Persona.Persona;
import Resultado.Resultado;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Tarea implements tieneLista, tieneClave, Serializable {
    private String titulo;
    private String descripcion;
    private List<Persona> personasAsignadas;    //EDITABLE METODO ADD y ELIM
    private Persona responsable;                //EDITABLE METODO ADD y ELIM
    private int prioridad;
    private LocalDate fechaInicio;
    private LocalDate fechaFinal;
    private boolean finalizada;
    private Resultado resultado;
    private List<String> listaEtiquetas;        //EDITABLE, AÑADIR Y BORRAR

    public Tarea(String titulo, String descripcion, List<Persona> personasAsignadas, Persona responsable, int prioridad, LocalDate fechaInicio, LocalDate fechaFinal, boolean finalizada, Resultado resultado, List<String> listaEtiquetas) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.personasAsignadas = personasAsignadas;
        this.responsable = responsable;
        this.prioridad = prioridad;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.finalizada = finalizada;
        this.resultado = resultado;
        this.listaEtiquetas = listaEtiquetas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Persona> getPersonasAsignadas() {
        return personasAsignadas;
    }

    public void setPersonasAsignadas(List<Persona> personasAsignadas) {
        this.personasAsignadas = personasAsignadas;
    }

    public Persona getResponsable() {
        return responsable;
    }

    public void setResponsable(Persona responsable) {
        this.responsable = responsable;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(LocalDate fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public Resultado getResultado() {
        return resultado;
    }

    public void setResultado(Resultado resultado) {
        this.resultado = resultado;
    }

    public List<String> getListaEtiquetas() {
        return listaEtiquetas;
    }

    public void setListaEtiquetas(List<String> listaEtiquetas) {
        this.listaEtiquetas = listaEtiquetas;
    }

    @Override
    public Object getClave() {
        return titulo;
    }

    @Override
    public List getLista() {
        return personasAsignadas;
    }
}