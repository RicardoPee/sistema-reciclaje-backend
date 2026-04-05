package pe.edu.pe.grupo2.entities;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Recompensas")
public class Recompensas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRecompensas;

    @Column(name = "nombreRecompensa", nullable = false, length = 200)
    private String nombreRecompensa;

    @Column(name = "descripcionRecompensa", nullable = false, length = 200)
    private String descripcionRecompensa;

    @Column(name = "fechaVencimiento", nullable = false)
    private LocalDate fechaVencimiento;

    @Column(name = "costo_puntos")
    private int costoPuntos;

    /** Stock disponible. -1 = ilimitado. 0 = AGOTADO. */
    @Column(name = "stock", nullable = false, columnDefinition = "INT DEFAULT 100")
    private int stock = 100;

    public Recompensas() {}

    public Recompensas(int idRecompensas, String nombreRecompensa, String descripcionRecompensa,
                       LocalDate fechaVencimiento, int costoPuntos, int stock) {
        this.idRecompensas = idRecompensas;
        this.nombreRecompensa = nombreRecompensa;
        this.descripcionRecompensa = descripcionRecompensa;
        this.fechaVencimiento = fechaVencimiento;
        this.costoPuntos = costoPuntos;
        this.stock = stock;
    }

    public int getIdRecompensas() { return idRecompensas; }
    public void setIdRecompensas(int idRecompensas) { this.idRecompensas = idRecompensas; }

    public String getNombreRecompensa() { return nombreRecompensa; }
    public void setNombreRecompensa(String nombreRecompensa) { this.nombreRecompensa = nombreRecompensa; }

    public String getDescripcionRecompensa() { return descripcionRecompensa; }
    public void setDescripcionRecompensa(String descripcionRecompensa) { this.descripcionRecompensa = descripcionRecompensa; }

    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public int getCostoPuntos() { return costoPuntos; }
    public void setCostoPuntos(int costoPuntos) { this.costoPuntos = costoPuntos; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}
