package pe.edu.pe.grupo2.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import pe.edu.pe.grupo2.entities.Actividad;
import pe.edu.pe.grupo2.entities.User;

import java.time.LocalDate;

public class RecompensasDTO {
    @JsonAlias({"id_recompensas", "idRecompensas"})
    private int idRecompensas;
    @JsonAlias({"nombre_recompensa", "nombreRecompensa"})
    private String nombreRecompensa;
    @JsonAlias({"fecha_vencimiento", "fechaVencimiento"})
    private LocalDate fechaVencimiento;
    @JsonAlias({"descripcion_recompensa", "descripcionRecompensa"})
    private String descripcionRecompensa;
    @JsonAlias({"costo_puntos", "costoPuntos"})
    private int costoPuntos;
    private int stock;

    public int getIdRecompensas() { return idRecompensas; }
    public void setIdRecompensas(int idRecompensas) { this.idRecompensas = idRecompensas; }

    public String getNombreRecompensa() { return nombreRecompensa; }
    public void setNombreRecompensa(String nombreRecompensa) { this.nombreRecompensa = nombreRecompensa; }

    public LocalDate getFechaVencimiento() { return fechaVencimiento; }
    public void setFechaVencimiento(LocalDate fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }

    public String getDescripcionRecompensa() { return descripcionRecompensa; }
    public void setDescripcionRecompensa(String descripcionRecompensa) { this.descripcionRecompensa = descripcionRecompensa; }

    public int getCostoPuntos() { return costoPuntos; }
    public void setCostoPuntos(int costoPuntos) { this.costoPuntos = costoPuntos; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}