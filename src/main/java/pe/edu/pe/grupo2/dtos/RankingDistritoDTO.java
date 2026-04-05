package pe.edu.pe.grupo2.dtos;

public class RankingDistritoDTO {
    private String username;
    private String nombres;
    private String apellidos;
    private int totalActividades;
    private int totalPuntos;
    private int posicion;

    public RankingDistritoDTO() {}

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getNombres() { return nombres; }
    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }
    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public int getTotalActividades() { return totalActividades; }
    public void setTotalActividades(int totalActividades) { this.totalActividades = totalActividades; }

    public int getTotalPuntos() { return totalPuntos; }
    public void setTotalPuntos(int totalPuntos) { this.totalPuntos = totalPuntos; }

    public int getPosicion() { return posicion; }
    public void setPosicion(int posicion) { this.posicion = posicion; }
}
