package pe.edu.pe.grupo2.dtos;

import jakarta.persistence.*;
import pe.edu.pe.grupo2.entities.CentroReciclaje;
import pe.edu.pe.grupo2.entities.User;

public class FavoritosDTO {
    private int idFavorito;
    private User user;
    private CentroReciclaje centroReciclaje;

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
