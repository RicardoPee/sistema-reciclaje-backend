package pe.edu.pe.grupo2.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Usuario")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;

    @Column(name = "nombres", nullable = false, length = 30)
    private String nombres;

    @Column(name = "apellidos", nullable = false, length = 30)
    private String apellidos;

    @Column(name = "username", length = 30, unique = true)
    private String username;

    @Column(name = "dni", nullable = false, length = 8)
    private String dni;

    @Column(name = "edad", nullable = false, length = 3)
    private int edad;

    @Column(name = "genero", nullable = false, length = 9)
    private String genero;

    @Column(name = "distrito", nullable = false)
    private String distrito;

    @Column(name = "telefono", nullable = false, length = 9)
    private String telefono;

    @Column(name = "correo", nullable = false)
    private String correo;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "enabled")
    private Boolean enabled;

    @Column(name = "puntos_acumulados")
    private Integer puntosAcumulados = 0;

    @ManyToOne
    @JoinColumn(name = "rol_id")
    private Rol rol;

    public User() {
    }

    public User(int idUser, String nombres, String apellidos, String username, String dni, int edad, String genero, String distrito, String telefono, String correo, String password, Boolean enabled, Rol rol, Integer puntosAcumulados) {
        this.idUser = idUser;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.username = username;
        this.dni = dni;
        this.edad = edad;
        this.genero = genero;
        this.distrito = distrito;
        this.telefono = telefono;
        this.correo = correo;
        this.password = password;
        this.enabled = enabled;
        this.rol = rol;
        this.puntosAcumulados = puntosAcumulados;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Integer getPuntosAcumulados() {
        return puntosAcumulados != null ? puntosAcumulados : 0;
    }

    public void setPuntosAcumulados(Integer puntosAcumulados) {
        this.puntosAcumulados = puntosAcumulados;
    }
}