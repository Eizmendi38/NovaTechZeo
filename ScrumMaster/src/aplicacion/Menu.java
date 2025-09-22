package aplicacion;

import java.io.FileReader;
import java.io.IOException;
import obj.Charter;
import java.util.*;
import obj.Firmas;
import com.google.gson.*;


public class Menu {

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

    public static void rellenarArray() {

    }

    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
        ArrayList<Firmas> firmList = new ArrayList<>();
        Random random = new Random();
        System.out.println("¿Desea entrar al menú de miembro o al menú de coordinador?\n1. Miembro\n2. Coordinador");
        System.out.print("Seleccione una opción: ");
        int usuario = scanner.nextInt();
        scanner.nextLine();

        if (usuario == 1) {
            int opcion;
            do{
                System.out.println("-----MENU DE OPCIONES DEL USUARIO-----");
                System.out.println("1. Mostrar contrato");
                System.out.println("2. Firmar");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");
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
                    case 3:
                    System.out.println("Saliendo al sistema.");
                    return;
                }

            } while (true);
        }


        if (usuario == 2){
            int attempts = 0;
            boolean guessed = false;
            do {
            System.out.println("Introduzca la contraseña: ");
            String contrasena = scanner.nextLine();
            if (contrasena.equals("1234")) {
                guessed = true;
                System.out.println("Bienvenido.");
            } else {
                System.out.println("Contraseña incorrecta.");
                attempts++;
            }
            } while (attempts<3 && guessed==false);

            if (guessed==true) {
                int opcion;
                do {
                    System.out.println("-----MENU DE OPCIONES DE ADMINISTRADOR-----");
                    System.out.println("1. Ver todas las firmas");
                    System.out.println("2. Salir");
                    System.out.println("Seleccione una opción: ");
                    opcion = scanner.nextInt();
                    scanner.nextLine(); 

                    switch (opcion) {
                        case 1:
                        
                            break;
                        case 2:
                            System.out.println("Saliendo del programa...");
                            return;
                        default:
                            System.out.println("Opción no válida. Intente de nuevo.");
                    }
                
            } while (true);
        } else {
            System.out.println("Contraseña incorrecta. Cerrando programa.");
        }
    }
}
}
