package pe.edu.pe.grupo2.dtos;

public class Top3UsuariosDTO {
    private String nombres;
    private int total;

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
