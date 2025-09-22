package aplicacion;

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

            }
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
            
        }

        scanner.close();
    }

}
