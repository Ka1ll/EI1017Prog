package Tarea;

public class Resultado {

    String identificador;
    int horasInvertidas;
    boolean destino; // true= destinado a ser comercializado y false=resultado interno


    public Resultado(String identificador, int horasInvertidas, boolean destino) {
        this.identificador = identificador;
        this.horasInvertidas = horasInvertidas;
        this.destino = destino;
    }
}
