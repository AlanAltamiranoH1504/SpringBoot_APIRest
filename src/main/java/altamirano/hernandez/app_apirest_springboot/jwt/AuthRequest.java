package altamirano.hernandez.app_apirest_springboot.jwt;

import java.util.Objects;

public class AuthRequest {
    //Correo y password
    private String correo;
    private String password;

    //Constructores
    public AuthRequest(){}
    public AuthRequest(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

    //Get y Set
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

    //Equals y Hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthRequest that = (AuthRequest) o;
        return Objects.equals(correo, that.correo) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(correo, password);
    }
}
