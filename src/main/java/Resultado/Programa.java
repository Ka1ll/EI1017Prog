package Resultado;

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

    public String getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(String lenguaje) {
        this.lenguaje = lenguaje;
    }

    public int getLineasCodigo() {
        return lineasCodigo;
    }

    public void setLineasCodigo(int lineasCodigo) {
        this.lineasCodigo = lineasCodigo;
    }

    public int getModulos() {
        return modulos;
    }

    public void setModulos(int modulos) {
        this.modulos = modulos;
    }
}
