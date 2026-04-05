package pe.edu.pe.grupo2.dtos;

import pe.edu.pe.grupo2.entities.CentroReciclaje;
import java.time.LocalDate;

public class NoticiasDTO {
    private int idNoticias;
    private String titulo;
    private String informacion;
    private LocalDate fechaPublicacion;
    private CentroReciclaje centroReciclaje; // NUEVO: centro asociado para notificaciones automáticas

    public int getIdNoticias() { return idNoticias; }
    public void setIdNoticias(int idNoticias) { this.idNoticias = idNoticias; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getInformacion() { return informacion; }
    public void setInformacion(String informacion) { this.informacion = informacion; }

    public LocalDate getFechaPublicacion() { return fechaPublicacion; }
    public void setFechaPublicacion(LocalDate fechaPublicacion) { this.fechaPublicacion = fechaPublicacion; }

    public CentroReciclaje getCentroReciclaje() { return centroReciclaje; }
    public void setCentroReciclaje(CentroReciclaje centroReciclaje) { this.centroReciclaje = centroReciclaje; }
}
