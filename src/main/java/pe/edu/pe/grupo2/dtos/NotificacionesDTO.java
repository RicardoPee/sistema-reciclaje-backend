package pe.edu.pe.grupo2.dtos;

import jakarta.persistence.Column;
import pe.edu.pe.grupo2.entities.Noticias;
import pe.edu.pe.grupo2.entities.User;

import java.time.LocalDate;
import java.time.LocalTime;

public class NotificacionesDTO {
    private int idNotificaciones;
    private String mensaje;
    private LocalDate fecha;
    private User us;

    public int getIdNotificaciones() {
        return idNotificaciones;
    }

    public void setIdNotificaciones(int idNotificaciones) {
        this.idNotificaciones = idNotificaciones;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public User getUs() {
        return us;
    }

    public void setUs(User us) {
        this.us = us;
    }

}
