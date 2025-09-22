package aplicacion;

import java.io.FileReader;
import java.io.IOException;
import obj.Charter;
import java.util.*;
import obj.Firmas;
import com.google.gson.*;


public class Menu {

    //Método que muestra el contenido del contrato leyendo un archivo JSON
    public static void mostrarContrato(String archivo) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try (FileReader reader = new FileReader(archivo)) {
            Charter charter = gson.fromJson(reader, Charter.class);

            //Muestra el nombre del proyecto y la misión
            System.out.println("Nuestro proyecto es: " + charter.getProject());
            System.out.println("Nuestra misión final es: " + charter.getMission());

            //Muestra los objetivos del proyecto
            System.out.println("\nPara cumplir con nuestra misión, cumpliremos con nuestros objetivos:");
            for (String obj : charter.getObjectives()) {
                System.out.println("- " + obj);
            }

            //Muestra los roles y sus descripciones
            System.out.println("\nPara asegurarnos que cumplimos con los objetivos nos aferraremos a nuestros roles:");
            for (Map.Entry<String, String> entry : charter.getRoles().entrySet()) {
                System.out.println("- " + entry.getKey() + ": " + entry.getValue());
            }

            //Muestra las normas del equipo
            System.out.println("\nY para asegurar el funcionamiento del equipo seguiremos las normas:");
            for (String rule : charter.getRules()) {
                System.out.println("- " + rule);
            }

            //Muestra los castigos en caso de incumplimiento
            System.out.println("\nEn caso contrario, sufriremos estos castigos:");
            for (String punishment : charter.getPunishments()) {
                System.out.println("- " + punishment);
            }

        } catch (IOException e) {
            //Muestra mensaje de error si no se puede leer el archivo
            System.out.println("Error al leer " + archivo + ": " + e.getMessage());
        }
    }

    //Método vacío reservado para futuras implementaciones
    public static void rellenarArray() {

    }

    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
        ArrayList<Firmas> firmList = new ArrayList<>();
        Random random = new Random();
        //Pregunta al usuario el tipo de menú al que quiere acceder
        System.out.println("¿Desea entrar al menú de miembro o al menú de coordinador?\n1. Miembro\n2. Coordinador");
        System.out.print("Seleccione una opción: ");
        int usuario = scanner.nextInt();
        scanner.nextLine();

        //Menú para miembros normales
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
                    //Muestra el contrato
                    try {
                        mostrarContrato("ScrumMaster/src/resources/charter.json");
                    } catch (IOException e) {
                        System.out.println("error al leer el archivo.");
                    }
                    break;
                    case 3:
                    //Sale del sistema
                    System.out.println("Saliendo al sistema.");
                    return;
                }

            } while (true);
        }


        //Menú para coordinadores (administradores)
        if (usuario == 2){
            int attempts = 0;
            boolean guessed = false;
            //Solicita contraseña hasta 3 intentos
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
                        //Aquí debería mostrarse la lista de firmas (falta implementación)
                            break;
                        case 2:
                            //Sale del sistema
                            System.out.println("Saliendo del programa...");
                            return;
                        default:
                            //Opción no válida
                            System.out.println("Opción no válida. Intente de nuevo.");
                    }
                
            } while (true);
        } else {
            //Si falla la contraseña 3 veces, cierra el programa
            System.out.println("Contraseña incorrecta. Cerrando programa.");
        }
    }
}
}
