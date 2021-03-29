package Tarea;

public class PaginaWeb extends Resultado{
    boolean tipo; //true = estatica, false = dinámica
    String lenguaje;
    String backEnd;


    public PaginaWeb(boolean tipo, String lenguaje, String backEnd, String identificador, int horasInvertidas, boolean destino) {
        super(identificador, horasInvertidas, destino);
        this.tipo = tipo;
        this.lenguaje = lenguaje;
        this.backEnd = backEnd;
    }
}
