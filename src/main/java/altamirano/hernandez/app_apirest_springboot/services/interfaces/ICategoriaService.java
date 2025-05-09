package altamirano.hernandez.app_apirest_springboot.services.interfaces;

import altamirano.hernandez.app_apirest_springboot.models.Categoria;

import java.util.List;
import java.util.Optional;

public interface ICategoriaService {
    public abstract List<Categoria> findAll();
    public abstract Optional<Categoria> findById(int id);
    public abstract void save(Categoria categoria);
    public abstract void deleteById(int id);
}
