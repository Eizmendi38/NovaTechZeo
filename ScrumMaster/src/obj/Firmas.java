package obj;

import java.time.LocalDateTime;

public class Firmas {

    //Declarar atributos
    private int id; //Identificador único de la firma
    private String firma; //Nombre del firmante
    private LocalDateTime horaFirmada;//Fecha y hora en que se firma


    // Constructor que asigna id y nombre, y pone la hora actual como hora de firma
    public Firmas (int id, String firma) {
        this.id = id;
        this.firma = firma;
        this.horaFirmada = LocalDateTime.now();
    }

    // Constructor que permite asignar también la hora de la firma
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

    //Devuelve una representación en texto de la firma
    @Override
    public String toString() {
        return "ID: " + id + "\nFirma: " + firma + "\nFecha de firma: " + horaFirmada;
    }
}
