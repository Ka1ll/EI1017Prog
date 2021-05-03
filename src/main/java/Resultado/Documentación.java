package Resultado;



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

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public long getEspacioDisco() {
        return espacioDisco;
    }

    public void setEspacioDisco(long espacioDisco) {
        this.espacioDisco = espacioDisco;
    }
}
