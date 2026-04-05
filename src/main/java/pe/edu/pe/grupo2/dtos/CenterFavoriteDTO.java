package pe.edu.pe.grupo2.dtos;

public class CenterFavoriteDTO {
    public String direccion;
    public int cantidadFavoritos;

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCantidadFavoritos() { return cantidadFavoritos; }

    public void setCantidadFavoritos(int cantidadFavoritos) { this.cantidadFavoritos = cantidadFavoritos; }
}
