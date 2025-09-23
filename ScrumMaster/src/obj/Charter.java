package obj;

import java.util.List;
import java.util.Map;

public class Charter {
    //Nombre del proyecto
    private String project;
    //Misión del proyecto
    private String mission;
    //Lista de objetivos del proyecto
    private List<String> objectives;
    //Mapa de roles y sus descripciones
    private Map<String, String> roles;
    //Lista de normas del equipo
    private List<String> rules;
    //Lista de castigos en caso de incumplimiento
    private List<String> punishments;

    // Getters
    public String getProject() { 
        return project; 
    }
    public String getMission() { 
        return mission; 
    }
    public List<String> getObjectives() { 
        return objectives; 
    }
    public Map<String, String> getRoles() { 
        return roles; 
    }
    public List<String> getRules() { 
        return rules; 
    }
    public List<String> getPunishments() { 
        return punishments; 
    }
}

