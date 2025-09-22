package aplicacion;

import java.util.*;
import obj.Firmas;
import java.io.IOException;
import java.io.FileReader;
import obj.Charter;
import com.google.gson.*;

public class MenuUsuario {
    public static void mostrarMenuUsuario(){
        System.out.println("-----MENU DE OPCIONES DEL USUARIO-----");
        System.out.println("1. Responsabilidades y penalizaciones");
        System.out.println("2. Agregar firma");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void mostrarContrato(String archivo) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileReader reader = new FileReader(archivo)) {
            Charter charter = gson.fromJson(reader, Charter.class);

            System.out.println("Nuestro proyecto es: " + charter.getProject());
            System.out.println("Nuestra misión final es: " + charter.getMission());

            System.out.println("\nPara cumplir con nuestra misión, cumpliremos con nuestros objetivos:");
            for (String obj : charter.getObjectives()) {
                System.out.println("- " + obj);
            }

            System.out.println("\nPara asegurarnos que cumplimos con los objetivos nos aferraremos a nuestros roles:");
            for (Map.Entry<String, String> entry : charter.getRoles().entrySet()) {
                System.out.println("- " + entry.getKey() + ": " + entry.getValue());
            }

            System.out.println("\nY para asegurar el funcionamiento del equipo seguiremos las normas:");
            for (String rule : charter.getRules()) {
                System.out.println("- " + rule);
            }

            System.out.println("\nEn caso contrario, sufriremos estos castigos:");
            for (String punishment : charter.getPunishments()) {
                System.out.println("- " + punishment);
            }

        } catch (IOException e) {
            System.out.println("Error al leer " + archivo + ": " + e.getMessage());
        }
    }

    public static void ejecutar(ArrayList<Firmas> firmList, Scanner scanner, Random random) {
        int opcion;
        do{
            mostrarMenuUsuario();
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    try {
                        mostrarContrato("ScrumMaster/src/resources/charter.json");
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