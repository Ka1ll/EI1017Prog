package Menu;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        System.out.println(OpcionesMenu.getMenu());
        Scanner sc = new Scanner(System.in);
        //do{
        System.out.println("Elija una opción: ");
        int opcion = sc.nextInt();
        OpcionesMenu opcionesMenu = OpcionesMenu.getOpcion(opcion);
        System.out.println("Ha elegido: " + opcionesMenu + "-" +opcion);
       // }while(sc)
    }
}