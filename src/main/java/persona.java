import java.util.List;

public class persona {
       String nombre;
       String correo;
       List<String> ListaTareas;


    public persona(String nombre, String correo, List<String> listaTareas) {
        this.nombre = nombre;
        this.correo = correo;
        ListaTareas = listaTareas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public List<String> getListaTareas() {
        return ListaTareas;
    }
}
