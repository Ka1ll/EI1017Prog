package Metodos;

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


        System.out.print("Resultado Tipo? ");
        String tipoResultado = sc.nextLine();

        System.out.println("Destinado a comercialización o interno? (1 comercialización, 2 interno) ");
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
        Tarea tarea = new Tarea(nombre,descripcion, null, null, prioridad, LocalDate.now(), null,false,new Resultado(tipoResultado,0, destinacion), etiquetas);
        if(proyecto.añadirTareaProyecto(tarea)) System.out.println("Tarea añadida");
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
                    System.out.print("\t" +p.getNombre());
                    if(p.getNombre().equals((t.getResponsable()).getNombre())){
                        System.out.print(" (Responsable)");
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

            System.out.println("\tEl identificador del resultado es:");
            System.out.println("\t" + (t.getResultado()).getIdentificador());
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

    public static void añadirPersonaATarea(Proyecto proyecto){
        Scanner sc = new Scanner(System.in);
        System.out.println("Que persona quieres añadir?");
        String nombrePersona = sc.nextLine();
        List<Persona> listaPersonas = proyecto.getPersonasProyecto();
        boolean personaExiste = false;
        for(Persona p : listaPersonas){
            //if(p.getClave().)
        }
        List<Tarea> listaTareas = proyecto.getTareas();
        for(Tarea t : listaTareas){
            //if(t.getTitulo().equals()){
                Tarea tarea = t;
                break;
            }
        }
}