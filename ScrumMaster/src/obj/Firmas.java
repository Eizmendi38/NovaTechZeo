package obj;

import java.time.LocalDateTime;

public class Firmas {

    //Declarar atributos
    private int id;
    private String firma;
    private LocalDateTime horaFirmada;


    // Constructor
    public Firmas (int id, String firma) {
        this.id = id;
        this.firma = firma;
        this.horaFirmada = LocalDateTime.now();
    }

    //Getters y Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFirma() {
        return firma;
    }
    public void setFirma(String firma) {
        this.firma = firma;
    }
    public LocalDateTime getHoraFirmada() {
        return horaFirmada;
    }
    public void setHoraFirmada(LocalDateTime horaFirmada) {
        this.horaFirmada = horaFirmada;
    }
}
