package altamirano.hernandez.app_apirest_springboot.jwt;

import java.util.Objects;

public class AuthResponse {
    private String correo;
    private String accessToken;

    //Constructores
    public AuthResponse(){}
    public AuthResponse(String correo, String accessToken) {
        this.correo = correo;
        this.accessToken = accessToken;
    }

    //Metodos Get y Set
    public String getAccessToken() {
        return accessToken;
    }
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    //Equals y hashcode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthResponse that = (AuthResponse) o;
        return Objects.equals(correo, that.correo) && Objects.equals(accessToken, that.accessToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(correo, accessToken);
    }
}
