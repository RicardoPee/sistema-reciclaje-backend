package pe.edu.pe.grupo2.dtos;

public class PromedioNotificacionesDTO {
    private String nombres;
    private Double promedio_noti;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Double getPromedio_noti() {
        return promedio_noti;
    }

    public void setPromedio_noti(Double promedio_noti) {
        this.promedio_noti = promedio_noti;
    }
}
