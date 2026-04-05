package pe.edu.pe.grupo2.dtos;

import java.time.LocalDate;

public class CloseToExpireDTO {
    public String recompensa;
    public LocalDate proximovencer;

    public String getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(String recompensa) {
        this.recompensa = recompensa;
    }

    public LocalDate getProximovencer() {
        return proximovencer;
    }

    public void setProximovencer(LocalDate proximovencer) {
        this.proximovencer = proximovencer;
    }
}
