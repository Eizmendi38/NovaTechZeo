package aplicacion;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import obj.Firmas;


public class Menu { //Menu de opciones para el usuario 
    public static void mostrarMenuUsuario(){
        System.out.println("-----MENU DE OPCIONES DEL USUARIO-----");
        System.out.println("1. Responsabilidades y penalizaciones");
        System.out.println("2. Agregar firma");
        System.out.println("3. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public static void mostrarMenuAdmin() { //Menu de opciones para el administrador
        System.out.println("-----MENU DE OPCIONES DE ADMINISTRADOR-----");
        System.out.println("1. Ver todas las firmas");
        System.out.println("2. Salir");
        System.out.println("Seleccione una opción: ");
    }

    public static void mostrarContrato() throws IOException {
        String json = new String(Files.readAllBytes(Paths.get("ScrumMaster/src/resources/charter.json")));

        String key = "\"mission\"";
        int start = json.indexOf(key) + key.length() + 2;
        int end = json.indexOf("\"", start + 1);
        String mission = json.substring(start, end);

        System.out.println("Formando parte de este equipo, te responsabilizas a cumplir con nuestra misión: " + mission+"\n");

        key = "\"objectives\"";
        start = json.indexOf("[", json.indexOf(key)) + 1;
        end = json.indexOf("]", start);
        String objectivesRaw = json.substring(start, end);

        String[] objectives = objectivesRaw.replace("\"", "").split(",");

        System.out.println("Para esto, has de cumplir los siguientes objetivos: ");
        for (String obj : objectives) {
            System.out.println("- " + obj.trim());
        }
        System.out.println("");

        key = "\"roles\"";
        start = json.indexOf("{", json.indexOf(key)) + 1;
        end = json.indexOf("}", start);
        String rolesRaw = json.substring(start, end);

        String[] roles = rolesRaw.split("\",");
        System.out.println("\nTambién haras el trabajo de tu rol asignado, que son los siguientes:");
        for (String role : roles) {
            int sep = role.indexOf(":");
            if (sep > 0) {
                String roleName = role.substring(0, sep).replace("\"", "").trim();
                String roleDesc = role.substring(sep + 1).replace("\"", "").trim();
                System.out.println("- " + roleName + ": " + roleDesc);
            }
        }

        key = "\"rules\"";
        start = json.indexOf("[", json.indexOf(key)) + 1;
        end = json.indexOf("]", start);
        String rulesRaw = json.substring(start, end);
        String[] rules = rulesRaw.replace("\"", "").split(",");
        System.out.println("\nTe comprometes a cumpli con las normas:");
        for (String rule : rules) {
            System.out.println("- " + rule.trim());
        }

        
        key = "\"punishments\"";
        start = json.indexOf("[", json.indexOf(key)) + 1;
        end = json.indexOf("]", start);
        String punishmentsRaw = json.substring(start, end);
        String[] punishments = punishmentsRaw.replace("\"", "").split(",");
        System.out.println("\nY si rompieses dichas normas, te verías afectado por los siguientes castigos:");
        for (String punishment : punishments) {
            System.out.println("- " + punishment.trim());
        }
    }

    public static void rellenarArray() {

    }
    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
        ArrayList<Firmas> firmList = new ArrayList<>();
        Random random = new Random();

        System.out.println("Ingrese un nombre de usuario: ");
        String usuario = scanner.nextLine();

        if (usuario.equals("usuario")) {
            int opcion;
            do{
                mostrarMenuUsuario();
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:

                }

            } while (true);
        }


        if (usuario.equals("administrados")){
            int opcion;
            do {
                Menu.mostrarMenuUsuario();
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
            
        } while (true);

    }
}
}
