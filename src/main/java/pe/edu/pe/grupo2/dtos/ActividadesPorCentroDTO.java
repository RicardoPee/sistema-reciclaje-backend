package pe.edu.pe.grupo2.dtos;

public class ActividadesPorCentroDTO {
    private String nombre_centro ;
    private int numero_actividades;

    public String getNombre_centro() {
        return nombre_centro;
    }

    public void setNombre_centro(String nombre_centro) {
        this.nombre_centro = nombre_centro;
    }

    public int getNumero_actividades() {
        return numero_actividades;
    }


    public void setNumero_actividades(int numero_actividades) {
        this.numero_actividades = numero_actividades;
    }

}
