package pe.edu.pe.grupo2.dtos;

public class UserCentroReciclajeDTO {
    private String nombres;
    private int edad;
    private String direccion;
    private String horario;

    public UserCentroReciclajeDTO() {
    }

    public UserCentroReciclajeDTO(String nombres, int edad, String direccion, String horario) {
        this.nombres = nombres;
        this.edad = edad;
        this.direccion = direccion;
        this.horario = horario;
    }

    // Getters y Setters
    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }
}
