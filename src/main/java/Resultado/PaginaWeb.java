package Resultado;

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

    public boolean isTipo() {
        return tipo;
    }

    public void setTipo(boolean tipo) {
        this.tipo = tipo;
    }

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public String getBackEnd() {
        return backEnd;
    }

    public void setBackEnd(String backEnd) {
        this.backEnd = backEnd;
    }
}
