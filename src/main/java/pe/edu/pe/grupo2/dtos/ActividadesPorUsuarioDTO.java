package pe.edu.pe.grupo2.dtos;

public class ActividadesPorUsuarioDTO {
    private String username;
    private int numeroactividades;
    private int total_puntos;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getNumeroactividades() {
        return numeroactividades;
    }

    public void setNumeroactividades(int numeroactividades) {
        this.numeroactividades = numeroactividades;
    }

    public int getTotal_puntos() {
        return total_puntos;
    }

    public void setTotal_puntos(int total_puntos) {
        this.total_puntos = total_puntos;
    }
}
