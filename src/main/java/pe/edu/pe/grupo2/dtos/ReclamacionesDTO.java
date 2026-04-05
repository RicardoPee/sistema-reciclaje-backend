package pe.edu.pe.grupo2.dtos;

import pe.edu.pe.grupo2.entities.Recompensas;
import pe.edu.pe.grupo2.entities.User;

public class ReclamacionesDTO {
    private Long idReclamacion;
    private Recompensas recompensa;
    private User usuario;

    public Long getIdReclamacion() {
        return idReclamacion;
    }

    public void setIdReclamacion(Long idReclamacion) {
        this.idReclamacion = idReclamacion;
    }

    public Recompensas getRecompensa() {
        return recompensa;
    }

    public void setRecompensa(Recompensas recompensa) {
        this.recompensa = recompensa;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }
}
