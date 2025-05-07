package altamirano.hernandez.app_apirest_springboot.models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.Objects;

public class Ejemplo {
    @NotBlank(message = "El nombre no puede estar vacio")
    @Size(min = 3, message = "El nombre debe tener al menos 3 caracteres")
    private String nombre;

    @NotBlank(message = "El correo no puede estar vacio")
    @Size(min = 3, max = 50, message = "El correo debe ser entre 3 y 50 caracteres")
    private String correo;

    @Positive(message = "El precio debe ser mayor a 0")
    private double precio;

    @NotBlank(message = "La descripcion no puede estar vacia")
    @Size(min = 10, max = 150, message = "La descripcion debe ser de entre 10 y 150 caracteres")
    private String descripcion;

    //Constructores
    public Ejemplo(){}
    public Ejemplo(String nombre, String correo, double precio, String descripcion) {
        this.nombre = nombre;
        this.correo = correo;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    //Get y Set
    public @NotBlank(message = "El correo no puede estar vacio") @Size(min = 3, max = 50, message = "El correo debe ser entre 3 y 50 caracteres") String getCorreo() {
        return correo;
    }
    public void setCorreo(@NotBlank(message = "El correo no puede estar vacio") @Size(min = 3, max = 50, message = "El correo debe ser entre 3 y 50 caracteres") String correo) {
        this.correo = correo;
    }
    public @NotBlank(message = "La descripcion no puede estar vacia") @Size(min = 10, max = 150, message = "La descripcion debe ser de entre 10 y 150 caracteres") String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(@NotBlank(message = "La descripcion no puede estar vacia") @Size(min = 10, max = 150, message = "La descripcion debe ser de entre 10 y 150 caracteres") String descripcion) {
        this.descripcion = descripcion;
    }
    public @NotBlank(message = "El nombre no puede estar vacio") @Size(min = 3, message = "El nombre debe tener al menos 3 caracteres") String getNombre() {
        return nombre;
    }
    public void setNombre(@NotBlank(message = "El nombre no puede estar vacio") @Size(min = 3, message = "El nombre debe tener al menos 3 caracteres") String nombre) {
        this.nombre = nombre;
    }
    @Positive(message = "El precio debe ser mayor a 0")
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(@Positive(message = "El precio debe ser mayor a 0") double precio) {
        this.precio = precio;
    }

    //toString
    @Override
    public String toString() {
        return "Ejemplo{" +
                "correo='" + correo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    //Equals y Hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ejemplo ejemplo = (Ejemplo) o;
        return Double.compare(precio, ejemplo.precio) == 0 && Objects.equals(nombre, ejemplo.nombre) && Objects.equals(correo, ejemplo.correo) && Objects.equals(descripcion, ejemplo.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, correo, precio, descripcion);
    }
}
