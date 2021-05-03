package Metodos;

import Facturacion.Calculo;
import Facturacion.ConsumoInterno;
import Facturacion.Descuento;
import Facturacion.Urgente;
import Menu.OpcionesMenu;
import Persona.Persona;
import Proyecto.Proyecto;
import Resultado.Resultado;
import Tarea.Tarea;
import org.w3c.dom.Text;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MetodosMenu {
    public static void cambiarNombreProyecto(Proyecto pActual){
        Scanner sc = new Scanner(System.in);
        System.out.print("Que nombre le quieres dar al proyecto? ");
        pActual.setNombreProyecto(sc.nextLine());
    }

    public static void añadirTarea(Proyecto proyecto){
        Scanner sc = new Scanner(System.in);
        System.out.print("Que nombre le quieres dar a la tarea? ");
        String nombre = sc.nextLine();

        System.out.print("Que descripción le quieres dar a la tarea? ");
        String descripcion = sc.nextLine();

        System.out.println("Que prioridad le quieres dar a la tarea? (1 baja, 5 alta)");
        int prioridad = sc.nextInt();


        System.out.print("Identificador del resultado (Web, Programa, Documentacion)? ");
        sc.skip("\\R");
        String tipoResultado = sc.nextLine();

        System.out.println("Destinado a comercialización(1) o interno(2)? ");
        int destinado = sc.nextInt();
        boolean destinacion = false;
        if (destinado == 1){
            destinacion = true;
        }

        boolean quiereEtiquetas = true;
        List<String> etiquetas = new ArrayList<>();

        while(quiereEtiquetas){
            System.out.println("Etiquetas? (1-Si, 2-No) ");
            int quiereEtiquetasInt = sc.nextInt();
            sc.skip("\\R");
            if(quiereEtiquetasInt == 1){
                System.out.println("Que etiqueta? ");
                String etiquetaString = sc.nextLine();
                etiquetas.add(etiquetaString);
                System.out.print("Mas ");
            }

            else{ quiereEtiquetas = false; }
        }

        System.out.println("Que coste tiene la tarea? ");
        double coste = sc.nextDouble();

        System.out.println("Que tipo de facturacion se va a aplicar (1-ConsumoInterno, 2-Descuento, 3-Urgente)");
        int facturacion = sc.nextInt();

        double descuento = 0;
        if(facturacion == 2 || facturacion == 3){
            //Descuento
            System.out.println("Que tipo de descuento(Descuento) o incremento(Urgente) le quieres añadir (0-100)");
            descuento = sc.nextDouble();
        }


        if(proyecto.añadirTareaProyecto(new Tarea(nombre,descripcion , new ArrayList<Persona>(), null, prioridad, LocalDate.now(), null,false,new Resultado(tipoResultado,0, destinacion), etiquetas, coste, calculoFacturacion(facturacion,descuento)))){
            System.out.println("Tarea añadida");
        }
        else{
            System.out.println("La tarea no se ha podido añadir.");
        }
    }

    public static void mostrarTareas(Proyecto proyecto){
        System.out.println("Las Tareas del proyecto son: ");
        List<Tarea> listaTareas = proyecto.getTareas();
        for (Tarea t : listaTareas){
            System.out.println(t.getTitulo());

            List<Persona> listaPersonas = t.getPersonasAsignadas();
            System.out.println("\tPersonas asignadas: ");
            if(listaPersonas.size() == 0){
                System.out.println("No hay personas asignadas a la tarea aún");
            }
            else{
                for(Persona p : listaPersonas){
                    System.out.print("\t" +p.getCorreo());
                    if(t.getResponsable()!= null){
                        if(p.getCorreo().equals((t.getResponsable()).getCorreo())){
                            System.out.print(" (Responsable)");
                        }
                    }
                    System.out.println();
                }
            }

            if(t.isFinalizada()){
                System.out.println("\tTarea finalizada");
            }
            else{
                System.out.println("\tTarea sin finalizar");
            }

            System.out.print("\tEl identificador del resultado es: ");
            System.out.println("\t" + (t.getResultado()).getIdentificador());

            System.out.print("El coste total de la tarea es: ");
            System.out.println(t.getFacturacion().calculoOperacion(t.getCoste()));

            System.out.print("Con facturazión: ");
            System.out.println(t.getFacturacion().nombre());
        }
    }
    public static void finalizarTarea(Proyecto proyecto){
        Scanner sc = new Scanner(System.in);
        System.out.println("Que tarea quiere finalizar? (Titulo de la tarea)");
        String nombre = sc.nextLine();
        List<Tarea> listaTareas = proyecto.getTareas();
        for(Tarea t : listaTareas){
            if(t.getTitulo().equals(nombre)){
                t.setFinalizada(true);
                t.setFechaFinal(LocalDate.now());
                System.out.println("Tarea finalizada");
                return;
            }
        }
        System.out.println("No hay ningúna tarea con ese titulo para finalizar");
    }

    public static void añadirPersonaATarea(Proyecto proyecto) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Añadir(1) o eliminar(2) persona de una tarea");
        int añadirEliminar = sc.nextInt();
        sc.skip("\\R");

        if(añadirEliminar == 1) {
            System.out.println("Que persona quieres añadir (Correo)?");
            String correoPersona = sc.nextLine();
            List<Persona> listaPersonasProyecto = proyecto.getPersonasProyecto();
            boolean personaExiste = false;
            Persona persona = null;
            for (Persona p : listaPersonasProyecto) {
                if (p.getClave().equals(correoPersona)) {
                    personaExiste = true;
                    persona = p;
                }
            }
            if (!personaExiste) {
                System.out.println("La persona no esta en el proyecto, añadela antes al proyecto");
                return;
            }

            System.out.println("A que tarea quieres añadir la persona?");
            String nombreTarea = sc.nextLine();
            List<Tarea> listaTareas = proyecto.getTareas();
            for (Tarea t : listaTareas) {
                if (t.getTitulo().equals(nombreTarea)) {
                    List<Persona> listaPersonas = t.getPersonasAsignadas();
                    if (listaPersonas.contains(persona)) {
                        System.out.println("La persona ya esta en la tarea.");
                    } else {
                        listaPersonas.add(persona);
                        t.setPersonasAsignadas(listaPersonas);
                    }
                    break;
                }
            }
        }
        else{
            System.out.println("A que tarea quieres eliminar la persona?");
            String nombreTarea = sc.nextLine();
            List<Tarea> listaTareas = proyecto.getTareas();
            for (Tarea t : listaTareas) {
                if (t.getTitulo().equals(nombreTarea)) {
                    System.out.println("Que persona quieres eliminar (Correo)?");
                    String correoPersona = sc.nextLine();
                    List<Persona> listaPersonas = t.getPersonasAsignadas();
                    for (Persona p : listaPersonas) {
                        if (p.getClave().equals(correoPersona)) {
                            listaPersonas.remove(p);
                            t.setPersonasAsignadas(listaPersonas);
                            return;
                        }
                    }
                }
            }
        }
    }

    public static void altaPersona(Proyecto proyecto){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre de la persona? ");
        String nombre = sc.nextLine();
        System.out.print("Correo de la persona? ");
        String correo = sc.nextLine();

        if(proyecto.añadirPersonaProyecto(new Persona(nombre,correo,null))){
            System.out.println("Persona añadida");
        }
        else{
            System.out.println("La persona no se ha podido añadir.");
        }
    }

    public static void mostrarPersonas(Proyecto proyecto){
        List<Persona> listaPersona = proyecto.getPersonasProyecto();
        for(Persona p : listaPersona){
            System.out.println(p.getCorreo());
        }
    }

    public static void añadirResponsable(Proyecto proyecto){
        Scanner sc = new Scanner(System.in);
        System.out.println("A que tarea quiere añadir el responsable? ");
        String nombreTarea = sc.nextLine();
        Tarea tarea = null;
        List<Tarea> listaTareas = proyecto.getTareas();
        for (Tarea t : listaTareas) {
            if (t.getTitulo().equals(nombreTarea)) {
                tarea = t;
                break;
            }
        }

        System.out.println("Que persona quieres añadir (Correo)?");
        String correoPersona = sc.nextLine();
        List<Persona> listaPersonasProyecto = proyecto.getPersonasProyecto();
        for (Persona p : listaPersonasProyecto) {
            if (p.getClave().equals(correoPersona)){
                Persona persona = p;
                tarea.setResponsable(persona);
                List<Persona> listaPersonas = tarea.getPersonasAsignadas();
                listaPersonas.add(persona);
                tarea.setPersonasAsignadas(listaPersonas);
            }
        }
            System.out.println("La persona no esta en el proyecto, añadela antes al proyecto");
    }

    public static void modificarFacturacion(Proyecto proyecto){
        Scanner sc = new Scanner(System.in);
        System.out.println("A que tarea quiere cambiar el tipo de facturazión: ");
        String nombreTarea = sc.nextLine();
        List<Tarea> listaTareas = proyecto.getTareas();
        for(Tarea t : listaTareas){
            if(t.getTitulo().equals(nombreTarea)){
                System.out.println("Que tipo de facturacion se va a aplicar (1-ConsumoInterno, 2-Descuento, 3-Urgente)");
                int facturacion = sc.nextInt();

                double descuento = 0;
                if(facturacion == 2 || facturacion == 3){
                    //Descuento
                    System.out.println("Que tipo de descuento(Descuento) o incremento(Urgente) le quieres añadir (0-100)");
                    descuento = sc.nextDouble();
                }
                t.setFacturacion(calculoFacturacion(facturacion,descuento));
                break;
            }
        }
    }

    public static Calculo calculoFacturacion(int facturacion, double descuentoIncremento){
        if(facturacion == 1){
            //Consumointero
            return new ConsumoInterno();
        }
        else if(facturacion == 2){
            //Descuento
            return new Descuento(descuentoIncremento);
        }
        else if(facturacion == 3){
            //Urgente
            return new Urgente(descuentoIncremento);
        }
        return null;
    }
}