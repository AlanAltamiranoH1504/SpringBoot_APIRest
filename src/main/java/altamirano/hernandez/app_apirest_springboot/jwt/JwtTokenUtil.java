package altamirano.hernandez.app_apirest_springboot.jwt;

import altamirano.hernandez.app_apirest_springboot.models.Usuario;
import altamirano.hernandez.app_apirest_springboot.utilities.Constantes;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenUtil {
    //Atributos
    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; //24 hrs
    private static final String SECRET = Constantes.FIRMA;

    //Metodos
    public String getSubject(String token){
        return parseClaims(token).getSubject();
    }

    //Metodo generador de Token
    public String generarToken(Usuario usuario){
        Key key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

        return Jwts
                .builder()
                .subject(String.format("%s,%s", usuario.getId(), usuario.getNombre()))
                .issuer("Alan")
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
                .signWith(key, SignatureAlgorithm.ES512)
                .compact();
    }

    //Metodo que valida el token
    public boolean validateToken(String token){
        Key key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
        try{
//            Jwts.parserBuilder().setSigningKey(key).parseClaims(token);
            Jwts.parser()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        }catch (ExpiredJwtException e){
            System.out.println("JWT expirado: " + e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("Token es null, esta vacio o contiene espacios: " + e.getMessage());
        }catch (MalformedJwtException e){
            System.out.println("JWT invalido: " + e.getMessage());
        }catch (UnsupportedJwtException e){
            System.out.println("JWT no soportado: " + e.getMessage());
        }
        return false;
    }

    private Claims parseClaims(String token) {
        Key key = Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));
        return Jwts
                .parser()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
