package Resultado;

import java.io.Serializable;

public class Resultado implements Serializable {

    String identificador;
    int horasInvertidas;
    boolean destino; // true= destinado a ser comercializado y false=resultado interno


    public Resultado(String identificador, int horasInvertidas, boolean destino) {
        this.identificador = identificador;
        this.horasInvertidas = horasInvertidas;
        this.destino = destino;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public int getHorasInvertidas() {
        return horasInvertidas;
    }

    public void setHorasInvertidas(int horasInvertidas) {
        this.horasInvertidas = horasInvertidas;
    }

    public boolean isDestino() {
        return destino;
    }

    public void setDestino(boolean destino) {
        this.destino = destino;
    }
}
