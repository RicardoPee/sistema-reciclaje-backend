package pe.edu.pe.grupo2.dtos;

import pe.edu.pe.grupo2.entities.Actividad;
import pe.edu.pe.grupo2.entities.User;

import java.time.LocalDate;

public class RecompensasDTO {
    private int idRecompensas;
    private String nombreRecompensa;
    private LocalDate fechaVencimiento;
    private String descripcionRecompensa;
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