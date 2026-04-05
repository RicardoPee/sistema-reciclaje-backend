package pe.edu.pe.grupo2.entities;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "CentroReciclaje")
public class CentroReciclaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCentroReciclaje;

    @Column(name = "direccion", nullable = false)
    private String direccion;

    @Column(name = "latitud", nullable = false, length = 100)
    private float latitud;

    @Column(name = "longitud", nullable = false, length = 2100)
    private float longitud;

    public CentroReciclaje() {

    }

    public CentroReciclaje(int idCentroReciclaje, String direccion, float latitud, float longitud) {
        this.idCentroReciclaje = idCentroReciclaje;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public int getIdCentroReciclaje() {
        return idCentroReciclaje;
    }

    public void setIdCentroReciclaje(int idCentroReciclaje) {
        this.idCentroReciclaje = idCentroReciclaje;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public float getLatitud() {
        return latitud;
    }

    public void setLatitud(float latitud) {
        this.latitud = latitud;
    }

    public float getLongitud() {
        return longitud;
    }

    public void setLongitud(float longitud) {
        this.longitud = longitud;
    }

}
