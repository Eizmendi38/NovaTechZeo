package aplicacion;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class FormularioManager {
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

    public static class Respuesta {
        private String usuario;
        private LocalDateTime fecha;
        private Map<String, String> respuestas;

        public Respuesta(String usuario, LocalDateTime fecha, Map<String, String> respuestas) {
            this.usuario = usuario;
            this.fecha = fecha;
            this.respuestas = respuestas;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Usuario: ").append(usuario).append("\n");
            sb.append("Fecha: ").append(fecha).append("\n");
            for (Map.Entry<String, String> entry : respuestas.entrySet()) {
                sb.append("  ").append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
            return sb.toString();
        }
    }

    // Mostrar formulario y guardar respuestas
    public static void mostrarYResponderFormulario(String archivoFormulario, String archivoRespuestas, String usuario) {
        try (Reader reader = new FileReader(archivoFormulario)) {
            List<String> preguntas = gson.fromJson(reader, new TypeToken<List<String>>() {}.getType());
            Scanner scanner = new Scanner(System.in);
            Map<String, String> respuestas = new LinkedHashMap<>();

            System.out.println("\n--- FORMULARIO ---");
            for (String pregunta : preguntas) {
                System.out.println(pregunta);
                String respuesta = scanner.nextLine();
                respuestas.put(pregunta, respuesta);
            }

            Respuesta nueva = new Respuesta(usuario, LocalDateTime.now(), respuestas);

            List<Respuesta> lista = new ArrayList<>();
            File f = new File(archivoRespuestas);
            if (f.exists()) {
                try (Reader r2 = new FileReader(f)) {
                    lista = gson.fromJson(r2, new TypeToken<List<Respuesta>>() {}.getType());
                    if (lista == null) lista = new ArrayList<>();
                }
            }

            lista.add(nueva);

            try (Writer writer = new FileWriter(archivoRespuestas)) {
                gson.toJson(lista, writer);
            }

            System.out.println("✅ Tus respuestas se han guardado con éxito.");

        } catch (IOException e) {
            System.out.println("⚠️ Error al leer o escribir el formulario: " + e.getMessage());
        }
    }

    // Ver respuestas (para admin)
    public static void verRespuestas(String archivoRespuestas) {
        try (Reader reader = new FileReader(archivoRespuestas)) {
            List<Respuesta> lista = gson.fromJson(reader, new TypeToken<List<Respuesta>>() {}.getType());
            if (lista == null || lista.isEmpty()) {
                System.out.println("No hay respuestas registradas.");
                return;
            }

            System.out.println("\n--- RESPUESTAS GUARDADAS ---");
            for (Respuesta r : lista) {
                System.out.println(r.toString());
                System.out.println("-------------------------");
            }
        } catch (IOException e) {
            System.out.println("⚠️ No se pudo leer el archivo de respuestas.");
        }
    }
}

