package pe.edu.pe.grupo2.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Tipo_de_actividad")
public class TipoActividad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tipo_actividad;
    @Column(name = "descripción", nullable = false)
    private String descripcion;

    public TipoActividad() {
    }
    public TipoActividad(int id_tipo_actividad, String descripcion) {
        this.id_tipo_actividad = id_tipo_actividad;
        this.descripcion = descripcion;
    }

    public int getId_tipo_actividad() {return id_tipo_actividad;}

    public void setId_tipo_actividad(int id_tipo_actividad) {this.id_tipo_actividad = id_tipo_actividad;}


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
