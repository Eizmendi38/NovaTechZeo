package aplicacion;

import java.util.*;
import obj.Firmas;

public class MenuAdmin {
    public static void ejecutar(ArrayList<Firmas> firmList, Scanner scanner, Random random) {
        int opcion;
        do {
            Menu.mostrarMenuAdmin();
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.println("Lista de todas las firmas:");
                    for (Firmas firma : firmList) {
                        System.out.println(firma);
                    }
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (true);
    }
}