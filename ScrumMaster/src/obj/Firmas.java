package obj;

import java.time.LocalDateTime;

public class Firmas {
    private int id;
    private String firma;
    private LocalDateTime horaFirmada;

    public Firmas (int id, String firma) {
        this.id = id;
        this.firma = firma;
        this.horaFirmada = LocalDateTime.now();
    }
}
