package pe.edu.pe.grupo2.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Noticias")
public class Noticias {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idNoticias;

    @Column(name = "titulo", nullable = false)
    private String titulo;

    @Column(name = "informacion", nullable = false)
    private String informacion;

    @Column(name = "fecha_publicacion", nullable = false)
    private LocalDate fechaPublicacion;

    /**
     * Centro asociado a esta noticia (nullable).
     * Si se especifica, el sistema notificará automáticamente a todos
     * los clientes que tengan este centro en favoritos.
     */
    @ManyToOne
    @JoinColumn(name = "id_centro_reciclaje", nullable = true)
    private CentroReciclaje centroReciclaje;

    public Noticias() {}

    public Noticias(int idNoticias, String titulo, String informacion, LocalDate fechaPublicacion, CentroReciclaje centroReciclaje) {
        this.idNoticias = idNoticias;
        this.titulo = titulo;
        this.informacion = informacion;
        this.fechaPublicacion = fechaPublicacion;
        this.centroReciclaje = centroReciclaje;
    }

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