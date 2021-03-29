package Tarea;



public class Documentación extends Resultado {
    String formato;
    int paginas;
    long espacioDisco;

    public Documentación(String formato, int paginas, long espacioDisco, String identificador, int horasInvertidas, boolean destino) {
        super(identificador,horasInvertidas, destino);
        this.formato = formato;
        this.paginas = paginas;
        this.espacioDisco = espacioDisco;
    }
}
