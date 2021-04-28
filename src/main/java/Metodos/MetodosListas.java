package Metodos;

import Genericos.tieneClave;
import Genericos.tieneLista;

import java.util.ArrayList;
import java.util.List;

public class MetodosListas {

    public static <E extends tieneLista> List<E> listaVacia(List<E> lista) {
        List <E> nuevaLista = new ArrayList<>();
        for(E e : lista ){
            if(e.getLista().size()== 0 ){
                nuevaLista.add(e);
            }
        }
        return lista;
    }

    public static <E extends tieneClave> boolean buscarClave(List<E> lista, E elem) {
        for(E e : lista){
            if(e.getClave().equals(elem)) return true;
        }
        return false;
    }
}
