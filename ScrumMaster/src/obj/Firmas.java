package obj;

import java.time.LocalDateTime;

public class Firmas {

    //Declarar atributos
    private int id; //Identificador único de la firma
    private String firma; //Nombre del firmante
    private LocalDateTime horaFirmada;//Fecha y hora en que se firma


    // Constructor
    public Firmas (int id, String firma) {
        this.id = id;
        this.firma = firma;
        this.horaFirmada = LocalDateTime.now();
    }

    public Firmas (int id, String firma, LocalDateTime horaFirmada) {
        this.id = id;
        this.firma = firma;
        this.horaFirmada = horaFirmada;
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
