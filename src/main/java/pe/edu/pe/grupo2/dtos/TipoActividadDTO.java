package pe.edu.pe.grupo2.dtos;

public class TipoActividadDTO {
    private int id_tipo_actividad;
    private String descripcion;

    public int getId_tipo_actividad() {
        return id_tipo_actividad;
    }

    public void setId_tipo_actividad(int id_tipo_actividad) {
        this.id_tipo_actividad = id_tipo_actividad;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
