package aplicacion;

import java.util.*;
import obj.Firmas;
import java.io.IOException;

public class MenuUsuario {
    public static void ejecutar(ArrayList<Firmas> firmList, Scanner scanner, Random random) {
        int opcion;
        do{
            Menu.mostrarMenuUsuario();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    try {
                        Menu.mostrarContrato("ScrumMaster/src/resources/charter.json");
                    } catch (IOException e) {
                        System.out.println("error al leer el archivo.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del firmante: ");
                    String nombre = scanner.nextLine();
                    int id = random.nextInt(1000); 
                    Firmas nuevaFirma = new Firmas(id, nombre);
                    firmList.add(nuevaFirma);
                    System.out.println("Firma agregada con ID: " + id);
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    return;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (true);
    }
}