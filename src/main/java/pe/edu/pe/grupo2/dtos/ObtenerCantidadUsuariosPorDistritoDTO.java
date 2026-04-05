package pe.edu.pe.grupo2.dtos;

public class ObtenerCantidadUsuariosPorDistritoDTO {
    public String distrito;
    public int cantidadusuarios;

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public int getCantidadusuarios() {
        return cantidadusuarios;
    }

    public void setCantidadusuarios(int cantidadusuarios) {
        this.cantidadusuarios = cantidadusuarios;
    }
}
