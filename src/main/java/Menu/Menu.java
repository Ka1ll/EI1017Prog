package Menu;

import Metodos.MetodosMenu;
import Metodos.Mostrar;
import Proyecto.Proyecto;

import java.io.IOException;
import java.util.Scanner;

import static Metodos.MetodosMenu.*;

public class Menu {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println("Que nombre de proyecto quieres abrir o crear: ");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        Proyecto proyectoActual = Mostrar.iniciarProyecto(nombre);

        boolean algoMas = true;
        while (algoMas) {
            System.out.println("Menu:\n" + OpcionesMenu.getMenu());
            boolean mal = true;
            int opcion;
            do {
                System.out.println("Elija una opción: ");
                opcion = sc.nextInt() - 1;
                try {
                    System.out.println("Ha elegido la opción: " + (opcion + 1) + " - " + OpcionesMenu.getOpcion(opcion));
                    mal = false;

                } catch (ArrayIndexOutOfBoundsException e) {
                    //e.printStackTrace();
                    System.out.println("Opción incorrecta, esa opción no existe. Por favor elija una opción viable");
                };
            } while (mal);

            OpcionesMenu opcionMenu = OpcionesMenu.getOpcion(opcion);
            switch (opcionMenu) {
                case NUEVO_PROYECTO:    //Crear nuevo proyecto Nombre del proyecto LLAMAR A METODO DE PROYECTO QUE CREE NUEVO PROYECTO
                    cambiarNombreProyecto(proyectoActual);
                    break;
                case ALTA_PERSONAS:     //Añadir personas
                    altaPersona(proyectoActual);
                        break;
                case ALTA_TAREAS:
                    MetodosMenu.añadirTarea(proyectoActual);
                    break;
                case FINALIZAR_TAREA:
                    MetodosMenu.finalizarTarea(proyectoActual);
                    break;
                case INTRODUCIR_ELIMINAR_PERSONA:
                    MetodosMenu.añadirPersonaATarea(proyectoActual);
                    break;
                case RESPONSABLE_DE_TAREA:
                    añadirResponsable(proyectoActual);
                    break;
                case MODIFICAR_FACTURACION:
                    modificarFacturacion(proyectoActual);
                    break;
                case MOSTRAR_LISTA_PERSONAS:
                    mostrarPersonas(proyectoActual);
                    break;
                case MOSTRAR_TAREAS_PROYECTO:
                    MetodosMenu.mostrarTareas(proyectoActual);
                    break;
                case SALIR:
                    System.out.println("Adios");
                    algoMas = false;
                    sc.close();
                    break;
            } //switch
        } //While
        proyectoActual.escribirDatos();
    }//Main
}//Class