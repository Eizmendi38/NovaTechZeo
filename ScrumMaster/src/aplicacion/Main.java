package aplicacion;

import java.util.*;
import obj.Firmas;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Firmas> firmList = new ArrayList<>();
        Random random = new Random();

        while (true) {
            System.out.print("Nombre de Usuario: ");
            String usuario = scanner.nextLine();

            if (usuario.equals("usuario")) {
                MenuUsuario.ejecutar(firmList, scanner, random);
                break;
            } else if (usuario.equals("admin")) {
                System.out.print("Ingrese la contraseña: ");
                String password = scanner.nextLine();
                if (password.equals("1234")) {
                    MenuAdmin.ejecutar(firmList, scanner, random);
                    break;
                } else {
                    System.out.println("Contraseña incorrecta.");
                }
            } else {
                System.out.println("El usuario no existe");
            }
        }
    }
}