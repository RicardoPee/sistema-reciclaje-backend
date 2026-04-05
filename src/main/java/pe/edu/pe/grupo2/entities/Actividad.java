package pe.edu.pe.grupo2.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Actividad")
public class Actividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idActividad;

    @Column(name = "fecha_recepcion", nullable = false, length = 225)
    private LocalDate fecha_recepcion;

    @Column(name = "puntos", nullable = false, length = 155)
    private int puntos;

    @Column(name = "cantidad", nullable = false, length = 150)
    private int cantidad;

    // NUEVO: Estado del flujo de verificación
    @Column(name = "estado", length = 20, nullable = false)
    private String estado = "PENDIENTE"; // PENDIENTE | APROBADA | RECHAZADA

    // NUEVO: Código único para verificación física en el centro
    @Column(name = "codigo_reserva", length = 15, unique = true)
    private String codigoReserva;

    @ManyToOne
    @JoinColumn(name = "id_tipo_de_actividad")
    private TipoActividad ta;

    @ManyToOne
    @JoinColumn(name = "idCentroReciclaje")
    private CentroReciclaje cr;

    @ManyToOne
    @JoinColumn(name = "idUser")
    private User u;

    public Actividad() {}

    public Actividad(int idActividad, LocalDate fecha_recepcion, int puntos, int cantidad, String estado, String codigoReserva, TipoActividad ta, CentroReciclaje cr, User u) {
        this.idActividad = idActividad;
        this.fecha_recepcion = fecha_recepcion;
        this.puntos = puntos;
        this.cantidad = cantidad;
        this.estado = estado;
        this.codigoReserva = codigoReserva;
        this.ta = ta;
        this.cr = cr;
        this.u = u;
    }

    public int getIdActividad() { return idActividad; }
    public void setIdActividad(int idActividad) { this.idActividad = idActividad; }

    public LocalDate getFecha_recepcion() { return fecha_recepcion; }
    public void setFecha_recepcion(LocalDate fecha_recepcion) { this.fecha_recepcion = fecha_recepcion; }

    public int getPuntos() { return puntos; }
    public void setPuntos(int puntos) { this.puntos = puntos; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getCodigoReserva() { return codigoReserva; }
    public void setCodigoReserva(String codigoReserva) { this.codigoReserva = codigoReserva; }

    public TipoActividad getTa() { return ta; }
    public void setTa(TipoActividad ta) { this.ta = ta; }

    public CentroReciclaje getCr() { return cr; }
    public void setCr(CentroReciclaje cr) { this.cr = cr; }

    public User getU() { return u; }
    public void setU(User u) { this.u = u; }
}
