package altamirano.hernandez.app_apirest_springboot.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Objects;

@Entity
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(min = 3, max = 100, message = "El nombre debe ser entre 3 y 100 caracteres")
    private String nombre;

    @NotBlank(message = "El correo no puede estar vacio")
    @Size(min = 3, max = 100, message = "El correo debe ser entre 3 y 100 caracteres")
    private String correo;

    @NotBlank(message = "El telefono no puede estar vacio")
    @Size(min = 3, max = 50, message = "El telefono debe ser entre 3 y 50 caracteres")
    private String telefono;

    @NotBlank(message = "El password no puede estar vacio")
    @Size(min = 5, max = 100, message = "El password debe ser entre 5 y 100 caracteres")
    private String password;

    private int estado;

    //Constructores
    public Usuario() {}
    public Usuario(String nombre, String correo, String telefono, String password, int estado) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.password = password;
        this.estado = estado;
    }
    public Usuario(int id, String nombre, String correo, String telefono, String password, int estado) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.password = password;
        this.estado = estado;
    }

    //Metodos GET y SET
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotBlank(message = "El nombre no puede estar vacio") @Size(min = 3, max = 100, message = "El nombre debe ser entre 3 y 100 caracteres") String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank(message = "El nombre no puede estar vacio") @Size(min = 3, max = 100, message = "El nombre debe ser entre 3 y 100 caracteres") String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank(message = "El correo no puede estar vacio") @Size(min = 3, max = 100, message = "El correo debe ser entre 3 y 100 caracteres") String getCorreo() {
        return correo;
    }

    public void setCorreo(@NotBlank(message = "El correo no puede estar vacio") @Size(min = 3, max = 100, message = "El correo debe ser entre 3 y 100 caracteres") String correo) {
        this.correo = correo;
    }

    public @NotBlank(message = "El telefono no puede estar vacio") @Size(min = 3, max = 50, message = "El telefono debe ser entre 3 y 50 caracteres") String getTelefono() {
        return telefono;
    }

    public void setTelefono(@NotBlank(message = "El telefono no puede estar vacio") @Size(min = 3, max = 50, message = "El telefono debe ser entre 3 y 50 caracteres") String telefono) {
        this.telefono = telefono;
    }

    public @NotBlank(message = "El password no puede estar vacio") @Size(min = 5, max = 100, message = "El password debe ser entre 5 y 100 caracteres") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "El password no puede estar vacio") @Size(min = 5, max = 100, message = "El password debe ser entre 5 y 100 caracteres") String password) {
        this.password = password;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    //toString
    @Override
    public String toString() {
        return "Usuario{" +
                "correo='" + correo + '\'' +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", password='" + password + '\'' +
                ", estado=" + estado +
                '}';
    }

    //Equals y Hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return id == usuario.id && estado == usuario.estado && Objects.equals(nombre, usuario.nombre) && Objects.equals(correo, usuario.correo) && Objects.equals(telefono, usuario.telefono) && Objects.equals(password, usuario.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, correo, telefono, password, estado);
    }
}
