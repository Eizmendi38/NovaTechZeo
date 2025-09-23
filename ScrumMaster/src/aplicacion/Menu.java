package aplicacion;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import obj.Charter;
import obj.ContenedorFirmas;

import java.util.*;

import javax.swing.plaf.synth.SynthScrollBarUI;

import obj.Firmas;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;


public class Menu {
    private static final Gson gson = new GsonBuilder()
        .registerTypeAdapter(LocalDateTime.class, new JsonDeserializer<LocalDateTime>() {
            @Override
            public LocalDateTime deserialize(JsonElement json, java.lang.reflect.Type typeOfT, JsonDeserializationContext context) {
                return LocalDateTime.parse(json.getAsString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            }
        })
        .registerTypeAdapter(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
            @Override
            public JsonElement serialize(LocalDateTime src, java.lang.reflect.Type typeOfSrc, JsonSerializationContext context) {
                return new JsonPrimitive(src.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            }
        })
        .setPrettyPrinting()
        .create();

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

    public static ArrayList<Firmas> cargarArray(String archivo) throws IOException {
        File f = new File(archivo);
        if (!f.exists()) return new ArrayList<>();

        try (Reader reader = new FileReader(f)) {
            ArrayList<Firmas> lista = gson.fromJson(reader, new TypeToken<ArrayList<Firmas>>(){}.getType());

            // Filtramos firmas inválidas (ej: solo tienen id = 0)
            ArrayList<Firmas> validas = new ArrayList<>();
            for (Firmas f1 : lista) {
                if (f1.getFirma() != null && f1.getHoraFirmada() != null) {
                    validas.add(f1);
                }
            }
            return validas;
        }
    }

    public static void guardarFirmas(String archivo, ArrayList<Firmas> firmas) throws IOException {
    try (Writer writer = new FileWriter(archivo)) {
        gson.toJson(firmas, writer);
    }
}

    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
        ArrayList<Firmas> firmList = new ArrayList<>();

        try {
        firmList = cargarArray("ScrumMaster/src/resources/signatures.json");
        } catch (IOException e) {
            System.out.println("error.");
        }
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
                    case 2:
                    System.out.println("¿Aceptas los terminos y condiciones?\n1. SI\n2. NO");
                    int ockion = scanner.nextInt();
                    scanner.nextLine();
                    switch (ockion) {
                        case 1:
                        System.out.println("Escribe tu nombre.");
                        String nombre = scanner.nextLine();
                        int id = (int)(random.nextInt((100000 - 10000 + 1)-10000));
                        firmList.add(new Firmas(id, nombre));
                        try {
                        guardarFirmas("ScrumMaster/src/resources/signatures.json", firmList);
                        } catch (IOException e) {
                            System.out.println("error al guardar las firmas.");
                            break;
                        }
                        System.out.println("Firma guardada.");
                        break;
                        case 2:
                        System.out.println("Volviendo al menú anterior.");
                        break;
                        default:
                        System.out.println("Opción inválida. Cerrando sistema.");
                    }
                    case 3:
                    //Sale del sistema
                    System.out.println("Saliendo al sistema.");
                    scanner.close();
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
                            for (int i = 0; i<firmList.size(); i++) {
                                System.out.println("Firma número "+(i+1)+":");
                                System.out.println(firmList.get(i).toString());
                            }
                            break;
                        case 2:
                            //Sale del sistema
                            System.out.println("Saliendo del programa...");
                            scanner.close();
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
