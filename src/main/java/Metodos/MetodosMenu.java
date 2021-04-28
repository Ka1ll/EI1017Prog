package Metodos;

import Proyecto.Proyecto;

import java.util.Scanner;

public class MetodosMenu {

    public static void cambiarNombreProyecto(Proyecto pActual){
        Scanner sc = new Scanner(System.in);
        System.out.println("Que nombre le quieres dar al proyecto? ");
        pActual.setNombreProyecto(sc.nextLine());
    }
}
