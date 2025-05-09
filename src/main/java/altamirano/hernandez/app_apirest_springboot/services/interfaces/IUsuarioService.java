package altamirano.hernandez.app_apirest_springboot.services.interfaces;

import altamirano.hernandez.app_apirest_springboot.models.Usuario;

import java.util.List;

public interface IUsuarioService {
    public abstract List<Usuario> findAll();
    public abstract Usuario findById(int id);
    public abstract void save(Usuario usuario);
    public abstract void deleteById(int id);
}
