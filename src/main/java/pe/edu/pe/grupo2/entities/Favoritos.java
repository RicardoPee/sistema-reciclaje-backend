package pe.edu.pe.grupo2.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "Favoritos")
public class Favoritos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFavorito;

    @ManyToOne
    @JoinColumn(name = "idUser", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "idCentroReciclaje", nullable = false)
    private CentroReciclaje centroReciclaje;

    public Favoritos() {}

    public Favoritos(User user, CentroReciclaje centroReciclaje) {
        this.user = user;
        this.centroReciclaje = centroReciclaje;
    }

    public int getIdFavorito() {
        return idFavorito;
    }

    public void setIdFavorito(int idFavorito) {
        this.idFavorito = idFavorito;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public CentroReciclaje getCentroReciclaje() {
        return centroReciclaje;
    }

    public void setCentroReciclaje(CentroReciclaje centroReciclaje) {
        this.centroReciclaje = centroReciclaje;
    }

}
