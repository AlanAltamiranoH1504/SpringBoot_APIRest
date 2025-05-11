package altamirano.hernandez.app_apirest_springboot.jwt;

import altamirano.hernandez.app_apirest_springboot.models.Usuario;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtTokenFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    //Filtro para autenticacion recibiendo el token
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        if (!hasAthorizationBearer(request)){
            filterChain.doFilter(request, response);
            return;
        }
        String token = getAccessToken(request);

        if (!jwtTokenUtil.validateToken(token)){
            filterChain.doFilter(request, response);
            return;
        }
        setAuthenticationContext(token, request);
        filterChain.doFilter(request, response);
    }

    //Metodo de verificacion de Bearer en el token
    private boolean hasAthorizationBearer(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        if (ObjectUtils.isEmpty(header) || !header.startsWith("Bearer ")){
            return false;
        }
        return true;
    }

    //Metodo que obtiene el token de los headers
    private String getAccessToken(HttpServletRequest request){
        String header = request.getHeader("Authorization");
        String token = header.split(" ")[1].trim();
        return token;
    }

    //Metodo que crea una autenticacion
    private void setAuthenticationContext(String token, HttpServletRequest request){
        Usuario userDetails = getUserDetails(token);
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, null);

        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    //Obtiene los detalles del usaurio
    private Usuario getUserDetails(String token){
        Usuario usuarioDetails = new Usuario();
        String[] jwtSubject = jwtTokenUtil.getSubject(token).split(",");
        usuarioDetails.setId(Integer.parseInt(jwtSubject[0]));
        usuarioDetails.setCorreo(jwtSubject[1]);

        return usuarioDetails;
    }
}
