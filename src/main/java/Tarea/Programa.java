package Tarea;

public class Programa extends Resultado{
    String lenguaje;
    int lineasCodigo;
    int modulos;

    public Programa(String lenguaje, int lineasCodigo, int modulos, String identificador, int horasInvertidas, boolean destino){
        super(identificador, horasInvertidas, destino);
        this.lenguaje = lenguaje;
        this.lineasCodigo = lineasCodigo;
        this.modulos = modulos;
    }
}
