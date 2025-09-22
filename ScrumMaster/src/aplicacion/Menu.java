package aplicacion;

import java.util.*;
import obj.Firmas;

public class Menu {
    public static void mostrarMenu() {
        System.out.println("Menú de opciones:");
        System.out.println("1. Responsabilidades y penalizaciones");
        System.out.println("2. Agregar firma");
        System.out.println("3. Ver firmas");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Firmas> firmList = new ArrayList<>();
        Random random = new Random();
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcion) {
                case 1:
                    System.out.println("Responsabilidades y penalizaciones:");
                    System.out.println("- Responsabilidad 1: Descripción...");
                    System.out.println("");
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
                    System.out.println("Lista de firmas:");
                    for (Firmas firma : firmList) {
                        System.out.println("ID: " + firma.getId() + ", Nombre: " + firma.getFirma() + ", Hora: " + firma.getHoraFirmada());
                    }
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);

        scanner.close();
    }

}
