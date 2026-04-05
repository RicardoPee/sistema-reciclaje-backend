package pe.edu.pe.grupo2.dtos;

public class CantidadUsuarioporRolDTO {
    private String nombres;
    private int cantidad_usuarios;


    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getCantidad_usuarios() {
        return cantidad_usuarios;
    }

    public void setCantidad_usuarios(int cantidad_usuarios) {
        this.cantidad_usuarios = cantidad_usuarios;
    }
}
