package pe.edu.pe.grupo2.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Reclamaciones")
public class Reclamaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReclamacion;

    @ManyToOne
    @JoinColumn(name = "idRecompensa", nullable = false)
    private Recompensas recompensa;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private User usuario;

    public Reclamaciones() {
    }

    public Reclamaciones(Long idReclamacion, Recompensas recompensa, User usuario) {
        this.idReclamacion = idReclamacion;
        this.recompensa = recompensa;
        this.usuario = usuario;
    }

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

