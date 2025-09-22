package obj;

import java.util.List;
import java.util.Map;

public class Charter {
    private String project;
    private String mission;
    private List<String> objectives;
    private Map<String, String> roles;
    private List<String> rules;
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

