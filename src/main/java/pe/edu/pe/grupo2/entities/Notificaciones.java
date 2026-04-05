package pe.edu.pe.grupo2.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Notificaciones")
public class Notificaciones {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNotificaciones;

    @Column(name = "mensaje", nullable = false, length = 500)
    private String mensaje;

    @Column(name = "fecha_notificacion", nullable = false)
    private LocalDate fecha;

    /** Usuario que recibe la notificación */
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = true)
    private User us;

    /** Noticia que originó esta notificación (puede ser null para notificaciones manuales) */
    @ManyToOne
    @JoinColumn(name = "id_noticias", nullable = true)
    private Noticias noti;

    public Notificaciones() {}

    public Notificaciones(String mensaje, LocalDate fecha, User us, Noticias noti) {
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.us = us;
        this.noti = noti;
    }

    public int getIdNotificaciones() { return idNotificaciones; }
    public void setIdNotificaciones(int idNotificaciones) { this.idNotificaciones = idNotificaciones; }

    public String getMensaje() { return mensaje; }
    public void setMensaje(String mensaje) { this.mensaje = mensaje; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public User getUs() { return us; }
    public void setUs(User us) { this.us = us; }

    public Noticias getNoti() { return noti; }
    public void setNoti(Noticias noti) { this.noti = noti; }
}
