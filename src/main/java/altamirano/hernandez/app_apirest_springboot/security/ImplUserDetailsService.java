package altamirano.hernandez.app_apirest_springboot.security;

import altamirano.hernandez.app_apirest_springboot.models.Usuario;
import altamirano.hernandez.app_apirest_springboot.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class ImplUserDetailsService implements UserDetailsService {
    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = iUsuarioRepository.findByEmail(email);

        //Verificacion de usuario encontrado
        if (usuario == null){
            throw new UsernameNotFoundException("Usuario no encontrado");
        }

        //Configuracion de permisos
        List<GrantedAuthority> permisos = new ArrayList<>();

        //Retornamos el usuarios
        return new User(usuario.getCorreo(), usuario.getPassword(), true, true, true,true, permisos);
    }
}
