package altamirano.hernandez.app_apirest_springboot.services;

import altamirano.hernandez.app_apirest_springboot.models.Usuario;
import altamirano.hernandez.app_apirest_springboot.repositories.IUsuarioRepository;
import altamirano.hernandez.app_apirest_springboot.services.interfaces.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplUsuarioService implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();
        return usuarios;
    }

    @Override
    public Usuario findById(int id) {
        try {
            Usuario usuarioFound = usuarioRepository.findById(id).get();
            return usuarioFound;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Usuario usuario) {
        try {
            usuarioRepository.save(usuario);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteById(int id) {
        try{
            var deletedUsuario = usuarioRepository.findById(id).get();
            if (deletedUsuario != null) {
                usuarioRepository.delete(deletedUsuario);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
